package fjtrans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;



/**
 * ���������IO����
 * @author saiya wyd1011@126.com
 * @lastEdit 2008-10-28
 *
 */
public class IOUtil {
	
	public static BufferedReader getReader(File source , String charSet ) throws IOException{
		InputStream is = new FileInputStream(source);
		InputStreamReader isr = new InputStreamReader(is,charSet);
		return new BufferedReader(isr);
	}
	
	
	public static BufferedWriter getWriter(File target , String charSet , boolean append) throws IOException{
		
		OutputStream os = new FileOutputStream(target , append );
		OutputStreamWriter osw = new OutputStreamWriter(os , charSet );
		return new BufferedWriter(osw);
	}
	
	

}
