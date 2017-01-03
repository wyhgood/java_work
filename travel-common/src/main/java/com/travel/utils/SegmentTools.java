package com.travel.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qihoo.segment.SegmentJNI;

public class SegmentTools {
	private static boolean debug = !ConfigTool.props.getProperty("seg_jni", "0").equals("0");
	
	static public boolean fLoadLib = true;
	static public Log log = LogFactory.getLog(SegmentTools.class);
	static public int flag;
	private static String[] getSplitedWords(String strInput) {
		return strInput.split("\\s");
	}

	static public String[] segments(String str) {
		if (str == null || str.isEmpty()) {
			return new String[0];
		}
		String result = "";
		try {
			str = URLEncoder.encode(str, "UTF-8");
			str = URLEncoder.encode(str, "UTF-8");
			URL url = new URL(
					"http://115.29.239.169:8080/segment_server/SegmentServlet?str=" 
							+ str);
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			InputStreamReader bin = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(bin);
			result = br.readLine();
			br.close();
		} catch (Exception e) {
			log.warn("exception", e);
		}
		return getSplitedWords(result);
	}
	static
	{
		try
		{
			
		
		flag = Integer.parseInt(ConfigTool.props.getProperty("seg_jni", "0"));
		String newconf = ConfigTool.props.getProperty("new_conf","/data/admin/xiewenbo/SegmentJni/src/qsegconf.ini");
		String newdata = ConfigTool.props.getProperty("new_data","/data/admin/xiewenbo/SegmentJni/src/segmenter/sws_data");
		log.info("newconf: " + newconf);
		log.info("newdata: " + newdata);
		
		if(!debug){
			SegmentJNI.init(newdata, 50, newconf);
		}
		} catch (Exception e)
		{
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	/**
	 * thread safe
	 * @param val
	 * @return
	 */
	static public String[] nativeSegments(String val) {
		String result = SegmentJNI.segment(val);
		return getSplitedWords(result);
	}
	/**
	 * thread safe
	 * @param val
	 * @return
	 */
	static public String[] nativePosSegments(String val){
		String result = SegmentJNI.possegment(val);
		return getSplitedWords(result);
	}
	
	static public String[] smartSegments(String val){
		if(TravelUtils.isEmpty(val))return new String[]{};
		if(flag == 1){
			return segments(val);
		}
		return nativeSegments(val);
	}
	
	public static HashMap<String, String[]> mapCache = new HashMap<String, String[]>();
	static public String[] smartQuickSegments(String val){
		
		
		
		if(TravelUtils.isEmpty(val))return new String[]{};
//		if(mapCache.containsKey(val))
//		{
//			return mapCache.get(val);
//		}
		
		if(flag == 1){
//			String[] words=segments(val);
//			mapCache.put(val, words);
			return segments(val);
		}
		String[] words = quickNativeSegments(val);
		
		return words;
	}
	static public int getCurrentThreadName(){
		String name = Thread.currentThread().getName();
		String[] fields = name.split("-");
		if(fields.length==4)return Integer.parseInt(fields[3]);
		if(fields.length==3)return Integer.parseInt(fields[2]);
		return 0;
	}
	static public String[] quickNativePosSegments(String val){
		int tIdx = getCurrentThreadName();
		String result = SegmentJNI.possegment(val, tIdx);
		return result.split(" ");
	}
	static public String[] quickNativeSegments(String val){
		int tIdx = getCurrentThreadName();
		String result = SegmentJNI.segment(val, tIdx);
//		log.info("thread index :  " + tIdx +", content : " + val + ", segment result : " + result);
		return result.split(" ");
	}
	public static void main(String args[]) throws Exception {
		//String[] strs = segments("晚上坐车回东门直接走到黑猪一条街，很近！就是在海兵魂那个旁边的巷子直走海边就是，去吃传闻中的火炉香。看似是老板的阿加西很热情啊，也是帮我们烤肉、剪肉，今天才知道泡菜也可以拿来烤的！包烤肉吃的菜叶除了生菜叶子和紫苏叶子也可以是酸萝卜片！终于吃到了最经典的黑猪五花肉，连皮上的黑毛都看得清清楚楚！第一家的黑豚家 主打碳烧黑猪肉，那火炉香就是主打石板烧黑猪肉，还免费赠送大豆汤，蛋羹和冷面！尤其爱配菜沙拉，能吃个精光！结账时才发现，这家上过采访，难怪那么晚来吃烤肉的人络绎不绝。");
		String[] strs= segments("cerveceria restaurante cabreira");
		for (String s : strs) {
			System.out.println(s);
		}
	}
}
