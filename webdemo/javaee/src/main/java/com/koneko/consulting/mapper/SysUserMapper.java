package com.koneko.consulting.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import com.koneko.consulting.dto.SysUserDto;
import com.koneko.consulting.vo.SysUser;

public interface SysUserMapper {
	public int insertUser(SysUser user);
	public int insertUsers(List<SysUser> users);
	public SysUser selectById(long id);
	public List<SysUser> selectAll();
	public List<SysUser> selectByMap(Map<String,Object> map);
	public List<SysUser> selectByDto(SysUserDto user);
	public List<SysUser> selectByIdOrName(@Param("id") Long id, @Param("userName") String userName);
	public List<SysUser> selectByCollection(Collection<Long> ids);
	public void getList(ResultHandler<SysUser> result);
	public boolean updateById(SysUser user);
	public List<SysUser> testSelectStar();
}
