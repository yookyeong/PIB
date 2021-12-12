package com.oracle.s20210902.dh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.dh.dao.Order1Dao;
import com.oracle.s20210902.model.Member;
import com.oracle.s20210902.model.Order1;

@Service
public class Order1ServiceImpl implements Order1Service {

	@Autowired
	private Order1Dao od;

// 일반회원
	
	// 장바구니 -> 주문서작성한 이후 데이터값 insert
	@Override
	public int insert(Order1 order1, HttpServletRequest request) {
		System.out.println("Order1ServiceImpl insert() start");
		int result = 0;
		// 반복값
		String [] p_code = request.getParameterValues("p_code");
		System.out.println("p_code.length ->>>>>>>>" + p_code.length);
		String [] p_size = request.getParameterValues("p_size");
		String [] c_qty = request.getParameterValues("c_qty");
		// 주소
		String text1 = request.getParameter("text1");
		String text2 = request.getParameter("text2");
		String text3 = request.getParameter("text3");
		String text4 = request.getParameter("text4");
		String o_address = text1+""+text2+""+text3+""+text4;
			
		// 단일
		String o_accept = request.getParameter("o_accept");
		String o_tel = request.getParameter("o_tel");
			
		 for(int i=0; i<p_code.length; i++){
			 order1.setP_code(Integer.parseInt(p_code[i]));
			 System.out.println("order1.getP_code"+order1.getP_code());
			 
			 order1.setP_size(Integer.parseInt(p_size[i]));
			 order1.setC_qty(Integer.parseInt(c_qty[i]));
			 
			 order1.setO_accept(o_accept);
			 System.out.println("order1.getO_accept()"+order1.getO_accept());
			 
			 order1.setO_address(o_address);
			 System.out.println("order1.getO_address()"+order1.getO_address());
			 
			 order1.setO_tel(o_tel);
				 
			 result = od.insert(order1, request, i);
			System.out.println("Order1ServiceImpl insert After order1.getO_num()->"+order1.getO_num());
		 }
		return result;
	}
	
	// 전체페이지 카운트(mem_id값을 비교해서 일반회원 또는 관리자 페이지, 관리자 페이지C 에 필요한 Cnt를 리턴 )
	@Override
	public int total(Order1 order1) {
		System.out.println("Order1ServiceImpl total() start...");
		System.out.println("Order1ServiceImpl  total() getO_cancel -> " + order1.getO_cancel());
		int totCnt = 0;
		
		if(order1.getMem_id().equals("admin")) {
			totCnt = od.selectM(order1);
		} else {
			totCnt = od.select(order1);
		}
		return totCnt;
	}
	
	// List(mem_id값을 비교해서 일반회원 또는 관리자 페이지에 필요한 list를 리턴)
	@Override
	public List<Order1> listOrder(Order1 order1) {
		System.out.println("Order1ServiceImpl listOrder() start");
		List<Order1> order1List = null;
		
		if(order1.getMem_id().equals("admin")) {
			order1List = od.listOrderManager(order1);
		} else {
			order1List = od.listOrder(order1);
		}
		return order1List;
	}
	
	// 회원 로그인 시, list에서 주문취소
	@Override
	public int update(Order1 order1) {
		System.out.println("Order1ServiceImpl update() start");
		int result = od.update(order1);
		return result;
	}
	
	// 주문상태에 따른 값 카테고리 cnt
	@Override
	public int totalCategory(Order1 order1) {
		System.out.println("Order1ServiceImpl totalCategory() start...");
		int totCnt = od.totalCategory(order1);
		System.out.println("Order1ServiceImpl totCnt->"+totCnt);
		return totCnt;
	}
	
	// 일반회원 로그인, 주문상태에 따른 값 List
		@Override
		public List<Order1> order1ListCategory(Order1 order1) {
			System.out.println("Order1ServiceImpl order1ListCategory() start...");
			List<Order1> order1Category = od.order1ListCategory(order1);
			System.out.println("Order1ServiceImpl order1Category->"+order1Category);
			return order1Category;
		}

		// 일반회원 주문날짜 정렬
		@Override
		public List<Order1> listOrderDate(Order1 order1) {
			System.out.println("Order1ServiceImpl listOrder() start");
			List<Order1> order1ListDate = od.listOrderDate(order1);
			return order1ListDate;
		}

// 관리자	
	
	// 주문확정처리
	// 주문확정처리와 동시에 Product에 있는 상품 재고 -qty처리
	@Override
	public int updateManager(Order1 order1) {
		System.out.println("Order1ServiceImpl updateManager() start");
		int result = od.updateManager(order1);		
		return result;
	}

// 관리자C
	
	// 관리자C에서 주문번호로 검색
	@Override
	public List<Order1> listOrderManagerCSearch(Order1 order1) {
		System.out.println("Order1ServiceImpl listOrderManagerSearch() start");
		List<Order1> order1ListManagerSearch = od.listOrderManagerCSearch(order1);	
		return order1ListManagerSearch;
	}
	
	// ManagerC의 주문번호검색 cnt
	@Override
	public int totalQ(Order1 order1) {
		System.out.println("Order1ServiceImpl total() start...");
		int totCnt = od.selectQ(order1);
		System.out.println("Order1ServiceImpl totCnt->"+totCnt);
		return totCnt;
	}
	
	// ManagerC의 날짜순 정렬
	@Override
	public List<Order1> listOrderManagerCDate(Order1 order1) {
		System.out.println("Order1ServiceImpl listOrderManagerCDate() start");
		List<Order1> order1DateManagerC = od.listOrderManagerCDate(order1);
		return order1DateManagerC;
	}

	@Override
	public int totalC(Order1 order1) {
		System.out.println("Order1ServiceImpl totalC() start");
		int totCnt = od.selectC(order1);
		return totCnt;
	}

	@Override
	public List<Order1> listOrderManagerC(Order1 order1) {
		System.out.println("Order1ServiceImpl listOrderManagerC() start");
		List<Order1> order1ListManagerC = od.listOrderManagerC(order1);
		return order1ListManagerC;
	}

	@Override
	public Member selectMem(String mem_id) {
		System.out.println("Order1ServiceImpl selectMem() start");
		Member member = od.selectMem(mem_id);
		return member;
	}

	@Override
	public int remove(Order1 order1) {
		System.out.println("Order1ServiceImpl remove() start...");
		int result = od.remove(order1);
		System.out.println("Order1ServiceImpl result->"+result);
		return result;
	}
}
