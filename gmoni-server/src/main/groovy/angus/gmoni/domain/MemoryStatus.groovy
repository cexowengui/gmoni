package angus.gmoni.domain

import javax.persistence.Entity

import com.fasterxml.jackson.annotation.JsonProperty


@Entity
class MemoryStatus extends Base{
	
	
	
	private long total
	private long ram
	private long used
	private long free
	@JsonProperty("actual_used")
	private long actualUsed
	@JsonProperty("actual_free")
	private long actualFree
	@JsonProperty("used_percent")
	private double usedPercent
	@JsonProperty("free_percent")
	private double freePercent


}
