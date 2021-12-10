package com.oracle.s20210902.dh.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.s20210902.dh.service.Order1Service;
import com.oracle.s20210902.model.Member;

@RestController
public class Order1ControllerAjax {
	
private static final Logger logger = LoggerFactory.getLogger(Order1ControllerAjax.class);
	
	@Autowired
	private Order1Service os;
	
	@RequestMapping(value = "getMemberInfo")
	public Member getMemberInfo(String mem_id) {
		System.out.println("Order1ControllerAjax getMemberInfo() start...");
		Member member = os.selectMem(mem_id);
		return member;
	}
	
	

}
