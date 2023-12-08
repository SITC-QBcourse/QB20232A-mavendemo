package com.koneko.consulting.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koneko.consulting.dao.IUserDao;
import com.koneko.consulting.factory.IUserDaoFactory;
import com.koneko.consulting.vo.User;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "jsp/mvc_login.jsp";
		String name = request.getParameter("name");
		System.out.println(name);
		String password = request.getParameter("password");
		System.out.println(password);
		List<String> info = new ArrayList<>();
		if(name == null || "".equals(name)) {
			info.add("用户名不可为空！");
		}
		if(password == null || "".equals(password)) {
			info.add("密码不可为空！");
		}
		if(info.size() == 0) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			try {
				IUserDao dao = IUserDaoFactory.getUserDao();
				boolean flag = dao.findLogin(user);
				if(flag) {
					info.add("用户登录成功！欢迎" + user.getNickname() + "光临！");
				}else {
					info.add("用户登陆失败，错误的用户名或者密码！");
				}
			}catch(Exception e) {}			
		}
		System.out.println(info);
		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
