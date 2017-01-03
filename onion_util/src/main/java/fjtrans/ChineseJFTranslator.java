package fjtrans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import fjtrans.Char;
import fjtrans.CharFilter;
import fjtrans.IOUtil;
import fjtrans.LoadConfig;

public class ChineseJFTranslator
{

	public static Char[] charMapList_Jan2Fan = null;

	public static Char[] charMapList_Fan2Jan = null;

	public static final int cashSize = 2000;
	
	
	private static  ChineseJFTranslator chineseJFTranslator = null;
	static{
		chineseJFTranslator = new ChineseJFTranslator();
		chineseJFTranslator.init();
	}
	private ChineseJFTranslator()
	{
		
	}
	public static ChineseJFTranslator getInstance()
	{
		return chineseJFTranslator;
	}

	public boolean initialized()
	{
		if (charMapList_Jan2Fan != null && charMapList_Fan2Jan != null)
		{
			return true;
		}
		return false;
	}

	public void init()
	{
		if (this.initialized() == false)
		{
			try
			{
				charMapList_Jan2Fan = LoadConfig.getInstance().loadJFmapUTF8();
				charMapList_Fan2Jan = LoadConfig.getInstance().loadFJmapUTF8();
			}
			catch (IOException e)
			{
				charMapList_Jan2Fan = null;
				charMapList_Fan2Jan = null;
				throw new RuntimeException(e);
			}
		}
	}

	public String chineseFan2Jan(String fanText)
	{
		if (fanText == null)
		{
			return null;
		}
		if (this.initialized() == false)
		{
			this.init();
		}
		StringBuffer sb = new StringBuffer();
		int textSize = fanText.length();
		for (int index = 0; index < textSize; index++)
		{
			sb.append(CharFilter.fan2Jan(fanText.charAt(index), charMapList_Fan2Jan));
		}
		return sb.toString();
	}

	public long chineseFan2Jan(File sourceFile, String sourceCharSet, File targetFile, String targetCharSet)
			throws IOException
	{
		if (this.initialized() == false)
		{
			this.init();
		}
		char[] readCash = new char[cashSize];
		char[] writCash = new char[cashSize];
		int readSize = 0;

		long staTime = new Date().getTime();

		BufferedReader br = null;
		BufferedWriter bw = null;
		try
		{
			br = IOUtil.getReader(sourceFile, sourceCharSet);
			bw = IOUtil.getWriter(targetFile, targetCharSet, true);
			while ((readSize = br.read(readCash, 0, cashSize)) != -1)
			{
				for (int index = 0; index < readSize; index++)
				{
					writCash[index] = CharFilter.fan2Jan(readCash[index], charMapList_Fan2Jan);
				}
				bw.write(writCash, 0, readSize);
				bw.flush();
			}
		}
		catch (IOException ex)
		{
			throw ex;
		}
		finally
		{
			readCash = null;
			writCash = null;
			try
			{
				if (bw != null)
				{
					bw.close();
				}
			}
			catch (Exception e)
			{
			}
			try
			{
				if (br != null)
				{
					br.close();
				}
			}
			catch (Exception e)
			{
			}
		}
		long endTime = new Date().getTime();
		return (endTime - staTime);
	}

	public String chineseJan2Fan(String janText)
	{
		if (janText == null)
		{
			return null;
		}
		if (this.initialized() == false)
		{
			this.init();
		}
		StringBuffer sb = new StringBuffer();
		int textSize = janText.length();
		for (int index = 0; index < textSize; index++)
		{
			sb.append(CharFilter.jan2Fan(janText.charAt(index), charMapList_Jan2Fan));
		}
		return sb.toString();
	}

	public long chineseJan2Fan(File sourceFile, String sourceCharSet, File targetFile, String targetCharSet)
			throws IOException
	{
		if (this.initialized() == false)
		{
			this.init();
		}
		char[] readCash = new char[cashSize];
		char[] writCash = new char[cashSize];
		int readSize = 0;

		long staTime = new Date().getTime();

		BufferedReader br = null;
		BufferedWriter bw = null;
		try
		{
			br = IOUtil.getReader(sourceFile, sourceCharSet);
			bw = IOUtil.getWriter(targetFile, targetCharSet, true);
			while ((readSize = br.read(readCash, 0, cashSize)) != -1)
			{
				for (int index = 0; index < readSize; index++)
				{
					writCash[index] = CharFilter.jan2Fan(readCash[index], charMapList_Jan2Fan);
				}
				bw.write(writCash, 0, readSize);
				bw.flush();
			}
		}
		catch (IOException ex)
		{
			throw ex;
		}
		finally
		{
			readCash = null;
			writCash = null;
			try
			{
				if (bw != null)
				{
					bw.close();
				}
			}
			catch (Exception e)
			{
			}
			try
			{
				if (br != null)
				{
					br.close();
				}
			}
			catch (Exception e)
			{
			}
		}
		long endTime = new Date().getTime();

		return (endTime - staTime);
	}

	public void free()
	{
		charMapList_Jan2Fan = null;
		charMapList_Fan2Jan = null;
	}

	public static void main(String[] args)
	{
		
	}

}
