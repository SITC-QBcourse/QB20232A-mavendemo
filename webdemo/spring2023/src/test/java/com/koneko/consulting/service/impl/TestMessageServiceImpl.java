package com.koneko.consulting.service.impl;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.koneko.consulting.di.config.MessageConfig;
import com.koneko.consulting.di.config.MessageProperties;
import com.koneko.consulting.service.IMessageService;
import com.koneko.consulting.vo.Dept;

//进行spring配置文件的加载
@ContextConfiguration(locations = {"classpath:spring-base.xml"})
@ExtendWith(SpringExtension.class)//表示此时使用的外部的测试工具进行的测试
public class TestMessageServiceImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestMessageServiceImpl.class);
	
//	@Autowired
//	private IMessageService service;
	
	@Test
	public void testSend() {
		LOGGER.info("-------测试开始-------");
//		LOGGER.info("测试结果为：{}",service.send("待会儿吃点啥？"));
		LOGGER.info("-------测试结束-------");
	}
	
	@Test
	public void testDepartment() {
		Dept dept1 = new Dept();
		System.out.println(dept1);
		Dept dept2 = new Dept();
		System.out.println(dept2);
	}
	
	@Test
	public void testDept() {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-base.xml");
		LOGGER.info("-------测试开始-------");
		Dept dept1 = con.getBean(Dept.class);
		dept1.setDeptNo(101L);
		LOGGER.info("第一次获取BEAN：{}",dept1);
		Dept dept2 = con.getBean(Dept.class);
		dept2.setDeptNo(102L);
		LOGGER.info("第二次获取BEAN：{}",dept2);
		
		LOGGER.info("部门1和部门2的NO的相加和：{}",dept1.getDeptNo() + dept2.getDeptNo());
		LOGGER.info("-------测试结束-------");
	}
	
	@Test
	public void testClone() {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-base.xml");
		LOGGER.info("-------测试开始-------");
//		Emp emp1 = con.getBean(Emp.class);
//		LOGGER.info("第一次获取Bean：{}",emp1);
//		LOGGER.info("第一次获取Bean：{}",emp1.getDept());
//		Emp emp2 = con.getBean(Emp.class);
//		LOGGER.info("第二次获取Bean：{}",emp2);
//		LOGGER.info("第二次获取Bean：{}",emp2.getDept());
		LOGGER.info("-------测试结束-------");
	}
	
	@Autowired
	Map<String,MessageConfig> configs;
	@Test
	public void testList() {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-base.xml");
		LOGGER.info("-------测试开始-------");
		IMessageService service = con.getBean("messageService",MessageServiceImpl.class);
		LOGGER.info("【信息发送】：{}",service.send("中午吃点啥？"));
		
		LOGGER.info("集合的实例化子类：{}",configs.getClass());
		LOGGER.info("-------测试结束-------");
	}
	
	@Test
	public void testProps() {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-base.xml");
		LOGGER.info("-------测试开始-------");
		MessageProperties messageProperties = con.getBean(MessageProperties.class);
		LOGGER.info("【{}】属性配置：{}",messageProperties.getSubject(),messageProperties.getAttribute());
		LOGGER.info("-------测试结束-------");
	}
}
