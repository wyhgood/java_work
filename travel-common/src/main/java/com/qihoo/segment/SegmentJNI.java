package com.qihoo.segment;

import com.travel.utils.ConfigTool;
import com.travel.utils.SegmentTools;

/**
 * 支持多线程
 */
public class SegmentJNI {
	private static boolean debug = !ConfigTool.props.getProperty("seg_jni", "0").equals("0");
	
	static {
		//System.load("/data/yangsong/Workspace/SegmentJni/src/lib/lib360segment.so");
		if(!debug){
			System.loadLibrary("360segment");
		}
	}
	public native static void init(String data, int segNum, String conf);
	public native static String segment(String content,int threadNum);
	public native static String possegment(String content,int threadNum);
	
	public native static String segment(String content);

	public native static String possegment(String content);

	public native static void init(String data, String conf);

	public static void main(String args[]) {

        String newconf = "/data/admin/xiewenbo/SegmentJni/src/qsegconf.ini";
		//String newdata = System.getProperty("user.dir") + "/segmenter/sws_data";
		String newdata="/data/admin/xiewenbo/SegmentJni/src/segmenter/sws_data";
        System.err.println("newconf: " + newconf);
		System.err.println("newdata: " + newdata);
		SegmentJNI.init(newdata,50,newconf);
		final SegmentJNI segJni = new SegmentJNI();
		System.out.println(segJni.segment("穿什么就是什么，什么也不是"));

        
		for(int i=0;i<20;i++){
        new Thread(new Runnable() {
                public void run() {
                        for (int i = 0; i < 10; i++) {
                             synchronized(segJni){
                       System.out.println(Thread.currentThread().getName()+"="+segJni.segment("说什么就是什么"));
                           //try{Thread.sleep(1000);}catch(Exception e){}
                        }}
                }
        }).start();
}
	}
}
