package angus.gmoni.domain


class Everything {
	
	private Cpu cpu
	private State state
	private Os os
	private List<Disk> disks
	private Memory memory
	private List<Network> networks
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Os getOs() {
		return os;
	}
	public void setOs(Os os) {
		this.os = os;
	}
	public List<Disk> getDisks() {
		return disks;
	}
	public void setDisks(List<Disk> disks) {
		this.disks = disks;
	}
	public Memory getMemory() {
		return memory;
	}
	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	public List<Network> getNetworks() {
		return networks;
	}
	public void setNetworks(List<Network> networks) {
		this.networks = networks;
	}
	
	
	

}
