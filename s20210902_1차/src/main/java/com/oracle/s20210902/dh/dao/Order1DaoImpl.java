package com.oracle.s20210902.dh.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Member;
import com.oracle.s20210902.model.Order1;

@Repository
public class Order1DaoImpl implements Order1Dao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(Order1 order1, HttpServletRequest request, int i) {
		System.out.println("Order1DaoImpl insert() Start...");
		int result = 0;
		int pk_oNum = 0;
		try {
			System.out.println("i-->"+i);
			if( i == 0 ) {
				result = session.insert("dhOrderInsert1", order1);
				System.out.println("Order1DaoImpl insert() result->"+result);
				System.out.println("Order1DaoImpl insert() order1.getO_num()->"+order1.getO_num());
			//	pk_oNum = order1.getO_num();
			} else {
				result = session.insert("dhOrderInsert2", order1);
			}
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return result;
	}
	
	
	// admin이 아닌경우 가져오는 totCnt
	@Override
	public int select(Order1 order1) {
		System.out.println("Order1DaoImpl select() start");
		int totCnt = 0;
		try {
			totCnt = session.selectOne("dhSelectOne", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return totCnt;
	}

	@Override
	public List<Order1> listOrder(Order1 order1) {
		List<Order1> order1List = null;
		try {
			order1List = session.selectList("dhOrderList", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return order1List;
	}

	

	@Override
	public int update(Order1 order1) {
		int result = 0;
		try {
			result = session.update("dhUpdate", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return result;
	}

	@Override
	public List<Order1> listOrderManager(Order1 order1) {
		List<Order1> order1ListManager = null;
		try {
			order1ListManager = session.selectList("dhOrderListManager", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return order1ListManager;
	}

	@Override
	public int updateManager(Order1 order1) {
		int result = 0;
		int result2 = 0;
		try {
			result = session.update("dhUpdateManager", order1);
			result2 = session.update("dhUpdateQty", order1);	// 수량
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return result;
	}

	@Override
	public List<Order1> listOrderManagerC(Order1 order1) {
		List<Order1> order1ListManagerC = null;
		try {
			order1ListManagerC = session.selectList("dhOrderListManagerC", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return order1ListManagerC;
	}

	@Override
	public List<Order1> listOrderManagerCSearch(Order1 order1) {
		List<Order1> order1ListManagerSearch = null;
		try {
			order1ListManagerSearch = session.selectList("dhQsearch", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return order1ListManagerSearch;
	}

	@Override
	public int updateManagerQty(Order1 order1) {
		int result2 = 0;
		try {
			result2 = session.update("dhUpdateQty", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return result2;
	}

	@Override
	public int selectM(Order1 order1) {
		System.out.println("Order1DaoImpl select() start");
		int totCnt = 0;
		try {
			totCnt = session.selectOne("dhSelectOneM", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return totCnt;
	}

	@Override
	public int selectC(Order1 order1) {
		System.out.println("Order1DaoImpl select() start");
		int totCnt = 0;
		try {
			totCnt = session.selectOne("dhSelectOneC", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return totCnt;
	}

	@Override
	public int selectQ(Order1 order1) {
		System.out.println("Order1DaoImpl select() start");
		int totCnt = 0;
		try {
			totCnt = session.selectOne("dhSelectOneQ", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return totCnt;
	}

	@Override
	public int totalCategory(Order1 order1) {
		System.out.println("Order1DaoImpl order1Category() start");
		int totCnt = 0;
		try {
			totCnt = session.selectOne("dhTotalCategory", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return totCnt;
	}

	@Override
	public List<Order1> order1ListCategory(Order1 order1) {
		List<Order1> order1Category = null;
		try {
			order1Category = session.selectList("dhOrder1CategoryList", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return order1Category;
	}

	@Override
	public Member memberInfo(String mem_name) {
		Member listMemberInfo = null;
		try {
			listMemberInfo	= (Member) session.selectOne("dhMemberSelectOne", mem_name);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return listMemberInfo;
	}

	@Override
	public List<Order1> listOrderDate(Order1 order1) {
		List<Order1> order1ListDate = null;
		try {
			order1ListDate	= session.selectList("dhSelectListDate", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return order1ListDate;
	}

	@Override
	public List<Order1> listOrderManagerCDate(Order1 order1) {
		List<Order1> order1DateManagerC = null;
		try {
			order1DateManagerC = session.selectList("dhOrderListManagerCDate", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return order1DateManagerC;
	}


	@Override
	public Member selectMem(String mem_id) {
		Member member  = null;
		try {
			member = session.selectOne("dhOrderListMember", mem_id);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return member;
	}


	@Override
	public int remove(Order1 order1) {
		int result = 0;
		try {
			result = session.delete("dhRemove", order1);
		} catch (Exception e) {
			System.out.println("Order1DaoImpl->" + e.getMessage());
		}
		return result;
	}
	
	
	
}
