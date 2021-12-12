package com.oracle.s20210902.dh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Cart;
import com.oracle.s20210902.model.Order1;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public int insert(Cart cart) {
		int result = 0;
		try {
			result = session.insert("dhInsertCart", cart);
		} catch (Exception e) {
			System.out.println("CartDaoImpl->" + e.getMessage());
		}
		return result;
	}

	@Override
	public int select(Cart cart) {
		int total = 0;
		try {
			total = session.selectOne("dhSelectCart", cart);
		} catch (Exception e) {
			System.out.println("CartDaoImpl->" + e.getMessage());
		}
		return total;
	}

	@Override
	public List<Order1> listCart(Cart cart) {
		 List<Order1> cartList = null;
		try {
			cartList = session.selectList("dhListCart", cart);
		} catch (Exception e) {
			System.out.println("CartDaoImpl->" + e.getMessage());
		}
		return cartList;
	}

	@Override
	public int delete(Cart cart) {
		int result = 0;
		try {
			result = session.delete("dhDeleteCart", cart);
		} catch (Exception e) {
			System.out.println("CartDaoImpl->" + e.getMessage());
		}
		return result;
	}


	
	
}
