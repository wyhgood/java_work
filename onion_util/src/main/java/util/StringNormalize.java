package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fjtrans.ChineseJFTranslator;

public class StringNormalize {
	private static Map<Character, Character> charMap = new HashMap<Character, Character>();
	private static Set<Character> igonreCharSet = new HashSet<Character>();
	static {
		charMap.put((char) 257, 'a');
		charMap.put((char) 7681, 'a');
		charMap.put((char) 259, 'a');
		charMap.put((char) 7683, 'b');
		charMap.put((char) 261, 'a');
		charMap.put((char) 263, 'c');
		charMap.put((char) 265, 'c');
		charMap.put((char) 267, 'c');
		charMap.put((char) 7691, 'd');
		charMap.put((char) 269, 'c');
		charMap.put((char) 7693, 'd');
		charMap.put((char) 271, 'd');
		charMap.put((char) 273, 'd');
		charMap.put((char) 7697, 'd');
		charMap.put((char) 275, 'e');
		charMap.put((char) 277, 'e');
		charMap.put((char) 279, 'e');
		charMap.put((char) 281, 'e');
		charMap.put((char) 537, 's');
		charMap.put((char) 283, 'e');
		charMap.put((char) 539, 't');
		charMap.put((char) 285, 'g');
		charMap.put((char) 7711, 'f');
		charMap.put((char) 287, 'g');
		charMap.put((char) 543, 'h');
		charMap.put((char) 289, 'g');
		charMap.put((char) 291, 'g');
		charMap.put((char) 293, 'h');
		charMap.put((char) 551, 'a');
		charMap.put((char) 295, 'h');
		charMap.put((char) 297, 'i');
		charMap.put((char) 7723, 'h');
		charMap.put((char) 299, 'i');
		charMap.put((char) 301, 'i');
		charMap.put((char) 303, 'i');
		charMap.put((char) 105, 'i');
		charMap.put((char) 309, 'j');
		charMap.put((char) 311, 'k');
		charMap.put((char) 7735, 'l');
		charMap.put((char) 314, 'l');
		charMap.put((char) 11365, 'a');
		charMap.put((char) 316, 'l');
		charMap.put((char) 318, 'l');
		charMap.put((char) 7743, 'm');
		charMap.put((char) 7745, 'm');
		charMap.put((char) 322, 'l');
		charMap.put((char) 384, 'b');
		charMap.put((char) 324, 'n');
		charMap.put((char) 649, 'u');
		charMap.put((char) 326, 'n');
		charMap.put((char) 328, 'n');
		charMap.put((char) 585, 'j');
		charMap.put((char) 333, 'o');
		charMap.put((char) 335, 'o');
		charMap.put((char) 337, 'o');
		charMap.put((char) 341, 'r');
		charMap.put((char) 117, 'u');
		charMap.put((char) 7767, 'p');
		charMap.put((char) 343, 'r');
		charMap.put((char) 345, 'r');
		charMap.put((char) 120, 'x');
		charMap.put((char) 121, 'y');
		charMap.put((char) 347, 's');
		charMap.put((char) 349, 's');
		charMap.put((char) 351, 's');
		charMap.put((char) 353, 's');
		charMap.put((char) 7777, 's');
		charMap.put((char) 7779, 's');
		charMap.put((char) 355, 't');
		charMap.put((char) 637, 'r');
		charMap.put((char) 357, 't');
		charMap.put((char) 359, 't');
		charMap.put((char) 103, 'g');
		charMap.put((char) 361, 'u');
		charMap.put((char) 7787, 't');
		charMap.put((char) 363, 'u');
		charMap.put((char) 7789, 't');
		charMap.put((char) 365, 'u');
		charMap.put((char) 367, 'u');
		charMap.put((char) 369, 'u');
		charMap.put((char) 371, 'u');
		charMap.put((char) 7795, 'u');
		charMap.put((char) 373, 'w');
		charMap.put((char) 375, 'y');
		charMap.put((char) 255, 'y');
		charMap.put((char) 378, 'z');
		charMap.put((char) 380, 'z');
		charMap.put((char) 382, 'z');
		charMap.put((char) 7809, 'w');
		charMap.put((char) 595, 'b');
		charMap.put((char) 7811, 'w');
		charMap.put((char) 7813, 'w');
		charMap.put((char) 392, 'c');
		charMap.put((char) 598, 'd');
		charMap.put((char) 599, 'd');
		charMap.put((char) 7819, 'x');
		charMap.put((char) 7825, 'z');
		charMap.put((char) 402, 'f');
		charMap.put((char) 608, 'g');
		charMap.put((char) 616, 'i');
		charMap.put((char) 7831, 't');
		charMap.put((char) 409, 'k');
		charMap.put((char) 626, 'n');
		charMap.put((char) 417, 'o');
		charMap.put((char) 421, 'p');
		charMap.put((char) 429, 't');
		charMap.put((char) 648, 't');
		charMap.put((char) 432, 'u');
		charMap.put((char) 436, 'y');
		charMap.put((char) 438, 'z');
		charMap.put((char) 658, 'z');
		charMap.put((char) 7865, 'e');
		charMap.put((char) 441, 'z');
		charMap.put((char) 7869, 'e');
		charMap.put((char) 224, 'a');
		charMap.put((char) 225, 'a');
		charMap.put((char) 226, 'a');
		charMap.put((char) 227, 'a');
		charMap.put((char) 228, 'a');
		charMap.put((char) 229, 'a');
		charMap.put((char) 231, 'c');
		charMap.put((char) 232, 'e');
		charMap.put((char) 233, 'e');
		charMap.put((char) 234, 'e');
		charMap.put((char) 7883, 'i');
		charMap.put((char) 235, 'e');
		charMap.put((char) 236, 'i');
		charMap.put((char) 7885, 'o');
		charMap.put((char) 237, 'i');
		charMap.put((char) 238, 'i');
		charMap.put((char) 239, 'i');
		charMap.put((char) 464, 'i');
		charMap.put((char) 241, 'n');
		charMap.put((char) 242, 'o');
		charMap.put((char) 243, 'o');
		charMap.put((char) 244, 'o');
		charMap.put((char) 245, 'o');
		charMap.put((char) 246, 'o');
		charMap.put((char) 249, 'u');
		charMap.put((char) 250, 'u');
		charMap.put((char) 251, 'u');
		charMap.put((char) 252, 'u');
		charMap.put((char) 253, 'y');
		charMap.put((char) 479, 'a');
		charMap.put((char) 485, 'g');
		charMap.put((char) 7909, 'u');
		charMap.put((char) 487, 'g');
		charMap.put((char) 489, 'k');
		charMap.put((char) 491, 'o');
		charMap.put((char) 495, 'z');
		charMap.put((char) 496, 'j');
		charMap.put((char) 7923, 'y');
		charMap.put((char) 501, 'g');
		charMap.put((char) 505, 'n');
		charMap.put((char) 7929, 'y');

		igonreCharSet.add('́');
	}

	public static String normalize(String strInput) {
		ChineseJFTranslator chineseJFTranslator = ChineseJFTranslator.getInstance();

		strInput = CommUtils.ToDBC(strInput);
		strInput = chineseJFTranslator.chineseFan2Jan(strInput);
		// 多次转换大小写处理特殊字符，如德语中的 ß 处理后为 ss
		strInput = strInput.toLowerCase().toUpperCase().toLowerCase();
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < strInput.length(); index++) {
			char c = strInput.charAt(index);
			if (igonreCharSet.contains(c)) {
				continue;
			}
			Character mappingChar = charMap.get(c);
			if (mappingChar != null) {
				sb.append(mappingChar);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// System.out.println("曼彻斯特_canyin_olde");
		System.out.println(normalize("曼彻斯特_canyin_ǫlṲ́dê"));
		System.out.println("ß".toUpperCase().toLowerCase());
	}

}
