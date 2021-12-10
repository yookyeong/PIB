package com.oracle.s20210902.cr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.s20210902.common.service.Paging;
import com.oracle.s20210902.cr.service.FaqService;
import com.oracle.s20210902.model.Faq;

@Controller
public class FaqController {
	@Autowired
	private FaqService fs;
	
	@RequestMapping(value = "faqListAll")
	public String faqListAll(Faq faq, String currentPage, Model model) {
		System.out.println("FaqController faqListAll Start...");
		// paging
		int total = fs.faqListTotal(faq);
		System.out.println("FaqController faqListAll total-->"+total);
		Paging page = new Paging(total, currentPage);
		faq.setStart(page.getStart());
		faq.setEnd(page.getEnd());
		System.out.println("FaqController faqListAll getEndPage()-->"+page.getEndPage());
		// List 갖고 오기
		List<Faq> faqList = fs.faqListAll(faq);
//		System.out.println("FaqController faqListAll faqList.size()-->"+faqList.get(1).getContent());
		System.out.println("FaqController faqListAll faqList.size()-->"+faqList.size());
		// model에 넣기
		model.addAttribute("total", total);
		model.addAttribute("faqList", faqList);
		model.addAttribute("page", page);
		return "/cr/faqListAll";
	}
	
	@RequestMapping(value = "adminFaqListAll")
	public String adminFaqListAll(Faq faq, String currentPage, Model model) {
		System.out.println("FaqController adminFaqListAll Start...");
		// paging
		int total = fs.faqListTotal(faq);
		System.out.println("FaqController adminFaqListAll total-->"+total);
		Paging page = new Paging(total, currentPage);
		faq.setStart(page.getStart());
		faq.setEnd(page.getEnd());
		// List 갖고 오기
		List<Faq> faqList = fs.faqListAll(faq);
		System.out.println("FaqController adminFaqListAll faqList.size()-->"+faqList.size());
		// model에 넣기
		model.addAttribute("total", total);
		model.addAttribute("faqList", faqList);
		model.addAttribute("page", page);
		return "/cr/adminFaqListAll";
	}
	
	@RequestMapping(value = "faqContent")
	public String faqContent(Faq faq, String currentPage, Model model) {
		System.out.println("FaqController faqContent Start...");
		Faq faqContent = fs.faqContent(faq);
		System.out.println("FaqController faqContent getF_num()-->"+faqContent.getF_num());
		
		model.addAttribute("faq", faqContent);
		model.addAttribute("currentPage", currentPage);
		return "/cr/faqContent";
	}
	
	@RequestMapping(value = "faqWriteForm")
	public String faqWriteForm(Model model) {
		System.out.println("FaqController faqWriteForm Start...");
		List<Faq> faq_mcode = fs.faqSelectMcode();
		System.out.println("FaqController faqWriteForm faq_mcode.size()-->"+faq_mcode.size());
		model.addAttribute("faq_mcode", faq_mcode);
		return "/cr/faqWriteForm";
	}
	
	@RequestMapping(value = "faqWritePro", method = RequestMethod.POST)
	public String faqWritePro(Faq faq, Model model) {
		System.out.println("FaqController faqWritePro start...");
		int result = fs.faqInsert(faq);
		System.out.println("FaqController faqWritePro result -->"+result);
		model.addAttribute("result", result);
		return "forward:faqWriteForm";
	}
	
	@RequestMapping(value = "faqUpdateForm")
	public String faqUpdateForm(Faq faq, Model model) {
		System.out.println("FaqController faqUpdateForm start...");
		Faq faqContent = fs.faqContent(faq);
		List<Faq> faq_mcode = fs.faqSelectMcode();
		model.addAttribute("faq", faqContent);
		model.addAttribute("faq_mcode", faq_mcode);
		return "/cr/faqUpdateForm";
	}
	
	@RequestMapping(value = "faqUpdatePro")
	public String faqUpdatePro(Faq faq, Model model) {
		System.out.println("FaqController faqUpdatePro start...");
		int result = fs.faqUpdate(faq);
		System.out.println("FaqController faqWritePro result -->"+result);
		model.addAttribute("result", result);
		model.addAttribute("f_num", faq.getF_num());
		return "forward:faqUpdateForm";
	}
	
	@RequestMapping(value = "faqDeletePro")
	public String faqDeletePro(Faq faq, Model model) {
		System.out.println("FaqController faqDelete start...");
		int result = fs.faqDelete(faq);
		System.out.println("FaqController faqDelete result -->"+result);
		model.addAttribute("result", result);
		model.addAttribute("f_num", faq.getF_num());
		return "forward:adminFaqListAll";
	}
}
