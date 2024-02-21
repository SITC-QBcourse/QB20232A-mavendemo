package com.koneko.consulting.converter;

import java.util.Arrays;

import org.springframework.core.convert.converter.Converter;

import com.koneko.consulting.vo.Student;

public class MyConverter implements Converter<String, Student>{

	@Override
	public Student convert(String source) {
		//id-name-age
		
		String[] temp = source.split("-");
		System.out.println(Arrays.toString(temp));
		Student stu = new Student();
		stu.setId(Integer.parseInt(temp[0]));
		stu.setName(temp[1]);
		stu.setAge(Integer.parseInt(temp[2]));
		return stu;
	}

}
