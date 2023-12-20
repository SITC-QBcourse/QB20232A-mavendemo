package com.koneko.consulting.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koneko.consulting.vo.Student;
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stu = new Student(
				101,
				"laoyang",
				"123",
				18,
				'F',
				new Date()
				);
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("/jsp/test_el/test_student.jsp").forward(request, response);
	}
}
