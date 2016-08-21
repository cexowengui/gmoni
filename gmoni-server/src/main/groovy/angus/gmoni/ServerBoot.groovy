package angus.gmoni

import groovy.transform.TypeChecked

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@TypeChecked
@SpringBootApplication
class ServerBoot {
	
	static void main(String[] args){
		configNode();
		new SpringApplicationBuilder()
				.sources(ServerBoot.class)
				.bannerMode(Banner.Mode.OFF)
				.run()
	}
	
	
	static void configNode(){
		//启动server之前，需要预先设置好数据中的node表，表示需要监视的节点
		//可以采用json文件，配置好，读取，然后持久化即可。
	}

}
