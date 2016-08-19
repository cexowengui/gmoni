package angus.gmoni.domain

import javax.persistence.Entity
import javax.persistence.Id


@Entity
class Disk {


	@Id
	String agent
	String dirName
	String devName
	String typeName
	String sysTypeName
	String options
	int type
	long flags
}
