package com.oracle.s20210902.cr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.cr.dao.FaqDao;
import com.oracle.s20210902.model.Faq;
@Service
public class FaqServiceImpl implements FaqService {
	
	@Autowired
	private FaqDao fd;
	
	@Override
	public int faqListTotal(Faq faq) {
		System.out.println("FaqServiceImpl faqListTotal Start...");
		int total = 0;
		total = fd.faqListTotal(faq);
		return total;
	}

	@Override
	public List<Faq> faqListAll(Faq faq) {
		System.out.println("FaqServiceImpl faqListAll Start...");
		List<Faq> faqList = fd.faqListAll(faq);
		return faqList;
	}

	@Override
	public Faq faqContent(Faq faq) {
		System.out.println("FaqServiceImpl faqContent Start...");
		Faq faqContent = fd.faqContent(faq);
		return faqContent;
	}

	@Override
	public List<Faq> faqSelectMcode() {
		System.out.println("FaqServiceImpl faqSelectMcode Start...");
		List<Faq> faqSelectMcode = fd.faqSelectMcode();
		return faqSelectMcode;
	}

	@Override
	public int faqInsert(Faq faq) {
		System.out.println("FaqServiceImpl faqInsert Start...");
		int result = fd.faqInsert(faq);
		return result;
	}

	@Override
	public int faqUpdate(Faq faq) {
		System.out.println("FaqServiceImpl faqUpdate Start...");
		int result = fd.faqUpdate(faq);
		return result;
	}

	@Override
	public int faqDelete(Faq faq) {
		System.out.println("FaqServiceImpl faqDelete Start...");
		int result = fd.faqDelete(faq);
		return result;
	}



	
	
}
