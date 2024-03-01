package com.koneko.consulting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koneko.consulting.vo.Person;

@Controller
public class PersonController {
	@RequestMapping("testform.do")
	public String testForm1(Model model) {
		Person per = new Person();
		model.addAttribute("person",per);
		return "jsp/form/form1";
	}
	
	@RequestMapping(value="testForm", method=RequestMethod.POST)
	public String testForm2a() {
		System.out.println("post");
		return "jsp/form/form2";
	}
	@RequestMapping(value="testForm", method=RequestMethod.GET)
	public String testForm2b() {
		System.out.println("get");
		return "jsp/form/form2";
	}
	@RequestMapping(value="testForm", method=RequestMethod.DELETE)
	public String testForm2c() {
		System.out.println("delete");
		return "jsp/form/form2";
	}
	@RequestMapping(value="testForm", method=RequestMethod.PUT)
	public String testForm2d() {
		System.out.println("put");
		return "jsp/form/form2";
	}
}
