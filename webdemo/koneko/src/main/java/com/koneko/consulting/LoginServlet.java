package com.koneko.consulting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userid"); // 接收请求参数
		String password = req.getParameter("password"); // 接收请求参数
		if (!"admin".equals(password)) { // 密码输入错误
			req.setAttribute("error", "错误的用户名及密码！");
			req.getRequestDispatcher("/errors.jsp").forward(req, resp);
		}
		// WEB组件中提供有监听操作，而通过监听操作可以实现HttpSession属性的处理
		req.getSession().setAttribute("userid", id); // 设置Session属性内容
		resp.sendRedirect("/koneko/pages/front/welcome.jsp"); // 客户端跳转
	}
}
