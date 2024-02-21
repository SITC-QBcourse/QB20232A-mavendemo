package com.koneko.consulting.service.impl;

import com.koneko.consulting.dao.DeptMapper;
import com.koneko.consulting.service.IDeptService;
import com.koneko.consulting.vo.Dept;

import lombok.Data;

@Data
public class DeptServiceImpl implements IDeptService {
	private DeptMapper mapper;
	@Override
	public Dept findByid(Long deptNo) {
		return this.mapper.findByid(deptNo);
	}	
}
