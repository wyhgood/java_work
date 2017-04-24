package com.travel.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.expression.spel.ast.LongLiteral;

import com.travel.data.Pair;
import com.travel.entity.comment.UserComment;

public class TravelUtils {
	final static Log log = LogFactory.getLog(TravelUtils.class);
	static public boolean isEquals(String val1,String val2){
		if(val1==null && val2==null)return true;
		if(val1==null || val2==null)return false;
		if(val1.equals(val2))return true;
		return false;
	}
	static public boolean isEquals(Integer val1,Integer val2){
		if(val1==null && val2==null)return true;
		if(val1==null || val2==null)return false;
		if(val1.intValue()==val2.intValue())return true;
		return false;
	}
	static public double log(double value, double base) {
		return Math.log(value) / Math.log(base);
	}
	/**
	 * @param to
	 * @param from
	 * @return
	 */
	static public List<String> mergeList(List<String> to, List<String> from) {
		Set<String> set = new TreeSet<String>();
		for(String s:to){
			if(TravelUtils.isNotEmpty(s))set.add(s);
		}
		for(String s:from){
			if(TravelUtils.isNotEmpty(s))set.add(s);
		}
		List<String> list = new ArrayList<String>(set.size());
		list.addAll(set);
		return list;
	}
	static public boolean isEmpty(String val){
		if(val==null)return true;
		val = trim(val);
		if(val.isEmpty())return true;
		return false;
	}
	static public boolean isNotEmpty(String val){
		return !isEmpty(val);
	}
	static public List<String> mergeArray(String[] to, String[] from) {
		List<String> tList = Arrays.asList(to);
		List<String> fList = Arrays.asList(from);
		return mergeList(tList, fList);
	}
	static public String list2Str(List<String> list, String delemiter) {
		StringBuilder sb = new StringBuilder();
		for (int i=0,len=list.size();i<len;i++) {
			String s = list.get(i);
			if(TravelUtils.isEmpty(s))continue;
			sb.append(s);
			if(i!=len-1)sb.append(delemiter);
		}
		return sb.toString();
	}
	static public String list2Str(List<String> list,String delemiter,int limitLength){
		StringBuilder sb = new StringBuilder();
		for (int i=0,len=list.size();i<len;i++) {
			String s = list.get(i);
			if(TravelUtils.isEmpty(s))continue;
			if((sb.length()+s.length())>limitLength)break;
			sb.append(s);
			if(i!=len-1)sb.append(delemiter);
		}
		return sb.toString();
	}
	static public String list2UniqueLimitStr(List<String> list,String delemiter,int limitLength){
		if(list.isEmpty())return "";
		Set<String> set = new HashSet<String>(list.size()*2);
		set.addAll(list);
		list.clear();
		list.addAll(set);
		StringBuilder sb = new StringBuilder();
		for (int i=0,len=list.size();i<len;i++) {
			if(sb.length()>limitLength)break;
			String s = list.get(i);
			if(TravelUtils.isEmpty(s))continue;
			sb.append(s);
			if(i!=len-1)sb.append(delemiter);
		}
		return sb.toString();
	}
	static public String list2UniqueStr(List<String> list, String delemiter) {
		if(list.isEmpty())return "";
		Set<String> set = new HashSet<String>(list.size()*2);
		set.addAll(list);
		list = new LinkedList<String>();
		list.addAll(set);
		StringBuilder sb = new StringBuilder();
		for (int i=0,len=list.size();i<len;i++) {
			String s = list.get(i);
			if(TravelUtils.isEmpty(s))continue;
			sb.append(s);
			if(i!=len-1)sb.append(delemiter);
		}
		return sb.toString();
	}

