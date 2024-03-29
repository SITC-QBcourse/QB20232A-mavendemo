package com.koneko.consulting.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection { // 数据库连接管理类
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	public static String DBURL = "jdbc:mysql://localhost:3306/";
	public static final String USER = "root";
	public static final String PASSWORD = "shirahagi";
	private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

	private DatabaseConnection() {
	} // 构造方法私有化

	public static Connection rebuildConnection(String databaseName) { // 重新创建数据库连接
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);
			System.out.println("DBURL = " + (DBURL + databaseName));
			conn = DriverManager.getConnection(DBURL + databaseName, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getConnection(String databaseName) {
		Connection conn = THREAD_LOCAL.get(); // 获取当前线程中的连接对象
		if (conn == null) { // 没有连接对象
			conn = rebuildConnection(databaseName); // 建立数据库连接
			THREAD_LOCAL.set(conn); // 保存连接对象
		}
		return conn;
	}

	public static void close() {
		Connection conn = THREAD_LOCAL.get(); // 获取当前线程中的连接对象
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
			THREAD_LOCAL.remove(); // 清空ThreadLocal
		}
	}
}
