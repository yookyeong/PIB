package com.oracle.s20210902.dh.dao;

import java.util.List;

import com.oracle.s20210902.model.WishList;

public interface WishListDao {

	int insert(WishList wishlist);

	int total(WishList wishlist);

	List<WishList> listWish(WishList wishlist);

	int delete(WishList wishlist);


	
	
	
}
