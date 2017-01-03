package com.travel.data;

import java.util.HashSet;

public class AnalyzedWord {

	public static String IGNORE = "IGNORE";
	public static String ENTITY = "ENTITY";
	public static String FOOD_NAME = "FOOD_NAME";
	public static String GEO = "GEO";
	public static String FOOD_COOK_WAY = "FOOD_COOK_WAY";
	public static String FOOD_ATOM = "FOOD_ATOM";
	public static String FOOD_SHAPE = "FOOD_SHAPE";
	public static String FOOD_TASTE = "FOOD_TASTE";
	public static String COUNTRY_CITY = "COUNTRY_CITY";

	public String strWord = "";
	public HashSet<String> types = new HashSet<String>();

	public String toReadableString() {
		return strWord + "(" + types + ")";
	}

	public AnalyzedWord copy() {
		AnalyzedWord word = new AnalyzedWord();
		word.strWord = strWord.trim();
		word.types.addAll(types);
		return word;
	}

}
