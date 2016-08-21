package angus.gmoni.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import angus.gmoni.dao.NodeStatusRepo;
import angus.gmoni.domain.CpuStatus;
import angus.gmoni.domain.NodeStatus;
import angus.gmoni.domain.local.Cpu;
import angus.gmoni.domain.local.Everything;
import angus.gmoni.domain.local.Node;
import angus.gmoni.service.CollectServiceI;
import angus.gmoni.util.JsonUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class CollectService implements CollectServiceI {

	private static final Logger LOG = LoggerFactory.getLogger(CollectService.class);

	private OkHttpClient httpClient = new OkHttpClient();

	@Autowired
	NodeService nodeService;
	
	@Autowired
	NodeStatusRepo nodeStatusRepo;
	
	@Autowired
	CpuStatusService cpuStatusService;

	@Override
	public void collectProcess() {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectEverything() {
		// TODO Auto-generated method stub
		LOG.info("collect service from node");
		List<Node> enabledNodes = nodeService.getNodeEnabled();

		for (Node node : enabledNodes) {
			NodeStatus status = new NodeStatus();
			status.setAgent(node.getAgent());
			Date now = new Date();
			status.setQuerytime(now);
			
			try {
				String response = get(node, "/everything");
				if(response == null){
					LOG.warn("get everything from node failed!");
				}
				Everything everything = JsonUtil.string2Object(response, Everything.class);
				status.setAvailable(1);
				status.setLoad(everything.getOs().getLoad());
				//update the node 
				node.setCpu(everything.getOs().getCpu());
				node.setArchitecture(everything.getOs().getArchitecture());
				node.setHostname(everything.getOs().getName());
				node.setOsVersion(everything.getOs().getVersion());
				
				//update to database
				nodeService.save(node);
				
				
				//collect other things and persistence to database;
				collectCpuStatus(node,everything.getCpu(),now);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.warn("LOG: get everything from node failed!");
				status.setAvailable(0);
			}finally {
				nodeStatusRepo.save(status);
			}
			
			
		}

	}

	

	@Override
	public void collectGc() {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectStack() {
		// TODO Auto-generated method stub

	}

	private String get(Node node, String uri) throws IOException {
		String url = String.format("%s://%s:%s%s", node.getSchema(), node.getAddress(), node.getPort(), uri);

		Request request = new Request.Builder().url(url).build();

		Response response = httpClient.newCall(request).execute();
		return response.body().string();

	}

	private String post(Node node, String uri, RequestBody body) throws IOException {
		String url = String.format("%s://%s:%s%s", node.getSchema(), node.getAddress(), node.getPort(), uri);
		Request request = new Request.Builder().url(url).post(body).build();

		Response response = httpClient.newCall(request).execute();
		return response.body().string();
	}
	
	
	private void collectCpuStatus(Node node,Cpu cpu,Date querytime) {
		CpuStatus status = new CpuStatus();
		status.setAgent(node.getAgent());
		status.setQuerytime(querytime);
		status.setCombined(cpu.getCombined());
		status.setIdle(cpu.getIdle());
		status.setIrq(cpu.getIrq());
		status.setNice(cpu.getNice());
		status.setSoftIrq(cpu.getSoftIrq());
		status.setStolen(cpu.getStolen());
		status.setSys(cpu.getSys());
		status.setUser(cpu.getUser());
		status.setUser(cpu.getUser());
		status.setWait(cpu.getWait());
		cpuStatusService.save(status);
		
	}

}
