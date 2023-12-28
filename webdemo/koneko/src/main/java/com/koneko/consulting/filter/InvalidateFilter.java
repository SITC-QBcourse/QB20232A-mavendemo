package com.koneko.consulting.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/pages/front/*")
public class InvalidateFilter extends HttpFilter implements Filter {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String userid = (String) request.getSession().getAttribute("userid");
		if (userid != null) { // 用户登录过
			Map<String, Boolean> onlineMap = (Map<String, Boolean>) request.getServletContext().getAttribute("online"); // Map集合
			if (onlineMap.containsKey(userid)) { // 用户还存在
				if (onlineMap.get(userid) == true) { // 本身保存的就是布尔类型
					request.getSession().invalidate(); // 强制注销
					request.setAttribute("error", "您的账户已被系统强制下线，为了您的安全，请重新登录！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else { // 正常的状态
					chain.doFilter(request, response);
				}
			}
		} else {
			request.setAttribute("error", "您还未登录，请先登录！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
