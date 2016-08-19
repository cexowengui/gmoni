package angus.gmoni.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import angus.gmoni.domain.DiskData;
import angus.gmoni.domain.Pk;

@Transactional
public interface DiskDataRepo extends CrudRepository<DiskData, Pk> {

	public List<DiskData> findByAgent(String agent);

}
