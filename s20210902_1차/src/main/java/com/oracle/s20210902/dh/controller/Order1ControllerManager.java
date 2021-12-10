package com.oracle.s20210902.dh.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210902.dh.service.Order1Paging;
import com.oracle.s20210902.dh.service.Order1Service;
import com.oracle.s20210902.model.Order1;

@Controller
public class Order1ControllerManager {

private static final Logger logger = LoggerFactory.getLogger(Order1Controller.class);
	
	@Autowired
	private Order1Service os;
	
	// 관리자 계정 로그인 시 나오게 되는 주문 list
	@RequestMapping(value = "order1ListManager")
	public String order1ListManager(Model model, String currentPage, Order1 order1) {
		System.out.println("Order1Controller Order1ListManager() start...");
		
		// 임시세션아이디
		order1.setMem_id("admin");
		
		int total = os.total(order1);
		Order1Paging pg = new Order1Paging(total, currentPage);			// 총 데이터 개수, 현재페이지 가져옴
		System.out.println("Order1Controller pg->"+pg);
		order1.setStart(pg.getStart());									// DB상에서 시작 rn값
		order1.setEnd(pg.getEnd());										// DB상에서 끝 rn값
		
		List<Order1> listOrderManager = os.listOrder(order1);			// Order1 테이블의 값들을 list에 담아서 가져옴
		System.out.println("Order1Controller order1ListManager ->"+listOrderManager);
		
		model.addAttribute("total", total);
		model.addAttribute("listOrderManager", listOrderManager);
		model.addAttribute("pg", pg);
		
		return "dh/order1ListManager";
	}
	
	// 관리자 계정으로 로그인 시, 주문확정처리, 확정처리되면 재고 수량처리
	@RequestMapping(value = "order1CancelManager")
	public String order1Cancel(Model model, Order1 order1) {
		System.out.println("Order1Controller Order1Cancel() start...");
		
		int result = os.updateManager(order1);
		
		model.addAttribute("result", result);
		return "dh/order1CancelManager";
	}
	

	// 관리자 계정으로 로그인 시, 확정처리된 주문을 보여주는 list
	@RequestMapping(value = "order1ListManagerC")
	public String order1ListManagerC (Model model, String currentPage, Order1 order1) {
		System.out.println("Order1Controller Order1ListManagerC() start...");
		// 임시세션아이디
		order1.setMem_id("admin");
		
		int total = os.totalC(order1);
		System.out.println("order1ListManagerC total -> " + total);
		Order1Paging pg = new Order1Paging(total, currentPage);			// 총 데이터 개수, 현재페이지 가져옴
		System.out.println("Order1Controller pg->"+pg);
		order1.setStart(pg.getStart());									// DB상에서 시작 rn값
		order1.setEnd(pg.getEnd());										// DB상에서 끝 rn값
		
		List<Order1> order1ListManagerC = os.listOrderManagerC(order1);			// Order1 테이블의 값들을 list에 담아서 가져옴
		System.out.println("Order1Controller Order1ListManagerC ->"+order1ListManagerC);
		
		model.addAttribute("total", total);
		model.addAttribute("order1ListManagerC", order1ListManagerC);
		model.addAttribute("pg", pg);
		
		return "dh/order1ListManagerC";
	}
	
	// order1ListManagerC 에서 주문번호로 검색하는 기능
	@RequestMapping(value = "order1Search")
	public String order1Search(Model model, String currentPage, Order1 order1) {
		System.out.println("Order1Controller Order1ListManagerC() start...");
		int total = os.totalQ(order1);
		Order1Paging pg = new Order1Paging(total, currentPage);		// 총 데이터 개수, 현재페이지 가져옴
		System.out.println("pg.endPage -> " + pg.getEndPage());
		System.out.println("Order1Controller pg->"+pg);
		order1.setStart(pg.getStart());								// DB상에서 시작 rn값
		order1.setEnd(pg.getEnd());									// DB상에서 끝 rn값
		String q1 = order1.getQ();
		System.out.println("q1 ->" + q1);
		
		List<Order1> order1ListManagerCSearch = os.listOrderManagerCSearch(order1);	
		
		model.addAttribute("total", total);
		model.addAttribute("order1ListManagerCSearch", order1ListManagerCSearch);
		model.addAttribute("pg", pg);
		model.addAttribute("q1", q1);
		
		return "dh/order1Search";
	}
	
	//  order1ListManagerC 에서 늦은 주문순으로 정렬
	@RequestMapping(value = "order1DateManagerC")
	public String order1DateManagerC(Model model, String currentPage, Order1 order1) {
		System.out.println("Order1Controller order1DateManagerC() start...");
		// 임시세션아이디
		order1.setMem_id("admin");
		order1.setO_cancel(1);
		int total = os.total(order1);
		Order1Paging pg = new Order1Paging(total, currentPage);		// 총 데이터 개수, 현재페이지 가져옴
		System.out.println("Order1Controller pg->"+pg);
		order1.setStart(pg.getStart());								// DB상에서 시작 rn값
		order1.setEnd(pg.getEnd());									// DB상에서 끝 rn값
		
		List<Order1> order1DateManagerC = os.listOrderManagerCDate(order1);				// Order1 테이블의 값들을 list에 담아서 가져옴
		System.out.println("Order1Controller Order1ListManagerC ->"+order1DateManagerC);
		
		
		model.addAttribute("total", total);
		model.addAttribute("order1DateManagerC", order1DateManagerC);
		model.addAttribute("pg", pg);
		
		return "dh/order1DateManagerC";
	}
	
}
