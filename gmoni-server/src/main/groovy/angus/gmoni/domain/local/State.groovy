package angus.gmoni.domain.local

import com.fasterxml.jackson.annotation.JsonProperty

class State {
	
	private String hostname;
	private int port;
	@JsonProperty("start_time")
	private Date startTime;
	
	
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	
	
	
}
