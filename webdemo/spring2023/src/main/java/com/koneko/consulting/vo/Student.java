package com.koneko.consulting.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	private int id;
	private String name;
	private int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getBirthday() {
		return birthday;
	}
}
