package angus.gmoni.web

import groovy.transform.TypeChecked

import org.codehaus.plexus.util.cli.CommandLineUtils
import org.hyperic.sigar.SigarException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import angus.gmoni.domain.Cpu
import angus.gmoni.domain.Disk
import angus.gmoni.domain.Everything
import angus.gmoni.domain.Memory
import angus.gmoni.domain.Network
import angus.gmoni.domain.Os
import angus.gmoni.domain.State
import angus.gmoni.service.ProcessService
import angus.gmoni.service.StateService

@TypeChecked
@Controller
class StateController {

	@Autowired
	private StateService stateService
	
	@Autowired
	private ProcessService processService
	
	@RequestMapping(value="/everything")
	@ResponseBody
	public Everything getEverything() throws SigarException {
		Everything e = new Everything()
		
		e.cpu = stateService.cpu
		e.disks = stateService.disks
		e.memory = stateService.memory
		e.networks = stateService.networks
		e.os = stateService.os
		e.state = stateService.state
	
		return e
	}
	
	
	@RequestMapping(value="/")
	@ResponseBody
	public State index()  {
	
		return getState() 
	}
	
	@RequestMapping(value="/state")
	@ResponseBody
	public State getState() throws SigarException {
		State s =stateService.state
		return s 
	}
	
	
	@RequestMapping(value="/os")
	@ResponseBody
	public Os getOs() {
		return stateService.getOs()
	}
	
	
	@RequestMapping(value="/cpu")
	@ResponseBody
	public Cpu getCpu() throws SigarException {
		return stateService.getCpu()
	}
	
	@RequestMapping(value="/disk")
	@ResponseBody
	public List<Disk> getDisks() throws SigarException {
		return stateService.getDisks()
	}
	
	@RequestMapping(value="/memory")
	@ResponseBody
	public Memory getMemory() throws SigarException {
		return stateService.getMemory()
	}

	@RequestMapping(value="/network")
	@ResponseBody
	public List<Network> getNetworks() throws SigarException {
		return stateService.getNetworks()
	}
	
	@RequestMapping(value="/env")
	@ResponseBody
	public Properties getEnv() throws IOException {
		return CommandLineUtils.getSystemEnvVars()
	}
	
	
}
