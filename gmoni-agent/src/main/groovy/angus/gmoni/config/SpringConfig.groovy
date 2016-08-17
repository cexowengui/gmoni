package angus.gmoni.config

import groovy.transform.TypeChecked

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc

import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

@TypeChecked
@Configuration
@EnableWebMvc
class SpringConfig {

	
	//
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
		MappingJackson2HttpMessageConverter jsonConverter  = new MappingJackson2HttpMessageConverter()
		ObjectMapper objectMapper = new ObjectMapper()
		
		//objectMapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE)
		//objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true)
		jsonConverter.setObjectMapper(objectMapper)
		jsonConverter
	}
	
	
}
