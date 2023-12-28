package com.koneko.consulting.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/KickoutServlet")
public class KickoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		Map<String, Boolean> onlineMap = (Map<String, Boolean>) req.getServletContext().getAttribute("online"); // Map集合
		if (onlineMap.containsKey(userid)) { // 用户还没走呢
			onlineMap.put(userid, true); // 设置为True就表示要剔除了
		}
		req.getServletContext().setAttribute("online", onlineMap);
		resp.sendRedirect("/koneko/pages/admin/online_user_list.jsp");
	}
}
