package angus.gmoni.service;

import angus.gmoni.domain.local.Node;
//import antlr.collections.List;
import java.util.List;

public interface NodeServiceI {
	
	public Node save(Node node) ;
	public List<Node> getNodeEnabled();

}
