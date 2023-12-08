package com.koneko.consulting.proxy.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.koneko.consulting.dao.IUserDao;
import com.koneko.consulting.dao.impl.UserDaoImpl;
import com.koneko.consulting.dbc.DatabaseConnection;
import com.koneko.consulting.vo.User;

public class UserDaoProxy implements IUserDao {
	private Connection conn;
	private IUserDao dao;
	
	public UserDaoProxy() {
		this.conn = DatabaseConnection.rebuildConnection();
		this.dao = new UserDaoImpl(this.conn);
	}
	@Override
	public boolean findLogin(User user) throws SQLException {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(user);
		}finally {
			this.conn.close();
		}
		return flag;
	}

}
