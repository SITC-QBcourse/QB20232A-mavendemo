package com.koneko.consulting.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.koneko.consulting.service.IMessageService;

//进行spring配置文件的加载
@ContextConfiguration(locations = {"classpath:spring-base.xml"})
@ExtendWith(SpringExtension.class)//表示此时使用的外部的测试工具进行的测试
public class TestMessageServiceImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestMessageServiceImpl.class);
	@Autowired
	private IMessageService service;
	
	@Test
	public void testSend() {
		LOGGER.info("-------测试开始-------");
		LOGGER.info("测试结果为：{}",service.send("待会儿吃点啥？"));
		LOGGER.info("-------测试结束-------");
	}
}
