package com.koneko.consulting.vo;

import lombok.Data;

/**
 * 
 *项目名称：chat01
 *类名称：SysPrivilege
 *类描述：权限类
 *创建人：Administrator
 * 创建时间：2022年1月3日
 * @version 1.0
 */
@Data
public class SysPrivilege {
	private Long id;				//权限ID
	private String privilegeName;	//权限名称
	private String privilegeUrl;	//权限URL
}