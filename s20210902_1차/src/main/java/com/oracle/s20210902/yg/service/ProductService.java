package com.oracle.s20210902.yg.service;

import java.util.List;

import com.oracle.s20210902.model.Common;
import com.oracle.s20210902.model.Product;

public interface ProductService {

	

	int total(Product product);

	List<Product> tableproduct(Product product);
	Product productContent(Product product);

	List<Product> listManager();

	int productUpdate(Product product);

	int productInsert(Product product);

	int productDelete(Product product);

	List<Common> cateProductList();

	List<Common> cateProductList2();

	

	

	

}
