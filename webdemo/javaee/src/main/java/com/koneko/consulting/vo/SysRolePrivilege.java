package com.koneko.consulting.vo;

import lombok.Data;

/**
 * 
 *项目名称：chat01
 *类名称：SysRolePrivilege
 *类描述：角色权限关联
 *创建人：Administrator
 * 创建时间：2022年1月3日
 * @version 1.0
 */
@Data
public class SysRolePrivilege {
//角色权限关联类
	private Long roleId;		//角色ID
	private Long privilegeId;	//权限ID
}