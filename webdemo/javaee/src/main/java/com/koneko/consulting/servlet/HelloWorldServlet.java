package com.koneko.consulting.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//所有的Servlet类中一定存在强制性的父类继承要求 Servlet是90年代末期出现 当时的技术要求决定了必须要继承父类
public class HelloWorldServlet extends HttpServlet {
    //暂时只关注get方法
	//进行get方法请求操作
	//在doGet方法中提供了两个参数，一个是request，一个是response
	//这两个都是通过容器进行的实例化操作，所以我们只需要传递参数不需要实例化
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//我们自己写代码，不需要原来提供的任何代码
		//printWriter PrintStream HTTP实际上是纯文本格式，所以咱们用到的是PrintWriter
		//在整个的Servlet中对于响应流的获取只能获取唯一一次，response.getWriter提供的
		//out对象只能在当前Servlet中有效
		  PrintWriter out = response.getWriter();
	      out.write("\n");
	      out.write("<!DOCTYPE html>\n");
	      out.write("<html>\n");
	      out.write("<head>\n");
	      out.write("<meta charset=\"UTF-8\">\n");
	      out.write("<title>Insert title here</title>\n");
	      out.println("</head>\n");
	      out.write("<body>\n");
	      out.write("<h1>Hello Servlet!</h1>\n");
	      out.write("</body>\n");
	      out.write("</html>");
	}
}
