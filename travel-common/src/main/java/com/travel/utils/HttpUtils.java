package com.travel.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.log4j.Logger;

public class HttpUtils {
	private static Logger logger = Logger.getLogger(HttpUtils.class);

	public static String get(String requestUrl, Map<String, String> params) throws IOException {
		InputStream ins = null;
		try {
			String urlStr = requestUrl + "?" + parseParams(params);
			logger.info("request url : " + urlStr);
			URL url = new URL(urlStr);
			URLConnection connection = url.openConnection();
			connection.connect();
			ins = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			return sb.toString();
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String parseParams(Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		for (String key : params.keySet()) {
			sb.append(key);
			sb.append("=");
			String value = params.get(key);
			if (value != null) {
				sb.append(value);
			}
			sb.append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
