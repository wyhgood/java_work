package com.travel.utils;

import info.debatty.java.stringsimilarity.Cosine;
import info.debatty.java.stringsimilarity.JaroWinkler;
import info.debatty.java.stringsimilarity.Levenshtein;
import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import info.debatty.java.stringsimilarity.interfaces.NormalizedStringSimilarity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static String trim(String str) {
		if (str == null) {
			return null;
		}
		return str.trim();
	}

	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}

		for (int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);
			if (!Character.isWhitespace(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEmpty(List<String> strList) {
		if (strList == null || strList.isEmpty()) {
			return true;
		}

		for (String str : strList) {
			if (!isEmpty(str)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEquals(String str1, String str2) {
		return isEquals(str1, str2, 0.9);
	}

	public static boolean isEquals(String str1, String str2, double t) {
		if (str1.equals(str2)) {
			return true;
		}
		NormalizedStringSimilarity stringSimilarity = new JaroWinkler(t);
		double sim = stringSimilarity.similarity(str1, str2);
		System.out.println(sim);
		return sim >= t;
	}

	public static boolean containsCN(String str) {
		Pattern pattern = Pattern.compile(".*[\\u4e00-\\u9fa5]+.*");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static boolean containsEN(String str, int num) {
		Pattern pattern = Pattern.compile(".*[a-zA-Z\\s]{" + num + ",}.*");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static void main(String[] args) {
//		for (int m = 0; m < 5; m++) {
//			for (int i = 1; i < 102; i++) {
//				if (i % 5 == m) {
//					System.out.println("http://121.43.102.248:1234/test-case-compare.html?pageSize=50&pageNum=" + i);
//				}
//			}
//		}
		System.out.println(isEquals("永珍越南食館", "永珍越南菜館",0.8));
		NormalizedStringSimilarity similarity = new NormalizedLevenshtein();
		System.out.println(similarity.similarity("永珍越南食館", "永珍越南菜館"));
		
		Levenshtein l = new Levenshtein();
		System.out.println(l.distance("永珍越南食館", "永珍越南菜館"));
	}
	
	static public String removeAllWhiteSpace(String val){
		val = val.replaceAll("[　*| *| *|//s*]*", "");
		return val;
	}
}
