package angus.gmoni.domain

import javax.persistence.EmbeddedId;
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
class DiskData {
	
	@EmbeddedId
	Pk id;
	
	
	String dirName
	long total
	long free
	long used
	long avail
	long files
	long freeFiles
	long diskReads
	long diskReadsPerSecond
	long diskWrites
	long diskWritesPerSecond
	long diskReadBytes
	long diskReadBytesPerSecond
	long diskWriteBytes
	long diskWriteBytesPerSecond
	double diskQueue
	double diskServiceTime
	double usePercent
}
