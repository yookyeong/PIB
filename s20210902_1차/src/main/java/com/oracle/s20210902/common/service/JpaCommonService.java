package com.oracle.s20210902.common.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.common.domain.Product;
import com.oracle.s20210902.common.repository.CommonRepository;

@Transactional
@Service
public class JpaCommonService implements CommonServiceJpa {

	@Autowired
	private CommonRepository cr;
	
	@Override
	public List<Product> productListHit() {
		System.out.println("JpaCommonService productListHit Start...");
		List<Product> productList = cr.productListHit();
		
		return productList;
	}

}
