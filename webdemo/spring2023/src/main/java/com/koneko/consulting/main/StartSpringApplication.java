package com.koneko.consulting.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.koneko.consulting.config.EmpConfig;
import com.koneko.consulting.listener.EmpListener;

public class StartSpringApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartSpringApplication.class);
	
	public static void main(String[] args) throws Exception {
		SmartInitializingSingleton s;
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(EmpConfig.class);
		context.refresh();
		EmpListener emp = context.getBean(EmpListener.class);
		LOGGER.info("【雇员信息】姓名：{}   工资：{}",emp.getName(),emp.getSalary());
		context.close();
	}
}
