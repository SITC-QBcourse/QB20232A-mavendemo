package com.koneko.consulting.factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {
	private SqlSessionFactory sf = null;
	private SqlSession sqlSession = null;
	private InputStream config;
	public DBConnection() {
		//获取配置文件
		try {
			config = Resources.getResourceAsStream("mybatis-config.xml");
			//打开工厂
			sf = new SqlSessionFactoryBuilder().build(config);
			//打开会话
			sqlSession = sf.openSession();
		} catch (IOException e) {
			System.out.println("mybatis-config.xml文件未找到");
		}
	}
	public SqlSession getSqlSession() {
		return this.sqlSession;
	}
	public void doConnection() {
		if(sqlSession != null) {
			try {
				sqlSession.commit();
			}catch (Exception e) {
				sqlSession.rollback();
			}finally {
				sqlSession.close();
			}
		}	
		
	}
}
