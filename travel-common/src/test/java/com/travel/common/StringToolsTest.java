package com.travel.common;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.gson.Gson;
import com.travel.utils.StringTools;
import com.travel.utils.StringTools.Position;

public class StringToolsTest {

	@Test
	public void testExtractWords(){
		String str1 = "this is a good game.";
		String str2 = "这个是我从TA上看到的";
		Map<String,Position> ens1 = StringTools.extractEnglishWithPos(str1);
		Map<String,Position> ens2 = StringTools.extractEnglishWithPos(str2);
		Gson gson = new Gson();
		System.out.println(gson.toJson(ens1));
		System.out.println(gson.toJson(ens2));
	}
	
	@Test
	public void testCode(){
		String val = "这个是我从TA上看到的";
		Map<String,Position> termPosMap = StringTools.extractEnglishWithPos(val);
		for(Entry<String,Position> entry:termPosMap.entrySet()){
			String word = entry.getKey();
			Position p = entry.getValue();
			if(word.toLowerCase().equals("ta")){
				val = val.substring(0,p.start)+" (#) "+val.substring(p.end);
			}
		}
		System.out.println(val);
	}
}
