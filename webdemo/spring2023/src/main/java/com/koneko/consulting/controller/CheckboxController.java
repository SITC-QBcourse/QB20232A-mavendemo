package com.koneko.consulting.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koneko.consulting.vo.Person;

@Controller
public class CheckboxController {
	@RequestMapping("testcheckbox1.do")
	public String testCheckbox(Map<String,Person> map) {
		Person per = new Person();
		per.setGender(false);
		map.put("person", per);
		return "jsp/form/checkbox";
	}
	@RequestMapping("testcheckbox.do")
	public String testCheckboxArray(Map<String,Object> map) {
		Person per = new Person();
		//这是从数据库提取到的兴趣的集合
		List<String> insts = Arrays.asList("足球","篮球","大保健");
		per.setInsts(insts);
		//在前台显示出来的兴趣的集合
		List<String> infos = Arrays.asList("足球","篮球","乒乓球");
		map.put("person", per);
		map.put("balls", infos);
		return "jsp/form/checkbox";
	}
}
