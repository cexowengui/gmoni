package angus.gmoni.domain.local

import groovy.transform.TypeChecked

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@TypeChecked
@Entity
@Table
class Deployment {

	//one node environment arguments
	@Id
	String agent
	String description
	int instanceCount //processes instance
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
