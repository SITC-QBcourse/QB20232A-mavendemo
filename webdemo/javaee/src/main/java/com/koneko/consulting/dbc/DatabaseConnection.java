package com.koneko.consulting.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/qb2022";
	public static final String DBUSER = "root";
	public static final String DBPASSWORD = "shirahagi";
	
	private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
	
	private DatabaseConnection() {}
	public static Connection rebuildConnection() {
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getConnection() {
		Connection conn = THREAD_LOCAL.get();
		if(conn == null) {
			conn = rebuildConnection();
			THREAD_LOCAL.set(conn);
		}
		return conn;
	}
	
	public static void close() {
		Connection conn = THREAD_LOCAL.get();
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		THREAD_LOCAL.remove();
	}
}
