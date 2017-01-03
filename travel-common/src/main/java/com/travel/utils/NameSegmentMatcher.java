package com.travel.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import util.StringNormalize;

public class NameSegmentMatcher {
	private static Set<String> nameWordSet = new TreeSet<String>();
	private static boolean isLoad = false;

	protected static void loadData() {
		if (isLoad) {
			return;
		}
		synchronized (nameWordSet) {
			if (isLoad) {
				return;
			}
			BufferedReader br = null;
			try {
				String fineName = "name_same";
				br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fineName))));
				String line = null;
				while ((line = br.readLine()) != null) {
					String[] lineSplits = line.split("=");
					List<String> nameList = new ArrayList<String>();
					for(String name : lineSplits){
						name = StringNormalize.normalize(name);
						name = name.replaceAll("[\\s]+", "");
						if(!StringUtils.isEmpty(name)){
							nameList.add(name);
						}
					}
					if(nameList.size() > 1){
						nameWordSet.addAll(nameList);
					}
				}
				isLoad = true;
			} catch (Exception e) {
				isLoad = false;
				nameWordSet.clear();
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static Set<List<String>> getSegments(List<String> segs) {
		loadData();
		List<String> normalizeSegs = new ArrayList<String>();
		for (int index = 0; index < segs.size(); index++) {
			String segItem = StringNormalize.normalize(segs.get(index)).replaceAll("[\\s]", "");
			if(!StringUtils.isEmpty(segItem)){
				normalizeSegs.add(segItem);
			}
		}
		Set<List<String>> resultSet = new HashSet<List<String>>();
		resultSet.add(normalizeSegs);
		for (int i = 0; i < normalizeSegs.size(); i++) {
			List<String> processSegs = new ArrayList<String>();
			for (int j = 0; j < i; j++) {
				processSegs.add(normalizeSegs.get(j));
			}
			List<String> tempSegs = new ArrayList<String>();
			for (int k = i; k < normalizeSegs.size(); k++) {
				tempSegs.add(normalizeSegs.get(k));
			}
			processSegs.addAll(processSegment(tempSegs));
			resultSet.add(processSegs);
		}

		return resultSet;
	}

	private static List<String> processSegment(List<String> segs) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < segs.size();) {
			boolean isMatch = false;
			if (segs.size() - i > 1) {
				for (int k = segs.size(); k > i; k--) {
					StringBuilder sb = new StringBuilder();
					if (k - i > 1) {
						for (int j = i; j < k; j++) {
							sb.append(segs.get(j));
						}
					}
					String word = sb.toString();
					if (word.length() > 0 && nameWordSet.contains(word)) {
						i = k;
						result.add(word);
						isMatch = true;
						break;
					}
				}
			}
			if (!isMatch) {
				result.add(segs.get(i));
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// nameWordSet.add("咖啡店");
		// nameWordSet.add("薯片咖啡");
		// nameWordSet.add("咖啡");
		List<String> segs = new ArrayList<String>();
		segs.add("薯片");
		segs.add("咖");
		segs.add("啡");
		segs.add("店");
		System.out.println(getSegments(segs));
	}
}
