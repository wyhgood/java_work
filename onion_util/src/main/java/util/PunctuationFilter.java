package util;

import java.io.FileReader;
import java.util.HashSet;

public class PunctuationFilter
{
	public static String strPuncs = "。•ˉˇ¨〃々—～‖…‘’“”。，、；：？！…―ˉˇ〃～‖∶＂＇｀｜﹕﹗/∕："
			+ "┇┅﹉﹊﹍﹎∵∴‖︱︳︴﹕﹗/_`,•。≈~～_-［＼］＾＿｀：；＜＝＞？＠※！＂＃￥％＆＇（）" + "＊＋，－．／︰﹍﹎∣═║∵∴‖︱︳︴<>`,•。{}~～()≮≯〔〕〈〉<>《》「」『』．〖〗【】"
			+ "（）［］｛｝　》　〒　〓　〖〗　︻︼　︽︾　｛｜｝︱︳︴︵︶︹︺︿﹀︽︾﹁﹂﹃﹄︻︼︷︸" + "︵︶︹︺︿﹀︴︽︾︽︾︵︶﹁﹂﹁﹂﹃﹄﹃﹄﹝﹞﹏ˇ‥︷︸…"
			+ "≈≡≠＝≤≥＜＞≮≯∷＋－／∶∫∮∝∞∧∨∑∏∪∩∈∵∴⊥∥∠⌒⊙≌∽√≒≦≧<" + "≈{}~～()_-『』$@*&#※卐々∞Ψ∪∩∈∏℡ぁ§∮〝〞ミ灬ξ№∑⌒ξζω＊ㄨ"
			+ "＋－×÷﹢﹣±／＝∫∮∝∞∨" + "∑∏∥∠≌∽≦≧≒﹤﹥兀≮≯﹢﹣／∝≌∽≦≧≒﹤﹥±＋－×÷∧∨∑∏∪∩∈√⊥∥∠⌒⊙∫∮≡≌≈∽∝≠≮≯≤≥∞∶∵∴∷√"
			+ "←↑↓↖↗↘↙╱╲╳→←♀♂↑↓→←↘↙♀♂"
			+ "─━│┃┄┅┆┇┈┉┊┋┌┍┎┏┐┑┒┓└┕┖┗┘┙┚┛├┝┞┟┠┡┢┣┤┥┦┧┨┩┪┫┬┭┮┯┰┱┲┳┴┵┶┷┸┹┘┺┻┼┽┾┿╀╁╂╃╄╅╆╇╈╉╊╋∣"
			+ "═║╒╓╔╕╖╗╘╙╚╛╜╝╞╟╠╡╢╣╤╥╦╧╨╩╪╫╬╱╲╳▔▕╬┌┍┎┏┐┑∟┒┓─┄┈├┝┞┟┠┡┢┣│┆┊┬┭┮┯┰┱┲┳┼┽┾┿╀╂╁╃≡╝"
			+ "╚╔╗╬═╓╩┠┨┯┷┏┓┗┛┳⊥﹃﹄┌┐└┗┛" + "☉⊕＠＃＆〓＼㊣℡﹋﹌﹍﹎﹏☆★○●◎◇◆□■▓△▲▼▽◢◣◤◥⊿※№＾＿△★☆♀◆◇⊙●○①⊕◎Θ⊙¤㊣★☆♀"
			+ "◆◇◣◢◥▲▼△▽⊿◤◥▂▃▄▅▆▇██■▓▂▂▃▄▅▆▇█○●◎◇◆回□■△▽⊿▲▼◣◤◢◥▁▂▃▄▅▆▇█▉▊"
			+ "▋▌▍▎▏▓⊙●★☆■◆◣◥▲▂▃▅▆█☆★︵︶︹︺︿﹀︴︽︾︽︾︵︶﹁﹂﹁﹂﹃﹄﹃﹄﹝﹞﹏ˇ‥︷︸…回□〓「」"
			+ "┇┅﹉﹊﹍﹎╭╮╰╯*^_^*^*^^-^^_^^︵^﹏﹋﹌︵︶︹︺【】〖〗＠﹕﹗/_じ☆veve↑↓♀『』Ψ※→№←㊣"
			+ "∑⌒〖〗＠ξζω□∮〓※∴ぷ∏卐△√∩¤々♀♂∞①ㄨ≡↘↙┗┛╰☆╮、♂♀°′″℃＄¤￠￡‰§№〇※→←↑↓↖↗↘↙〓﹏﹋﹌⊕㊣㈱曱"
			+ "甴囍∟┅﹊﹍╭╮╰╯_^︵^-√$@*&#卐℡ぁ〝〞ミ灬№＊ㄨじぷ￥￡§я-―‥…‰′″℅℉№℡∕∝〆〒〡〢〣" + "〤〥〦〧〨〩"
			+"❤▶=][♥!:.'";
		public HashSet<Character> mapPuncChars = new HashSet<Character>();
		public  void init()
		{
			for (int i=0;i<strPuncs.length();i++)
			{
				mapPuncChars.add(strPuncs.charAt(i));
			}

		}
		
		public String filter(String strInput)
		{
			if(mapPuncChars.size()==0)
			{
				init();
			}
			
			String strResult = "";
			
			for(int i=0;i<strInput.length();i++)
			{
				if(!mapPuncChars.contains(strInput.charAt(i)))
				{
					strResult+=strInput.charAt(i);
				}
			}
			return strResult;
		}
		
		public static void main(String[] args)
		{
			PunctuationFilter punctuationFilter = new PunctuationFilter();
			punctuationFilter.init();
			String strReturn = punctuationFilter.filter("『金田一少年の事件簿』");
			System.out.println(strReturn);
			
		}
}
