package com.travel.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

	static public String extractStr(String content,String regex){
		Matcher matcher = Pattern.compile(regex).matcher(content);
		if(matcher.find()){
			return matcher.group();
		}
		return null;
	}
}
