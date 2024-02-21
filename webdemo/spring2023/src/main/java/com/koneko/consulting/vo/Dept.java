package com.koneko.consulting.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Dept {
	private Long deptNo;
	private String deptName;
	private String deptLoc;
}
