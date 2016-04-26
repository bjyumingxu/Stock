package com.isoft91.common.base.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationConfigurationFilter implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		// TODO Auto-generated method stub
		ServletContext servletContext = contextEvent.getServletContext();
		servletContext.setAttribute("ctx", servletContext.getContextPath());
	}

}
