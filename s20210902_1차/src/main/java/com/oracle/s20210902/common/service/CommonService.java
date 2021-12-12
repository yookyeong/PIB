package com.oracle.s20210902.common.service;

import java.util.List;

import com.oracle.s20210902.model.Product;

//import com.oracle.s20210902.common.domain.Product;

public interface CommonService {

	List<Product> productListHit();

	List<Product> productListNew();

}
