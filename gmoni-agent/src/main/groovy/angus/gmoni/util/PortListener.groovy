package angus.gmoni.util


import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/*
 * 监控服务器的port，设置application.properties的server.port=port 0表示随机端口
 */
@Component
class PortListener implements 
	ApplicationListener<EmbeddedServletContainerInitializedEvent> {
	
	private int port;

	@Override
	public void onApplicationEvent(final EmbeddedServletContainerInitializedEvent event) {
		port = event.getEmbeddedServletContainer().getPort();
	}
	
	public int getPort() {
		return port;
	}
	
}
