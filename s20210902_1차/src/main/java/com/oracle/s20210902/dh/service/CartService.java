package com.oracle.s20210902.dh.service;

import java.util.List;

import com.oracle.s20210902.model.Cart;
import com.oracle.s20210902.model.Order1;

public interface CartService {

	int insert(Cart cart);

	int total(Cart cart);

	List<Order1> listCart(Cart cart);

	int delete(Cart cart);


}
