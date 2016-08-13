package angus.gmoni.config

import org.springframework.aop.TrueClassFilter;
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

import groovy.transform.TypeChecked;

@TypeChecked
@Configuration
@EnableWebMvc
class SpringConfig {

	
	//将controller返回的object转换为json
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
		MappingJackson2HttpMessageConverter jsonConverter  = new MappingJackson2HttpMessageConverter()
		ObjectMapper objectMapper = new ObjectMapper()
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true)
		jsonConverter.setObjectMapper(objectMapper)
		jsonConverter
	}
	
	
}
