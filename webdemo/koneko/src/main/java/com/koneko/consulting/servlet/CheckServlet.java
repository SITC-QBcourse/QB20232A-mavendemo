package com.koneko.consulting.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koneko.consulting.dbc.DatabaseConnection;

@WebServlet("/check.action")
public class CheckServlet extends HttpServlet {
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/qb2023";
	public static final String USER = "root";
	public static final String PASSWORD = "shirahagi";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = null;
		String mid = request.getParameter("mid");
		String password = request.getParameter("password");
		//错误数据库处理操作
		try {
			Class.forName(DBDRIVER);
			Connection conn = DatabaseConnection.getConnection("");
			Statement st = conn.createStatement();
			String sql = "select name from member where mid = '" + mid + "' and password = '" + password + "'"; 
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				name = rs.getString(1);
			}
			if(name == null) {
				response.getWriter().print("<h1>用户登陆失败，错误的 用户名及密码！</h1>");
			}else {
				response.getWriter().print("<h1>用户登录成功，欢迎光临</h1>");
			}
			DatabaseConnection.close();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
