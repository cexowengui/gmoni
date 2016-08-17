package angus.gmoni.domain

import groovy.transform.TypeChecked

import javax.persistence.EmbeddedId;
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@TypeChecked
@Entity
@Table
class Deployment {

	
	@EmbeddedId
	Pk id;
	String description
	int instanceCount //agentCount
	String pidFile
	String user
	String workingDirectory
	String environment
	String startCommand
	String stopCommand
	String javaHome
	String jreHome
	String classpath
	String mainClass
	String jar
	String arguments
	String vmArguments

}
