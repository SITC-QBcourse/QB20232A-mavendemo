package com.koneko.consulting.service.impl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.koneko.consulting.vo.Company;
import com.koneko.consulting.vo.ICompany;

public class TestSpringMybatis {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestSpringMybatis.class);
	@Test
	public void testSpringMybatis() {
		LOGGER.info("===========开始===========");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.koneko.consulting.config");
		context.refresh();
		Company company = context.getBean(Company.class);
		LOGGER.info("{}",company);
		LOGGER.info("{}",company.getAddress());
		LOGGER.info("===========结束===========");
	}
	@Autowired
	@Qualifier("companyA")
	private ICompany company;
	
	@Test
	public void testAutowired() {
		LOGGER.info("===========开始===========");
		LOGGER.info("title = {}, class = {}",this.company.getTitle(),this.company.getClass().getName());
		LOGGER.info("===========结束===========");
	}
	@Test
	public void testMessage() {
		LOGGER.info("===========开始===========");
		Object[][] objs = new Object[1][];
		objs[0] = new Object[2];
		objs[0][0] = new int[2];
		
		LOGGER.info("===========结束===========");
	}
	@Test
	public void testPropertyEditor() {
		LOGGER.info("===========开始===========");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.koneko.consulting.config");
		context.refresh();
		Company company = context.getBean(Company.class);
		LOGGER.info("{}",company);
		LOGGER.info("{}",company.getAddress());
		LOGGER.info("===========结束===========");
	}
}
