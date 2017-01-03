package com.travel.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Utils {
	
	public static byte[] decode(String str){
		return Base64.getDecoder().decode(str);
	}
	
	public static String decode(String str, String charsetName){
		byte[] bytes = Base64.getDecoder().decode(str);
		try {
			return new String(bytes, charsetName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
