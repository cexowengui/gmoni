package angus.gmoni.util;

import java.io.File;
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
import com.jayway.jsonpath.internal.Path;

import angus.gmoni.domain.local.Node;

/**
 * parser the initial json file the json file is Nodes configuration
 * 
 * @author hsiung
 *
 */
public class NodeParser {

	public static List<Node> parser() throws JsonParseException, JsonMappingException, IOException {

		return parser(null);
	}

	public static List<Node> parser(String jsonPath) throws JsonParseException, JsonMappingException, IOException {
		String path = jsonPath;
		if (jsonPath == null) {
			path = "nodes.json";
		}

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream json = classloader.getResourceAsStream(path);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		DateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		mapper.setDateFormat(myDateFormat);

		List<Node> nodes = mapper.readValue(json, new TypeReference<List<Node>>(){});

		return nodes;
	}

}
