package com.koneko.consulting.proxy.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koneko.consulting.dao.IStudentDao;
import com.koneko.consulting.dao.impl.SutdentDaoImpl;
import com.koneko.consulting.dbc.DatabaseConnection;
import com.koneko.consulting.vo.Student;

public class StudentDaoProxy implements IStudentDao {
	private Connection conn;
	private IStudentDao dao;
	
	public StudentDaoProxy() {
		this.conn = DatabaseConnection.rebuildConnection();
		this.dao = new SutdentDaoImpl(this.conn);
	}
	
	@Override
	public boolean doCreate(Student stu) throws SQLException {
		boolean flag = false;
		//增加一条数据的时候，首先应该是先确认当前数据是否存在于数据库
		try {
			if(this.dao.findById(stu.getUserId()) == null) {
				flag = this.dao.doCreate(stu);
			}
		}finally {
			this.conn.close();
		}
		return flag;
	}

	@Override
	public Student findById(int id) throws SQLException {
		Student stu = null;
		try {
			stu = this.dao.findById(id);
		}finally {
			this.conn.close();
		}
		return stu;
	}

	@Override
	public List<Student> findAll(String keyword) throws SQLException {
		List<Student> list = new ArrayList<>();
		try {
			list = this.dao.findAll(keyword);
		}finally {
			this.conn.close();
		}
		return list;
	}

}
