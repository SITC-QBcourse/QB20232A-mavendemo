package com.koneko.consulting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("name1", "laoyang");
		request.setAttribute("name2", "草泥马");
		request.getRequestDispatcher("jsp/test_application/test_forward.jsp").forward(request, response);//客户端跳转 request无效
	}
}
