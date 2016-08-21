package angus.gmoni.util;

import java.io.IOException;

import angus.gmoni.domain.local.FileInfo;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JsonToClassTest {
	
	public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");

	OkHttpClient client = new OkHttpClient();

	String post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder()
				.url(url)
				.post(body)
				.build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	
	String run(String url) throws IOException {
		Request request = new Request.Builder()
				.url(url)
				.build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public static void main(String[] args) throws IOException {
		String url = "http://localhost:8090/file";
		JsonToClassTest test = new JsonToClassTest();
		   RequestBody formBody = new FormBody.Builder()
				    .add("path", "/home/hsiung/code/history.txt")
				    .build();
		   Request request = new Request.Builder()
					.url(url)
					.post(formBody)
					.build();
		   
		   	OkHttpClient client = new OkHttpClient();
			Response response = client.newCall(request).execute();
			String res = response.body().string();
			FileInfo fileInfo = JsonUtil.string2Object(res, FileInfo.class);
			assert fileInfo != null;
			System.out.println(res);
			System.out.println(fileInfo.getLastModifiedTime()+fileInfo.getName());
	}
	
	
}
