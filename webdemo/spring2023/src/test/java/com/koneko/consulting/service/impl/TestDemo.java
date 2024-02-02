package com.koneko.consulting.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"classpath:spring-base.xml"})
@ExtendWith(SpringExtension.class)//表示此时使用的外部的测试工具进行的测试
public class TestDemo {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestDemo.class);
	
	@Test
	public void test() {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-base.xml");
		LOGGER.info("-------测试开始-------");
		LOGGER.info("-------测试结束-------");
	}
}
