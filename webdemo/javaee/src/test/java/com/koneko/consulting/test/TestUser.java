package com.koneko.consulting.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koneko.consulting.factory.DBConnection;
import com.koneko.consulting.vo.User;

public class TestUser {
	private static final Logger logger = LoggerFactory.getLogger(TestUser.class);
	
	@Test
	public void testAddUser() throws SQLException {
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		User user = new User("laoyang",18,'M',new Date());
		logger.warn("运行结果：{}",ss.insert("addUser",user));
		dbc.doConnection();
	}
	@Test
	public void testUpdateById() throws SQLException {
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		User user = new User();
		user.setName("laoli");
		user.setAge(19);
		user.setSex('F');
		user.setId(11);
		logger.warn("运行结果：{}",ss.update("updateById",user));
		dbc.doConnection();
	}
	@Test
	public void testRemoveById() throws SQLException {
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();		
		logger.warn("运行结果：{}",ss.delete("removeById",13));
		dbc.doConnection();
	}
	@Test
	public void testFindById() throws SQLException{
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		User user = ss.selectOne("findById",13);
		dbc.doConnection();
		logger.warn("获取的对象结果：{}",user);
	}
	@Test
	public void testFindNameById() throws SQLException{
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		String name = ss.selectOne("findNameById",14);
		dbc.doConnection();
		logger.warn("获取的对象结果：{}",name);
	}
	
	@Test
	public void testStatement() throws Exception{
		String DBDRIVER = "com.mysql.cj.jdbc.Driver";
		String DBURL = "jdbc:mysql://localhost:3306/qb2023";
		String DBUSER = "root";
		String DBPASSWORD = "shirahagi";
		Class.forName(DBDRIVER);
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		//生成PreparedStatement
		String sql = "delete user from user where id = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 12);
		ps.executeUpdate();
	}
}
