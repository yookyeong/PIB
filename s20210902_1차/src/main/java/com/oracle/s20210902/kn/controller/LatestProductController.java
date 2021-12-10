package com.oracle.s20210902.kn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.s20210902.common.service.Paging;
import com.oracle.s20210902.dh.service.Order1Paging;
import com.oracle.s20210902.kn.service.LatestProductPaging;
import com.oracle.s20210902.kn.service.LatestProductService;
import com.oracle.s20210902.model.LatestProduct;
import com.oracle.s20210902.model.Order1;


@Controller
public class LatestProductController {
	private static final Logger logger = LoggerFactory.getLogger(LatestProductController.class);
	@Autowired
	private LatestProductService ls;
	
	
	// keyword 검색 결과 값을 list 값으로 담아 오고 화면에 뿌려줌
	@RequestMapping(value = "proSearch")
	public String proSearch(LatestProduct latestProduct, String currentPage, Model model)	{
		System.out.println("LatestProductController Start list...");
	    String keyword = "%";
		if (latestProduct.getKeyword() == null)  {
			keyword = "%";
		} else {
			keyword = latestProduct.getKeyword();
		}
		int total = ls.repSearchListTotal(keyword);   // 각 상품의 대표 코드 값  총 갯수 18
		System.out.println("LatestProductController keyword=>" + keyword);
		System.out.println("LatestProductController total=>" + total);
		// Paging
		Paging pg = new Paging(total, currentPage);
		System.out.println("LatestProductController getStart=>" + pg.getStart());
		System.out.println("LatestProductController getEnd=>" + pg.getEnd());
		latestProduct.setStart(pg.getStart());		// 1
		latestProduct.setEnd(pg.getEnd());			// 6
		latestProduct.setKeyword(keyword);
		List<LatestProduct> listProSearch = ls.listProSearch(latestProduct);
		
		System.out.println("LatestProductController proSearch.size=>" + listProSearch.size());
		for(LatestProduct listProSearchDate : listProSearch) {
			System.out.println("listProSearchDate.getP_img=>" + listProSearchDate.getP_img());
			System.out.println("listProSearchDate.getP_name=>" + listProSearchDate.getP_name());
			System.out.println("listProSearchDate.getP_price=>" + listProSearchDate.getP_price());
		}
		model.addAttribute("total", total);
		model.addAttribute("listProSearch", listProSearch);
		model.addAttribute("pg", pg);
		
		return "kn/proSearch";
	}
	
	@RequestMapping(value = "latestProductList")
	public String latestProductList(LatestProduct latestProduct, String currentPage, Model model)	{
		System.out.println("LatestProductController Start list...");

		// 임시 세션 아이디
		latestProduct.setMem_id("aaaa");
		
		int total = ls.repListTotal(latestProduct);		// 각 상품의 대표 코드 값 총 갯수 18
		System.out.println("LatestProductController currentPage=>" + currentPage);
		System.out.println("LatestProductController total=>" + total);
		// Paging
		LatestProductPaging lp = new LatestProductPaging(total, currentPage);
		System.out.println("LatestProductController getStart=>" + lp.getStart());
		System.out.println("LatestProductController getEnd=>" + lp.getEnd());
		latestProduct.setStart(lp.getStart());			// 1
		latestProduct.setEnd(lp.getEnd());				// 3
		
		List<LatestProduct> latestProductList = ls.listLatestProduct(latestProduct);
		System.out.println("LatestProductController proSearch.size=>" + latestProductList.size());
		for(LatestProduct listLatestProductDate : latestProductList) {
			System.out.println("listLatestProductDate.getP_img=>" + listLatestProductDate.getP_img());
			System.out.println("listLatestProductDate.getP_name=>" + listLatestProductDate.getP_name());
			System.out.println("listLatestProductDate.getP_price=>" + listLatestProductDate.getP_price());
		}
		model.addAttribute("total", total);
		model.addAttribute("latestProductList", latestProductList);
		model.addAttribute("lp", lp);
		
		return "kn/latestProductList";
	}
	
}
