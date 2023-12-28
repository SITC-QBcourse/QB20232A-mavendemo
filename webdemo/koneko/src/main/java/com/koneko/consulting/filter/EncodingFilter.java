package com.koneko.consulting.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter extends HttpFilter { // 定义编码过滤类
	// 默认的编码，如果用户没有配置任何的编码，则使用此编码
	public static final String DEFAULT_ENCODING = "UTF-8";
	private String charset; // 接收初始化参数

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.charset = filterConfig.getInitParameter("charset"); // 接收初始化参数
		if (this.charset == null || "".equals(this.charset)) { // 没有配置编码
			this.charset = DEFAULT_ENCODING; // 使用默认编码
		}
	}

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}
}
