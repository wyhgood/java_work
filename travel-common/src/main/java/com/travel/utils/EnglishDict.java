package com.travel.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnglishDict {
	private static Map<String, List<String>> enWordCnWordMap = new HashMap<String, List<String>>();
	private static volatile boolean isLoad = false;
	public static String pathname;

	public static void load(String pathname) {
		if (isLoad) {
			return;
		}
		synchronized (enWordCnWordMap) {
			if (isLoad) {
				return;
			}
			BufferedReader br = null;
			try {
				File file = new File(pathname);
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					String[] lineSplits = line.split("[\\s]+");
					if (lineSplits.length < 2) {
						continue;
					}
					String enWord = lineSplits[0];
					List<String> cnWordList = enWordCnWordMap.get(enWord);
					if (cnWordList == null) {
						cnWordList = new ArrayList<String>();
						enWordCnWordMap.put(enWord, cnWordList);
					}
					for (int index = 1; index < lineSplits.length; index++) {
						cnWordList.add(lineSplits[index]);
					}
				}
			} catch (Exception e) {
				enWordCnWordMap = new HashMap<String, List<String>>();
				isLoad = false;
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (Exception e) {

				}
			}
		}
	}

	public static List<String> getZhCN(String word) {
		load(pathname);
		List<String> result = enWordCnWordMap.get(word);
		if (result == null || result.isEmpty()) {
			result = new ArrayList<String>();
			result.add(word);
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		// translate("/Users/lijunpeng/Desktop/a.txt", null);
		pathname = "/Users/lijunpeng/Desktop/en_cn_word.txt";
		System.out.println(String.join("\t", getZhCN("music")));
	}

	public static void translate(String input, String output) throws Exception {
		File inputFile = new File(input);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "GBK"));
		Pattern pattern = Pattern.compile("[^a-z]*([a-z&\\.]+\\.)[^a-z]*");
		String line = null;
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.matches("[a-zA-X\\s]+") || line.equals("大学英语四级考试大纲") || line.length() == 0) {
				continue;
			}
			String[] lineSplits = line.split("[\\s]+");
			List<String> itemList = new ArrayList<String>();
			for (String item : lineSplits) {
				Matcher matcher = pattern.matcher(item);
				while (matcher.find()) {
					item = item.replace(matcher.group(1), "");
				}
				item = item.trim();
				if (item.length() > 0) {
					String[] itemSplits = item.split("[，,;；]+");
					for (String itemSplit : itemSplits) {
						itemSplit = itemSplit.replaceAll("…", "");
						itemSplit = itemSplit.replaceAll("\\(.*\\)", "");
						itemSplit = itemSplit.replaceAll("（.*）", "");
						itemList.add(itemSplit);
					}
				}
			}
			System.out.println(String.join("\t", itemList));
		}
		br.close();
	}
}
