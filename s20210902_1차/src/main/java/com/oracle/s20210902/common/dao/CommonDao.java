package com.oracle.s20210902.common.dao;

import java.util.List;

import com.oracle.s20210902.model.Product;

public interface CommonDao {

	List<Product> productListHit();

	List<Product> productListNew();

}
