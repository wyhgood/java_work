package com.travel.utils;

import java.util.HashSet;

public class RemovePunctuation{
	static private HashSet<String> punctuation_set;
	static {
		// TODO Auto-generated method stub
		String punctuationFile = ConfigTool.props.getProperty("punctuation_file","punctuation.txt");
		punctuation_set = new HashSet<String>(FileUtils.readLinesFromFile(punctuationFile));
	}
	
	static public String RemovePunc(String text){
		String res = "";
		for(char c:text.toCharArray()){
			res+=punctuation_set.contains(String.valueOf(c))?"":c;
		}
		return res;
	}
	
	
	
	
}