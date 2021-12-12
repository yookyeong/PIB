package com.oracle.s20210902.dh.service;

import java.util.List;

import com.oracle.s20210902.model.WishList;

public interface WishListService {

	int insert(WishList wishlist);

	int total(WishList wishlist);

	List<WishList> listWish(WishList wishlist);

	int delete(WishList wishlist);


	
	

}
