package com.koneko.consulting.mapper;

import java.util.List;

import com.koneko.consulting.vo.SysRole;

public interface SysRoleMapper {
	public List<SysRole> selectRolesByUserId(long id);
}
