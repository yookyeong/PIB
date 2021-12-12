package com.oracle.s20210902.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.common.dao.CommonDao;
import com.oracle.s20210902.model.Product;
@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private CommonDao cd;
	
	@Override
	public List<Product> productListHit() {
		System.out.println("JpaCommonService productListHit Start...");
		List<Product> productList = cd.productListHit();
		
		return productList;
	}

	@Override
	public List<Product> productListNew() {
		System.out.println("JpaCommonService productListNew Start...");
		List<Product> productList2 = cd.productListNew();
		
		return productList2;
	}

}
