package com.travel.comment.fetcher.http;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import com.travel.utils.TravelUtils;
@Deprecated
public class AsyncTask extends HttpTask {
	static public final Log log = LogFactory.getLog(AsyncTask.class);
	public String url;
	public int trynt = 3;
	public Map<String, String> params;
	public String charsetName = "UTF-8";

	@Override
	public String run() {
		for (int i = 0; i < trynt; i++) {
			CloseableHttpAsyncClient httpclient = HttpAsyncClients
					.createDefault();
			try {
				httpclient.start();
				HttpGet request = new HttpGet(url);
				Future<HttpResponse> future = httpclient.execute(request, null);
				HttpResponse response = future.get();
				code = response.getStatusLine().getStatusCode();
				String result = HttpCommonUtils.readFromInputStream(response.getEntity()
						.getContent(), charsetName);
				if(TravelUtils.isEmpty(result)){
					throw new Exception("Exception http response is empty ");
				}
				return result;
			} catch (Exception e) {
				log.warn("exception", e);
			} finally {
				try {
					httpclient.close();
				} catch (IOException e) {
					log.warn("exception", e);
				}
			}
		}
		return null;
	}
}
