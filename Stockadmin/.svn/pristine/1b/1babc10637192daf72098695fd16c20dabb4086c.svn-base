package com.isoft.stock.stockutils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaiduStockData {
	static String httpHSUrl = "http://apis.baidu.com/apistore/stockservice/stock";
	static String httpHKUrl = "http://apis.baidu.com/apistore/stockservice/hkstock";
	static String httpUSAUrl = "http://apis.baidu.com/apistore/stockservice/usastock";
	// static String httpArg = "stockid=sz002230&list=1";

	public static void main(String[] args) {
		 System.out.println(selectHSStockDataBD("sz002230"));
		// System.out.println(selectHKStockDataBD("00109"));
//		System.out.println(selectUSAStockDataBD("bidu"));
	}

	/**
	 * 查询沪深股票
	 * 
	 * @param stockNum
	 * @return
	 */
	public static Object selectHSStockDataBD(String stockNum) {
		String httpArg = "stockid=" + stockNum + "&list1=1";
		return request(httpHSUrl, httpArg);
	}

	/**
	 * 查询美国股票
	 * 
	 * @param stockNum
	 * @return
	 */
	public static Object selectUSAStockDataBD(String stockNum) {
		String httpArg = "stockid=" + stockNum + "&list1=1";
		return request(httpUSAUrl, httpArg);
	}

	/**
	 * 查询香港股票
	 * 
	 * @param stockNum
	 * @return
	 */
	public static Object selectHKStockDataBD(String stockNum) {
		String httpArg = "stockid=" + stockNum + "&list1=1";
		return request(httpHKUrl, httpArg);
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
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			// 填入apikey到HTTP header
			connection.setRequestProperty("apikey",
					"162ae652b5634fa035ad401352327fde");
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
