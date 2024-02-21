package com.koneko.consulting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.koneko.consulting.listener.EmpListener;

@Configuration
public class EmpConfig {
	@Scope("prototype")
	@Bean
	public EmpListener emp() {
		EmpListener emp = new EmpListener();
		emp.setName("老杨");
		emp.setSalary(1800);
		return emp;
	}
}
