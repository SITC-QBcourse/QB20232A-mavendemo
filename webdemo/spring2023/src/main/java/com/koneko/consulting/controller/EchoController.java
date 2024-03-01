package com.koneko.consulting.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koneko.consulting.vo.Student;

@Controller
public class EchoController {
	@ResponseBody
	@RequestMapping(value="echo.action",method=RequestMethod.POST)
	public Student echo(@RequestParam("id") int id) throws ParseException {
		Student stu1 = new Student();
		stu1.setId(1);
		stu1.setName("老楊");
		stu1.setAge(18);
		stu1.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-12"));
		Student stu2 = new Student();
		stu2.setId(2);
		stu2.setName("老李");
		stu2.setAge(28);
		stu2.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-12"));
		Student stu3 = new Student();
		stu3.setId(3);
		stu3.setName("老王");
		stu3.setAge(38);
		stu3.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-12"));
		Student stu = null;
		switch(id) {
		case 1: stu = stu1;break;
		case 2: stu = stu2;break;
		case 3: stu = stu3;break;
		}
		
		return stu;
	}
}

