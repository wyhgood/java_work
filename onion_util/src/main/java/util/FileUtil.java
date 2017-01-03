package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil
{
	public static String GetStringContent(String strPath) throws IOException
	{
		StringBuffer sb= new StringBuffer();
		BufferedReader bReader = new BufferedReader(new FileReader(strPath));
		String strLine= null;
		while ((strLine = bReader.readLine())!=null)
		{
			sb.append(strLine);
		}
		
		bReader.close();
		return sb.toString();
	}
}
