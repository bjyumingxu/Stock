package com.isoft.project.module.contorller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName:MVCProject
 * @Description: 
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: 周楠
 * @date 2016年4月16日 下午2:42:24
 */

public class Linster  implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	 ServletContext sc=	arg0.getServletContext();
	 
	  ApplicationContext   apc=new ClassPathXmlApplicationContext("applicationContext.xml");
		 
	  sc.setAttribute("springcontext", apc);
		
		
	}

}
