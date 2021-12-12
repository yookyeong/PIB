package com.oracle.s20210902.kn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oracle.s20210902.model.LatestProduct;


public interface LatestProductService {
	
	int repSearchListTotal(String keyword);

	List<LatestProduct> listProSearch(LatestProduct latestProduct);
	
	int repListTotal(LatestProduct latestProduct);

	List<LatestProduct> listLatestProduct(LatestProduct latestProduct);

	int deleteLatestProduct(int p_code);

	int updateLatestProduct(LatestProduct latestProduct);

	int selectLatestProduct(LatestProduct latestProduct);

	int insertLatestProduct(LatestProduct latestProduct);





}
