package com.koneko.consulting.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.koneko.consulting.dbc.DatabaseConnection;

public class Demo{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String name = null;
		Connection conn = DatabaseConnection.getConnection("qb2023");
		Statement st = conn.createStatement();
		String pass = "abcdefg' or '1' = '1";
		String sql = "select name from member where mid = 'tmc10001' and password = '" + pass + "'"; 
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			name = rs.getString(1);
		}
		if(name == null) {
			System.out.println("<h1>用户登陆失败，错误的 用户名及密码！</h1>");
		}else {
			System.out.println("<h1>用户登录成功，欢迎光临</h1>");
		}
	}
}
