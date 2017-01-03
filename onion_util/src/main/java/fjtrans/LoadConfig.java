package fjtrans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import fjtrans.Char;
public class LoadConfig {
	
	
	
	public static final String fjMapUTF8="fj_map_utf8.properties";
	
	
	public static final String jfMapUTF8="jf_map_utf8.properties";
	
	private static LoadConfig instance = null ;
	
	public static LoadConfig getInstance(){
		if(instance==null){
			instance=new LoadConfig();
		}
		return instance;
	}
	
	
	public Char[] loadFJmapUTF8() throws IOException{
		String line=null;
		ArrayList list = new ArrayList();
		BufferedReader br = null;
		Char[] charList = null;
		try{
			br = this.getReader(fjMapUTF8);
			int index=0;
			while((line=br.readLine())!=null){
				if(line.startsWith("#")){
					continue;
				}
				if(line.trim().length()==0){
					continue;
				}
				char fChar=line.charAt(0);
				char jChar=line.charAt(2);
				if(index>=(int)fChar){
					list=null;
					throw new IOException("Error when read:FCharId="+(int)fChar);
				}
				index=(int)fChar;
				list.add(new Char(jChar,fChar));
			}
			charList=new Char[list.size()];
			for(int i=0;i<list.size();i++){
				charList[i]=(Char)list.get(i);
			}
			list=null;
		}catch(IOException ex){
			list=null;
			throw ex;
		}finally{
			if(br!=null){try{br.close();}catch(IOException ex){}}
		}
		return charList;
	}
	
	
	

	public Char[] loadJFmapUTF8() throws IOException{
		String line=null;
		ArrayList list = new ArrayList();
		Char[] charList = null;
		BufferedReader br = null;
		try{
			br=this.getReader(jfMapUTF8);
			int index=0;
			while((line=br.readLine())!=null){
				if(line.startsWith("#")){
					continue;
				}
				if(line.trim().length()==0){
					continue;
				}
				char jChar=line.charAt(0);
				char fChar=line.charAt(2);
				if(index>=(int)jChar){
					list=null;
					throw new IOException("erro when read["+jfMapUTF8+"]JCharId="+(int)jChar);
				}
				index=(int)jChar;
				list.add(new Char(jChar,fChar));
			}
			
			charList=new Char[list.size()];
			for(int i=0;i<list.size();i++){
				charList[i]=(Char)list.get(i);
			}
			list=null;
		}catch(IOException ex){
			list=null;
			throw ex;
		}finally{
			if(br!=null){try{br.close();}catch(IOException ex){}}
		}
		return charList;
	}
	
	

	protected BufferedReader getReader(String file){
		BufferedReader bufferedReader = null;
		try{
			InputStream is = this.getClass().getResourceAsStream(file);
			InputStreamReader isr = new InputStreamReader(is , "UTF-8");
			bufferedReader = new BufferedReader(isr);
		}catch(IOException ex){
			bufferedReader=null;
			throw new RuntimeException(ex);
		}
		return bufferedReader;
	}
	
	
}
