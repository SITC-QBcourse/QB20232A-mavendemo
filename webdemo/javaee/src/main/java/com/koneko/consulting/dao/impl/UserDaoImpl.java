//package com.koneko.consulting.dao.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import com.koneko.consulting.dao.IUserDao;
//import com.koneko.consulting.vo.User;
//
//public class UserDaoImpl implements IUserDao {
//	private Connection conn;
//	private PreparedStatement ps;
//	
//	public UserDaoImpl(Connection conn) {
//		this.conn = conn;
//	}
//	
//	@Override
//	public boolean findLogin(User user) throws SQLException {
////		boolean flag = false;
////		String sql = "select nickname from user where name = ? and password = ?";
////		this.ps = this.conn.prepareStatement(sql);
////		this.ps.setString(1, user.getName());
////		this.ps.setString(2, user.getPassword());
////		ResultSet rs = this.ps.executeQuery();
////		if(rs.next()) {
////			user.setNickname(rs.getString(1));
////			flag = true;
////		}
////		this.ps.close();
////		return flag;
//		return true;
//	}
//
//}
