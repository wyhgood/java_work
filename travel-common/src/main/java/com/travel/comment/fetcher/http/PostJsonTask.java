package com.travel.comment.fetcher.http;

import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.travel.utils.ConfigTool;
import com.travel.utils.TravelUtils;

public class PostJsonTask extends HttpTask {

	static public final Log log = LogFactory.getLog(PostJsonTask.class);
	static public int TIMEOUT_MS;
	static{
		TIMEOUT_MS = Integer.parseInt(ConfigTool.props.getProperty("timeout_ts", "20000"));
	}
	public String url;
	public int trynt = 10;
	public String charsetName = "UTF-8";
	public String run() {
		for(int i=0;i<trynt;i++){
			HttpPost m = null;
			CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			RequestConfig config = null;
			try{
				if(proxy!=null && TravelUtils.isNotEmpty(proxy.getIp())){
					log.info("use proxy "+proxy.getIp()+" port:"+proxy.getPort());
					HttpHost httpProxy = new HttpHost(proxy.getIp(), proxy.getPort(), "http");
					config = RequestConfig.custom()
							.setSocketTimeout(TIMEOUT_MS)
							.setConnectTimeout(TIMEOUT_MS)
							.setCircularRedirectsAllowed(true)
							.setConnectionRequestTimeout(TIMEOUT_MS)
							.setRedirectsEnabled(true)
							.setProxy(httpProxy)
							.build();
				}else log.info("use local http");
				m = new HttpPost(url);
				if(config!=null)m.setConfig(config);
				if(params!=null){
					//TODO
				}
				if(TravelUtils.isNotEmpty(jsonParams)){
					StringEntity entity = new StringEntity(jsonParams);
					entity.setContentEncoding("UTF-8");
					entity.setContentType("application/json");
					m.setEntity(entity);
				}
				if(headers!=null){
					for(Header header:headers){
						m.addHeader(convert(header));
					}
				}
				if(cookies!=null){
					for(Cookie c:cookies){
//						client.getState().addCookie(c);
					}
				}
				response = client.execute(m);
				for(org.apache.http.Header header:response.getAllHeaders()){
					log.debug(header.getName()+"="+header.getValue());
				}
				int code = response.getStatusLine().getStatusCode();
				redirectUrl = m.getURI().toString();
				if(code==404){
					log.warn("page has removed code:"+code+" for url:"+url);
					return null;
				}
				if(code == 403 || code == 503){
					log.warn("ip is forbidden code:"+code+" for url:"+url);
					throw new Exception("Exception response code :"+code);
				}
				if(code!=200){
					log.warn("code:"+code+" for url:"+url + " try after 10s");
					sleep(10);
					throw new Exception("Exception response code :"+code);
				}
				HttpEntity entity = response.getEntity();
				String result = EntityUtils.toString(entity);
				if(TravelUtils.isEmpty(result)){
					throw new Exception("Exception http response is empty ");
				}
				EntityUtils.consume(entity);
				return result;
			}catch(Exception e){
				log.info("http request try "+(i+1)+" times url:"+url);
				log.warn("exception proxy:"+(proxy==null?"local":proxy.getIp()), e);
				//if code is 403 503 ,then there is no need to retry
				sleep(1);
				if((code==403||code==503)&&i==2){
					proxy.setBad(true);
					break;
				}
			}finally{
				if(m!=null){
					m.releaseConnection();
					m.abort();
				}
				try {
					if(response!=null)response.close();
				} catch (IOException e) {
					log.warn("exception",e);
				}
				try {
					if(client!=null)client.close();
				} catch (IOException e) {
					log.warn("exception",e);
				}
			}
		}
		log.warn("url request exception:"+url);
		proxy.setBad(true);
		return null;
	}
}
