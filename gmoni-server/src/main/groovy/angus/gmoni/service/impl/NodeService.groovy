package angus.gmoni.service.impl

import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import angus.gmoni.dao.NodeRepo
import angus.gmoni.domain.local.Node
import angus.gmoni.service.NodeServiceI


@TypeChecked
@Service
class NodeService implements NodeServiceI{

	@Autowired
	NodeRepo repo;
	
	
	
	@Override
	public List<Node> getNodeEnabled() {
		Iterable<Node> allNodes = repo.findAll();
		List<Node> enabled = new ArrayList<>();
		for(Node node in allNodes){
			if(node.enabled){
				enabled.add(node)
			}
		} 
		return enabled;
	}






	@Override
	public Node save(Node node) {
		// TODO Auto-generated method stub
		repo.save(node)
		return null;
	}
	
	

}
