package angus.gmoni.domain.local

import javax.persistence.Entity
import javax.persistence.Id


/**
 * 
 * @author hsiung
 *
 */

@Entity
class Node {
	
	@Id
	String agent
	String schema
	String address
	int port
	String hostname
	String description
	String location
	String osName
	String osVersion
	int cpu
	String architecture
	String idRsa
	String idRsaPub
	Date createTime
	boolean enabled
}
