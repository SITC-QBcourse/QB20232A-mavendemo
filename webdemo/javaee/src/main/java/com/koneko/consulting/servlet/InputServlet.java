package com.koneko.consulting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(
//		description = "使用注解实现Servlet配置",
//		urlPatterns = {"/input.action","/input/action/*"},
//		loadOnStartup = 2
//		)
public class InputServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("【InputServlet】Servlet初始化");
	}
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	request.setCharacterEncoding("utf-8");//request请求的时候不出现乱码
////	response.setCharacterEncoding("utf-8");//回应的时候也是不出现乱码
//	response.setContentType("text/html; charset=UTF-8");
//	String msg = request.getParameter("message");
//	  PrintWriter out = response.getWriter();
//      out.write("\n");
//      out.write("<!DOCTYPE html>\n");
//      out.write("<html>\n");
//      out.write("<head>\n");
//      out.write("<meta charset=\"UTF-8\">\n");
//      out.write("<title>Insert title here</title>\n");
//      out.println("</head>\n");
//      out.write("<body>\n");
//      out.write("<h1>" + msg + "</h1>\n");
//      out.write("</body>\n");
//      out.write("</html>");
//	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("【InputServlet】Servlet处理HTTP请求");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("【InputServlet】Servlet处理GET请求");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("【InputServlet】Servlet处理POST请求");
	}
}
