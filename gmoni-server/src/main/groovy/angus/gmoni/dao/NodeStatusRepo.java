package angus.gmoni.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import angus.gmoni.domain.NodeStatus;
import angus.gmoni.domain.Pk;

@Transactional
@Repository
public interface NodeStatusRepo extends CrudRepository<NodeStatus, Pk> {

	public List<NodeStatus> findByAgent(String agent);
}


