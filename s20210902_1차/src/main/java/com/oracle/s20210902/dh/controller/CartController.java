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
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.s20210902.dh.service.CartService;
import com.oracle.s20210902.dh.service.Order1Paging;
import com.oracle.s20210902.model.Cart;
import com.oracle.s20210902.model.Order1;

@Controller
public class CartController {

private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private CartService cs;
	
	/*
	 * // 보훈님 페이지
	 * 
	 * @RequestMapping(value = "cartDummy") public String cartDummy () { return
	 * "dh/cartDummy"; }
	 */
	
	// 카트에 데이터 삽입
	@RequestMapping(value = "cartInsert", method=RequestMethod.POST)
	public String cartInsert(Model model, Cart cart, HttpServletRequest request) {
		System.out.println("CartController CartInsert start");
		String mem_id = (String) request.getSession().getAttribute("mem_id");
		cart.setMem_id(mem_id);
		System.out.println("CartController CartInsert cart.getMem_id-->"+cart.getMem_id());
		System.out.println("CartController CartInsert cart.getP_code-->"+cart.getP_code());
		System.out.println("CartController CartInsert cart.getP_size-->"+cart.getP_size());
		int result = cs.insert(cart);
		model.addAttribute("result",result);
		model.addAttribute("p_code", cart.getP_code()); 
//		String result2 = result+"";
//		return result2;
		return "dh/cartInsertPro";
	}
	
	@RequestMapping(value = "cartList")
	public String cartList(Model model, String currentPage, Cart cart, HttpServletRequest request) {
		System.out.println("CartController cartList() start...");
		String mem_id = (String) request.getSession().getAttribute("mem_id");
		cart.setMem_id(mem_id);
		
		int total = cs.total(cart);								// DB에 전체 데이터 개수
		System.out.println("CartController total->"+total);
		System.out.println("CartController currentPage->"+currentPage);
		
		Order1Paging pg = new Order1Paging(total, currentPage);		// 총 데이터 개수, 현재페이지를 가져감
		System.out.println("CartController pg->"+pg);
		cart.setStart(pg.getStart());								// DB상에서 시작 rn값
		cart.setEnd(pg.getEnd());									// DB상에서 끝 rn값
		
		List<Order1> cartList = cs.listCart(cart);				// Order1 테이블의 값들을 list에 담아서 가져옴
		System.out.println("CartController cartList ->"+cartList);
		
		model.addAttribute("total", total);
		model.addAttribute("cartList", cartList);
		model.addAttribute("pg", pg);
		
		return "dh/order1Write";
	}
	
	@RequestMapping(value = "cartDelete")
	public String cartDelete (Cart cart, Model model, HttpServletRequest request) {
		System.out.println("CartController cartDelete start");
		String mem_id = (String) request.getSession().getAttribute("mem_id");
		cart.setMem_id(mem_id);
		int result = cs.delete(cart);
	
		model.addAttribute("result", result);
		
		return "dh/cartDeletePro";
	}
	
	
	
	
}
