package com.oracle.s20210902.jm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.s20210902.common.service.Paging;
import com.oracle.s20210902.jm.service.NoticeService;
import com.oracle.s20210902.model.Notice;


@Controller
public class NoticeController {
	
	@Autowired
	// new es - impl
	private NoticeService ns;
	
	@RequestMapping(value = "noticeList")
	public String noticeList(Notice notice , String currentPage,   Model model) {
		System.out.println("NoticeController Start list...");
		int total = ns.total();
		System.out.println("NoticeController total=>" + total);
		// Paging
		Paging pg = new Paging(total, currentPage);
		
		
		// 지금은 notice List 
		notice.setStart(pg.getStart());   // 1
		notice.setEnd(pg.getEnd());       // 10
		
		System.out.println("NoticeController NoticeList start......");
		List<Notice> listNotice = ns.listNotice(notice);
//		System.out.println("NoticeController noticeList end...");
//		System.out.println("NoticeController noticeList listNotice.size->"+ listNotice.size());
//		for(Notice Notice3 : listNotice ) {
//			System.out.println("notice3.getn_num->"+notice3.getn_num());
//			System.out.println("notice3.getEname->"+notice3.getEname());
//			System.out.println("notice3.getJob->"+notice3.getJob());
//		}

		model.addAttribute("total",   total);
		model.addAttribute("listNotice", listNotice);
		model.addAttribute("pg",      pg);
		
		
		return "jm/noticeListAll";
	}
	
	@RequestMapping(value = "customerNoticeList")
	public String customerNoticeList(Notice notice , String currentPage,   Model model) {
		System.out.println("NoticeController Start list...");
		int total = ns.total();
		System.out.println("NoticeController total=>" + total);
		// Paging
		Paging pg = new Paging(total, currentPage);
		// 지금은 notice List 
		notice.setStart(pg.getStart());   // 1
		notice.setEnd(pg.getEnd());       // 10
		System.out.println("NoticeController NoticeList start......");
		List<Notice> listNotice = ns.listNotice(notice);
//		System.out.println("NoticeController noticeList end...");
//		System.out.println("NoticeController noticeList listNotice.size->"+ listNotice.size());
//		for(Notice Notice3 : listNotice ) {
//			System.out.println("notice3.getn_num->"+notice3.getn_num());
//			System.out.println("notice3.getEname->"+notice3.getEname());
//			System.out.println("notice3.getJob->"+notice3.getJob());
//		}

		model.addAttribute("total",   total);
		model.addAttribute("listNotice", listNotice);
		model.addAttribute("pg",      pg);
		
		
		return "jm/customerNoticeListAll";
	}
	
	@GetMapping(value="noticeDetail")
	public String noticeDetail(int n_num, Model model) {
		System.out.println("NoticeController Start detail..." );
		Notice notice = ns.noticeDetail(n_num);
		model.addAttribute("notice",notice);
		return "/jm/noticeDetail";
		
	}
	
	@GetMapping(value="customerNoticeDetail")
	public String customerNoticeDetail(int n_num, Model model) {
		System.out.println("NoticeController Start detail..." );
		Notice notice = ns.noticeDetail(n_num);
		model.addAttribute("notice",notice);
		return "/jm/customerNoticeDetail";		

	}
	@GetMapping(value="noticeUpdateForm")
	public String noticeUpdateForm(int n_num,Model model) {
		System.out.println("NoticeController Start updateForm..." );
		Notice notice = ns.noticeDetail(n_num);
		model.addAttribute("notice",notice);

		return "/jm/noticeUpdateForm";
	}
	// @RequestMapping(value="update" , method=RequestMethod.POST)
	@PostMapping(value="noticeUpdate")
    public String noticeUpdate(Notice notice, Model model) {
		System.out.println("uploadResult noticeUpdate notice.getN_num-->"+notice.getN_num());
		System.out.println("uploadResult noticeUpdate notice.getN_content-->"+notice.getN_content());
		System.out.println("uploadResult noticeUpdate notice.getN_title-->"+notice.getN_title());
		int k = ns.noticeUpdate(notice);
		model.addAttribute("result", k);
		System.out.println("es.noticeUpdate(notice) k-->"+k);

		//return "redirect:/noticeList";   
		//return "forward:noticeList"; 
		return "jm/noticeUpdateResult";
    }

	//@GetMapping(value="writeForm")
	@RequestMapping(value="noticeWriteForm")
	public String noticeWriteForm(Model model) {
//	  List<Notice> noticeList = ns.noticeListManager();
//	  System.out.println("noticeController writeForm list.size->"+noticeList.size());
//	  model.addAttribute("noticeMngList",noticeList); // notice Manager List

		return "/jm/noticeWriteForm";
	}

//	@RequestMapping(value="write" ,  method=RequestMethod.POST)
	@PostMapping(value="noticeWrite")
	public String noticeWrite(Notice notice, Model model) {
		System.out.println("noticeController Start write..." );
		//System.out.println("notice.getHiredate->"+notice.getHiredate());
		// Service, Dao , Mapper명 까지 -> insert
		String returnStr ="";
		int result = ns.noticeInsert(notice);
		//if (result > 0) returnStr = "redirect:noticeList";
		if (result > 0) returnStr = "/jm/noticeWriteResult";
		
		else {
			returnStr = "forward:noticeWriteForm";
		}
			model.addAttribute("result", result);
		return returnStr;
	}	

	@GetMapping(value="noticeConfirm")
	public String noticeConfirm(int n_num, Model model) {
		Notice notice = ns.noticeDetail(n_num);
		model.addAttribute("n_num", n_num);
		
		return "forward:noticeWriteForm";
	}
		
	@RequestMapping(value="noticeDelete")
	public String noticeDelete(int n_num, Model model) {
		System.out.println("noticeController Start delete..." );
		int result = ns.noticeDelete(n_num);
			model.addAttribute("result", result);
		
		return "/jm/noticeDeleteResult";
	}	
	

}
