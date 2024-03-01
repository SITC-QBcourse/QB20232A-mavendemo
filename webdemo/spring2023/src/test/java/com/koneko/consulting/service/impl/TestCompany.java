package com.koneko.consulting.service.impl;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import com.koneko.consulting.config.CompanyConfiguration;
import com.koneko.consulting.vo.ICompany;

@ContextConfiguration(classes = {CompanyConfiguration.class})
public class TestCompany {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestCompany.class);
	@Resource(name="companyB")
	private ICompany company;
	
	@Test
	public void testAutowired() {
		LOGGER.info("===========开始===========");
//		LOGGER.info("title = {}, class = {}",this.company.getTitle(),this.company.getClass().getName());
		
		LOGGER.info("===========结束===========");
	}
}
