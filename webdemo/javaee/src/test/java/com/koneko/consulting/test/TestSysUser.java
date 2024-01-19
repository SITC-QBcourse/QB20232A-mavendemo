package com.koneko.consulting.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.executor.result.DefaultResultContext;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koneko.consulting.dto.SysUserDto;
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
		System.out.println();
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
	@Test
	public void testInsertUser() throws Exception {
		logger.debug("----执行代码开始位置----");
		user = new SysUser();
		user.setUserName("张三");
		user.setUserPassword("123456");
		user.setUserEmail("zhangsan@koneko-consulting.com");
		user.setUserInfo("这家伙很懒，什么都没有留下");
		File file = new File("C:\\Users\\SITC-050\\OneDrive\\Documents\\GitHub\\QB20232A-mavendemo\\webdemo\\javaee\\src\\main\\java\\com\\koneko\\consulting\\mapper\\headImg.jpg");
		InputStream in = new FileInputStream(file);
		byte[] headImg = new byte[(int)file.length()];
		in.read(headImg);
		user.setHeadImg(headImg);
		user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-10-23 04:15:35"));
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		int result = mapper.insertUser(user);
		dbc.doConnection();
		logger.info("执行结果：{}，插入数据的编号为：{}",result,user.getId());
		logger.debug("----执行代码结束位置----");
	}
	@Test
	public void testInsertUsers() throws Exception {
		logger.debug("----执行代码开始位置----");
		users = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			user = new SysUser();
			user.setUserName("张三" + i);
			user.setUserPassword("123456");
			user.setUserEmail("zhangsan@koneko-consulting.com");
			user.setUserInfo("这家伙很懒，什么都没有留下");
			File file = new File("C:\\Users\\SITC-050\\OneDrive\\Documents\\GitHub\\QB20232A-mavendemo\\webdemo\\javaee\\src\\main\\java\\com\\koneko\\consulting\\mapper\\headImg.jpg");
			InputStream in = new FileInputStream(file);
			byte[] headImg = new byte[(int)file.length()];
			in.read(headImg);
			user.setHeadImg(headImg);
			user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-10-23 04:15:35"));
			users.add(user);
		}
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		int result = mapper.insertUsers(users);
		dbc.doConnection();
		logger.info("执行结果：{}",result);
		logger.debug("----执行代码结束位置----");
	}
	
	@Test
	public void testSelectByMap() {
		logger.debug("----执行代码开始位置----");
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		Map<String,Object> map = new HashMap<>();
		map.put("id", 1L);
		map.put("UserName", "张三");
		users = mapper.selectByMap(map);
		dbc.doConnection();
		for(SysUser user : users) {
			this.printUser(user);
		}
		logger.debug("----执行代码结束位置----");
	}
	@Test
	public void testSelectByDto() {
		logger.debug("----执行代码开始位置----");
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		SysUserDto dto = new SysUserDto();
		dto.setUserEmail("admin@laoyang.org");
		users = mapper.selectByDto(dto);
		dbc.doConnection();
		for(SysUser user : users) {
			this.printUser(user);
		}
		logger.debug("----执行代码结束位置----");
	}
	@Test
	public void testSelectByIdOrName() {
		logger.debug("----执行代码开始位置----");
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		users = mapper.selectByIdOrName(null,null);
		dbc.doConnection();
		for(SysUser user : users) {
			this.printUser(user);
		}
		logger.debug("----执行代码结束位置----");
	}
	@Test
	public void testUpdateById() {
		logger.debug("----执行代码开始位置----");
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		user = new SysUser();
		user.setId(null);
		mapper.updateById(user);
		dbc.doConnection();
		logger.debug("----执行代码结束位置----");
	}
	@Test
	public void testSelectByCollection() {
		logger.debug("----执行代码开始位置----");
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		users = mapper.selectByCollection(Arrays.asList(1L,1001L,1005L,1003L));
		dbc.doConnection();
		for(SysUser user : users) {
			this.printUser(user);
		}
		logger.debug("----执行代码结束位置----");
	}
	@Test
	public void testGetList() {
		logger.debug("----执行代码开始位置----");
		DBConnection dbc = new DBConnection();
		SqlSession ss = dbc.getSqlSession();
		mapper = ss.getMapper(SysUserMapper.class);
		mapper.getList(context -> {
			DefaultResultContext<SysUser> result = (DefaultResultContext<SysUser>) context;
			printUser(result.getResultObject());
			if(result.getResultCount() == 2) {
				result.stop();
			}
		});
		dbc.doConnection();
//		for(SysUser user : users) {
//			this.printUser(user);
//		}
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
	public void printRoleAndUser(SysRole role) {
		logger.info("========角色信息========\n" + 
				"角色编号:" + role.getId() +  
				"\n角色姓名:" + role.getRoleName() + 
				"\n有效标识:" + role.getEnabled() + 
				"\n创建人员:" + role.getCreateBy() + 
				"\n创建时间:" + role.getCreateTime() +
				"\n用户姓名：" + role.getUsers().get(0).getUserName() + 
				"\n用户简介：" + role.getUsers().get(0).getUserInfo()
				);
	}
	public void printUsers(List<SysUser> users) {
		for(SysUser user : users) {
			this.printUser(user);
		}
	}
	public void printRoles(List<SysRole> roles) {
		for(SysRole role : roles) {
			this.printRoleAndUser(role);
		}
	}
	public TestSysUser() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
}
