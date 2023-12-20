package com.koneko.consulting.linster;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

//@WebListener
public class VideoCountListener implements ServletRequestListener {
	public void requestInitialized(ServletRequestEvent sre)  { 
		System.out.println("【VideoCountListener】进行本次请求的处理");
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		//头信息里面如果是通过强跳转进行的页面转换，referer属性可以获取到该页面的前页面信息
		String url = request.getHeader("referer");
		//localhost:8080/javaee/video/10   //vid=10
		String pattern = ".+/video/vid=\\d+"; 
		System.out.println("【当前url】" + url);
		if(url != null && url.matches(pattern)) {
			System.out.println("【VideoCountListener】视频被播放，访问量+1");
		}
	}
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("【VideocountListener】本次请求处理完毕！");
    }
}
