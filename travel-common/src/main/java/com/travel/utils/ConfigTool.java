package com.travel.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigTool {

	public static Properties props;
	
	static{
		props = new Properties();
		try {
			//InputStream inputStream = ConfigTool.class.getClassLoader().getResourceAsStream("system.properties");
			InputStream inputStream = new FileInputStream("system.properties");
			props.load(inputStream);
			inputStream.close(); // 关闭流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		System.out.println(ConfigTool.props.getProperty("redis_flag"));
	}
}
