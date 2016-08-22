package angus.gmoni.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import angus.gmoni.domain.local.Node;

public class NodeParserTest {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		DateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		mapper.setDateFormat(myDateFormat);
		
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream json = classloader.getResourceAsStream("nodes.json");
		
		List<Node> nodes = mapper.readValue(json, new TypeReference<List<Node>>(){});
		
		assert nodes != null;
		for(Node it:nodes){
			System.out.println(it.getAgent());
		}
		
		
	}

}
