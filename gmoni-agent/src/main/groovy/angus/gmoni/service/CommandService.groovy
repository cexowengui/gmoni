package angus.gmoni.service

import angus.gmoni.domain.Command


interface  CommandService {
	
	String execute(String cmd)
	
	String start(String cmd, boolean background)
	
	String consume(String id)
	
	void terminate(String id)

	String getStatus(String id)
	
	List<Command> getCommands()
	
	Command getCommand(String id)

}
