package com.travel.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.travel.data.Pair;

public class FileUtils {
	static public final Log log = LogFactory.getLog(FileUtils.class);
	
	public static String readStrFromFile(String fileName){
		StringBuilder sb = new StringBuilder();
		File file = new File(fileName);
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line = br.readLine();
			while(line != null){
				sb.append(line.trim());
				line = br.readLine();
			}
		}catch(Exception e){
			log.info("exception.", e);
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					log.info("exception.", e);
				}
			}
		}
		return sb.toString();
	}
	public static List<Integer> readIntegerLinesFromFile(String fileName){
		List<Integer> results = new LinkedList<Integer>();
		File file = new File(fileName);
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line = br.readLine();
			while(line != null){
				results.add(Integer.parseInt(line.trim()));
				line = br.readLine();
			}
		}catch(Exception e){
			log.info("exception.", e);
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					log.info("exception.", e);
				}
			}
		}
		return results;
	}
	public static Set<Integer> readIntegerSetLinesFromFile(String fileName){
		Set<Integer> resultSet = new HashSet<Integer>();
		File file = new File(fileName);
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line = br.readLine();
			while(line != null){
				resultSet.add(Integer.parseInt(line.trim()));
				line = br.readLine();
			}
		}catch(Exception e){
			log.info("exception.", e);
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					log.info("exception.", e);
				}
			}
		}
		
		return resultSet;
	}
	
	static public List<String> readLinesFromFile(String filename) {
		List<String> list = new ArrayList<String>();
		File file = new File(filename);
		if(!file.exists()){
			log.error("file doesn't exist:"+filename);
			return list;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if(!line.isEmpty()&&!line.equals("\\N"))list.add(line);
			}
		} catch (IOException e) {
			log.warn("exception",e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					log.warn("exception",e);
				}
			}
		}
		return list;
	}
	static public void writeFile(List<String> contents,String file){
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new FileWriter(file,true));
			for(String str:contents){
				writer.write(str);
				writer.newLine();
			}
		}catch(Exception e){
			log.warn("exception",e);
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					log.warn("exception",e);
				}
			}
		}
	}
	static public void writeFile(String content,String file){
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(content);
			writer.newLine();
		}catch(Exception e){
			log.warn("exception",e);
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					log.warn("exception",e);
				}
			}
		}
	}
	static public void writePair2File(List<Pair> contents,String file){
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new FileWriter(file,true));
			for(Pair p:contents){
				writer.write(p.key+":"+p.value);
				writer.newLine();
			}
		}catch(Exception e){
			log.warn("exception",e);
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					log.warn("exception",e);
				}
			}
		}
	}
}
