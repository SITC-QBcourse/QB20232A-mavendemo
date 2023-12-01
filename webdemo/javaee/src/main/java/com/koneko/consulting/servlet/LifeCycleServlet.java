package com.koneko.consulting.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		value="/life",
		loadOnStartup = 1,
		initParams = {
				@WebInitParam(name="message1",value="www1.koneko-consulting.com"),
				@WebInitParam(name="message2",value="www2.koneko-consulting.com"),
				@WebInitParam(name="message3",value="www3.koneko-consulting.com"),
				@WebInitParam(name="message4",value="www4.koneko-consulting.com")
		})//直接通过这个url访问，一定是get方式的
public class LifeCycleServlet extends HttpServlet {
	
	//初始化
	@Override
	public void init() throws ServletException {
		System.out.println("【LifeCycleServlet】Servlet的无参init初始化");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("【LifeCycleServlet】Servlet初始化：message1 = " + config.getInitParameter("message1"));
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("【LifeCycleServlet】Servlet处理HTTP请求");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("【LifeCycleServlet】Servlet处理GET请求");
	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("【LifeCycleServlet】Servlet处理POST请求");
//	}
	//Servlet销毁
	@Override
	public void destroy() {
		System.out.println("【LifeCycleServlet】SErvlet销毁");
	}
}
