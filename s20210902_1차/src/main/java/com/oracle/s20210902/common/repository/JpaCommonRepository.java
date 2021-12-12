package com.oracle.s20210902.common.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.common.domain.Product;

@Repository
public class JpaCommonRepository implements CommonRepository {

	@Autowired
	private EntityManager em;
	
	@Override
	public List<Product> productListHit() {
		System.out.println("JpaCommonRepository productListHit Start...");
		String sql = "select distinct p from Product p order by p_hit desc";
		List<Product> productList = em.createQuery(sql, Product.class).setFirstResult(1).setMaxResults(8).getResultList();
		return productList;
	}

}
