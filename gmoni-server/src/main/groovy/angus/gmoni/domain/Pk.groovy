package angus.gmoni.domain

import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder


class Pk implements Serializable{

	String agentId;
	Date querytime;


	public Pk(){}

	public Pk(String agent,Date time){
		this.agentId = agent
		this.querytime = time
	}

	@Override
	public int hashCode() {
		return  new  HashCodeBuilder( 17 ,  37 )
				.append(agentId)
				.append(querytime).toHashCode( );
	}

	@Override
	public boolean equals(Object o) {
		boolean  equals  =   false ;
		if  ( o  != null && Pk.class.isAssignableFrom(o) )  {
			Pk pk  =  (Pk) o;
			equals  = (new  EqualsBuilder()
					.append(agentId, pk.agentId)
					.append(querytime, pk.agentId)).isEquals()
		}
		return  equals;
	}
}
