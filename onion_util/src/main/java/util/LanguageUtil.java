package util;

public class LanguageUtil {
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否是汉字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isOnlyChinese(String str) {
		str = str.replaceAll("[0-9]", "");
		str = StringNormalize.normalize(str);
		str = str.replaceAll("\\s", "");
		if (str.length() == 0) {
			return false;
		}
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!isChinese(c)) {
				return false;
			}
		}
		return true;
	}

	// 完整的判断中文汉字和符号，数字返回true
	public static boolean isChinese(String strName) {

		strName = strName.replaceAll("\\s", "");
		strName = strName.replaceAll("[0-9]", "");
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!isChinese(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean hasChinese(String strName) {

		strName = strName.replaceAll("\\s", "");
		strName = strName.replaceAll("[0-9]", "");
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isEnglishWord(String strName) {

		strName = strName.replaceAll("\\s", "");
		strName = strName.replaceAll("[0-9]", "");
		boolean sign = true; // 初始化标志为为'true'
		for (int i = 0; i < strName.length(); i++) {
			if (!(strName.charAt(i) >= 'A' && strName.charAt(i) <= 'Z') && !(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z')) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSymbol(char ch) {
		if (isCnSymbol(ch))
			return true;
		if (isEnSymbol(ch))
			return true;

		if (0x2010 <= ch && ch <= 0x2017)
			return true;
		if (0x2020 <= ch && ch <= 0x2027)
			return true;
		if (0x2B00 <= ch && ch <= 0x2BFF)
			return true;
		if (0xFF03 <= ch && ch <= 0xFF06)
			return true;
		if (0xFF08 <= ch && ch <= 0xFF0B)
			return true;
		if (ch == 0xFF0D || ch == 0xFF0F)
			return true;
		if (0xFF1C <= ch && ch <= 0xFF1E)
			return true;
		if (ch == 0xFF20 || ch == 0xFF65)
			return true;
		if (0xFF3B <= ch && ch <= 0xFF40)
			return true;
		if (0xFF5B <= ch && ch <= 0xFF60)
			return true;
		if (ch == 0xFF62 || ch == 0xFF63)
			return true;
		if (ch == 0x0032)
			return true;
		if (ch == 0x3000)
			return true;
		return false;

	}

	static boolean isCnSymbol(char ch) {
		if (0x3004 <= ch && ch <= 0x301C)
			return true;
		if (0x3020 <= ch && ch <= 0x303F)
			return true;
		return false;
	}

	static boolean isEnSymbol(char ch) {

		if (ch == 0x40)
			return true;
		if (ch == 0x2D || ch == 0x2F)
			return true;
		if (0x23 <= ch && ch <= 0x26)
			return true;
		if (0x28 <= ch && ch <= 0x2B)
			return true;
		if (0x3C <= ch && ch <= 0x3E)
			return true;
		if (0x5B <= ch && ch <= 0x60)
			return true;
		if (0x7B <= ch && ch <= 0x7E)
			return true;

		return false;
	}

	public static boolean isPunctuation(char ch) {
		if (isCjkPunc(ch))
			return true;
		if (isEnPunc(ch))
			return true;

		if (0x2018 <= ch && ch <= 0x201F)
			return true;
		if (ch == 0xFF01 || ch == 0xFF02)
			return true;
		if (ch == 0xFF07 || ch == 0xFF0C)
			return true;
		if (ch == 0xFF1A || ch == 0xFF1B)
			return true;
		if (ch == 0xFF1F || ch == 0xFF61)
			return true;
		if (ch == 0xFF0E)
			return true;
		if (ch == 0xFF65)
			return true;

		return false;
	}

	static boolean isEnPunc(char ch) {
		if (0x21 <= ch && ch <= 0x22)
			return true;
		if (ch == 0x27 || ch == 0x2C)
			return true;
		if (ch == 0x2E || ch == 0x3A)
			return true;
		if (ch == 0x3B || ch == 0x3F)
			return true;

		return false;
	}

	static boolean isCjkPunc(char ch) {
		if (0x3001 <= ch && ch <= 0x3003)
			return true;
		if (0x301D <= ch && ch <= 0x301F)
			return true;

		return false;
	}

	// public static boolean isSymbol(String strName) {
	// char[] ch = strName.toCharArray();
	// for (int i = 0; i < ch.length; i++) {
	// char c = ch[i];
	// if (isSymbol(c)) {
	// return true;
	// }
	// }
	// return false;
	// }
	public static boolean isPunction(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isPunctuation(c)) {
				return true;
			}
		}
		return false;
	}

	public static String removePunction(String strInput) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strInput.length(); i++) {
			char c = strInput.charAt(i);
			if (isPunction(c + "")) {
				continue;
			}
			sb.append(c);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(isSymbol('\002'));
	}
}
