package com.koneko.consulting.linster;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce)  { 
		System.out.println("【WebContextListener】上下文启动：" + sce.getServletContext().getVirtualServerName());
	}
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("【WebContextListener】上下文销毁：" + sce.getServletContext().getVirtualServerName());
    }
}
