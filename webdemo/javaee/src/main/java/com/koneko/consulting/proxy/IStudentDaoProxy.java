package com.koneko.consulting.proxy;

import java.sql.SQLException;
import java.util.List;

import com.koneko.consulting.vo.Student;

public interface IStudentDaoProxy {
	//增加一条数据
	public boolean doCreate(Student stu) throws SQLException;
	//查询一条数据
	public Student findById(int id) throws SQLException;
	//查询所有满足条件数据
	public List<Student> findAll(String keyword) throws SQLException;
}
