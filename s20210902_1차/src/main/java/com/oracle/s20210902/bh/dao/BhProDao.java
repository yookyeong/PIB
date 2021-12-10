package com.oracle.s20210902.bh.dao;

import java.util.List;

import com.oracle.s20210902.model.Product;
import com.oracle.s20210902.model.Review;

public interface BhProDao {

	int total(Product pro);
	List<Product> listPro(Product pro);
	Product bhDetail(int p_code);
	int bhReviewWrite(Review review);

}
