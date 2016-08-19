package angus.gmoni.service.impl

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

import org.springframework.stereotype.Service

import angus.gmoni.service.CollectServiceI


@Service
class CollectService implements CollectServiceI{

	@Override
	public void collectProcess() {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectEverything() {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectGc() {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectStack() {
		// TODO Auto-generated method stub

	}




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
}
