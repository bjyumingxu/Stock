package com.isoft91.common.base.utilities;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @ProjectName:91isoft_oa
 * @Description: 
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: 周楠
 * @date 2016年3月20日 上午2:11:27
 */

public class ClassPathUtil {
	
	
	public static String defaultClassPath(){
		return ClassPathUtil.class.getResource("").getPath();
	}
	
	public static URL getURIFromClassPath(String path){
		
		return ClassPathUtil.class.getResource(path);

	}
	
    public static InputStream getInputStreamFromClassPath(String path){
		
		return ClassPathUtil.class.getResourceAsStream(path);
		
	}
    
    public static File getFileFromClassPath(String path) throws URISyntaxException{
    
    	return new File(ClassPathUtil.class.getResource(path).toURI());
    }
    
    public static  String getStringPathFromClassPath(String path){
    	
    	return ClassPathUtil.class.getResource(path).getPath();
    	
    }

}
