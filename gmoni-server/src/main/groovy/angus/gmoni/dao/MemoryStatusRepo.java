package angus.gmoni.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import angus.gmoni.domain.MemoryStatus;
import angus.gmoni.domain.Pk;


@Repository
@Transactional
public interface MemoryStatusRepo extends CrudRepository<MemoryStatus, Pk> {

	public List<MemoryStatus> findByAgent(String agent);
}
