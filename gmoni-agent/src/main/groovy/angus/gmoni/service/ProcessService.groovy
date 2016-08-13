package angus.gmoni.service

import java.util.List;

import angus.gmoni.domain.Stack;

interface ProcessService {
	
	
	List<angus.gmoni.domain.Process> findProcesses(String[] query)
	
	angus.gmoni.domain.Process getProcess(long pid)
	
	String getInfo(long pid)
	
	List<Stack> getStacks(long pid)
	
	void kill(long pid, int signum)

}
