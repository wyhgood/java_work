package com.travel.comment.fetcher.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpCommonUtils {
	static public final Log log = LogFactory.getLog(HttpCommonUtils.class);
	static public String readFromInputStream(InputStream in,String charsetName) throws Exception{
		StringBuilder sb = new StringBuilder();
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(in,charsetName));
			String line = null;
			while((line=reader.readLine())!=null){
				sb.append(line);
			}
		}catch(Exception e){
			log.warn("exception",e);
			throw e;
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				log.warn("exception",e);
			}
		}
		return sb.toString();
	}
}
