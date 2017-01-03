package com.travel.comment.fetcher.http;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.message.BasicHeader;

abstract public class HttpTask {
	static public final Log log = LogFactory.getLog(HttpTask.class);
	public HttpClientParams params;
	public String redirectUrl;
	public List<Header> headers;
	public List<Cookie> cookies;
	public String jsonParams;
	public Proxy proxy;
	public int code;
	abstract public String run();
	public void sleep(long secs){
		try {
			TimeUnit.SECONDS.sleep(secs);
		} catch (InterruptedException e) {
			log.warn("InterruptedException",e);
		}
	}
	public org.apache.http.Header convert(org.apache.commons.httpclient.Header header){
		return new BasicHeader(header.getName(), header.getValue());
	}
}
