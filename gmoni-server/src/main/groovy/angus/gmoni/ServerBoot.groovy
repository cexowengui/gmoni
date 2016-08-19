package angus.gmoni

import groovy.transform.TypeChecked

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@TypeChecked
@SpringBootApplication
class ServerBoot {
	
	static void main(String[] args){
		new SpringApplicationBuilder()
				.sources(ServerBoot.class)
				.bannerMode(Banner.Mode.OFF)
				.run()
	}
	

}
