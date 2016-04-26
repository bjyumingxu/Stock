package com.isoft91.common.base.utilities;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
/**
 * 
 * @ProjectName:91isoft_oa
 * @ClassName:PropertiesResourceUtility.java
 * @Description: 外部配置文件读取工具
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: Lan Yuan
 * @email: lanyuan@91isoft.com 
 * @date 2016年2月22日 上午10:15:24
 * @version V1.0
 */
public class PropertiesResourceUtility extends PropertyResourceConfigurer implements BaseCommonUtility{

	private static Properties globalProperties;
	
	public String getPropertity(String key){
		return globalProperties.getProperty(key);
	}
	
	@Override
	@PostConstruct
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		globalProperties = props;
	}
	
	
    public static Properties getProperties(String classpath) throws IOException{
    	
    	Properties properties =new Properties();
    	
    	properties.load(ClassPathUtil.getInputStreamFromClassPath(classpath));
		return properties;
    	
    }
	
}
