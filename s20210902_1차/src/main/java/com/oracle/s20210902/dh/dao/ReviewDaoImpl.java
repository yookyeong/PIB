package com.oracle.s20210902.dh.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private SqlSession session;

	@Override
	public int insert(Review review) {
		Review reviewSelect = null;
		int result1 = 0;
		int result2 = 0;
		
		try {
			reviewSelect = session.selectOne("dhselectOneReview", review);
			System.out.println("ReviewDaoImpl insert review-->"+reviewSelect.getR_num());
			result1 = session.update("dhUpdateReview", reviewSelect);
			review.setReply(reviewSelect.getReply());
			System.out.println("ReviewDaoImpl insert result1-->"+result1);
			result2 = session.insert("dhInsertReview", review);
			System.out.println("ReviewDaoImpl insert result2-->"+result2);
		} catch (Exception e) {
			System.out.println("ReviewDapImpl -> " + e.getMessage());
		}
		return result2;
	}

	@Override
	public int delete(Review review) {
		int result = 0;
		try {
			result = session.delete("dhDeleteReply", review);
		} catch (Exception e) {
			System.out.println("ReviewDapImpl -> " + e.getMessage());
		}
		return result;
	}



	
	
}
