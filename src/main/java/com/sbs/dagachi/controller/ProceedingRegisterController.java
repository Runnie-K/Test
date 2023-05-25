package com.sbs.dagachi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProceedingRegisterController {
	@RequestMapping("/usr/proceeding/regist")
	
	public String Proceeding_regist() {
		return "/usr/proceeding/regist";
	}
	

}