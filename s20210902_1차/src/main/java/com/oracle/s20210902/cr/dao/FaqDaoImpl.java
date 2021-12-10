package com.oracle.s20210902.cr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Faq;
@Repository
public class FaqDaoImpl implements FaqDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public int faqListTotal(Faq faq) {
		System.out.println("FaqDaoImpl faqListTotal Start...");
		int totalCnt = 0;
		try {
			if(faq.getQ_mcode() == 0)
				totalCnt  = session.selectOne("crFaqTotalCnt");
			else
				totalCnt = session.selectOne("crFaqPartCnt",faq);
		} catch (Exception e) {
			System.out.println("FaqDaoImpl faqListTotal Exception-->"+e.getMessage());
		}
		return totalCnt;
	}

	@Override
	public List<Faq> faqListAll(Faq faq) {
		System.out.println("FaqDaoImpl faqListAll Start...");
		List<Faq> faqListAll = null;
		try {
			if(faq.getQ_mcode() == 0)
				faqListAll  = session.selectList("crFaqListAll", faq);
			else
				faqListAll  = session.selectList("crFaqListPart", faq);
			System.out.println("FaqDaoImpl faqListAll faqListAll.size()-->"+faqListAll.size());
		} catch (Exception e) {
			System.out.println("FaqDaoImpl faqListAll Exception-->"+e.getMessage());
		}
		return faqListAll;
	}

	@Override
	public Faq faqContent(Faq faq) {
		System.out.println("FaqDaoImpl faqContent Start...");
		Faq faqContent = null;
		try {
			faqContent  = session.selectOne("crFaqContent", faq);
			System.out.println("FaqDaoImpl faqContent getF_num() -->"+faqContent.getF_num());
		} catch (Exception e) {
			System.out.println("FaqDaoImpl faqContent Exception-->"+e.getMessage());
		}
		return faqContent;
	}

	@Override
	public List<Faq> faqSelectMcode() {
		System.out.println("FaqDaoImpl faqSelectMcode Start...");
		List<Faq> faqSelectMcode = null;
		try {
			faqSelectMcode  = session.selectList("crFaqSelectMcode");
			System.out.println("FaqDaoImpl faqSelectMcode faqSelectMcode.size()-->"+faqSelectMcode.size());
		} catch (Exception e) {
			System.out.println("FaqDaoImpl faqSelectMcode Exception-->"+e.getMessage());
		}
		return faqSelectMcode;
	}

	@Override
	public int faqInsert(Faq faq) {
		System.out.println("FaqDaoImpl faqSelectMcode Start...");
		int result = -1;
		try {
			result  = session.insert("crFaqInsert", faq);
			System.out.println("FaqDaoImpl faqSelectMcode result-->"+result);
		} catch (Exception e) {
			System.out.println("FaqDaoImpl faqSelectMcode Exception-->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int faqUpdate(Faq faq) {
		System.out.println("FaqDaoImpl faqUpdate Start...");
		int result = -1;
		try {
			result  = session.insert("crFaqUpdate", faq);
			System.out.println("FaqDaoImpl faqUpdate result-->"+result);
		} catch (Exception e) {
			System.out.println("FaqDaoImpl faqUpdate Exception-->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int faqDelete(Faq faq) {
		System.out.println("FaqDaoImpl faqDelete Start...");
		int result = -1;
		try {
			result  = session.insert("crFaqDelete", faq);
			System.out.println("FaqDaoImpl faqDelete result-->"+result);
		} catch (Exception e) {
			System.out.println("FaqDaoImpl faqDelete Exception-->"+e.getMessage());
		}
		return result;
	}


}
