package com.isoft.stock.stockutils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @ProjectName:StockTest
 * @Description: 
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: 周楠
 * @date 2016年4月15日 下午2:56:33
 */

public class JuheDataToBean {
	
	/**
	 * 来自  dapandata 部分的 大盘数据
	 * @MethodName:ToDaPanBean
	 * @author: 姓名
	 * @date 2016年4月15日 下午7:27:09
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static Object ToDaPanBean  (JSONObject json,Class clazz){
		
		    return json.toBean(json,clazz);
		
	}
	
	/**
	 * reslut 直接获取大盘数据
	 * @MethodName:ToDaPanBeanNew
	 * @author: 姓名
	 * @date 2016年4月15日 下午7:27:31
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static Object ToDaPanBeanNew  (JSONObject json,Class clazz){
		
		    return json.toBean(json,clazz);
		
	}
	

	public static Object ToDanGuBean  (JSONArray json,Class clazz){
		
		JSONObject obj=	 (JSONObject) json.get(0);
	    
	    JSONObject json1=  (JSONObject) obj.get("data");
	    
	    JSONObject json2=  (JSONObject) obj.get("dapandata");
	    
	    String str1=json1.toString();
	    String str2=json2.toString();
	    
	    String res=str1.replaceAll("}", ",")+str2.substring(1);
	    
	    JSONObject obj2= JSONObject.fromObject(res);
	    
	    JSONArray obj3 = (JSONArray) obj2.remove("name");
	    
	    obj2.remove("traAmount");
	    obj2.remove("traNumber");
	 
	    
	    obj2.put("name", obj3.get(0));
	    
	    
	    
	    
        return obj2.toBean(obj2, clazz);
	    
	}
	
	
	public static List ToStockInfo(JSONObject json,Class clazz){
		
		 JSONArray SZSlistdata=	(JSONArray) json.get("data");
		 
		 List list=new ArrayList();
		 
		for (Object object : SZSlistdata) {
		
			JSONObject  jobj= (JSONObject) object;
			
		 Object obj=	jobj.toBean(jobj, clazz);
			
		 
		 list.add(obj);
			
		}
		
		return list;
		
	}
	
	

}
