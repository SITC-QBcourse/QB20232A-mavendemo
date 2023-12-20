package com.koneko.consulting.linster;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

public class UserStateMonitor implements HttpSessionIdListener,HttpSessionListener {
	
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("【UserStateMonitor】创建：sessionID = " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("【UserStateMonitor】销毁：sessionID = " + se.getSession().getId());
    }

	@Override
	public void sessionIdChanged(HttpSessionEvent paramHttpSessionEvent, String paramString) {
		System.out.printf("【UserStateMonitor】新的ID = %s%n, 旧的ID = %s%n，session属性：%s%n",paramHttpSessionEvent.getSession().getId(),paramString,paramHttpSessionEvent.getSession().getAttribute("msg"));	
	}
	
}
