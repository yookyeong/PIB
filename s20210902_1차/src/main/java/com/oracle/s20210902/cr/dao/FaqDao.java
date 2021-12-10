package com.oracle.s20210902.cr.dao;

import java.util.List;

import com.oracle.s20210902.model.Faq;

public interface FaqDao {
	List<Faq> faqListAll(Faq faq);
	int faqListTotal(Faq faq);
	Faq faqContent(Faq faq);
	List<Faq> faqSelectMcode();
	int faqInsert(Faq faq);
	int faqUpdate(Faq faq);
	int faqDelete(Faq faq);

}
