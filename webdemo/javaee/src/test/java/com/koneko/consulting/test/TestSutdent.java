package com.koneko.consulting.test;

import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koneko.consulting.Demo;
import com.koneko.consulting.dao.IStudentDao;
import com.koneko.consulting.factory.DBConnection;
import com.koneko.consulting.factory.IStudentFactory;
import com.koneko.consulting.vo.User;

public class TestSutdent {

	@Test
	public void testAddUser() throws SQLException {
		IStudentDao dao = IStudentFactory.getStudentDao();
		Logger logger = LoggerFactory.getLogger(Demo.class);
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		User user = new User("laoyang",18,'M',new Date());
		logger.info("运行结果：{}",ss.insert("addUser",user));
	}
}
