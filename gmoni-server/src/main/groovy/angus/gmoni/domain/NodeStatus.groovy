package angus.gmoni.domain

import javax.persistence.Entity


@Entity
class NodeStatus extends Base{

	 double load;
	 int available;
	 
}
