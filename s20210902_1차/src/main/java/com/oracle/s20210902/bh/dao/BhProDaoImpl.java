package com.oracle.s20210902.bh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Product;
import com.oracle.s20210902.model.Review;

@Repository
public class BhProDaoImpl implements BhProDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public int total(Product pro) {
		int tot = 0;
		System.out.println("BhProDaoImpl total Start ..." );
		try {
			if(pro.getP_c_mcode() == 0)
				tot = session.selectOne("bhProTotal");
			else
				tot = session.selectOne("bhProTotalP", pro);
		} catch (Exception e) {
			System.out.println("BhProDaoImpl total Exception->"+e.getMessage());
		}
		
		return tot;
	}

	@Override
	public List<Product> listPro(Product pro) {
		List<Product> bhPro = null;
		System.out.println("BhProDaoImpl listPro Start ..." );
		try {
			if(pro.getP_c_mcode() == 0) {
				if(pro.getSort() == 0)
					bhPro = session.selectList("bhProListAll", pro);
				else if(pro.getSort() == 1)
					bhPro = session.selectList("bhProListAll1", pro);
				else if(pro.getSort() == 2)
					bhPro = session.selectList("bhProListAll2", pro);
				else if(pro.getSort() == 3)
					bhPro = session.selectList("bhProListAll3", pro);
				else
					bhPro = session.selectList("bhProListAll4", pro);
			}else {
				if(pro.getSort() == 0)
					bhPro = session.selectList("bhProListPart", pro);
				else if(pro.getSort() == 1)
					bhPro = session.selectList("bhProListPart1", pro);
				else if(pro.getSort() == 2)
					bhPro = session.selectList("bhProListPart2", pro);
				else if(pro.getSort() == 3)
					bhPro = session.selectList("bhProListPart3", pro);
				else
					bhPro = session.selectList("bhProListPart4", pro);
			}
			System.out.println("BhProDaoImpl listPro bhPro.size() -> " + bhPro.size());
		}catch (Exception e) {
			System.out.println("BhProDaoImpl listPro Exception -> " + e.getMessage());
		}
		return bhPro; 
	}

	@Override
	public Product bhDetail(int p_code) {
		System.out.println("BhProDaoImpl bhDetail start...");
		Product pro = null;
		try {
			pro = session.selectOne("bhProSelOne", p_code);	
			System.out.println("BhProDaoImpl bhDetail getP_code->" + pro.getP_code());
		}catch (Exception e) {
			System.out.println("BhProDaoImpl bhDetail Exception->" + e.getMessage());
		}
		return pro;
	}

	@Override
	public int bhReviewWrite(Review review) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * @Override public List<Product> bhSortList(int sort, Product pro) {
	 * List<Product> bhSortList = null;
	 * System.out.println("BhProDaoImpl bhSortList start..."); try { if(sort == 4)
	 * bhSortList = session.selectList("bhSort4", pro); else if(sort == 1){
	 * bhSortList = session.selectList("bhSort1", pro); }else if(sort == 2){
	 * bhSortList = session.selectList("bhSort2", pro); }else { bhSortList =
	 * session.selectList("bhSort3", pro); } } catch (Exception e) {
	 * System.out.println("BhProDaoImpl bhSortList Exception->" + e.getMessage()); }
	 * return bhSortList; }
	 */


}
