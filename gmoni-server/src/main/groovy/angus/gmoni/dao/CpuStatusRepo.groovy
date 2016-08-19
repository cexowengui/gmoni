package angus.gmoni.dao

import javax.transaction.Transactional

import org.springframework.data.repository.CrudRepository

import angus.gmoni.domain.CpuStatus
import angus.gmoni.domain.Pk


@Transactional
interface  CpuStatusRepo extends CrudRepository<CpuStatus, Pk>{
	
	public List<CpuStatus> findByAgent(String agent)

}
