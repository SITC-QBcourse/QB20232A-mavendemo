package com.koneko.consulting.vo;

import java.util.Date;

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
public class Student {
	private int userId;
	private String userName;
	private String userPassword;
	private int userAge;
	private char userSex;
	private Date userBirthday;
}
