package angus.gmoni.dao;

import org.springframework.data.repository.CrudRepository;

import angus.gmoni.domain.local.Node;

public interface NodeRepo extends CrudRepository<Node, String>{

}
