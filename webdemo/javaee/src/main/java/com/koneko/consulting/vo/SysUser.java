package com.koneko.consulting.vo;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 *项目名称：chat01
 *类名称：SysUser
 *类描述：用户类
 *创建人：Administrator
 * 创建时间：2022年1月3日
 * @version 1.0
 */
@Getter
@Setter
public class SysUser {
	private Long id; 				// 用户 ID
	private String userName; 	// 用户名
	private String userPassword;// 密码
	private String userEmail; 	// 邮箱
	private String userInfo; 	// 简介
	private byte[] headImg; 	// 头像
	private Date createTime;	// 创建时间
	
	List<SysRole> roles;
}