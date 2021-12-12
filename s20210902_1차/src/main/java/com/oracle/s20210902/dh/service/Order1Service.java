package com.oracle.s20210902.dh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oracle.s20210902.model.Member;
import com.oracle.s20210902.model.Order1;

public interface Order1Service {
	
	// 일반 회원
	int insert(Order1 order1, HttpServletRequest request);
	
	int total(Order1 order1);
	List<Order1> listOrder(Order1 order1);
	
	int update(Order1 order1);
	
	int totalCategory(Order1 order1);
	
	List<Order1> order1ListCategory(Order1 order1);
	
	List<Order1> listOrderDate(Order1 order1);
	
	int remove(Order1 order1);
	
	
	// 관리자	
	int updateManager(Order1 order1);
	
	// 관리자C
	int totalC(Order1 order1);
	List<Order1> listOrderManagerC(Order1 order1);
	
	int totalQ(Order1 order1);
	List<Order1> listOrderManagerCSearch(Order1 order1);

	List<Order1> listOrderManagerCDate(Order1 order1);

	
	// 회원 아작스
	Member selectMem(String mem_id);




	
	










	
	
}
