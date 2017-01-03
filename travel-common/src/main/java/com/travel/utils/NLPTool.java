package com.travel.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class NLPTool implements InitializingBean{
	static public final Log log = LogFactory.getLog(NLPTool.class);
	private boolean isFilteredFullStopWord;
	private Set<String> punctions;
	private Set<String> stopWords;
	private Set<String> fullStopWords;
	private Set<String> enStopWords;
	private Set<String> transEnDirtyPrefixSet;
	public List<String> removeStopWords(String[] words){
		List<String> terms = new LinkedList<String>();
		for(String word:words){
			if(isFilteredFullStopWord){
				if(!isFullStopWord(word))terms.add(word);
			}else{
				if(!isStopWord(word))terms.add(word);
			}
		}
		return terms;
	}
	public List<String> fackedRemoveStopWords(String[] words){
		List<String> terms = new LinkedList<String>();
		for(String word:words){
			if(!punctions.contains(word)){
				terms.add(word);
			}
		}
		return terms;
	}
	public boolean isStopWord(String w){
		if(TravelUtils.isEmpty(w))return true;
		return stopWords.contains(w);
	}
	public boolean isFullStopWord(String w){
		if(TravelUtils.isEmpty(w))return true;
		return fullStopWords.contains(w);
	}
	public List<String> removeStopWord(String[] items){
		List<String> result = new LinkedList<String>();
		for(String item:items){
			if(isStopWord(item))continue;
			result.add(item);
		}
		return result;
	}
	public List<String> segmentEnSentence(String sentence){
		List<String> terms = new LinkedList<String>();
		String[] words = sentence.split("[～~,.?;!\\s]");
		for(String s:words){
			if(TravelUtils.isNotEmpty(s)){
				if(s.length()==1){
					char c = s.charAt(0);
					if((c>='a' && c<='z') 
							|| (c>='A' && c<='Z')){
						terms.add(s);
					}
				}else{
					terms.add(s);
				}
			}
		}
		return terms;
	}
	/**
	 * 删除
	 * @param c
	 * @return
	 */
	public String removeDirtyTransEn(String sentence){
		String[] terms = sentence.split("\\s");
		if(transEnDirtyPrefixSet.contains(terms[0])){
			return sentence.substring(terms[0].length());
		}
		return sentence;
	}
	public boolean isPunction(String c){
		return punctions.contains(c);
	}
	public List<String> splitTranslationEnSentence(String sentence){
		List<String> terms = new LinkedList<String>();
		String[] words = sentence.split("[～~.?;!]");
		for(String s:words){
			if(TravelUtils.isNotEmpty(s)){
				if(s.length()==1){
					char c = s.charAt(0);
					if((c>='a' && c<='z') 
							|| (c>='A' && c<='Z')){
						terms.add(s.trim());
					}
				}else{
					terms.add(s.trim());
				}
			}
		}
		return terms;
	}
	public int computeEnTermLen(String sentence){
		String[] words = sentence.split("[～~,.?;!\\s]");
		int len = 0;
		for(String s:words){
			if(TravelUtils.isNotEmpty(s)){
				if(s.length()==1){
					char c = s.charAt(0);
					if((c>='a' && c<='z') 
							|| (c>='A' && c<='Z')){
						len++;
					}
				}else{
					len++;
				}
			}
		}
		return len;
	}
	private Map<String,String> prepareTranslateDict;
	public String prepareTranslate(String sentence){
		for(Entry<String,String> ent:prepareTranslateDict.entrySet()){
			sentence = sentence.replaceAll(" "+ent.getKey()+" ", " "+ent.getValue()+" ");
			sentence = sentence.replaceAll(" "+ent.getKey()+",", " "+ent.getValue()+",");
			sentence = sentence.replaceAll(" "+ent.getKey()+"$", " "+ent.getValue()+" ");
			sentence = sentence.replaceAll("^"+ent.getKey()+" ", " "+ent.getValue()+" ");
			sentence = sentence.replaceAll("^"+ent.getKey()+"$", " "+ent.getValue()+" ");
		}
		return sentence;
	}
	public void afterPropertiesSet() throws Exception {
		prepareTranslateDict = new HashMap<String,String>();
		List<String> enConverts = FileUtils.readLinesFromFile("config/en_convert.txt");
		for(String c:enConverts){
			String[] f = c.split("=");
			if(f.length<2)continue;
			for(int i=1;i<f.length;i++){
				prepareTranslateDict.put(f[i], f[0]);
			}
		}
		isFilteredFullStopWord = ConfigTool.props.getProperty(
				"is_full_stop_word", "0").equals("1") ? true : false;
		punctions = new HashSet<String>();
		punctions.addAll(FileUtils.readLinesFromFile("config/punctions"));
		log.info("load punctions size:"+punctions.size());
		
		stopWords = new HashSet<String>();
		stopWords.addAll(FileUtils.readLinesFromFile("config/stop_words"));
		log.info("load stop words size:"+stopWords.size());

		fullStopWords = new HashSet<String>();
		fullStopWords.addAll(FileUtils.readLinesFromFile("config/full_stop_words"));
		log.info("load full stop words size:"+fullStopWords.size());
		
		enStopWords = new HashSet<String>();
		enStopWords.addAll(FileUtils.readLinesFromFile("config/en_stop_words"));
		log.info("load en stop words size:"+enStopWords.size());
		
		transEnDirtyPrefixSet = new HashSet<String>();
		transEnDirtyPrefixSet.addAll(FileUtils.readLinesFromFile("trans_en_prefix.txt"));
	}
	
	public String removePunctions(String sentence,String replacement){
		sentence = sentence.replaceAll("[～~,.?;!\\s，。！～；、\\-–…【】]", replacement);
		return sentence;
	}
	public int absLenOfZhSentence(String sentence){
		sentence = sentence.replaceAll("[～~,.?;!\\s，。！～；、\\-–…【】]", "");
		return TravelUtils.smartLengthWithoutPunctuation(sentence);
	}
	public static void main(String args[]){
		String sentence = "因为你在那里,所以我在那里……– 【人人分享-人人网】";
		System.out.println(sentence.replaceAll("[～~,.?;!\\s，。！～；、\\-–…【】]", ""));
	}
}
