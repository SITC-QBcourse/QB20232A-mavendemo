package com.koneko.consulting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
	
	@RequestMapping("forward.do")
	public String forward() {
		return "forward:/view/a/a.jsp";
	}
	@RequestMapping("redirect.do")
	public String redirect() {
		return "redirect:/view/a/b.jsp";
	}
}
