package com.koneko.consulting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/elservlet")
public class ELServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("name", "www.koneko-consulting.com");
		request.setAttribute("name", "laoyang");
		request.getRequestDispatcher("/jsp/test_el/show.jsp").forward(request, response);
	}
}
