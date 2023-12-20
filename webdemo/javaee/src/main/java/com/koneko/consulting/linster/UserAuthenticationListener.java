package com.koneko.consulting.linster;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserAuthenticationListener implements HttpSessionBindingListener {
	private String userId;//保存用户ID
	public UserAuthenticationListener(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	
    public void valueBound(HttpSessionBindingEvent event)  { 
    	//此处应该是严谨的处理操作
    	System.out.println("【UserAuthenticationListener】属性绑定：name = " + event.getName() + "\tvalue = " + event.getValue());
    }

    public void valueUnbound(HttpSessionBindingEvent event)  {
    	//此处应该有严谨的处理操作
    	System.out.println("【UserAuthenticationListener】属性解绑：name = " + event.getName() + "\tvalue = " + event.getValue());
    }
	
}
