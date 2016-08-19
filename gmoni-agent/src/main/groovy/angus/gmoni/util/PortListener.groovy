package angus.gmoni.util


import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/*
 * ��ط�������port������application.properties��server.port=port 0��ʾ����˿�
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
