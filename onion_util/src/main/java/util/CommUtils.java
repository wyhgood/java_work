package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CommUtils
{

	public static String[] Split(String input, String splitStr)
	{
		if (input.indexOf(splitStr) == -1)
		{
			String[] returnValue = new String[1];
			returnValue[0] = input;

			return returnValue;
		}
		LinkedList<String> splitedList = new LinkedList<String>();
		int iBegingIndex = 0;

		while (true)
		{
			int index = input.indexOf(splitStr, iBegingIndex);
			int ilastIndex = 0;
			if (index == -1)
			{
				ilastIndex = input.length();
			}
			else
			{
				ilastIndex = index;
			}

			String subStr = input.substring(iBegingIndex, ilastIndex);
			splitedList.addLast(subStr);

			if (index == -1)
				break;

			iBegingIndex = index + splitStr.length();

			if (iBegingIndex > input.length() - 1)
			{
				splitedList.add("");
				break;

			}
		}

		String[] returnValues = new String[splitedList.size()];
		splitedList.toArray(returnValues);
		return returnValues;
	}

	public static <T> String list2String(List<T> listInput, String strSplitor)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < listInput.size(); i++)
		{
			if (i > 0)
			{
				sb.append(strSplitor);
			}
			sb.append(listInput.get(i));
		}
		return sb.toString();
	}

	public static <T> String set2String(Set<T> setInput, String strSplitor)
	{
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (T strWord : setInput)
		{
			if (i > 0)
			{
				sb.append(strSplitor);
			}

			sb.append(strWord);
			i++;
		}
		return sb.toString();
	}

	public static <T> String listlist2String(LinkedList<LinkedList<String>> listInput, String strL1Splitor,
			String strL2Splitor)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < listInput.size(); i++)
		{
			if (i > 0)
			{
				sb.append(strL1Splitor);
			}
			sb.append(list2String(listInput.get(i), strL2Splitor));
		}
		return sb.toString();
	}

	public static void string2ListList(String strInput, String strL1Splitor, String strL2Splitor,
			LinkedList<LinkedList<String>> listOut)
	{
		String[] parts = Split(strInput, strL1Splitor);

		for (int i = 0; i < parts.length; i++)
		{
			LinkedList<String> listPer = new LinkedList<String>();
			string2List(parts[i], strL2Splitor, listPer);

			listOut.add(listPer);
		}
	}

	public static void string2List(String strInput, String strSplitor, LinkedList<String> listOut)
	{
		String[] parts = Split(strInput, strSplitor);

		for (int i = 0; i < parts.length; i++)
		{
			listOut.add(parts[i]);
		}

	}

	public static String mapStringToList2String(HashMap<String, LinkedList<String>> mapToList, String strL1Splitor,
			String strL2Splitor, String strL3Splitor)
	{
		StringBuffer sb = new StringBuffer();

		boolean fFirst = true;
		for (String strKey : mapToList.keySet())
		{
			if (!fFirst)
			{
				sb.append(strL1Splitor);
				// fFirst = false;
			}
			LinkedList<String> listValue = mapToList.get(strKey);
			sb.append(strKey);
			sb.append(strL2Splitor);
			sb.append(list2String(listValue, strL3Splitor));
			fFirst = false;
		}

		return sb.toString();
	}

	public static void string2MapStringToList(HashMap<String, LinkedList<String>> mapToList, String strL1Splitor,
			String strL2Splitor, String strL3Splitor, String strInput)
	{
		if (strInput.trim().length() == 0)
			return;
		String[] parts = Split(strInput, strL1Splitor);
		for (int i = 0; i < parts.length; i++)
		{
			String strPart = parts[i];
			String[] perParts = Split(strPart, strL2Splitor);
			LinkedList<String> listStrings = new LinkedList<String>();
			string2List(perParts[1], strL3Splitor, listStrings);
			mapToList.put(perParts[0], listStrings);
		}
	}

	public static String map2String(HashMap<String, String> mapStringHashMap, String strL1Splitor, String strL2Splitor)
	{
		StringBuffer sb = new StringBuffer();
		boolean fFirst = true;
		for (String strKey : mapStringHashMap.keySet())
		{
			if (!fFirst)
			{
				sb.append(strL1Splitor);
			}
			String strValue = mapStringHashMap.get(strKey);
			sb.append(strKey);
			sb.append(strL2Splitor);
			sb.append(strValue);

			fFirst = false;
		}

		return sb.toString();
	}

	public static void string2Map(String strInput, String strL1Splitor, String strL2Splitor,
			HashMap<String, String> mapString)
	{
		if (strInput.trim().length() == 0)
			return;
		String[] parts = Split(strInput, strL1Splitor);
		for (int i = 0; i < parts.length; i++)
		{
			String strPerPart = parts[i];
			String[] perParts = Split(strPerPart, strL2Splitor);
			mapString.put(perParts[0], perParts[1]);
		}
	}

	public static Date ParseDate(String strInput, String strFormat, Locale locale)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat, locale);
		Date date = null;
		try
		{
			date = (sdf.parse(strInput));
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;

	}

	public static String GetFatherDomain(String strDomain)
	{
		String[] parts = Split(strDomain, ".");
		if (parts.length < 2)
			return strDomain;

		String strReturn = strDomain.substring(parts[0].length() + 1);
		return strReturn;

	}

	public static boolean IsLegalDomain(String strInput)
	{
		return strInput.matches("[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?");

	}

	public static long getUnsignedInt(int data)
	{
		return data & 0x0FFFFFFFFl;
	}

	/*
	 * Regex related
	 */
	public static LinkedList<String> REGEX_find(String strInput, String strRegex)
	{
		LinkedList<String> listReturn = new LinkedList<String>();
		Pattern pattern = Pattern.compile(strRegex);
		Matcher matcher = pattern.matcher(strInput);
		while (matcher.find())
		{
			listReturn.add(matcher.group(1));
			// System.out.println(matcher.group(1));
		}
		return listReturn;
	}

	public static void putListToMap(HashMap<String, String> map, LinkedList<String> list)
	{
		for (String string : list)
		{
			map.put(string, "");
		}
	}

	public static void mapKeyToList(HashMap<String, String> map, LinkedList<String> list)
	{
		for (String strKey : map.keySet())
		{
			list.add(strKey);
		}
	}

	public static int MapKeySameCount(HashMap<String, String> map1, HashMap<String, String> map2)
	{
		int iCount = 0;
		for (String strKey1 : map1.keySet())
		{
			for (String strKey2 : map2.keySet())
			{
				if (strKey1.trim().compareTo(strKey2.trim()) == 0)
				{

					iCount++;
				}
			}
		}
		return iCount;
	}

	public static String StrToMd5(String str)
	{
		String md5Str = null;
		if (str != null && str.length() != 0)
		{
			try
			{
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(str.getBytes());
				byte b[] = md.digest();

				int i;
				StringBuffer buf = new StringBuffer("");
				for (int offset = 0; offset < b.length; offset++)
				{
					i = b[offset];
					if (i < 0)
						i += 256;
					if (i < 16)
						buf.append("0");
					buf.append(Integer.toHexString(i));
				}
				// 32位
				// md5Str = buf.toString();
				// 16位
				md5Str = buf.toString();
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
		}
		return md5Str;
	}

	public static String ToDBC(String input)

	{

		char[] c = input.toCharArray();

		for (int i = 0; i < c.length; i++)

		{

			if (c[i] == 12288)

			{

				c[i] = (char) 32;

				continue;

			}

			if (c[i] > 65280 && c[i] < 65375)

				c[i] = (char) (c[i] - 65248);

		}

		return new String(c);

	}

	public static int comSubstring(String str1, String str2)
	{
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		int a_length = a.length;
		int b_length = b.length;
		int[][] lcs = new int[a_length + 1][b_length + 1];
		// 初始化数组
		for (int i = 0; i <= b_length; i++)
		{
			for (int j = 0; j <= a_length; j++)
			{
				lcs[j][i] = 0;
			}
		}
		for (int i = 1; i <= a_length; i++)
		{
			for (int j = 1; j <= b_length; j++)
			{
				if (a[i - 1] == b[j - 1])
				{
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				}
				if (a[i - 1] != b[j - 1])
				{
					lcs[i][j] = lcs[i][j - 1] > lcs[i - 1][j] ? lcs[i][j - 1] : lcs[i - 1][j];
				}
			}
		}

		return lcs[a_length][b_length];
		// // 输出数组结果进行观察
		// for (int i = 0; i <= a_length; i++)
		// {
		// for (int j = 0; j <= b_length; j++)
		// {
		// System.out.print(lcs[i][j] + ",");
		// }
		// System.out.println("");
		// }
		// // 由数组构造最小公共字符串
		// int max_length = lcs[a_length][b_length];
		// char[] comStr = new char[max_length];
		// int i = a_length, j = b_length;
		// while (max_length > 0)
		// {
		// if (lcs[i][j] != lcs[i - 1][j - 1])
		// {
		// if (lcs[i - 1][j] == lcs[i][j - 1])
		// {// 两字符相等，为公共字符
		// comStr[max_length - 1] = a[i - 1];
		// max_length--;
		// i--;
		// j--;
		// } else
		// {// 取两者中较长者作为A和B的最长公共子序列
		// if (lcs[i - 1][j] > lcs[i][j - 1])
		// {
		// i--;
		// } else
		// {
		// j--;
		// }
		// }
		// } else
		// {
		// i--;
		// j--;
		// }
		// }
		// System.out.print("最长公共字符串是：");
		// System.out.print(comStr);
	}

	public static <K, V> boolean ifMapKeyHasSame(HashMap<K, V> map1, HashMap<K, V> map2)
	{
		for (K k : map1.keySet())
		{
			if (map2.containsKey(k))
			{
				return true;
			}
		}

		return false;
	}

	public static LinkedList<String> REGEX_find(String strInput, String strRegex, LinkedList<Integer> listGroupToCatch)
	{

		LinkedList<String> listReturn = new LinkedList<String>();
		Pattern pattern = Pattern.compile(strRegex);
		Matcher matcher = pattern.matcher(strInput);
		if (matcher.find())
		{
			for (int iGroupIndex : listGroupToCatch)
			{
				listReturn.add(matcher.group(iGroupIndex));
			}

			return listReturn;
		}

		return null;
	}

	public static HashMap<String, String> getRegexInfo(LinkedList<String> listRegexs, String strInput,
			boolean fExsitWhenFind)
	{

		HashMap<String, String> mapExtractInfo = new HashMap<String, String>();

		LinkedList<Integer> listGroupToCatch = new LinkedList<Integer>();
		listGroupToCatch.add(1);
		for (int i = 0; i < listRegexs.size(); i++)
		{
			String strRegex = listRegexs.get(i);
			LinkedList<String> listExtracts = CommUtils.REGEX_find(strInput, strRegex, listGroupToCatch);

			if (listExtracts != null)
			{
				for (String strExtract : listExtracts)
				{
					mapExtractInfo.put(strExtract, "");
				}
				if (fExsitWhenFind)
					return mapExtractInfo;
			}
		}
		return mapExtractInfo;

	}

	public static LinkedList<String> getPropertiesKeys(Properties properties)
	{
		LinkedList<String> listReturn = new LinkedList<String>();
		Enumeration<?> enu = properties.propertyNames();
		while (enu.hasMoreElements())
		{
			Object key = enu.nextElement();
			listReturn.add(key.toString());
		}

		return listReturn;
	}

	public static String getPage(String strURL, String strCharset, int iTimeOutMillSeconds)
	{
		return getPage(strURL, strCharset, iTimeOutMillSeconds, null);
	}

	public static String getPageTillSucceed(String strURL, String strCharset, int iTimeOutMillSeconds,
			HashMap<String, String> mapHeaders, List<String> listProxy)
	{
		String strPage = "";

		do
		{

			for (String strProxy : listProxy)
			{
				try
				{

					System.out.println("Useing proxy" + strProxy);
					String[] parts = strProxy.split("=");
					String strIp = parts[0];
					String strPort = parts[1];
					int iPort = Integer.parseInt(strPort);

					strPage = getPageWithProxy(strURL, strCharset, iTimeOutMillSeconds, mapHeaders, strIp, iPort,
							"http");
					if (strPage.trim().length() > 0)
					{
						return strPage;
					}

				}
				catch (Exception e)
				{
					// TODO: handle exception
					e.printStackTrace();
				}

			}

		}
		while (false);
		return "";
	}

	public static String getPage(String strURL, String strCharset, int iTimeOutMillSeconds,
			HashMap<String, String> mapHeaders)
	{

		try
		{
			HttpClient httpclient = new DefaultHttpClient();

			HttpContext localContext = new BasicHttpContext();

			CookieStore cookieStore = new BasicCookieStore();

			localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

			httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
			httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, iTimeOutMillSeconds);
			httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, iTimeOutMillSeconds);

			HttpGet httpget = new HttpGet(strURL);

			// String strCookie = "RT=s="+lTime+"&r="+URLEncoder.encode(strURL);

			// System.out.println(strCookie);
			if (mapHeaders != null)
			{
				for (String strMapKey : mapHeaders.keySet())
				{
					String strValue = mapHeaders.get(strMapKey);

					httpget.setHeader(strMapKey, strValue);
				}
			}

			HttpResponse response;
			response = httpclient.execute(httpget, localContext);

			Header[] headers = httpget.getAllHeaders();

			List<Cookie> listCookies = cookieStore.getCookies();

			HttpEntity entity = response.getEntity();

			if (entity != null)
			{
				return EntityUtils.toString(entity, strCharset);
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static String getHttpsPageWithProxy(String strURL, String strCharset, int iTimeOutMillSeconds,
			HashMap<String, String> mapHeaders, String strProxyHost, int iProxyPort, String strProtocol)
	{

		try
		{
			HttpClient httpclient = wrapClient(new DefaultHttpClient());

			HttpContext localContext = new BasicHttpContext();

			CookieStore cookieStore = new BasicCookieStore();

			localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

			HttpHost httpProxy = new HttpHost(strProxyHost, iProxyPort, strProtocol);

			httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, httpProxy);
			httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
			httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, iTimeOutMillSeconds);
			httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, iTimeOutMillSeconds);

			HttpGet httpget = new HttpGet(strURL);

			Date date = new Date();
			long lTime = date.getTime();
			// String strCookie = "RT=s="+lTime+"&r="+URLEncoder.encode(strURL);

			// System.out.println(strCookie);
			if (mapHeaders != null)
			{
				for (String strMapKey : mapHeaders.keySet())
				{
					String strValue = mapHeaders.get(strMapKey);

					httpget.setHeader(strMapKey, strValue);
				}
			}

			HttpResponse response;
			response = httpclient.execute(httpget, localContext);

			Header[] headers = httpget.getAllHeaders();

			List<Cookie> listCookies = cookieStore.getCookies();

			HttpEntity entity = response.getEntity();

			if (entity != null)
			{
				return EntityUtils.toString(entity, strCharset);
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static String getPageWithProxy(String strURL, String strCharset, int iTimeOutMillSeconds,
			HashMap<String, String> mapHeaders, String strProxyHost, int iProxyPort, String strProtocol)
	{
		return getPageWithProxy(strURL, strCharset, iTimeOutMillSeconds, mapHeaders, strProxyHost, iProxyPort,
				strProtocol, true);
	}

	public static String getPageWithProxy(String strURL, String strCharset, int iTimeOutMillSeconds,
			HashMap<String, String> mapHeaders, String strProxyHost, int iProxyPort, String strProtocol,
			boolean fProxyWork)
	{
		String strResultContent = null;
		try
		{
			HttpClient httpclient = new DefaultHttpClient();

			// HttpContext localContext = new BasicHttpContext();

			CookieStore cookieStore = new BasicCookieStore();

			// localContext.setAttribute(ClientContext.COOKIE_STORE,
			// cookieStore);

			HttpHost httpProxy = new HttpHost(strProxyHost, iProxyPort, strProtocol);

			if (fProxyWork)
			{
				httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, httpProxy);
			}
			httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
			httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, iTimeOutMillSeconds);
			httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, iTimeOutMillSeconds);

			HttpGet httpget = new HttpGet(strURL);

			Date date = new Date();
			long lTime = date.getTime();
			// String strCookie = "RT=s="+lTime+"&r="+URLEncoder.encode(strURL);

			// System.out.println(strCookie);
			if (mapHeaders != null)
			{
				for (String strMapKey : mapHeaders.keySet())
				{
					String strValue = mapHeaders.get(strMapKey);

					httpget.setHeader(strMapKey, strValue);
				}
			}

			CloseableHttpResponse response;
			response = (CloseableHttpResponse) httpclient.execute(httpget);

			Header[] headers = httpget.getAllHeaders();

			List<Cookie> listCookies = cookieStore.getCookies();

			HttpEntity entity = response.getEntity();

			if (entity != null)
			{
				//
				// System.out.println("Status line:" +
				// response.getStatusLine());
				// System.out.println("Status line:" +
				// entity.getContentLength());

				int statusCode = response.getStatusLine().getStatusCode();

				if (statusCode == 403 || statusCode == 404 || statusCode == 503)
				{
					strResultContent = "";
				}
				else
				{
					strResultContent = EntityUtils.toString(entity, strCharset);
				}
				EntityUtils.consume(entity);
			}

			response.close();

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strResultContent;
	}

	public static HttpClient wrapClient(HttpClient base)
	{
		try
		{
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager tm = new X509TrustManager()
			{
				public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
				{
				}

				public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
				{
				}

				public X509Certificate[] getAcceptedIssuers()
				{
					return null;
				}
			};

			ctx.init(null, new TrustManager[]
			{
				tm
			}, null);
			SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			ClientConnectionManager ccm = base.getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", 443, ssf));
			return new DefaultHttpClient(ccm, base.getParams());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String getFirst(String strKey, HashMap<String, LinkedList<HashMap<String, String>>> inputMap,
			String strNeededKey)
	{

		LinkedList<HashMap<String, String>> listTempResult = inputMap.get(strKey);
		if (listTempResult != null && listTempResult.size() > 0)
		{
			for (HashMap<String, String> perItemHashMap : listTempResult)
			{
				String strItemValue = perItemHashMap.get(strNeededKey);
				if (strItemValue != null)
				{
					return strItemValue;
				}
			}

		}

		return "";
	}

	public static boolean simpleFill(LinkedList<String> listResult, String strKey,
			HashMap<String, LinkedList<HashMap<String, String>>> inputMap, String strNeededKey)
	{
		LinkedList<HashMap<String, String>> listTempResult = inputMap.get(strKey);
		if (listTempResult != null && listTempResult.size() > 0)
		{
			for (HashMap<String, String> perItemHashMap : listTempResult)
			{
				String strItemValue = perItemHashMap.get(strNeededKey);
				if (strItemValue != null)
				{
					listResult.add(strItemValue);
				}
			}
			return true;
		}
		return false;
	}

	public static String GetObjectString(Object objInstance)
	{

		String strReturn = "";
		Field[] fields = objInstance.getClass().getFields();
		// Field[] fields = objInstance.getClass().get;

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

				strReturn += "[" + strFieldName + ":" + strFieldValue + "]";

			}
			catch (Exception e)
			{
				// TODO: handle exception
			}

		}
		return strReturn;
	}

	public static void main(String[] args)
	{

	}

	public static void loadCollectionFile(String strFileName, Collection<String> words)
	{
		try
		{
			BufferedReader bufferedReader = new BufferedReader(new FileReader(strFileName));
			String strLine = null;
			while ((strLine = bufferedReader.readLine()) != null)
			{
				words.add(strLine);

			}

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isSetEqual(Collection set1, Collection set2)
	{

		if (set1 == null && set2 == null)
		{
			return true; // Both are null
		}

		if (set1 == null || set2 == null || set1.size() != set2.size() || set1.size() == 0 || set2.size() == 0)
		{
			return false;
		}

		Iterator ite1 = set1.iterator();
		Iterator ite2 = set2.iterator();

		boolean isFullEqual = true;

		while (ite2.hasNext())
		{
			if (!set1.contains(ite2.next()))
			{
				isFullEqual = false;
			}
		}

		return isFullEqual;
	}

	public static boolean hasSameMembers(Collection set1, Collection set2)
	{
		if (set1.size() * set2.size() == 0)
			return false;
		for (Object s1Member : set1)
		{
			if (set2.contains(s1Member))
			{
				return true;
			}

		}

		return false;
	}

}
