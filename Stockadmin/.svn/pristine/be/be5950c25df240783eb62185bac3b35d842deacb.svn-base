package com.isoft.stock.stockutils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaiduNews {
	static String kjNewsUrl = "http://apis.baidu.com/txapi/keji/keji";
	static String worldNewsUrl = "http://apis.baidu.com/txapi/world/world";
	static String tiyuNewsUrl = "http://apis.baidu.com/txapi/tiyu/tiyu";
	static String socialNewsUrl = "http://apis.baidu.com/txapi/social/social";

	/*public static void main(String[] args) {
		 System.out.println(getkjNews(1));
		 System.out.println(getworldNews(1));
		 System.out.println(getsocialNews(1));
		 System.out.println(gettiyuNews(1));
	}*/

	/**
	 * 获取科技新闻
	 * 
	 * @param page
	 * @return
	 */
	public static Object getkjNews(int page) {
		String httpArg = "num=10&page=" + page;
		return request(kjNewsUrl, httpArg);
	}

	/**
	 * 获取国际新闻
	 * 
	 * @param page
	 * @return
	 */
	public static Object getworldNews(int page) {
		String httpArg = "num=10&page=" + page;
		return request(worldNewsUrl, httpArg);
	}

	/**
	 * 获取社会新闻
	 * 
	 * @param page
	 * @return
	 */
	public static Object getsocialNews(int page) {
		String httpArg = "num=10&page=" + page;
		return request(socialNewsUrl, httpArg);
	}

	/**
	 * 获取体育新闻
	 * 
	 * @param page
	 * @return
	 */
	public static Object gettiyuNews(int page) {
		String httpArg = "num=10&page=" + page;
		return request(tiyuNewsUrl, httpArg);
	}


	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static String request(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			// 填入apikey到HTTP header
			connection.setRequestProperty("apikey", "162ae652b5634fa035ad401352327fde");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
