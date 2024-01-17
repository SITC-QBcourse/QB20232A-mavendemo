package com.koneko.consulting.mapper;

import com.koneko.consulting.vo.User;

public interface UserMapper {
	public int addUser(User user);
	public User findById(int id);
	public int updateById(int id);
	public int removeById(int id);
}
