package com.travel.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringTools {
	static public class Position{
		public int start;
		public int end;
	}
	static Logger log = LoggerFactory.getLogger(StringTools.class);
	static public String[] punctuationChar = 
			new String[]{"\\,","\\.","\\[","\\]","\\-","\\(","\\)",
						"_","。","，","“","”","！","!","（","）","'"
						,"\\{","\\}","/"};
	/**
	 * 判断是否为英文单词
	 * @param word
	 * @return
	 */
	public static boolean strIsEnglish(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
					&& !(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
				return false;
			}
		}
		return true;
	}
	/**
	 * remove words from string val
	 * @param word
	 * @param removeWords
	 * @return
	 */
	static public String replaceWord(String val,List<String> removeWords){
		for(String w:removeWords){
			val = val.replaceAll(w, " ");
		}
		return val;
	}
	/**
	 * return bigram word list
	 * @param val
	 * @return
	 */
	static public List<String> bigramStrs(String val){
		List<String> list = new ArrayList<String>();
		
		val = replacePunctuationChar(val);
		String[] words = val.split("\\s");
		for(String word:words){
			if(strIsEnglish(word)){
				if(!word.trim().isEmpty())list.add(word);
				continue;
			}
			//extract english word
			List<String> exts = extractEnglish(word);
			if(exts.size()!=0){
				list.addAll(exts);
				word = replaceWord(word,exts);
			}
			//extractor number
			List<String> nums = extractNumber(word);
			if(nums.size()!=0){
				list.addAll(nums);
				word = replaceWord(word,nums);
			}
			
			//TODO
			if(word.length()==1){
				list.add(word);
				continue;
			}
			for(int i=0;i<word.length();i++){
				if((i+2)>word.length()-1){
					list.add(""+word.charAt(i)+word.charAt(i+1));
					break;
				}
				list.add(word.substring(i, i+2));
			}
		}
		log.debug("val:"+val+" bigram:"+list);
		return list;
	}
	
	/**
	 * 删除一些标点符号
	 * @param val
	 * @return
	 */
	static public String replacePunctuationChar(String val	){
		for(String c:punctuationChar){
			val = val.replaceAll(c, " ");
		}
		return val;
	}
	static public List<String> extractEnglish(String word){
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile("([a-zA-Z]+)");
		Matcher matcher = p.matcher(word);
		while(matcher.find()){
			list.add(matcher.group(1));
		}
		return list;
	}
	static public Map<String,Position> extractEnglishWithPos(String sentence){
		Map<String,Position> posMap = new HashMap<String,Position>();
		Pattern p = Pattern.compile("([a-zA-Z]+)");
		Matcher matcher = p.matcher(sentence);
		while(matcher.find()){
			String word = matcher.group(1);
			int start = matcher.start();
			int end = matcher.end();
			Position pos = new Position();
			pos.start = start;
			pos.end = end;
			posMap.put(word, pos);
		}
		return posMap;
	}
	static public List<String> extractNumber(String word){
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile("([0-9]+)");
		Matcher matcher = p.matcher(word);
		while(matcher.find()){
			list.add(matcher.group(1));
		}
		return list;
	}
	public static void main(String args[]){
		System.out.println(bigramStrs("今天的天很不错，。,.this is a  (hong kong)"));
		//extractEnglish("今天的/天很不错this is a  (hong kong)");
	}
}
