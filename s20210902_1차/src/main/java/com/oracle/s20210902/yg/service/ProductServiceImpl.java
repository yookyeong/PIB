package com.oracle.s20210902.yg.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.model.Common;
import com.oracle.s20210902.model.Faq;
import com.oracle.s20210902.model.Product;
import com.oracle.s20210902.yg.dao.ProductDao;


@Service

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao pd;
	
	@Override
	public int total (Product product) {
		System.out.println("ProductServiceImpl Start total..");
		int tot=0;
		tot=pd.total(product);
		System.out.println("ProductServiceImpl total totCnt->"+tot);
		return tot;
	}
	
	
	
	@Override
	public List<Product> tableproduct (Product product) {
		List<Product> productTable=null;
		System.out.println("ProductServiceImpl listProduct Start.. ");
		productTable=pd.tableProduct(product);
		System.out.println("ProductServiceImpl listProduct productList.size()->"+productTable.size());
		
		return productTable;
	}



	@Override
	public Product productContent (Product product) {
		System.out.println("ProductServiceImpl productcontent...");
		Product product1 =null;
		product1=pd.productContent(product);
	
		return product1;
	}

	@Override
	public List<Product> listManager() {
		List<Product> M_productList=null;
		System.out.println("ProductServiceImpl listManager Start....");
		M_productList=pd.listManager();
		System.out.println("ProductServiceImpl listprouct M_productList.size()"+M_productList.size());
		
		return M_productList;
	}
	
	@Override
	public int productInsert(Product product) {
		System.out.println("ProductServiceImpl  productinsert Start ");
		int result=0;
		result=pd.productInsert(product);
		return result;
	}

	@Override
	public int productUpdate(Product product) {
		System.out.println("ProductServiceImpl productUpdate Start...");
		int a=0;
		a=pd.productUpdate(product);
		System.out.println("ProductServiceImpl productUpdate a->"+a);
		return a;
	}

	@Override
	public int productDelete(Product product) {
		System.out.println("ProductServiceImpl productDelete start...");
		int result=0;
		result=pd.productDelete(product);
		return result;
	}

	@Override
	public List<Common> cateProductList() {
		List<Common> cateProductList1 = null;
		System.out.println("ProductServiceImpl cateProductList Start..." );
		cateProductList1 = pd.cateProductList();
		System.out.println("ProductServiceImpl cateProductList empList.size()->" +cateProductList1.size());
		
		return cateProductList1;
	}
	@Override
	public List<Common> cateProductList2() {
		List<Common> cateProductList2 = null;
		System.out.println("ProductServiceImpl cateProductList2 Start..." );
		cateProductList2 = pd.cateProductList2();
		System.out.println("ProductServiceImpl cateProductList2 empList.size()->" +cateProductList2.size());
		
		return cateProductList2;
	}






	

	
	
}
