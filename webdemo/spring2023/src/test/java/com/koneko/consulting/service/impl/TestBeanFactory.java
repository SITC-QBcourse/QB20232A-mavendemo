package com.koneko.consulting.service.impl;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

import com.koneko.consulting.config.CompanyConfiguration;
import com.koneko.consulting.vo.ICompany;
import com.koneko.consulting.vo.Member;

@ContextConfiguration(classes = {CompanyConfiguration.class})
public class TestBeanFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestBeanFactory.class);
	
	@Test
	public void testBeanFactory() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.koneko.consulting.config");
		context.refresh();
		ListableBeanFactory factory = context;//通过子类实例转为父接口对象		
		LOGGER.info("【Bean信息】获取Spring容器中Bean数量:{}",factory.getBeanDefinitionCount());
		LOGGER.info("【Bean信息】获取Spring容器中Bean名称：{}",Arrays.toString(factory.getBeanDefinitionNames()));
		LOGGER.info("【Bean信息】获取拥有Bean注解的Bean：{}",Arrays.toString(factory.getBeanNamesForAnnotation(Bean.class)));
	}
	
	@Test
	public void testSingleton() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.koneko.consulting.vo");
		context.refresh();
		LOGGER.info("【Bean信息】获取Member实例:{}",context.getBean(Member.class));
		LOGGER.info("【Bean信息】获取Member实例:{}",context.getBean(Member.class));
		LOGGER.info("【Bean信息】获取Member实例:{}",context.getBean(Member.class));
	}
	@Test
	public void testPrototype() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.koneko.consulting.vo");
		context.refresh();
		LOGGER.info("【Bean信息】获取Member实例:{}",context.getBean(Member.class));
		LOGGER.info("【Bean信息】获取Member实例:{}",context.getBean(Member.class));
		LOGGER.info("【Bean信息】获取Member实例:{}",context.getBean(Member.class));
	}
	@Test
	public void testConfigurableBeanFactory() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.koneko.consulting.vo");
		context.refresh();
		ConfigurableBeanFactory factory = context.getBeanFactory();
		LOGGER.info("【Bean信息】获取Member实例:{}",factory.getSingleton("member"));
	}
	@Test
	public void testObjectProvider() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.koneko.consulting.config");
		context.refresh();
		ObjectProvider<ICompany> provider = context.getBeanProvider(ICompany.class);
		LOGGER.info("【Bean实例】{}",provider.stream().findFirst().orElse(null));
	}
}
