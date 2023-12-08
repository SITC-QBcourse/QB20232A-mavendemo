package com.koneko.consulting.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koneko.consulting.dao.IStudentDao;
import com.koneko.consulting.vo.Student;

public class SutdentDaoImpl implements IStudentDao {
	private Connection conn; 
	private PreparedStatement ps;
	
	public SutdentDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(Student stu) throws SQLException {
		boolean flag = false;
		String sql = "insert into student (user_id,user_name,user_password,user_age,user_sex,user_birthday) values(?,?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, stu.getUserId());
		this.ps.setString(2, stu.getUserName());
		this.ps.setString(3, stu.getUserPassword());
		this.ps.setInt(4, stu.getUserAge());
		this.ps.setString(5, stu.getUserSex() + "");
		this.ps.setDate(6, new java.sql.Date(stu.getUserBirthday().getTime()));
		int temp = this.ps.executeUpdate();
		if(temp > 0) {
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	public Student findById(int id) throws SQLException{
		Student stu = null;
		String sql = "select * from student where user_id = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, id);
		ResultSet rs = this.ps.executeQuery();
		while(rs.next()) {
			stu = new Student();
			stu.setUserId(rs.getInt(1));
			stu.setUserName(rs.getString(2));
			stu.setUserPassword(rs.getString(3));
			stu.setUserAge(rs.getInt(4));
			stu.setUserSex(rs.getString(5).charAt(0));
			stu.setUserBirthday(rs.getDate(6));
		}
		this.ps.close();
		return stu;
	}

	@Override
	public List<Student> findAll(String keyword)  throws SQLException{
		List<Student> stus = new ArrayList<>();
		String sql = "select * from student where user_name like ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, '%' + keyword + '%');
		ResultSet rs = this.ps.executeQuery();
		Student stu = null;
		while(rs.next()) {
			stu = new Student();
			stu.setUserId(rs.getInt(1));
			stu.setUserName(rs.getString(2));
			stu.setUserPassword(rs.getString(3));
			stu.setUserAge(rs.getInt(4));
			stu.setUserSex(rs.getString(5).charAt(0));
			stu.setUserBirthday(rs.getDate(6));
			stus.add(stu);
		}
		this.ps.close();
		return stus;
	}
}
