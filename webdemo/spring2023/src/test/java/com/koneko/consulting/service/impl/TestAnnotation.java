package com.koneko.consulting.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.koneko.consulting.service.IDeptService;
import com.koneko.consulting.service.IMessageService;

@ContextConfiguration(locations = {"classpath:spring-base.xml"})
@ExtendWith(SpringExtension.class)//表示此时使用的外部的测试工具进行的测试
public class TestAnnotation {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestAnnotation.class);
	@Autowired
	private IDeptService service;
	@Test
	public void testAnnotation() {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-base.xml");
		LOGGER.info("-------测试开始-------");
		LOGGER.info("【部门信息】：{}",service.findByid(101L));
		LOGGER.info("-------测试结束-------");
	}
	
	@Autowired
	private IMessageService messageService;
	
	@Test
	public void testConfiguration() {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-base.xml");
		LOGGER.info("-------测试开始-------");
		LOGGER.info("【执行结果】：{}", messageService.send("abc"));
		LOGGER.info("【configBean】:{}",con.getBean("php"));
		LOGGER.info("【deptBean】:{}",con.getBean("dept"));
		
		LOGGER.info("-------测试结束-------");
	}
}
