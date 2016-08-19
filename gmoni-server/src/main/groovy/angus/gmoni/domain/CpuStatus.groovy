package angus.gmoni.domain

import groovy.transform.TypeChecked

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table


@TypeChecked
@Entity
class CpuStatus extends Base{
	//primary key in Base
	
	double user
	double sys
	double nice
	double idle
	double wait
	double irq
	double softIrq
	double stolen
	double combined
	
}
