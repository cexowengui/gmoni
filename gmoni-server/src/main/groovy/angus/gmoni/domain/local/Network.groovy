package angus.gmoni.domain.local

import javax.persistence.Entity
import javax.persistence.Id



//节点的网卡参数

@Entity
class Network {
	
	@Id
	String agent
	
	String address
	String name
	String hwaddr
	String type
	String description
	String destination
	String broadcast
	String netmask
	long flags
	long mtu //Maximum Transmission Unit
	long metric
}
