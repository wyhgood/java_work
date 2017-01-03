package com.travel.comment.fetcher.http;

import java.io.InputStream;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.travel.utils.ConfigTool;
import com.travel.utils.TravelUtils;

public class FetchTask extends HttpTask{
	static public final Log log = LogFactory.getLog(FetchTask.class);
	static public int TIMEOUT_MS;
	static{
		TIMEOUT_MS = Integer.parseInt(ConfigTool.props.getProperty("timeout_ts", "20000"));
	}
	public String url;
	public int trynt = 3;
	public String charsetName = "UTF-8";
	public String run() {
		HttpClient client = new HttpClient();
		if(proxy!=null && TravelUtils.isNotEmpty(proxy.getIp())){
			log.info("use proxy "+proxy.getIp()+" port:"+proxy.getPort());
			client.getHostConfiguration().setProxy(proxy.getIp(), proxy.getPort());
		}else log.info("use local http");
		client.getHttpConnectionManager().getParams().setConnectionTimeout(TIMEOUT_MS);
		client.getHttpConnectionManager().getParams().setSoTimeout(TIMEOUT_MS);
		HttpMethod m = null;
		for(int i=0;i<trynt;i++){
			try{
				m = new GetMethod(url);
				if(params!=null)client.setParams(params);
				if(headers!=null){
					for(Header header:headers){
						m.addRequestHeader(header);
					}
				}
				if(cookies!=null){
					for(Cookie c:cookies){
						client.getState().addCookie(c);
					}
				}
				code = client.executeMethod(m);
				redirectUrl = m.getURI().toString();
				InputStream in = m.getResponseBodyAsStream();
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
				String result = HttpCommonUtils.readFromInputStream(in,charsetName);
				if(TravelUtils.isEmpty(result)){
					throw new Exception("Exception http response is empty ");
				}
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
			}
		}
		log.warn("url request exception:"+url);
		proxy.setBad(true);
		return null;
	}
}
