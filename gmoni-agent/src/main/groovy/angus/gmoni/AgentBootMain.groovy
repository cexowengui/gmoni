package angus.gmoni

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder



@SpringBootApplication
class AgentBootMain {

	static void main(String[] args){
		new SpringApplicationBuilder()
				.sources(AgentBootMain.class)
				.bannerMode(Banner.Mode.OFF)
				.run()
	}
}
