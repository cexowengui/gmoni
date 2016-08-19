package angus.gmoni.domain

import com.fasterxml.jackson.annotation.JsonProperty


class Cpu {
	
	private double user
	private double sys
	private double nice
	private double idle
	private double wait
	private double irq
	@JsonProperty("soft_irq")
	private double softIrq
	private double stolen
	private double combined
	public double getUser() {
		return user;
	}
	public void setUser(double user) {
		this.user = user;
	}
	public double getSys() {
		return sys;
	}
	public void setSys(double sys) {
		this.sys = sys;
	}
	public double getNice() {
		return nice;
	}
	public void setNice(double nice) {
		this.nice = nice;
	}
	public double getIdle() {
		return idle;
	}
	public void setIdle(double idle) {
		this.idle = idle;
	}
	public double getWait() {
		return wait;
	}
	public void setWait(double wait) {
		this.wait = wait;
	}
	public double getIrq() {
		return irq;
	}
	public void setIrq(double irq) {
		this.irq = irq;
	}
	public double getSoftIrq() {
		return softIrq;
	}
	public void setSoftIrq(double softIrq) {
		this.softIrq = softIrq;
	}
	public double getStolen() {
		return stolen;
	}
	public void setStolen(double stolen) {
		this.stolen = stolen;
	}
	public double getCombined() {
		return combined;
	}
	public void setCombined(double combined) {
		this.combined = combined;
	}
	
	
	

}
