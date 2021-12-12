package com.oracle.s20210902.dh.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.s20210902.dh.service.Order1Paging;
import com.oracle.s20210902.dh.service.Order1Service;
import com.oracle.s20210902.model.Member;
import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.Product;

import lombok.val;

@Controller
public class Order1Controller {

	private static final Logger logger = LoggerFactory.getLogger(Order1Controller.class);
	
	@Autowired
	private Order1Service os;
	
	// 지민님 페이지 
	@RequestMapping(value = "order1Write")
	public String orderWrite() {
		System.out.println("Order1Controller OrderWrite() start...");
		return "dh/order1Write";
	}
	
	
	// 장바구니 이후에 주문을 위한 주문서 작성 페이지 이후 데이터 넘어옴	
	@RequestMapping(value = "order1Insert", method=RequestMethod.POST)
	public String order1Insert (Model model, Order1 order1, HttpServletRequest request) {
		System.out.println("Order1Controller Order1List() start...");
		String mem_id = (String) request.getSession().getAttribute("mem_id");
		order1.setMem_id(mem_id);
		
		int result = os.insert(order1, request);
		System.out.println("order1Insert result!!!! -> " + result);
		
		model.addAttribute("result" , result);
		
		return "dh/order1ListPro";
	}
	
	// 테이블 조인 이후 list값으로 담아오고 화면에 뿌려줌
	// 회원으로 로그인 했을 때, 내가 주문한 상품들 리스트
	@RequestMapping(value = "order1List")
	public String order1List(Model model, String currentPage, Order1 order1, HttpServletRequest request) {
		System.out.println("Order1Controller Order1List() start...");
		String mem_id = (String) request.getSession().getAttribute("mem_id");
		order1.setMem_id(mem_id);
		
		int total = os.total(order1);								// DB에 전체 데이터 개수
		System.out.println("Order1Controller total->"+total);
		System.out.println("Order1Controller currentPage->"+currentPage);
		
		Order1Paging pg = new Order1Paging(total, currentPage);		// 총 데이터 개수, 현재페이지를 가져감
		System.out.println("Order1Controller pg->"+pg);
		order1.setStart(pg.getStart());								// DB상에서 시작 rn값
		order1.setEnd(pg.getEnd());									// DB상에서 끝 rn값
		
		
		int result = os.remove(order1);
		List<Order1> order1List = os.listOrder(order1);				// Order1 테이블의 값들을 list에 담아서 가져옴
		System.out.println("Order1Controller order1List ->"+order1List);
		
		model.addAttribute("total", total);
		model.addAttribute("order1List", order1List);
		model.addAttribute("pg", pg);
		return "dh/order1List";
	}
	// 회원으로 로그인 했을 때, 주문한 상품에 대한 주문취소 (완료)
	@RequestMapping(value = "order1Cancel")
	public String order1Cancel(Model model, Order1 order1) {
		System.out.println("Order1Controller Order1Cancel() start...");
		int result = os.update(order1);
		model.addAttribute("result", result);
		return "dh/order1Cancel";
	}
	
	// 주문상태에 따른 결과값
	@RequestMapping(value = "order1ListCategory")
	public String order1ListCategory(Order1 order1, String currentPage, Model model, String o_cancel, HttpServletRequest request) {
		System.out.println("Order1Controller order1ListCategory() start...");
		String mem_id = (String) request.getSession().getAttribute("mem_id");
		order1.setMem_id(mem_id);
		int o_cancel1 = Integer.parseInt(o_cancel);
		order1.setO_cancel(o_cancel1);
		
		int total = os.totalCategory(order1);
		
		Order1Paging pg = new Order1Paging(total, currentPage);	
		order1.setStart(pg.getStart());							
		order1.setEnd(pg.getEnd());	
		List<Order1> order1Category = os.order1ListCategory(order1);
		model.addAttribute("total", total);
		model.addAttribute("order1Category", order1Category);
		model.addAttribute("pg", pg);
		return "dh/order1ListCategory";
	}
	
	// 등록일 가장 오래된 순
	@RequestMapping(value = "order1Date")
	public String order1Date (Model model, String currentPage, Order1 order1, HttpServletRequest request) {
		System.out.println("Order1Controller Order1List() start...");
		String mem_id = (String) request.getSession().getAttribute("mem_id");
		order1.setMem_id(mem_id);
		
		int total = os.total(order1);									// DB에 전체 데이터 개수
		System.out.println("Order1Controller total->"+total);
		System.out.println("Order1Controller currentPage->"+currentPage);
		
		Order1Paging pg = new Order1Paging(total, currentPage);			// 총 데이터 개수, 현재페이지 가져옴
		System.out.println("Order1Controller pg->"+pg);
		order1.setStart(pg.getStart());									// DB상에서 시작 rn값
		order1.setEnd(pg.getEnd());										// DB상에서 끝 rn값
		
		List<Order1> order1ListDate = os.listOrderDate(order1);			// Order1 테이블의 값들을 list에 담아서 가져옴
		System.out.println("Order1Controller order1List ->"+order1ListDate);
		
		model.addAttribute("total", total);
		model.addAttribute("order1ListDate", order1ListDate);
		model.addAttribute("pg", pg);
		
		return "dh/order1Date"; 
	}
	
	
	
}
