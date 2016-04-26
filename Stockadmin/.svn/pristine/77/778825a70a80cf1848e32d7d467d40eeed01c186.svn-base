package com.isoft.stock.stockutils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 股票数据调用示例代码 － 聚合数据 在线接口文档：http://www.juhe.cn/docs/21
 **/

public class JuheStockData {
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

	// 配置您申请的KEY
	public static final String APPKEY = "0c6d8dabdfe8f8d46827af64ca9f5219";

    /*public static void main(String[] args) {
		System.out.println(getHKStockData(3));
		System.out.println(getSZStockData(2));
		 System.out.println(selectHSStock("sh600109"));
		 System.out.println(selectHKStock("00011"));
		 System.out.println(selectUSAStock("fb"));
	}*/
	
	/**
	 * type =0 为上证指数  type=1 为深证指数
	 * @MethodName:selectStockDaPan
	 * @author: 姓名
	 * @date 2016年4月15日 下午7:24:49
	 * @param type
	 * @return
	 */
	public static Object selectStockDaPan(Integer type) {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/hs";// 请求接口地址
		Map params = new HashMap();// 请求参数
	
		params.put("key", APPKEY);// APP Key
		params.put("type", type);// APP Key
		
		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return object.get("result");
			} else {
				return object.get("error_code") + ":" + object.get("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	// 1.查询 沪深股市
	public static Object selectHSStock(String stockNum) {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/hs";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("gid", stockNum);// 股票编号，上海股市以sh开头，深圳股市以sz开头如：sh601009
		params.put("key", APPKEY);// APP Key

		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return object.get("result");
			} else {
				return object.get("error_code") + ":" + object.get("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 2.查询 香港股市
	public static Object selectHKStock(String stockNum) {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/hk";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("num", stockNum);// 股票代码，如：00001 为“长江实业”股票代码
		params.put("key", APPKEY);// APP Key
		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return object.get("result");
			} else {
				return object.get("error_code") + ":" + object.get("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 3.查询 美国股市
	public static Object selectUSAStock(String stockNum) {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/usa";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("gid", stockNum);// 股票代码，如：aapl 为“苹果公司”的股票代码
		params.put("key", APPKEY);// APP Key
		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return object.get("result");
			} else {
				return object.get("error_code") + ":" + object.get("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 4.获取 香港股市列表
	public static Object getHKStockData(int page) {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/hkall";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("key", APPKEY);// 您申请的APPKEY
		params.put("page", page);// 第几页,每页20条数据,默认第1页
		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return object.get("result");
			} else {
				return object.get("error_code") + ":" + object.get("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 5.获取 美国股市列表
	public static Object getUSAStockData(int page) {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/usaall";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("key", APPKEY);// 您申请的APPKEY
		params.put("page", page);// 第几页,每页20条数据,默认第1页
		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return object.get("result");
			} else {
				return object.get("error_code") + ":" + object.get("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 6.获取 深圳股市列表 80 条一页
	public static Object getSZStockData(int page) {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/szall";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("key", APPKEY);// 您申请的APPKEY
		params.put("page", page);// 第几页(每页20条数据),默认第1页
		params.put("type", 4);
		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return object.get("result");
			} else {
				return object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 7.获取 沪股列表  80 条一页
	public static Object getSHStockData(int page) {
		String result = null;
		String url = "http://web.juhe.cn:8080/finance/stock/shall";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("key", APPKEY);// 您申请的APPKEY
		params.put("page", page);// 第几页,每页80条数据,默认第1页
		params.put("type", 4);
		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return object.get("result");
			} else {
				return object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 *
	 * @param strUrl
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param method
	 *            请求方法
	 * @return 网络请求字符串
	 * @throws Exception
	 */
	public static String net(String strUrl, Map params, String method) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("GET")) {
				strUrl = strUrl + "?" + urlencode(params);
			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if (method == null || method.equals("GET")) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params != null && method.equals("POST")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(urlencode(params));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	// 将map型转为请求参数型
	public static String urlencode(Map<String, Object> data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
