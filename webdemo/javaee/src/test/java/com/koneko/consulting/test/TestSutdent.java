package com.koneko.consulting.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.koneko.consulting.dao.IStudentDao;
import com.koneko.consulting.factory.IStudentFactory;
import com.koneko.consulting.vo.Student;

public class TestSutdent {

	@Test
	public void testDoCreate() throws SQLException {
		IStudentDao dao = IStudentFactory.getStudentDao();
		Student stu = new Student(6,"瑛姑","321456",68,'F',new Date());
		boolean flag = dao.doCreate(stu);
		if(flag) {
			System.out.println("【IStudentDao】插入成功");
		}else {
			System.out.println("【IStudentDao】插入失败");
		}
	}
	
	@Test
	public void testFindById() throws SQLException{
		IStudentDao dao = IStudentFactory.getStudentDao();
		Student stu = dao.findById(5);
		System.out.println(stu);
	}
	
	@Test
	public void testFindAll() throws SQLException{
		IStudentDao dao = IStudentFactory.getStudentDao();
		List<Student> list = dao.findAll("阳");
		for(Student stu : list) {
			System.out.println(stu);
		}
	}
}