	/**
	 * 使用Pattern和Matcher类的方法
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNumber(String s) {

		String regex = "^[1-9][0-9]*\\.[0-9]+$|^[1-9][0-9]*$|^0+\\.[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		char c = s.charAt(0);
		if (c == '+' || c == '-') {
			s = s.substring(1);
		}
		Matcher matcher = pattern.matcher(s);
		boolean bool = matcher.matches();
		if (bool) {
			return true;
		} else {
			return false;
		}
	}

	static public Double parseDouble(String val) {
		if (val == null || val.isEmpty() || !isNumber(val))
			return 0.;
		return Double.parseDouble(val);
	}
	
	static public double processDoubleScale(Double val){
		return processDoubleScale(val,2);
	}
	static public double processDoubleScale(Double val,int scale){
		if(val==null
				||Double.compare(val.doubleValue(),Double.NaN)==0){
			return 0.;
		}
		try {
			BigDecimal b = new BigDecimal(val.toString());
			b = new BigDecimal(val.toString())
				.setScale(scale, BigDecimal.ROUND_HALF_UP);
			return b.doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.;
	}
	static public double divide(Double dividend,Double divisor){
		if(dividend==null||divisor==null)return 0;
		if(dividend==0||divisor==0)return 0;
		double result = dividend/divisor;
		return processDoubleScale(result);
	}
	static public String formatDate(Date ts){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(ts);
	}
	static public double nextGaussian(double mean,double max){
		Random random = new Random();
		double r = random.nextGaussian()/1.0+mean;
		if(r>max||r<0)return mean;
		return processDoubleScale(r,1);
	}
//	public static void main(String args[]){
//		for(int i=0;i<100;i++){
//			System.out.println(nextGaussian(3, 5));
//		}
//	}
	static public List<Pair> sortMapByValue(Map<String,Integer> map){
		List<Pair> list = new ArrayList<Pair>(map.size());
		for(Entry<String,Integer> ent:map.entrySet()){
			Pair p = new Pair(ent.getKey(),ent.getValue());
			list.add(p);
		}
		list.sort(new Comparator<Pair>(){
			@Override
			public int compare(Pair o1, Pair o2) {
				return -o1.value+o2.value;
			}
		});
		return list;
	}
	/**
	 * @param u1
	 * @param u2
	 * @return true: equal <br/> false:not equal
	 */
	static public boolean isUserCommentEquals(UserComment u1,UserComment u2){
		if(!isEquals(u1.getFlag(),u2.getFlag()))return false;
		if(!isEquals(u1.getCommentTime(),u2.getCommentTime()))return false;
		if(!isEquals(u1.getCommentText(),u2.getCommentText()))return false;

		if(!isEquals(u1.getUserPic(),u2.getUserPic()))return false;
		if(!isEquals(u1.getPoUserPic(),u2.getPoUserPic()))return false;

		if(!isEquals(u1.getCommentPics(),u2.getCommentPics()))return false;
		if(!isEquals(u1.getPoCommentPics(),u2.getPoCommentPics()))return false;
		
		if(!isEquals(u1.getLargeCommentPics(),u2.getLargeCommentPics()))return false;
		if(!isEquals(u1.getPoLargeCommentPics(),u2.getPoLargeCommentPics()))return false;

		if(!isEquals(u1.getAbsTags(),u2.getAbsTags()))return false;
		if(!isEquals(u1.getBrandsTags(),u2.getBrandsTags()))return false;
		if(!isEquals(u1.getOriginTag(),u2.getOriginTag()))return false;
		if(!isEquals(u1.getStarTag(),u2.getStarTag()))return false;
		
		if(!isEquals(u1.getCommentTime(),u2.getCommentTime()))return false;
		if(!isEquals(u1.getUserName(),u2.getUserName()))return false;
		if(!isEquals(u1.getStarLevel(),u2.getStarLevel()))return false;
		if(!isEquals(u1.getCommentTitle(),u2.getCommentTitle()))return false;
		if(!isEquals(u1.getDetail(),u2.getDetail()))return false;
		if(!isEquals(u1.getDataLang(),u2.getDataLang()))return false;
		return true;
	}
	static public void exit(int status,String msg,String logFile){
		String[] mails = ConfigTool.props.getProperty("mails", "xiewenbo@mxtrip.cn").split(",");
		String mailProps = ConfigTool.props.getProperty("mail_config","mail.properties");
		log.warn("system exit with code:"+status+" msg:"+msg);
		for(String mail:mails){
			String strConf = mailProps;
			String strAttacheMent = logFile;
			String strTitle = "system exception:"+logFile;
			String strContent = msg;
			String strDest = mail;
			MailSender se = new MailSender(false, strConf);
			File affix = new File(strAttacheMent);
			se.doSendHtmlEmail(strTitle, strContent, strDest, affix);
			log.info("[send mail]"+mail);
		}
		System.exit(status);
	}
	static public void sendEmail(String msg,String systemName){
		String[] mails = ConfigTool.props.getProperty("mails", "xiewenbo@mxtrip.cn").split(",");
		String mailProps = ConfigTool.props.getProperty("mail_config","mail.properties");
		log.warn("msg:"+msg);
		for(String mail:mails){
			String strConf = mailProps;
			String strTitle = "system exception "+systemName;
			String strContent = msg;
			String strDest = mail;
			MailSender se = new MailSender(false, strConf);
			se.doSendHtmlEmail(strTitle, strContent, strDest,null);
			log.info("[send mail]"+mail);
		}
	}
	static public void sendEmail(String title, String msg,String other){
		String[] mails = ConfigTool.props.getProperty("mails", "wangyahui@mxtrip.cn").split(",");
		String mailProps = ConfigTool.props.getProperty("mail_config","mail.properties");
		log.warn("msg:"+msg);
		for(String mail:mails){
			String strConf = mailProps;
			MailSender se = new MailSender(false, strConf);
			se.doSendHtmlEmail(title, msg, mail,null);
			log.info("[send mail]"+mail);
		}
	}
	static public void sleep(int sec){
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (InterruptedException e) {
			log.warn("Exception",e);
		}
	}
	/**
	 * 去除字符串中头部和尾部所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
	 * @param s
	 * @return
	 */
	public static String trim(String s){
		String result = "";
		if(null!=s && !"".equals(s)){
			result = s.replaceAll("^[　*| *| *|\\s*]*", "").replaceAll("[　*| *| *|\\s*]*$", "");
		}
		return result;
	}
	static public int strongLength(String len){
		if(len == null)return 0;
		return len.trim().length();
	}
	static public int smartLength(String len){
		if(TravelUtils.isEmpty(len))return 0;
		if(!isContainChinese(len)){
			return len.split("\\s").length;
		}else{
			return replaceStrVal(len).length();
		}
	}
	static public int smartLengthWithoutPunctuation(String str){
		str = replacePunctuation(str);
		return smartLength(str);
	}
	static public String replacePunctuation(String str){
		String punc = "[～~,.?;!，。？；！\\s]";
		str = str.replaceAll(punc, "");
		return str;
	}
	static public String replaceStrVal(String str){
		if(TravelUtils.isEmpty(str))return "";
		str = str.replaceAll("([a-zA-Z]+)", "=");
		str = str.replaceAll("([0-9\\.]+)", "=");
		return trim(str);
	}
	static public boolean isChineseChars(String val){
		return Pattern.matches("[\\u4E00-\\u9FA5]+", val);
	}
	static public String extractSentenceWithPuction(String val){
		Pattern p1 = Pattern.compile("[\u4e00-\u9fa5]");
		Pattern p2 = Pattern.compile("[a-zA-Z]");
		StringBuilder sb = new StringBuilder();
		for(int i=0,len=val.length();i<len;i++){
			String c = val.substring(i,i+1);
			Matcher m1 = p1.matcher(c);
			Matcher m2 = p2.matcher(c);
			if(m1.find() || m2.find())sb.append(c);
		}
		return sb.toString();
	}
	public static boolean isContainChinese(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}
	public static boolean isContainJapanese(String str){
		Pattern p = Pattern.compile("[\u0800-\u4e00]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}
	public static boolean isChineseSentence(String str,double scale){
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		String zh = "";
		while(m.find()) {
			zh+=m.group();
		}
		double zhLen = zh.length();
		double len = smartLength(str);
		if(zhLen/len>scale){
			return true;
		}else{
			return false;
		}
	}
	public static int sentenceSize(String sentence){
		if(isEmpty(sentence))return 0;
		String[] fields = sentence.split(" ");
		int len = 0;
		for(String field:fields){
			if(isContainChinese(field)){
				len+=field.length();
			}else len++;
		}
		return len;
	}
	static public double similarity(List<String> s1,List<String> s2){
		Set<String> set = new HashSet<String>();
		for(String s:s1){
			set.add(s);
		}
		double score = 0.;
		for(String s:s2){
			if(set.contains(s))score++;
		}
		return score;
	}
	static public void incrMap(Map<String,Double> map,String key){
		Double r = map.get(key);
		if(r == null){
			map.put(key, 1.);
		}else {
			r++;
			map.put(key, r);
		}
	}

	static public String[] splitByFirstDelemter(String val, String delemter) {
		String[] fields = new String[2];
		String[] f = val.split(delemter);
		if(f.length > 2){
			fields[0] = f[0];
			fields[1] = val.substring((f[0]+delemter).length());
			return fields;
		}else if(f.length==2){
			fields[0] = f[0];
			fields[1] = f[1];
			return fields;
		}
		return null;
	}
	static Map<String, String> map = new ConcurrentHashMap<String, String>();
	static {
        List<String> lines = FileUtils.readLinesFromFile("./chinese.dict");
        for(String line:lines){
        		String[] strings = line.split("=");
        		if(strings.length == 2){
        			map.put(strings[0], strings[1]);
        		}
        }
    }
	
	public static boolean isTraditionalChinese(String str){
		return map.containsKey(str);
	}
	
	public static boolean isTraditionalChineseSentence(String sen){
		char[] cs = sen.toCharArray();
		if(cs.length ==0) return false;
		int traditionNum = 0;
		for(char c:cs){
			if(isTraditionalChinese(String.valueOf(c))){
				traditionNum+=1;
			}	
		}
		float l1 = Float.valueOf(traditionNum);
		float l2 = Float.valueOf(cs.length);
		System.out.println(l1/l2);
		if(l1/l2>0.02) return true;
		return false;
	}
	public static void main(String[] args) {
		String string = "去年秋天經過大埔曾經光顧這鋪,d野幾好食 上星期同朋友再入去食,見有新的小食出咗,叫了個2人餐,加個炸魷魚,比第一次去差好多 個雞沙律好細份又唔好食,有d似雞皮的感覺,三文魚薄餅餅邊不平均,又燶燶地(以前係好脹好靚的),個牛肉飯癡底,又油,口感好差,洋蔥圈同加果個魷魚好似營養不良咁,細得可憐,2杯野飲係正常一點,一杯是熱朱古力,一杯是藥水味的冰茶,以為有圖樣,係主打,就叫咗,點知飲野都衰咗一杯飲品 坐就可憐,桌子小,上菜又迫,都唔知食得咩先,攪到d野又涷又更加難食,坐又迫放唔到野.... 去洗手間又遠又煩又污糟,仲要撞正人地攞咗條鎖匙,又要等別人回來,去到洗手間,更直是恐怖,仲衰過公厠,早知唔使等啦! 坐唔舒服,傾唔到計,成三百蚊,真的好貴";
		boolean b = isTraditionalChineseSentence(string);
		System.out.println(b);
	}
}
