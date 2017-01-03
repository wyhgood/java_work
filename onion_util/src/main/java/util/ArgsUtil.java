package util;

import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class ArgsUtil
{
	public static boolean CheckMissing(String strArg, CommandLine commandLine, Options options)
	{
		if (!commandLine.hasOption(strArg))
		{
			System.err.println("Missing arg:" + strArg);
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("Input args", options);
			return false;
		}
		return true;
	}
	public static boolean CheckMissing(String strArg,Properties properties)
	{
		
		String strValue = properties.getProperty(strArg);
		
		if (strValue==null)
		{
			System.err.println("Missing arg:" + strArg);
			return false;
		}
		return true;
	}
	public static String GetValueOrDefault(CommandLine commandLine,String strKey,String strDefault)
	{
		if(commandLine.hasOption(strKey))
		{
			return commandLine.getOptionValue(strKey);
		}
		return strDefault; 
	}
}
