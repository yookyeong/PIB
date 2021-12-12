package com.oracle.s20210902.bh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.bh.dao.BhProDao;
import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.Product;
import com.oracle.s20210902.model.Review;

@Service
public class BhProServiceImpl implements BhProService{
	@Autowired
	private BhProDao pd;

	@Override
	public int total(Product pro) {
		System.out.println("BhProServiceImpl total Start ..." );
		int totCnt = pd.total(pro);
		System.out.println("BhProServiceImpl total totCnt->"+totCnt );
		return totCnt;
	}

	@Override
	public List<Product> listPro(Product pro) {
		List<Product> bhPro = null;
		System.out.println("BhProServiceImpl listPro Start..." );
		bhPro = pd.listPro(pro);
		System.out.println("BhProServiceImpl listPro bhPro.size()->" + bhPro.size());
		return bhPro;
	}

	@Override
	public Product bhDetail(int p_code) {
		System.out.println("BhProServiceImpl detail ...");
		Product pro = null;
		pro = pd.bhDetail(p_code);
		return pro;
	}

	@Override
	public int bhReviewWrite(Review review) {
		int result = pd.bhReviewWrite(review); 
		return result;
	}

	@Override
	public List<Order1> bhProExist(Order1 order) {
		List<Order1> ordered = null;
		ordered = pd.bhProExist(order);
		System.out.println("BhProServiceImpl bhProExist ordered.getP_size()->" + ordered.size());
		return ordered;
	}

	@Override
	public int total(Review review) {
		System.out.println("BhProServiceImpl total Start ..." );
		int totCnt = pd.total(review);
		System.out.println("BhProServiceImpl total totCnt->"+totCnt );
		return totCnt;
	}

	@Override
	public List<Review> listRev(Review review) {
		List<Review> bhRev = null;
		System.out.println("BhProServiceImpl listRev Start..." );
		bhRev = pd.listRev(review);
		System.out.println("BhProServiceImpl listRev bhRev.size()->" + bhRev.size());
		return bhRev;
	}

	@Override
	public int insertRev(Review review) {
		System.out.println("BhProServiceImpl insertRev Start..." );
		int result = 0;
		result = pd.insertRev(review);
		return result;
	}

	@Override
	public int updateRev(Review review) {
		System.out.println("BhProServiceImpl updateRev Start...");
		int up = 0;
		up = pd.updateRev(review);
		return up;
	}

	@Override
	public int deleteRev(Review review) {
		System.out.println("BhProServiceImpl deleteRev Start...");
		int result = 0;
		result = pd.deleteRev(review);
		return result;
	}

	@Override
	public Review selectRevGet(Review review) {
		Review reviewGet = pd.selectRevGet(review);
		return reviewGet;
	}


}
