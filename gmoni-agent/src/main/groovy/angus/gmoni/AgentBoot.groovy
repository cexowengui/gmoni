package angus.gmoni

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder



@SpringBootApplication
class AgentBoot {

	static void main(String[] args){
		new SpringApplicationBuilder()
				.sources(AgentBoot.class)
				.bannerMode(Banner.Mode.OFF)
				.run()
	}
}
