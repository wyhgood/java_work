package util;

import java.util.LinkedList;

public class StringSegmentorUtil
{
	public static LinkedList<String>  getSplitedWords(String strInput)
	{
		
		LinkedList<String> listReturn = new LinkedList<String>();
		String[] parts = strInput.split("\\s|\\(|\\)");
		for (String strPerPart : parts)
		{
			if(strPerPart.matches("[a-z|A-Z|0-9|']+"))
			{
				listReturn.add(strPerPart);
			}
			else {
				for (int i=0;i< strPerPart.length() ; i++)
				{
					listReturn.add(strPerPart.charAt(i)+"");
				}
			}
		}
		
		return listReturn;
	}
	
	public static void main(String[] args)
	{
		String strA= "珍妮曲奇 Jenny Bakery(尖沙咀店)";
		System.out.println(getSplitedWords(strA));
	}
}
