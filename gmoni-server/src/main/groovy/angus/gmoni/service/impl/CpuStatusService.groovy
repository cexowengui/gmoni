package angus.gmoni.service.impl

import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import angus.gmoni.dao.CpuStatusRepo
import angus.gmoni.domain.CpuStatus
import angus.gmoni.service.CpuStatusServiceI

@TypeChecked
@Service
class CpuStatusService implements CpuStatusServiceI {

	@Autowired
	private CpuStatusRepo repo;


	void save(CpuStatus status){
		repo.save(status)
	}
}
