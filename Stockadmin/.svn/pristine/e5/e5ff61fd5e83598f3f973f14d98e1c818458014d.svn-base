package com.isoft91.common.base.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ProjectName:91isoft_oa
 * @ClassName:DateFormatUtility.java
 * @Description: 时间数据格式化工具类
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: Lan Yuan
 * @email: lanyuan@91isoft.com 
 * @date 2016年2月20日 下午11:57:30
 * @version V1.0
 */
public class DateFormatUtility implements BaseCommonUtility{
	
	
	
	
	
	
	
	public static String appendSecondDateString(String sourse,boolean isStart){
//		source = source.replaceAll("-|/|:|\\s", "");
		String clear_sourse = sourse.replaceAll("[^0-9]", "");
		if(clear_sourse.length()>14||clear_sourse.length()<4){
			try {
				throw new ParseException("错误的日期格式，日期长度必须在4-14之间",-1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sourse.length()==8){
			if(isStart){
				clear_sourse+="000000";
			}else {
				clear_sourse+="235959";
			}
		}
		return clear_sourse;
	}
	
	
	
	/**
	 * 
	 * @Description: 将输入的字符串时间转成日期类型数据
	 * @MethodName:parseDate
	 * @author: Lan Yuan
	 * @email: lanyuan@91isoft.com 
	 * @date 2016年2月21日 下午12:21:13
	 * @version V1.0
	 * @param sourse
	 * @return
	 * @throws ParseException
	 */
	public static Date stringParseDate(String sourse) throws ParseException{
		String formater="yyyyMMddHHmmss";
		String clear_sourse = sourse.replaceAll("[^0-9]", "");
		if(clear_sourse.length()>14||clear_sourse.length()<4){
			throw new ParseException("错误的日期格式，日期长度必须在4-14之间",-1);
		}else{
			return new SimpleDateFormat(formater.substring(0,clear_sourse.length())).parse(clear_sourse);
		}
	}
	
	
	/**
	 * 
	 * @Description: 将输入的日期时间转成字符串类型数据
	 * @MethodName:parseDate
	 * @author: Lan Yuan
	 * @email: lanyuan@91isoft.com 
	 * @date 2016年2月21日 下午12:21:13
	 * @version V1.0
	 * @param sourse
	 * @return
	 * @throws ParseException
	 */
	public static String dateParseString(Date sourse,String formatter) throws ParseException{
			return new SimpleDateFormat(formatter).format(sourse);
	}
	
	
	
	
	
	
	
}
