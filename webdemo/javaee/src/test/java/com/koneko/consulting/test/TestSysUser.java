package com.koneko.consulting.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koneko.consulting.factory.DBConnection;
import com.koneko.consulting.mapper.SysRoleMapper;
import com.koneko.consulting.mapper.SysUserMapper;
import com.koneko.consulting.vo.SysRole;
import com.koneko.consulting.vo.SysUser;

public class TestSysUser {
	private static final Logger logger = LoggerFactory.getLogger(TestUser.class);
	private SysUser user = null;
	private SysRole role = null;
	private List<SysUser> users = null;
	private List<SysRole> roles = null;
	private SysUserMapper mapper = null;
	private SysRoleMapper roleMapper = null;
	@Test
	public void testSelectById() {
		logger.debug("----执行代码开始位置----");
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		user = mapper.selectById(1001L);
		dbc.doConnection();
		logger.debug("执行结果为：");
		this.printUser(user);
		logger.debug("----执行代码结束位置----");
	}
	@Test
	public void testSelectRolesByUserId() {
		logger.debug("----执行代码开始位置----");
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		roleMapper = ss.getMapper(SysRoleMapper.class);
		roles = roleMapper.selectRolesByUserId(1001L);
		dbc.doConnection();
		this.printRoles(roles);
		logger.debug("----执行代码结束位置----");
	}
	@Test
	public void testSelectAll() {
		logger.debug("----执行代码开始位置----");
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		this.users = mapper.selectAll();
		dbc.doConnection();
		logger.debug("执行结果为：");
		this.printUsers(users);
		logger.debug("----执行代码结束位置----");
	}
	public void printUser(SysUser user) {
		logger.info("========用户信息========\n" + 
				"用户编号:" + user.getId() + 
				"\n用户姓名:" + user.getUserName() + 
				"\n用户密码:" + user.getUserPassword() + 
				"\n用户邮箱:" + user.getUserEmail() + 
				"\n用户简介:" + user.getUserInfo() + 
				"\n创建时间:" + user.getCreateTime()
				);
	}
	public void printRole(SysRole role) {
		logger.info("========角色信息========\n" + 
				"角色编号:" + role.getId() +  
				"\n角色姓名:" + role.getRoleName() + 
				"\n有效标识:" + role.getEnabled() + 
				"\n创建人员:" + role.getCreateBy() + 
				"\n创建时间:" + role.getCreateTime() 
				);
	}
	public void printUsers(List<SysUser> users) {
		for(SysUser user : users) {
			this.printUser(user);
		}
	}
	public void printRoles(List<SysRole> roles) {
		for(SysRole role : roles) {
			this.printRole(role);
		}
	}
}
