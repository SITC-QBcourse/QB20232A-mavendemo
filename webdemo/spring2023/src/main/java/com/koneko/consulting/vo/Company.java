package com.koneko.consulting.vo;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class Company {
	@Value("${company.name}")
	private String name;
	@Value("${company.homepage}")
	private String homepage;
	@Value("${company.edu}")
	private String edu;
	@Value("${company.address}")
	private Address address;
	@Override
	public String toString() {
		return "Company [name=" + name + ", homepage=" + homepage + ", edu=" + edu + "]";
	}
	
}
