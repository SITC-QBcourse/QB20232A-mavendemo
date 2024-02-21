package com.koneko.consulting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koneko.consulting.vo.CompanyA;
import com.koneko.consulting.vo.CompanyB;

@Configuration

public class CompanyConfiguration {
	@Bean
	public CompanyA companyA() {
		CompanyA companyA = new CompanyA();
		companyA.setTitle("java");
		return companyA;
	}
	@Bean
	public CompanyB companyB() {
		CompanyB companyB = new CompanyB();
		companyB.setTitle("Spring");
		return companyB;
	}
}
