package com.travel.utils;

import java.util.Stack;

import org.apache.commons.lang.StringUtils;

public class SentenceFormatter {
	/**
	 * 处理不匹配的括号
	 * @param s
	 * @return
	 */
	static public String removeMisMatchBracket(String s){
		if(TravelUtils.isEmpty(s))return s;
		if(!matchBracket(s)){
			s = s.replaceAll("[()（）【】｛｝]","");
		}
		return s;
	}
	/**
	 * 判断括号是否匹配
	 * @param s
	 * @return true:match false:not
	 */
	static public boolean matchBracket(String s) {
		Stack<Character> sc = new Stack<Character>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(' || c[i] == '[' || c[i] == '{' || c[i] == '（' || c[i] == '【') {
				sc.push(c[i]);
			} else if (c[i] == ')') {
				if (sc.isEmpty()) {
					return false;
				} else {
					if (sc.peek() == '(') {
						sc.pop();
					}
				}
			} else if (c[i] == ']') {
				if (sc.isEmpty()) {
					return false;
				} else {
					if (sc.peek() == '[') {
						sc.pop();
					}
				}
			} else if (c[i] == '}') {
				if (sc.isEmpty()) {
					return false;
				} else {
					if (sc.peek() == '{') {
						sc.pop();
					}
				}
			} else if (c[i] == '）') {
				if (sc.isEmpty()) {
					return false;
				} else {
					if (sc.peek() == '（') {
						sc.pop();
					}
				}
			} else if (c[i] == '】') {
				if (sc.isEmpty()) {
					return false;
				} else {
					if (sc.peek() == '【') {
						sc.pop();
					}
				}
			}
		}
		if (sc.empty()) {
			return true;
		} else {
			return false;
		}
	}

	static public String format(String sentence) {
		if (TravelUtils.isEmpty(sentence))
			return sentence;
		sentence = formatBracket(sentence);
		sentence = formatQuotes(sentence);
		return sentence;
	}

	static public String formatBracket(String sentence) {
		int leftBracket = StringUtils.countMatches(sentence, "(");
		int rightBracket = StringUtils.countMatches(sentence, ")");
		if (leftBracket != rightBracket) {
			sentence = StringUtils.replace(sentence, "(", "");
			sentence = StringUtils.replace(sentence, ")", "");
		}
		leftBracket = StringUtils.countMatches(sentence, "（");
		rightBracket = StringUtils.countMatches(sentence, "）");
		if (leftBracket != rightBracket) {
			sentence = StringUtils.replace(sentence, "（", "");
			sentence = StringUtils.replace(sentence, "）", "");
		}
		return sentence;
	}
	/**
	 * 处理引号对问题
	 * @param sentence
	 * @return true:bad false:good
	 */
	static public boolean isBadQuote(String sentence){
		int c = StringUtils.countMatches(sentence, "\"");
		if(c%2!=0)return true;
		int ldc = StringUtils.countMatches(sentence, "“");
		int rdc = StringUtils.countMatches(sentence, "”");
		if(ldc!=rdc)return true;
		int sc = StringUtils.countMatches(sentence, "'");
		if(sc%2!=0)return true;
		int lsc = StringUtils.countMatches(sentence, "‘");
		int rsc = StringUtils.countMatches(sentence, "’");
		if(lsc!=rsc)return true;
		return false;
	}
	static public String formatQuotes(String sentence) {
		int leftQuotes = StringUtils.countMatches(sentence, "“");
		int rightQuotes = StringUtils.countMatches(sentence, "”");
		if (leftQuotes != rightQuotes) {
			sentence = StringUtils.replace(sentence, "“", "");
			sentence = StringUtils.replace(sentence, "”", "");
		}
		int enQuotes = StringUtils.countMatches(sentence, "\"");
		if (enQuotes % 2 != 0) {
			sentence = StringUtils.replace(sentence, "\"", "");
		}
		return sentence;
	}

	public static void main(String args[]) {
		String str = "(this is nothing!()";
		System.out.println(StringUtils.countMatches(str, "("));
		System.out.println(removeMisMatchBracket("(this is a good place"));
		System.out.println(formatQuotes("\"this is a good place"));
		System.out.println(isBadQuote("air”，一个善于营销爱情的国度"));
	}
}
