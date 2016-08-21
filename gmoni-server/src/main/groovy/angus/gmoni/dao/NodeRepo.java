package angus.gmoni.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import angus.gmoni.domain.local.Node;


@Repository
public interface NodeRepo extends CrudRepository<Node, String>{

}
