package com.koneko.consulting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koneko.consulting.dao.IDeptDAO;
import com.koneko.consulting.service.IDeptService;
import com.koneko.consulting.vo.Dept;

@Service
public class DeptServiceImpl implements IDeptService {
	@Autowired
	private IDeptDAO dao;
	@Override
	public Dept findByid(Long deptNo) {
		return this.dao.findByid(deptNo);
	}

}
