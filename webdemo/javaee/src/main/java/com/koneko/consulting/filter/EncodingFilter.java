package com.koneko.consulting.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(urlPatterns = {"/*"})
public class EncodingFilter extends HttpFilter implements Filter {
	public static final String DEFAULT_ENCODING = "UTF-8";
	private String charset;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.charset = filterConfig.getInitParameter("charset");
		if(this.charset == null || "".equals(this.charset)) {
			this.charset = DEFAULT_ENCODING;
		}
		// TODO 自動生成されたメソッド・スタブ
		super.init(filterConfig);
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(DEFAULT_ENCODING);
		response.setCharacterEncoding(DEFAULT_ENCODING);
		chain.doFilter(request, response);
	}
}
