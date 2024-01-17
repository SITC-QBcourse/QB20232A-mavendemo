package com.koneko.consulting.vo;

import lombok.Data;

/**
 * 
 *项目名称：chat01
 *类名称：SysUserRole
 *类描述：用户角色关联
 *创建人：Administrator
 * 创建时间：2022年1月3日
 * @version 1.0
 */
@Data
public class SysUserRole {
	private Long userId; //用户 ID
	private Long roleId;// 角色 ID
}