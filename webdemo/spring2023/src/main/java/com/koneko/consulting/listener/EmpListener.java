package com.koneko.consulting.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;

public class EmpListener implements SmartInitializingSingleton{
	private static final Logger LOGGER = LoggerFactory.getLogger(EmpListener.class);
	private String name;
	private int salary;
	@Override
	public void afterSingletonsInstantiated() {
		LOGGER.info("【属性修改前】salary = {}",this.salary);
		if(this.salary < 2000) {
			this.salary = 2000;
		}
		LOGGER.info("【属性修改后】salary = {}",this.salary);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
}
