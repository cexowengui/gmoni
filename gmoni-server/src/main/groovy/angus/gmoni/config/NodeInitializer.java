package angus.gmoni.config;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import angus.gmoni.dao.NodeRepo;
import angus.gmoni.domain.local.Node;
import angus.gmoni.util.NodeParser;


public class NodeInitializer {
	Logger logger = LoggerFactory.getLogger(NodeInitializer.class);

	@Autowired
	NodeRepo repo;
	public void initNodeConfig() {
		try {
			List<Node> nodes = NodeParser.parser();
			repo.save(nodes);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("获取配置文件/解析文件失败，请检查配置文件格式和路径");
			e.printStackTrace();
		}
	}

}
