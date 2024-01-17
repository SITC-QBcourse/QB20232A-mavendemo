package com.koneko.consulting.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("User")
public class User {
	private int id;
	private String name;
	private int age;
	private char sex;
	private Date birthday;
	
	public User(String name, int age,char sex, Date birthday) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}
}
