package com.oracle.s20210902.bh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.bh.dao.BhProDao;
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
		return 0;
	}


}
