package com.oracle.s20210902.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Product;

@Repository
public class CommonDaoImpl implements CommonDao {
	@Autowired
	private SqlSession session;
	
	public List<Product> productListHit() {
		System.out.println("CommonDaoImpl productListHit Start...");
		List<Product> productList = session.selectList("coProductListHit");
		return productList;
	}

	@Override
	public List<Product> productListNew() {
		System.out.println("CommonDaoImpl productListNew Start...");
		List<Product> productList2 = session.selectList("coProductListNew");
		return productList2;
	}
	
}
