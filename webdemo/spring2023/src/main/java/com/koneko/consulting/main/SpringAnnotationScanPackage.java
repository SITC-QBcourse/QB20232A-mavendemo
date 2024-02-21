package com.koneko.consulting.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.koneko.consulting.vo.Company;

public class SpringAnnotationScanPackage {
	public static final Logger LOGGER = LoggerFactory.getLogger(SpringAnnotationScanPackage.class);
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.koneko.consulting.config");
		context.refresh();
		Company company = context.getBean(Company.class);
		LOGGER.info("{}",company);
		LOGGER.info("{}",company.getAddress());
	}
}
