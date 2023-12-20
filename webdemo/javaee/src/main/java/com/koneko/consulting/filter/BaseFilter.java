package com.koneko.consulting.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

//@WebFilter(urlPatterns = {"/*"},
//initParams = {@WebInitParam(name = "info", value = "laoyang")},
//dispatcherTypes = {DispatcherType.FORWARD} )
public class BaseFilter extends HttpFilter implements Filter {
	private String info = null;

	public void destroy() {
		System.out.println("【BaseFilter】过滤器销毁。");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(request.getAttribute("name2"));
		String name = (String) request.getAttribute("name2");
		if ("草泥马".equals(name)) {
			name = "你好";
			request.setAttribute("name2", name);
		}
		System.out.println("【BaseFilter】过滤器执行用户请求过滤，过滤成功！");
		chain.doFilter(request, response);
		System.out.println("【BaseFilter】脏话修改完毕，已经放行！");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("【BaseFilter】过滤器初始化：参数 = " + fConfig.getInitParameter("info"));
		this.info = fConfig.getInitParameter("info");
	}

}
