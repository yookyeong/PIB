package com.oracle.s20210902.dh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.dh.dao.WishListDao;
import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.WishList;


@Service
public class WishListServiceImpl implements WishListService {
	
	@Autowired
	private WishListDao wld;

	@Override
	public int insert(WishList wishlist) {
		System.out.println("WishListServiceImpl insert start");
		int result = wld.insert(wishlist);
		return result;
	}

	@Override
	public int total(WishList wishlist) {
		System.out.println("WishListServiceImpl total start");
		int total = wld.total(wishlist);
		return total;
	}

	@Override
	public List<WishList> listWish(WishList wishlist) {
		System.out.println("WishListServiceImpl listWish start");
		List<WishList> wishList = wld.listWish(wishlist);
		return wishList;
	}

	@Override
	public int delete(WishList wishlist) {
		System.out.println("WishListServiceImpl delete start");
		int result = wld.delete(wishlist);
		return result;
	}


	
}
