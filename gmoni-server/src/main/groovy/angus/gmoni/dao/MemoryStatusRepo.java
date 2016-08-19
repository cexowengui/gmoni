package angus.gmoni.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import angus.gmoni.domain.MemoryStatus;
import angus.gmoni.domain.Pk;

@Transactional
public interface MemoryStatusRepo extends CrudRepository<MemoryStatus, Pk> {

	public List<MemoryStatus> findByAgent(String agent);
}
