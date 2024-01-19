package com.koneko.consulting.dto;

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
public class SysUserDto {
	private Long id; 				// 用户 ID
	private String userName; 	// 用户名
	private String userEmail;
}