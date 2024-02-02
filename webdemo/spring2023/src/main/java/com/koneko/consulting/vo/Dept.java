package com.koneko.consulting.vo;

import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Configuration
public class Dept {
	private Long deptNo;
	private String deptName;
	private String deptLoc;
}
