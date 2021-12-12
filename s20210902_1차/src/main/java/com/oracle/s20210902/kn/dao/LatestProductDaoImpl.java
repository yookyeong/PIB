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


	// keyword 상품 검색, 상품 총 갯수 18EA
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
	
	// keyword 상품 검색 list
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
	
	// 로그인 시 최근 본 상품 총 갯수
	@Override
	public int repListTotal(LatestProduct latestProduct) {
		int tot = 0;
		System.out.println("LatestProductDaoImpl repListTotal Start...");
		try {
			tot = session.selectOne("knRepListTotal", latestProduct);
		} catch (Exception e) {
			System.out.println("LatestProductDaoImpl repListTotal Exception=>"+ e.getMessage());
		}
		return tot;
	}
	
	// 최근 본 상품 list
	@Override
	public List<LatestProduct> listLatestProduct(LatestProduct latestProduct) {
		List<LatestProduct> latestProductList = null;
		try {
			System.out.println("LatestProductDaoImpl getStart=>" + latestProduct.getStart());
			System.out.println("LatestProductDaoImpl getEnd=>" + latestProduct.getEnd());
			System.out.println("LatestProductDaoImpl getMem_id=>" + latestProduct.getMem_id());
			latestProductList = session.selectList("knRepListALL", latestProduct);
		} catch (Exception e) {
			System.out.println("LatestProductDaoImpl listLatestProduct Exception=>" + e.getMessage());
		}
		return latestProductList;
	}

	// p_code 값을 조회 한 값을 최근 본 상품 삭제
	@Override
	public int deleteLatestProduct(int p_code) {
		System.out.println("LatestProductDaoImpl deleteLatestProduct Start");
		System.out.println("LatestProductDaoImpl deleteLatestProduct p_code->"+p_code);
		int result = 0;
		try {
			result = session.delete("knDeleteLatestProduct", p_code);
			System.out.println("LatestProductDaoImpl deleteLatestProduct result->"+result);
		} catch (Exception e) {
			System.out.println("LatestProductDaoImpl deleteLatestProduct Exception : " + e.getMessage());
		}
		return result;
	}
	
	// 최근 본 상품 date 검색
	@Override
	public int selectLatestProduct(LatestProduct latestProduct) {
		System.out.println("LatestProductDaoImpl selectLatestProduct start...");
		int result = 0;
		try {
			result = session.selectOne("knSelectLatestProduct", latestProduct);	
			System.out.println("LatestProductDaoImpl selectLatestProduct result->" + result);
		}catch (Exception e) {
			System.out.println("LatestProductDaoImpl selectLatestProduct Exception->" + e.getMessage());
		}
		return result;
	}

	// 최근 본 리스트 date 검색 후 있을 시 sysdate update
	@Override
	public int updateLatestProduct(LatestProduct latestProduct) {
		System.out.println("LatestProductDaoImpl updateLatestProduct start...");
		int result = 0;
		try {
			System.out.println("LatestProductDaoImpl updateLatestProduct getMem_id->" + latestProduct.getMem_id());
			System.out.println("LatestProductDaoImpl updateLatestProduct getP_code->" + latestProduct.getP_code());

			result = session.update("knUpdateLatestProduct", latestProduct);	
			System.out.println("LatestProductDaoImpl updateLatestProduct result->" + result);
		}catch (Exception e) {
			System.out.println("LatestProductDaoImpl updateLatestProduct Exception->" + e.getMessage());
		}
		return result;
	}

	// 최근 본 리스트 date 검색 후 없을 시 insert
	@Override
	public int insertLatestProduct(LatestProduct latestProduct) {
		System.out.println("LatestProductDaoImpl insertLatestProduct start...");
		int result = 0;
		try {
			result = session.insert("knInsertLatestProduct", latestProduct);	
			System.out.println("LatestProductDaoImpl insertLatestProduct result->" + result);
		}catch (Exception e) {
			System.out.println("LatestProductDaoImpl insertLatestProduct Exception->" + e.getMessage());
		}
		return result;
	}

}
