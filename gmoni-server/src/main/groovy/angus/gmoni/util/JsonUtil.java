package angus.gmoni.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	static ObjectMapper mapper = new ObjectMapper();

	public static <T> T string2Object(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		T t = mapper.readValue(json, clazz);
		return t;
	}
	
	public static <T> T file2Object(File json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		T t = mapper.readValue(json, clazz);
		return t;
	}
	
	public static <T> String toJson(T obj) throws JsonProcessingException {
		String jsonString = mapper.writeValueAsString(obj);
		return jsonString;
	}
	
	

}
