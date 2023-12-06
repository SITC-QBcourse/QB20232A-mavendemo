package com.koneko.consulting.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serverServlet")
public class ServerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("name1", "laoyang");
		request.getSession().setAttribute("name2", "laoyang");
		RequestDispatcher rd = request.getRequestDispatcher("jsp/test_application/test_forward.jsp");
		rd.forward(request, response);
	}
}
