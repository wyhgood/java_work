package com.travel.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.travel.utils.FileUtils;

public class StopWordsTool{
	static private Map<String,Boolean> stops;
	static public List<String> removeStopWords(List<String> words){
		List<String> result = new ArrayList<String>(words.size());
		for(String word:words){
			if(stops.get(word)==null)result.add(word);
		}
		return result;
	}
	static {
		stops = new HashMap<String,Boolean>();
		List<String> words = FileUtils.readLinesFromFile("config/stopwords_en");
		for(String word:words){
			stops.put(word, true);
		}
	}
	
}
