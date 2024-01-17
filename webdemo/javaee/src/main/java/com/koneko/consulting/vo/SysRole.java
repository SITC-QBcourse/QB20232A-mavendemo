package com.koneko.consulting.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;
/**
 * 
 *项目名称：chat01
 *类名称：SysRole
 *类描述：角色类
 *创建人：Administrator
 * 创建时间：2022年1月3日
 * @version 1.0
 */
@Data
public class SysRole {
	private Long id;			//角色ID
	private String roleName;	//角色名
	private String enabled;		//有效标识
	private String createBy;	//创建人
	private Date createTime;	//创建时间
	
	List<SysUser> users;	
}