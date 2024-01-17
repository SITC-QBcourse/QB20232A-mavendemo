package com.koneko.consulting;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koneko.consulting.factory.DBConnection;
import com.koneko.consulting.vo.User;

public class Demo{
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Demo.class);
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		User user = new User("laoyang",18,'M',new Date());
		logger.info("运行结果：{}" + ss.insert("addUser",user));
		
	}
}
