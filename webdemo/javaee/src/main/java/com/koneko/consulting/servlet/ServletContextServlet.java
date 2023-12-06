package com.koneko.consulting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class ServletContextServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("【HttpServletRequest】application实例：" + request.getServletContext());
		System.out.println("【GenericServlet】application实例：" + super.getServletContext());
	}
}
