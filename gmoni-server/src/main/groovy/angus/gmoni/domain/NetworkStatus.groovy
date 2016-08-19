package angus.gmoni.domain

import javax.persistence.Entity

@Entity
class NetworkStatus extends Base{
	

	 String address //物理地址
	 long rxBytes
	 long rxBytesPerSecond
	 long rxPackets
	 long rxPacketsPerSecond
	 long rxErrors
	 long rxErrorsPerSecond
	 long rxDropped
	 long rxDroppedPerSecond
	 long rxOverruns
	 long rxOverrunsPerSecond
	 long rxFrame
	 long rxFramePerSecond
	 long txBytes
	 long txBytesPerSecond
	 long txPackets
	 long txPacketsPerSecond
	 long txErrors
	 long txErrorsPerSecond
	 long txDropped
	 long txDroppedPerSecond
	 long txOverruns
	 long txOverrunsPerSecond
	 long txCollisions
	 long txCarrier
	 long txCarrierPerSecond
	 long speed

}
