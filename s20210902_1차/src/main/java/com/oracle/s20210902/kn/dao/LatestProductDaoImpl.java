package com.oracle.s20210902.kn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.LatestProduct;

@Repository
public class LatestProductDaoImpl implements LatestProductDao {
	@Autowired
	private	SqlSession session;

	@Override
	public int total() {
		int tot = 0;
		System.out.println("LatestProductDaoImpl total Start...");
		try {
			tot = session.selectOne("knListTotal");
		} catch (Exception e) {
			System.out.println("LatestProductDaoImpl total Exception=>"+ e.getMessage());
		}
		return tot;
	}


	@Override
	public int repSearchListTotal(String keyword) {
		int tot = 0;
		System.out.println("LatestProductDaoImpl repListTotal Start...");
		try {
			tot = session.selectOne("knSearchListTotal", keyword);
		} catch (Exception e) {
			System.out.println("LatestProductDaoImpl repSearchListTotal Exception=>"+ e.getMessage());
		}
		return tot;
	}
	
	
	@Override
	public List<LatestProduct> listProSearch(LatestProduct latestProduct) {
		List<LatestProduct> proSearch = null;
		try {
			System.out.println("LatestProductDaoImpl getStart=>" + latestProduct.getStart());
			System.out.println("LatestProductDaoImpl getEnd=>" + latestProduct.getEnd());
			System.out.println("LatestProductDaoImpl keyword=>" + latestProduct.getKeyword());
			proSearch = session.selectList("knSearchListALL", latestProduct);
		} catch (Exception e) {
			System.out.println("LatestProductDaoImpl listProSearch Exception=>" + e.getMessage());
		}
		return proSearch;
	}


	@Override
	public int repListTotal(LatestProduct latestProduct) {
		int tot = 0;
		System.out.println("LatestProductDaoImpl repListTotal Start...");
		try {
			tot = session.selectOne("knRepListTotal");
		} catch (Exception e) {
			System.out.println("LatestProductDaoImpl repListTotal Exception=>"+ e.getMessage());
		}
		return tot;
	}

	
	@Override
	public List<LatestProduct> listLatestProduct(LatestProduct latestProduct) {
		List<LatestProduct> listlatestProduct = null;
		try {
			System.out.println("LatestProductDaoImpl getStart=>" + latestProduct.getStart());
			System.out.println("LatestProductDaoImpl getEnd=>" + latestProduct.getEnd());
			listlatestProduct = session.selectList("knRepListALL", latestProduct);
		} catch (Exception e) {
			System.out.println("LatestProductDaoImpl listLatestProduct Exception=>" + e.getMessage());
		}
		return listlatestProduct;
	}
}
