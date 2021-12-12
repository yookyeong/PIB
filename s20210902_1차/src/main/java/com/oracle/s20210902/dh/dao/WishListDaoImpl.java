package com.oracle.s20210902.dh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.WishList;

@Repository
public class WishListDaoImpl implements WishListDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public int insert(WishList wishlist) {
		int result = 0;
		try {
			result = session.insert("dhInsertWishList", wishlist);
		} catch (Exception e) {
			System.out.println("WishListDaoImpl->" + e.getMessage());
		}
		return result;
	}

	@Override
	public int total(WishList wishlist) {
		int total = 0;
		try {
			total = session.selectOne("dhSelectOneWishList", wishlist);
		} catch (Exception e) {
			System.out.println("WishListDaoImpl->" + e.getMessage());
		}
		return total;
	}

	@Override
	public List<WishList> listWish(WishList wishlist) {
		List<WishList> listWish = null;
		try {
			listWish = session.selectList("dhListWishList", wishlist);
		} catch (Exception e) {
			System.out.println("WishListDaoImpl->" + e.getMessage());
		}
		return listWish;
	}

	@Override
	public int delete(WishList wishlist) {
		int result = 0;
		try {
			result = session.delete("dhDeleteWishList", wishlist);
		} catch (Exception e) {
			System.out.println("WishListDaoImpl->" + e.getMessage());
		}
		return result;
	}


}
