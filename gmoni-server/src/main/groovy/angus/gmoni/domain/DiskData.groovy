package angus.gmoni.domain

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table
class DiskData extends Base{

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
