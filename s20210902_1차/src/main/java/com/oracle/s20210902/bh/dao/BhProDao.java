package com.oracle.s20210902.bh.dao;

import java.util.List;

import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.Product;
import com.oracle.s20210902.model.Review;

public interface BhProDao {

	int total(Product pro);
	List<Product> listPro(Product pro);
	Product bhDetail(int p_code);
	int bhReviewWrite(Review review);
	List<Order1> bhProExist(Order1 order);
	int total(Review review);
	List<Review> listRev(Review review);
	int insertRev(Review review);
	int updateRev(Review review);
	int deleteRev(Review review);
	Review selectRevGet(Review review);

}
