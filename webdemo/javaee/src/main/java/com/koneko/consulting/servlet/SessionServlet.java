package com.koneko.consulting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("【HttpServletRequest】getSession()获取实例：" + request.getSession());
		System.out.println("【HttpServletRequest】getSession(true)获取实例：" + request.getSession(true));
		System.out.println("【HttpServletRequest】getSession(false)获取实例：" + request.getSession(false));
	}
}
