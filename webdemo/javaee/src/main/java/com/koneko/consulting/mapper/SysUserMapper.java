package com.koneko.consulting.mapper;

import java.util.List;

import com.koneko.consulting.vo.SysUser;

public interface SysUserMapper {
	public SysUser selectById(long id);
	public List<SysUser> selectAll();
}
