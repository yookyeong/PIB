package com.oracle.s20210902.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210902.common.service.CommonService;
import com.oracle.s20210902.common.service.CommonServiceJpa;
import com.oracle.s20210902.model.Product;

@Controller
public class CommonController {
	@Autowired
	private CommonService cs;
	@Autowired
	private CommonServiceJpa cj;
	
	@RequestMapping(value = "home")
	public String home(Model model) {
		System.out.println("CommonController home Start...");
		List<com.oracle.s20210902.common.domain.Product> product = cj.productListHit();
		List<Product> productList = cs.productListHit();
		List<Product> productList2 = cs.productListNew();
		model.addAttribute("productList", productList);
		model.addAttribute("productList2", productList2);
		System.out.println("CommonController home productList.size()-->"+productList.size());
		return "home";
	}
	
	@RequestMapping(value = "loginMessage")
	public String loginMessage(Model model){
		return "cr/loginMessage";
	}
	
	@RequestMapping(value = "myPageForm")
	public String myPageForm(Model model){
		return "cr/myPageForm";
	}
	
	@RequestMapping(value = "adminPageForm")
	public String adminPageForm(Model model){
		return "cr/adminPageForm";
	}
}
