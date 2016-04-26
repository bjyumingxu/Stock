package com.isoft91.common.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName:91isoft_oa
 * @Description: 
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: 周楠
 * @date 2016年3月25日 上午8:09:31
 */

public class HttpServletController {

    
    protected static final String REDIRECT = "redirect";

	protected static final String SUCCESS = "success";
	protected static final String NONE = "none";
	protected static final String ERROR = "error";
	protected static final String INPUT = "input";
	protected static final String LOGIN = "login";
	protected static final String FAIL = "fail";


	protected   String  redirectView(String viewname) {
		return REDIRECT + ":/" + viewname;
	}
	
	protected  Map<String, Object> responseStateMap(String state){

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", state);
		return map;
		
	}
	
	protected  Map<String, Object> responseStateDateMap(String state,String key[], Object value[]){

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", state);	
		
		for (int i = 0; i < key.length; i++) {

			map.put(key[i], value[i]);

		}
		return map;
		
	}
	
	protected  Map<String, Object> responseStateDateMap(String state,String key, Object value){

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", state);
		map.put(key, value);
		return map;
		
	}
	
	

	protected  Map<String, Object> responseMap(String key, Object value) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put(key, value);
		return map;

	}

	protected  Map<String, Object> responseMap(String[] key, Object[] value) {

		Map<String, Object> map = new HashMap<String, Object>();

		for (int i = 0; i < key.length; i++) {

			map.put(key[i], value[i]);

		}

		return map;

	}
	
	/**
	 * 返回错误的map对象
	 * @param errorMsg 错误信息
	 * @return
	 */
	protected  Map<String, Object> responseError(String errorMsg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", ERROR);
		map.put("msg", errorMsg);
		return map;

	}
	
	/**
	 * 返回成功的map对象
	 * @return
	 */
	protected  Map<String, Object> responseSuccess() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", SUCCESS);
		return map;

	}
	
	
	protected  String getIpAddr(HttpServletRequest request) throws Exception {
	    String ip = request.getHeader("x-forwarded-for");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    return ip;
	}
    
	
}
