package com.koneko.consulting.dao.impl;

import org.springframework.stereotype.Repository;

import com.koneko.consulting.dao.IDeptDAO;
import com.koneko.consulting.vo.Dept;

@Repository
public class DeptDAOImpl implements IDeptDAO {

	@Override
	public Dept findByid(Long deptNo) {
		Dept dept = new Dept();
		dept.setDeptNo(deptNo);
		dept.setDeptName("教学部");
		dept.setDeptLoc("新大久保");
		return dept;
	}

}
