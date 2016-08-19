package angus.gmoni.domain

import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder


class Pk implements Serializable{

	String agent;  //使用ip 作为agent id
	Date querytime;


	public Pk(){}

	public Pk(String agent,Date time){
		this.agent = agent
		this.querytime = time
	}

	@Override
	public int hashCode() {
		return  new  HashCodeBuilder( 17 ,  37 )
				.append(agent)
				.append(querytime).toHashCode( );
	}

	@Override
	public boolean equals(Object o) {
		boolean  equals  =   false ;
		if  ( o  != null && Pk.class.isAssignableFrom(o) )  {
			Pk pk  =  (Pk) o;
			equals  = (new  EqualsBuilder()
					.append(agent, pk.agent)
					.append(querytime, pk.querytime)).isEquals()
		}
		return  equals;
	}
}
