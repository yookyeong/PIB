package com.oracle.s20210902.kn.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.kn.dao.LatestProductDao;
import com.oracle.s20210902.model.LatestProduct;

@Service
public class LatestProductServiceImpl implements LatestProductService {
	@Autowired
	private	LatestProductDao ld;

	// 전체페이지 카운트
	@Override
	public int total() {
		System.out.println("LatestProductServiceImpl Start total...");
		int totCnt = ld.total();
		System.out.println("LatestProductServiceImpl total totCnt=>" + totCnt);
		return totCnt;
	}

	
	// keyword, 각 상품 대표 코드 (p_size : 120)값을 비교해서  검색 페이지에 필요한 Cnt를 리턴
	@Override
	public int repSearchListTotal(String keyword) {
		System.out.println("LatestProductServiceImpl repSearchListTotal total...");
		int totCnt = ld.repSearchListTotal(keyword);
		System.out.println("LatestProductServiceImpl repSearchListTotal totCnt=>" + totCnt);
		return totCnt;
	}
	
	
	// keyword 검색 값 list를 return
	@Override
	public List<LatestProduct> listProSearch(LatestProduct latestProduct) {
		List<LatestProduct> proSearch = null;
		System.out.println("LatestProductServiceImpl listProSearch Start...");
		System.out.println("LatestProductServiceImpl keyword=>" + latestProduct.getKeyword());
		proSearch = ld.listProSearch(latestProduct);
		System.out.println("LatestProductServiceImpl listProSearch proSearch.size()=>" + proSearch.size());
		return proSearch;
	}


	@Override
	public int repListTotal(LatestProduct latestProduct) {
		System.out.println("LatestProductServiceImpl repSearchListTotal total...");
		int totCnt = ld.repListTotal(latestProduct);
		System.out.println("LatestProductServiceImpl repSearchListTotal totCnt=>" + totCnt);
		return totCnt;
	}


	@Override
	public List<LatestProduct> listLatestProduct(LatestProduct latestProduct) {
		List<LatestProduct> latestProductList = null;
		System.out.println("LatestProductServiceImpl listProSearch Start...");
		latestProductList = ld.listLatestProduct(latestProduct);
		System.out.println("LatestProductServiceImpl listLatestProduct proSearch.size()=>" + latestProductList.size());
		return latestProductList;
	}


}
