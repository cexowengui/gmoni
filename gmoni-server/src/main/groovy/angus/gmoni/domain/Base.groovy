package angus.gmoni.domain

import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.MappedSuperclass


@MappedSuperclass
@IdClass(value=Pk.class)
class Base implements Serializable {
	@Id
	String agent;
	
	@Id
	Date querytime;

}
