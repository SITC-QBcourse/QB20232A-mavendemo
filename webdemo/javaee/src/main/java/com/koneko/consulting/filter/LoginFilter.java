package com.koneko.consulting.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/jsp/login/*"})
public class LoginFilter extends HttpFilter implements Filter {
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String name = (String)request.getSession().getAttribute("nickname");
		if(name != null) {
			System.out.println(name);
			chain.doFilter(request, response);
		}else {
			System.out.println("非法用户");
			response.sendRedirect("/javaee/jsp/login.jsp");
		}
	}
}
