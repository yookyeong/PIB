package com.oracle.s20210902.kn.dao;

import java.util.List;

import com.oracle.s20210902.model.LatestProduct;


public interface LatestProductDao {
	
	int repSearchListTotal(String keyword);
	
	List<LatestProduct>listProSearch(LatestProduct latestProduct);

	int repListTotal(LatestProduct latestProduct);

	List<LatestProduct> listLatestProduct(LatestProduct latestProduct);

	int deleteLatestProduct(int p_code);

	int updateLatestProduct(LatestProduct latestProduct);

	int insertLatestProduct(LatestProduct latestProduct);

	int selectLatestProduct(LatestProduct latestProduct);

	
	


	
}
