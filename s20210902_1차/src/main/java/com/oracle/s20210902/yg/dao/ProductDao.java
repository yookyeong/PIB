package com.oracle.s20210902.yg.dao;

import java.util.List;

import com.oracle.s20210902.model.Common;
import com.oracle.s20210902.model.Product;

public interface ProductDao {

	int total(Product product); //조회용 total
	List<Product> tableProduct(Product product); //table
	
	Product productContent(Product product);
	
	List<Product> listManager();
	
	int productInsert(Product product);
	
	int productUpdate(Product product);
	
	int productDelete(Product product);
	
	List<Common> cateProductList();
	List<Common> cateProductList2();
	
	

}
