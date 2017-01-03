package com.travel.utils;

import java.io.UnsupportedEncodingException;

import fjtrans.Char;

public class CharUtils {

	@Deprecated
	public static boolean isJapaneseChar(char c) {
		return false;
	}

	public static boolean isChineseString(String str) {
		for (int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);
			if (!isChineseChar(c) && !isSeparateChar(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isChineseChar(char c) {
		return (c >= '\u4e00' && c <= '\u9fbf') || c == 63803 || c == 63844 || c == 63934 || c == 64017 || c == 64027 || c == 63969;
	}

	public static boolean isDigitalString(String str) {
		for (int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);
			if (!isDigitalChar(c) && !isSeparateChar(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDigitalChar(char c) {
		return (c >= '0' && c <= '9') || (c >= '０' && c <= '９');
	}

	
	public static boolean isEnglishOrDigitalStr(String str){
		for (int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);
			if (!isEnglishChar(c) && !isSeparateChar(c) && !isDigitalChar(c)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isEnglistString(String str) {
		for (int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);
			if (!isEnglishChar(c) && !isSeparateChar(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEnglishChar(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= 'ａ' && c <= 'ｚ') || (c >= 'Ａ' && c <= 'Ｚ');
	}

	public static boolean isSplitChar(char c) {
		return c == '\\' || c == '|' || c == '/' || c == '丨' || c == '／';
	}

	public static boolean isSeparateString(String str) {
		for (int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);
			if (!isSeparateChar(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSeparateChar(char c) {
		return (!isEnglishChar(c) && !isDigitalChar(c) && (c >= '\u0021' && c <= '\u007E')) || c == ' ' || c == '‧' || c == '，' || c == '；' || c == '、' || c == '：' || c == '！' || c == '‘' || c == '’' || c == '“' || c == '”' || c == '—' || c == '−' || c == '…' || c == '。' || c == '《' || c == '》' || c == '〈' || c == '〉' || (c >= 8192 && c <= 8207) || (c >= 698 && c <= 703) || (c >= 8192 && c <= 8207) || c == '丨' || c == '　' || c == '•' || c == '–' || c == '°' || (c >= '！' && c <= '／') || c == 141 || c == 143 || c == 144 || c == 157 || c == 160 || c == 173 || c == 183 || c == 12291 || c == 12539 || c == 12442 || c == 12443 || c == 12444 || c == 12685 || c == 128 || c == 142 || c == 150 || c == 65038 || c == 65309 || c == 65106 || c == 65117 || c == 65118 || c == 65123 || c == 65279 || c == 65532 || (c >= 65308 && c <= 65312) || (c >= 8232 && c <= 8236) || (c >= 65371 && c <= 65381) || (c >= 1 && c <= 32);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(isSeparateChar('‧'));
		System.out.println(isDigitalChar('1'));
		System.out.println("134-5".matches("[0-9]*"));
		String str = "15000韩元";
		for(int index = 0; index < str.length();index++){
			System.out.println(str.charAt(index));
		}
	}
}
