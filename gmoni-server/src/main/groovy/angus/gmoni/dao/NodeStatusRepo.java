package angus.gmoni.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import angus.gmoni.domain.NodeStatus;
import angus.gmoni.domain.Pk;

@Transactional
public interface NodeStatusRepo extends CrudRepository<NodeStatus, Pk> {

	public List<NodeStatus> findByAgent(String agent);
}


