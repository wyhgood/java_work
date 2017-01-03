package com.travel.comment.fetcher.http;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.ProxyServer;
import com.ning.http.client.Response;
import com.travel.utils.TravelUtils;

public class AsyncFetchTask extends HttpTask{
	static public final Log log = LogFactory.getLog(AsyncFetchTask.class);
	public String url;
	public int trynt = 3;
	public Map<String,String> params;
	public String charsetName = "UTF-8";
	public String run(){
		for(int i=0;i<trynt;i++){
			AsyncHttpClient client = new AsyncHttpClient();
			try {
				BoundRequestBuilder requestBuilder = client.preparePost(url);
				if(params!=null)for(String k:params.keySet()){
					requestBuilder.addFormParam(k, params.get(k));
				}
				if(headers!=null){
					for(Header header:headers){
						requestBuilder.addHeader(header.getName(), header.getName());
					}
				}
				if(proxy!=null && TravelUtils.isNotEmpty(proxy.getIp())){
					log.info("use proxy "+proxy.getIp()+" port:"+proxy.getPort());
					requestBuilder.setProxyServer(new ProxyServer(proxy.getIp(),
							proxy.getPort()));
				}else log.info("use local http");
				if(cookies!=null){
					for(Cookie c:cookies){
						requestBuilder.addCookie(convert(c));
					}
				}
				Future<Response> f = requestBuilder.execute();
			
				Response r = f.get();
				code = r.getStatusCode();
				if(code==404){
					log.warn("page has removed code:"+code+" for url:"+url);
					return null;
				}
				if(code == 403 || code == 503){
					log.warn("ip is forbidden code:"+code+" for url:"+url);
					throw new Exception("Exception response code :"+code);
				}
				if(code!=200){
					log.warn("code:"+code+" for url:"+url);
					sleep(10);
					throw new Exception("Exception response code :"+code);
				}
				InputStream in = r.getResponseBodyAsStream();
				String result = HttpCommonUtils.readFromInputStream(in,charsetName);
				if(TravelUtils.isEmpty(result)){
					throw new Exception("Exception http response is empty ");
				}
				return result;
			} catch (Exception e) {
				log.info("http request try "+(i+1)+" times url:"+url);
				log.warn("exception",e);
				//if code is 403 503 ,then there is no need to retry
				if(code==403||code==503){
					proxy.setBad(true);
					break;
				}else sleep(1);
			} finally{
				client.close();
			}
		}
		log.warn("url request exception:"+url);
		proxy.setBad(true);
		return null;
	}
	public com.ning.http.client.cookie.Cookie convert(Cookie c){
		return new com.ning.http.client.cookie.Cookie(c.getName(),
				c.getValue(),
				"", c.getDomain(), c.getPath(), 100000, 
				10000, false, false);
	}
}
