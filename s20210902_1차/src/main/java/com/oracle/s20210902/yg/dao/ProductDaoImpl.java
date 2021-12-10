package com.oracle.s20210902.yg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Common;
import com.oracle.s20210902.model.Product;


@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<Product> tableProduct (Product product) {
		List<Product> productTable=null;
		System.out.println("ProductDaoImpl productList Start.... ");
		
		try { 
			productTable =session.selectList("ygProductListAll",product);
			
			
		} catch (Exception e) {
			System.out.println("ProductDaoImpl listProduct Exception->"+e.getMessage());
		}
		
		
		return productTable;
	}
 
	@Override
	public int total(Product product) {
		int totCnt=0;
		System.out.println("ProductDaoImpl total Start...");
		try {
			totCnt=session.selectOne("ygProductTotal");
		} catch (Exception e) {
			System.out.println("ProductDaoImpl total Exception"+e.getMessage());
		}
		
		return totCnt;
	}

	@Override
	public Product productContent (Product product) {
		Product product1=new Product();
		System.out.println("ProductDaoImpl total Start...");
		
	
			try {
				product1 =session.selectOne("ygproductContent", product);
				System.out.println("ProductDaoImpl productcontent getP_code"+product.getP_code());	
			} catch (Exception e) {
				System.out.println("ProductDaoImpl productcontent Exception"+e.getMessage());			
			}

		return product1;
	}

	@Override
	public List<Product> listManager() {
		List<Product> M_productList=null;
		System.out.println("ProductDaoImpl listManager Start...");
		
		try {
			M_productList=session.selectList("yglistManager");
		}catch (Exception e) {
			System.out.println("ProductDaoImpl listManager  Exception"+e.getMessage());
		}
		
		return M_productList;
	}
	@Override
	public int productInsert(Product product) {
		System.out.println("ProductDaoImpl productInsert Start.. ");
		int result=-1;
		try {
			result=session.insert("productInsert", product);
		} catch (Exception e) {
			System.out.println("ProductDaoImpl productInsert Exception->"+e.getMessage());
		}
		
		return result;
	}
	@Override
	public int productUpdate(Product product) {
		System.out.println("ProductDaoImpl productUpdate Start..");
		int a=0;
		try {
			a=session.update("ygproductUpdate",product);
			System.out.println("ProductDaoImpl productUpdate a->"+a);
		} catch (Exception e) {
			System.out.println("ProductDaoImpl productUpdate Exception->"+e.getMessage());
		}
		return a;
	}

	@Override
	public int productDelete(Product product) {
		System.out.println("ProductDaoImpl productDelete Start..");
		int result=-1;
		
		try {
			result=session.delete("productDelete",product);
			System.out.println("ProductDaoImpl delete result->"+result);
			
			
		} catch (Exception e) {
			System.out.println("ProductDaoImpl delete Exception->"+e.getMessage());
		}

		return result;
	}

	@Override
	public List<Common> cateProductList() {
		List<Common> cateProductList1 = null;
		System.out.println("ProductDaoImpl cateProductList1 Start ..." );
		try {
			cateProductList1 = session.selectList("ygCateProductList1");
			System.out.println("ProductDaoImpl ProductTable for cateProductList1.size()->" + cateProductList1.size());
			for(Common comm : cateProductList1) {
				System.out.println("ProductDaoImpl ProductTable for comm.getMcode()->" + comm.getMcode());
				System.out.println("ProductDaoImpl ProductTable for comm.getContent()->" + comm.getContent());
			}

		} catch (Exception e) {
			System.out.println("ProductDaoImpl cateProductList1 Exception->"+e.getMessage());
		}
		return cateProductList1;
	}
	@Override
	public List<Common> cateProductList2() {
		List<Common> cateProductList2 = null;
		System.out.println("ProductDaoImpl cateProductList1 Start ..." );
		try {
			cateProductList2= session.selectList("ygCateProductList2");
			System.out.println("ProductDaoImpl ProductTable for cateProductList1.size()->" + cateProductList2.size());
			for(Common comm : cateProductList2) {
				System.out.println("ProductDaoImpl ProductTable for comm.getMcode()->" + comm.getMcode());
				System.out.println("ProductDaoImpl ProductTable for comm.getContent()->" + comm.getContent());
			}

		} catch (Exception e) {
			System.out.println("ProductDaoImpl cateProductList1 Exception->"+e.getMessage());
		}
		return cateProductList2;
	}


	
}
