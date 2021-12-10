package com.oracle.s20210902.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	@RequestMapping(value = "home")
	public String home(Model model) {
		System.out.println("CommonController home Start...");
		return "home";
	}
}
