package com.koneko.consulting.vo;

import java.util.List;

import lombok.Data;

@Data
public class Person {
	private String name;
	private Integer age;
	private Boolean gender;
	private List<String> insts;
}
