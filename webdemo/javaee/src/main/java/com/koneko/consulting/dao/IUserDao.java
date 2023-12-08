package com.koneko.consulting.dao;

import java.sql.SQLException;

import com.koneko.consulting.vo.User;

public interface IUserDao {
	public boolean findLogin(User user) throws SQLException;
}
