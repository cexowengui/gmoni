package angus.gmoni.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import angus.gmoni.domain.DiskData;
import angus.gmoni.domain.Pk;

@Repository
@Transactional
public interface DiskDataRepo extends CrudRepository<DiskData, Pk> {

	public List<DiskData> findByAgent(String agent);

}
