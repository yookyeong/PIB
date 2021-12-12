package com.oracle.s20210902.dh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.dh.dao.ReviewDao;
import com.oracle.s20210902.model.Review;


@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao rd;

	@Override
	public int insert(Review review) {
		System.out.println("ReviewDao insert start");
		int result2 = rd.insert(review);
		return result2;
	}

	@Override
	public int delete(Review review) {
		System.out.println("ReviewDao insert start");
		int result = rd.delete(review);
		return result;
	}


	
}
