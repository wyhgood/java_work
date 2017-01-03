package com.travel.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Logger {
	private BufferedWriter writer = null;
	
	public Logger(String fileName) {
		File file = new File(fileName);
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void flush() {
		try {
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeLine(String line){
		try {
			writer.write(line+System.getProperty("line.separator"));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
