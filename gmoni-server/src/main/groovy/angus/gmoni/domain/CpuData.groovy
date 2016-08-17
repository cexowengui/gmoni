package angus.gmoni.domain

import groovy.transform.TypeChecked

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table


@TypeChecked
@Entity
@Table
class CpuData {
	
	@EmbeddedId
	Pk id;
	
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
