package util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;


public class ObjectUtil
{
	public static  String getObjectAsString(Object objInstance)
	{
		Field[] fields = objInstance.getClass().getFields();
		// Field[] fields = objInstance.getClass().get;

		StringBuffer sb = new StringBuffer();
		sb.append("\n");

		for (Field field : fields)
		{
			try
			{
				String strSize = "";
				if (field.getType().newInstance() instanceof HashMap)
				{
					strSize = ((HashMap) field.get(objInstance)).size() + "";
				}
				if (field.getType().newInstance() instanceof LinkedList)
				{
					strSize = ((LinkedList) field.get(objInstance)).size() + "";
				}
				String strFieldName = field.getName();
				if (strSize.length() > 0)
				{
					strFieldName += "(" + strSize + ")";
				}
				String strFieldValue = field.get(objInstance).toString();

				sb.append(strFieldName + ":" + strFieldValue + "\n");
				// CPFactory.logger.info(strFieldName + ":" + strFieldValue);

			} catch (Exception e)
			{
				// TODO: handle exception
			}
		}
		
		return sb.toString();
	}
}
