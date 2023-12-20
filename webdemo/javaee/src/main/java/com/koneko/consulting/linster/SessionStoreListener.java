package com.koneko.consulting.linster;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class SessionStoreListener implements HttpSessionActivationListener {
	private String userId;
	public SessionStoreListener(String userId) {
		this.userId = userId;
	}
	public void sessionWillPassivate(HttpSessionEvent se)  {
		System.out.println("【SessionStoreListener】session钝化sessionID：" + se.getSession().getId());
	}

    public void sessionDidActivate(HttpSessionEvent se)  {
    	System.out.println("【SessionStoreListener】session激活sessionID：" + se.getSession().getId());
    }

	
}
