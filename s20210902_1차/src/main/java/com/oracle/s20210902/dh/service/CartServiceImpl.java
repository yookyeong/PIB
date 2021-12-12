package com.oracle.s20210902.dh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.dh.dao.CartDao;
import com.oracle.s20210902.model.Cart;
import com.oracle.s20210902.model.Order1;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cd;

	@Override
	public int insert(Cart cart) {
		System.out.println("CartServiceImpl insert start");
		int result = cd.insert(cart);
		return result;
	}

	@Override
	public int total(Cart cart) {
		System.out.println("CartServiceImpl total start");
		int total = cd.select(cart);
		return total;
	}

	@Override
	public List<Order1> listCart(Cart cart) {
		System.out.println("CartServiceImpl total start");
		List<Order1> cartList = cd.listCart(cart);
		return cartList;
	}

	@Override
	public int delete(Cart cart) {
		System.out.println("CartServiceImpl delete start");
		int result = cd.delete(cart);
		return result;
	}


	
}
