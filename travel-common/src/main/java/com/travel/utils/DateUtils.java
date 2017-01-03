package com.travel.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {

	static public String getCurrDateStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}
	static public String formatUserCommentTs(String date){
		if(TravelUtils.isEmpty(date))return date;
		String ts = date;
		int idx = ts.indexOf("更新于");
		if(idx != -1){
			ts = ts.substring(0, idx);
		}
		String regex1 = "^\\d{4}-\\d{2}-\\d{2}$";
		String regex2 = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$";
		String regex4 = "^\\d{2}-\\d{1,2}-\\d{1,2}";
		String regex3 = "^\\d{2}-\\d{2}";
		String regex5 = "^\\d{4}-\\d{1,2}-\\d{1,2}";
		Pattern pattern1  = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(ts);
		if(matcher1.find())return ts;
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(ts);
		if(matcher2.find())return ts;
		Pattern pattern4 = Pattern.compile(regex4);
		Matcher matcher4 = pattern4.matcher(ts);
		if(matcher4.find()){
			return "20"+ts;
		}
		Pattern pattern3 = Pattern.compile(regex3);
		Matcher matcher3 = pattern3.matcher(ts);
		if(matcher3.find()){
			String t = matcher3.group();
			int m = Integer.parseInt(t.split("-")[0]);
			int currM = Calendar.getInstance().get(Calendar.MONTH)+1;
			int y = Calendar.getInstance().get(Calendar.YEAR);
			if(m>currM){
				y--;
			}
			return y+"-"+ts;
		}
		Pattern pattern5 = Pattern.compile(regex5);
		Matcher matcher5 = pattern5.matcher(ts);
		if(matcher5.find()){
			String t = matcher5.group();
			return t;
		}
		return ts;
	}
	static public String extractroYYYYMMDD(String date){
		String regex = "((\\d+)-(\\d+)-(\\d+))";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		if(matcher.find()){
			String y = matcher.group(2);
			String m = matcher.group(3);
			String d = matcher.group(4);
			if(m.length()==1)m="0"+m;
			if(d.length()==1)d="0"+d;
			return y+"-"+m+"-"+d;
		}
		return date;
	}
	/**
	 * yyyy-MM-dd
	 * @param day
	 * @return
	 */
	static public String getNDaysBefore(int day){
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.DATE, cld.get(Calendar.DATE) - day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cld.getTime());
	}
	
	static public String getNDaysAfter(int day){
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.DATE, cld.get(Calendar.DATE) + day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cld.getTime());
	}
	public static void main(String args[]){
		System.out.println(formatUserCommentTs("03-24"));
	}
}
