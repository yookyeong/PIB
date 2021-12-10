package com.oracle.s20210902.cr.service;

import java.util.List;

import com.oracle.s20210902.model.Faq;

public interface FaqService {
	List<Faq> faqListAll(Faq faq);
	int faqListTotal(Faq faq);
	Faq faqContent(Faq faq);
	List<Faq> faqSelectMcode();
	int faqInsert(Faq faq);
	int faqUpdate(Faq faq);
	int faqDelete(Faq faq);

}
