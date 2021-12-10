package com.oracle.s20210902.dh.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oracle.s20210902.model.Member;
import com.oracle.s20210902.model.Order1;

public interface Order1Dao {

	int insert(Order1 order1, HttpServletRequest request, int i);
	
	int select(Order1 order1);

	List<Order1> listOrder(Order1 order1);

	int update(Order1 order1);

	List<Order1> listOrderManager(Order1 order1);

	int updateManager(Order1 order1);

	List<Order1> listOrderManagerC(Order1 order1);

	List<Order1> listOrderManagerCSearch(Order1 order1);

	int updateManagerQty(Order1 order1);

	int selectM(Order1 order1);

	int selectC(Order1 order1);

	int selectQ(Order1 order1);

	int totalCategory(Order1 order1);

	List<Order1> order1ListCategory(Order1 order1);

	Member memberInfo(String mem_name);

	List<Order1> listOrderDate(Order1 order1);

	List<Order1> listOrderManagerCDate(Order1 order1);

	Member selectMem(String mem_id);



	
	
}
