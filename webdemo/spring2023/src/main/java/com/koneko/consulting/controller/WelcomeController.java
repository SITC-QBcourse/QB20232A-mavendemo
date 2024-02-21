package com.koneko.consulting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.koneko.consulting.vo.Student;

@Controller
@SessionAttributes(types={Student.class})
public class WelcomeController {

	@RequestMapping(value="testStudent.do",method=RequestMethod.POST)
	public String testStudent(Student stu,BindingResult result,Model model) {
		if(result.getErrorCount() > 0) {
			model.addAttribute("errorMessage", "日期格式错误，格式例：2000-01-01");
			return "forward:/view/index.jsp";
		}else {
			return "welcome";
		}
	}
}

