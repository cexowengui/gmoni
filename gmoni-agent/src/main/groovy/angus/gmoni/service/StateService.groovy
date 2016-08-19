package angus.gmoni.service

import org.hyperic.sigar.SigarException

import angus.gmoni.domain.Cpu
import angus.gmoni.domain.Disk
import angus.gmoni.domain.Memory
import angus.gmoni.domain.Network
import angus.gmoni.domain.Os
import angus.gmoni.domain.State


interface StateService {
	
	State getState()
	
	Os getOs()

	Cpu getCpu() throws SigarException
	
	List<Disk> getDisks() throws SigarException

	Memory getMemory() throws SigarException

	List<Network> getNetworks() throws SigarException

}
