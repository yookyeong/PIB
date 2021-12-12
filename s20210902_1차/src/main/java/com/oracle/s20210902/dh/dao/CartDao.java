package com.oracle.s20210902.dh.dao;

import java.util.List;

import com.oracle.s20210902.model.Cart;
import com.oracle.s20210902.model.Order1;

public interface CartDao {

	int insert(Cart cart);

	int select(Cart cart);

	List<Order1> listCart(Cart cart);

	int delete(Cart cart);



	
	
	
}
