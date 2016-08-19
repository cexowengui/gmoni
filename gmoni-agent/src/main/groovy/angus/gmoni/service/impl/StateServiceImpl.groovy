package angus.gmoni.service.impl

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.ref.ReferenceQueue.Null
import java.net.InetAddress
import java.util.ArrayList;
import java.util.List

import org.hyperic.sigar.CpuPerc
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage
import org.hyperic.sigar.Mem
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import angus.gmoni.domain.Cpu;
import angus.gmoni.domain.Disk;
import angus.gmoni.domain.Memory;
import angus.gmoni.domain.Network;
import angus.gmoni.domain.Os;
import angus.gmoni.domain.State;
import angus.gmoni.service.StateService
import angus.gmoni.util.PortListener
import groovy.transform.CompileStatic;
import groovy.transform.TypeChecked;;

@TypeChecked
@Service("stateService")
class StateServiceImpl implements StateService{

	private State state

	@Autowired
	private PortListener portListener

	private Sigar sigar = new Sigar()

	private void init(){
		state.hostname =  InetAddress.getLocalHost().getHostName()
		state.port = portListener.getPort()
		state.startTime = new Date()
	}

	@Override
	public State getState() {
		if(!state) init()

		return state;
	}

	@Override
	public Os getOs() {
		OperatingSystemMXBean oper = ManagementFactory.getOperatingSystemMXBean();
		Os os = new Os();
		os.setArchitecture(oper.getArch());
		os.setCpu(oper.getAvailableProcessors());
		os.setLoad(oper.getSystemLoadAverage());
		os.setName(oper.getName());
		os.setVersion(oper.getVersion());
		return os;
	}

	@Override
	public Cpu getCpu() throws SigarException {
		Cpu cpu = new Cpu();
		CpuPerc cpuP = sigar.getCpuPerc();
		cpu.setCombined(cpuP.getCombined());
		cpu.setIdle(cpuP.getCombined());
		cpu.setIrq(cpuP.getIrq());
		cpu.setNice(cpuP.getNice());
		cpu.setSoftIrq(cpuP.getSoftIrq());
		cpu.setStolen(cpuP.getStolen());
		cpu.setSys(cpuP.getSys());
		cpu.setUser(cpuP.getUser());
		cpu.setWait(cpuP.getWait());

		return cpu;
	}

	@Override
	public List<Disk> getDisks() throws SigarException {
		FileSystem[] fss = sigar.getFileSystemList();

		List<Disk> list = new ArrayList<Disk>();
		for (FileSystem fs : fss) {
			FileSystemUsage fsu = sigar.getFileSystemUsage(fs.getDirName());
			if (fs.getType() == 2) {
				Disk disk = new Disk();
				disk.setAvail(fsu.getAvail());
				disk.setDevName(fs.getDevName());
				disk.setDirName(fs.getDirName());
				disk.setDiskQueue(fsu.getDiskQueue());
				disk.setDiskReadBytes(fsu.getDiskReadBytes());
				disk.setDiskReads(fsu.getDiskReads());
				disk.setDiskServiceTime(fsu.getDiskServiceTime());
				disk.setDiskWriteBytes(fsu.getDiskWriteBytes());
				disk.setDiskWrites(fsu.getDiskWrites());
				disk.setFiles(fsu.getFiles());
				disk.setFlags(fs.getFlags());
				disk.setFree(fsu.getFree());
				disk.setFreeFiles(fsu.getFreeFiles());
				disk.setOptions(fs.getOptions());
				disk.setSysTypeName(fs.getSysTypeName());
				disk.setTotal(fsu.getTotal());
				disk.setType(fs.getType());
				disk.setTypeName(fs.getTypeName());
				disk.setUsed(fsu.getUsed());
				disk.setUsePercent(fsu.getUsePercent());
				list.add(disk);
			}
		}
		return list;
	}

	@Override
	public Memory getMemory() throws SigarException {
		Memory memory = new Memory();
		Mem mem = sigar.getMem();
		memory.setActualFree(mem.getActualFree());
		memory.setActualUsed(mem.getActualUsed());
		memory.setFree(mem.getFree());
		memory.setFreePercent(mem.getFreePercent());
		memory.setRam(mem.getRam());
		memory.setTotal(mem.getTotal());
		memory.setUsed(mem.getUsed());
		memory.setUsedPercent(mem.getUsedPercent());

		return memory;
	}

	@Override
	public List<Network> getNetworks() throws SigarException {
		String[] netIfs = sigar.getNetInterfaceList();
		List<Network> networks = new ArrayList<Network>();

		for (String name : netIfs) {
			NetInterfaceConfig config = sigar.getNetInterfaceConfig(name);
			NetInterfaceStat stat = sigar.getNetInterfaceStat(name);
			if (stat.getRxBytes() > 0
			&& !config.getAddress().equals("127.0.0.1")
			&& !config.getAddress().equals("0.0.0.0")) {
				Network network = new Network();
				network.setAddress(config.getAddress());
				network.setBroadcast(config.getBroadcast());
				network.setDescription(config.getDescription());
				network.setDestination(config.getDestination());
				network.setFlags(config.getFlags());
				network.setHwaddr(config.getHwaddr());
				network.setMetric(config.getMetric());
				network.setMtu(config.getMtu());
				network.setName(config.getName());
				network.setNetmask(config.getNetmask());
				network.setRxBytes(stat.getRxBytes());
				network.setRxDropped(stat.getRxDropped());
				network.setRxErrors(stat.getRxErrors());
				network.setRxFrame(stat.getRxFrame());
				network.setRxOverruns(stat.getRxOverruns());
				network.setRxPackets(stat.getRxPackets());
				network.setSpeed(stat.getSpeed());
				network.setTxBytes(stat.getTxBytes());
				network.setTxCarrier(stat.getTxCarrier());
				network.setTxCollisions(stat.getTxCollisions());
				network.setTxDropped(stat.getTxDropped());
				network.setTxErrors(stat.getTxErrors());
				network.setTxOverruns(stat.getTxOverruns());
				network.setTxPackets(stat.getTxPackets());
				network.setType(config.getType());

				networks.add(network);
			}
		}
		return networks;
	}
}
