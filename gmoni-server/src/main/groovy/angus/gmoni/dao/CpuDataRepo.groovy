package angus.gmoni.dao

import javax.transaction.Transactional

import org.springframework.data.repository.CrudRepository

import angus.gmoni.domain.CpuData
import angus.gmoni.domain.Pk


@Transactional
interface  CpuDataRepo extends CrudRepository<CpuData, Pk>{
	


}
