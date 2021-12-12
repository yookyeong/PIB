package com.oracle.s20210902.cr.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.s20210902.common.service.Paging;
import com.oracle.s20210902.cr.service.FaqService;
import com.oracle.s20210902.cr.service.QnaService;
import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.Qna;

@Controller
public class QnaController {
	
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	private QnaService qs;
	
	// 1:1문의 리스트
	@RequestMapping(value = "qnaClientList")
	public String qnaClientList(HttpServletRequest request, String currentPage, Model model) {
		System.out.println("QnaController qnaClientList Start...");
		Qna qna = new Qna();
		// 현재 로그인한 아이디 값 가져옴
		qna.setMem_id((String)request.getSession().getAttribute("mem_id"));
		// paging 로직 쓰기 위한 total값 가져오기
		int total = qs.qnaListAll(qna);
		System.out.println("QnaController qnaClientList total-->"+total);
		// paging 로직
		Paging page = new Paging(total, currentPage);
		qna.setStart(page.getStart());
		qna.setEnd(page.getEnd());
		// 해당 고객의 1:1문의 리스트 가져오기 
		List<Qna> qnaList = qs.qnaClientList(qna);
//		System.out.println("QnaController qnaClientList qnaList.size()-->"+qnaList.size());
		// jsp model 객체 보내기
		model.addAttribute("total", total);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("page", page);
		return "cr/qnaClientList";
	}
	
	// 1:1 문의 작성하는 폼으로 이동
	@RequestMapping(value = "qnaClientWriteForm")
	public String qnaClientWriteForm(HttpServletRequest request, Model model) {
		System.out.println("QnaController qnaClientWriteForm Start...");
		
		List<Qna> qMcodeList = qs.selectQmcode();
		model.addAttribute("qMocodeList", qMcodeList);
		/* model.addAttribute("orderList", orderList); */
		return "cr/qnaClientWriteForm";
	}
	// 1:1 문의 상세내용
	@RequestMapping(value = "qnaClientContent")
	public String qnaClientContent(Qna qna, Model model, HttpServletRequest request) {
		System.out.println("QnaController qnaClientContent Start...");
		String adminId = (String) request.getSession().getAttribute("mem_id");
		int admin = (int) request.getSession().getAttribute("mem_admin");
//		int adminCheck = qs.adminCheck(adminId);
		System.out.println("QnaController qnaClientContent q_num -->"+qna.getQ_num());
		int reStatus = qs.qnaReplyStatusCheck(qna);
		System.out.println("QnaController qnaClientContent reStatus -->"+reStatus);
		// q_re_status가 0일때 1로 바꾸는 로직 짜기
		if(admin == 1 && reStatus == 0) {
			int readResult = qs.qnaAdminReadContent(qna);
			System.out.println("QnaController qnaClientContent readResult-->"+readResult);
		}
		System.out.println("QnaController qnaAdminList adminCheck -->"+admin);
		Qna qnaContent = qs.qnaClientContent(qna);
		System.out.println("QnaController qnaClientContent qna.getQ_num() -->"+qnaContent.getQ_num());
		System.out.println("QnaController qnaClientContent qna.getQ_re_status() -->"+qnaContent.getQ_re_status());
		model.addAttribute("qna", qnaContent);
		model.addAttribute("adminCheck", admin);
		return "cr/qnaClientContent";
	}
	
	// 1:1 문의 글쓰기 Insert
	@RequestMapping(value = "qnaClientWritePro", method = RequestMethod.POST)
	public String qnaClientWritePro(Qna qna, HttpServletRequest request, MultipartFile file1, Model model) throws IOException {
		System.out.println("QnaController qnaCleintWritePro Start...");
		qna.setMem_id((String)request.getSession().getAttribute("mem_id"));
		if(file1.getSize() != 0) {
			String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
			System.out.println("uploadForm POST Start...");
			logger.info("originalName : "+file1.getOriginalFilename());
			logger.info("size : "+file1.getSize());
			logger.info("contentType : "+file1.getContentType());
			logger.info("uploadPath : "+uploadPath);
			String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
			logger.info("savedName : "+savedName);
			qna.setQ_image("upload/"+savedName);
		}else {
			qna.setQ_image("");
		}
		int result = qs.qnaClientWrite(qna);
		model.addAttribute("result", result);
		return "forward:qnaClientList";
	}
	// 1:1 문의 수정하는 폼으로 가기
	@RequestMapping(value = "qnaClientUpdateForm")
	public String qnaClientUpdateForm(Qna qna, Model model, HttpServletRequest request) {
		System.out.println("QnaController qnaClientUpdateForm Start...");
		qna.setMem_id((String)request.getSession().getAttribute("mem_id"));
		Qna qnaSelect = qs.qnaClientContent(qna);
		List<Qna> qnaQmcodeList = qs.qnaQmcodeList();
		model.addAttribute("mCodeList", qnaQmcodeList);
		model.addAttribute("qna", qnaSelect);
		return "cr/qnaClientUpdateForm";
	}
	
	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws IOException {
		UUID uid = UUID.randomUUID();
		// requestPath = requestPath + "/resource/image";
		System.out.println("uploadPath : "+uploadPath);
		// Directory 생성
		File fileDirectory = new File(uploadPath);
		if(!fileDirectory.exists()) {
			// make directory 
			fileDirectory.mkdir();
			System.out.println("업로드용 폴더 생성 : "+uploadPath);
		}
		String savedName = uid.toString() + "_" + originalName;
		logger.info("UUID savedName : "+savedName);
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);		// org.springframework.util.FileCopyUtils
		return savedName;
	}
	
	@RequestMapping(value = "modalSelect")
	@ResponseBody
	public List<Order1> modalSelect(Model model) {
		System.out.println("QnaController qnaCleintWritePro Start...");
		Order1 order1 = new Order1();
		order1.setMem_id("park0505");
		List<Order1> orderList = qs.orderList(order1);
		/* model.addAttribute("orderList", orderList); */
		return orderList;
	}
	
	@RequestMapping(value = "qnaClientUpdatePro" , method = RequestMethod.POST)
	public String qnaClientUpdatePro(Qna qna, HttpServletRequest request, MultipartFile file1, Model model) throws IOException {
		System.out.println("QnaController qnaClientUpdatePro Start...");
		int result = 0;
		System.out.println("Qnacontroller qnaClientUpdatePro file1-->"+file1);
		if(file1.getSize() == 0) {
			System.out.println("Qnacontroller qnaClientUpdatePro file1-->"+file1);
			System.out.println("QnaController qnaCleintUpdatePro qna.getQ_image -->"+qna.getQ_image());
			result = qs.qnaClientUpdatePro(qna);
		}else {
			String uploadPath = request.getSession().getServletContext().getRealPath("/");
			String deleteFileName = uploadPath + qna.getQ_image();
			System.out.println("QnaController qnaClientUpdatePro deleteFileName -->"+deleteFileName);
			int delResult = upFileDelete(deleteFileName);
			System.out.println("QnaController qnaClientUpdatePro delResult-->"+delResult);
			
			String uploadPath2 = request.getSession().getServletContext().getRealPath("/upload/");
			logger.info("originalName : "+file1.getOriginalFilename());
			logger.info("size : "+file1.getSize());
			logger.info("contentType : "+file1.getContentType());
			logger.info("uploadPath : "+uploadPath);
			String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath2);
			logger.info("savedName : "+savedName);
			qna.setQ_image("upload/"+savedName);
			result = qs.qnaClientUpdatePro(qna);
		}
			
		model.addAttribute("result", result);
		model.addAttribute("qna", qna);
		return "forward:qnaClientContent";
		
	}
	
	private int upFileDelete(String deleteFileName) {
		int result = 0;
		logger.info("upFileDelete result-->"+deleteFileName);
		File file = new File(deleteFileName);
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("파일 삭제 성공");
				result = 1;
			}else {
				System.out.println("파일 삭제 실패");
				result = 0;
			}
		}else {
			System.out.println("파일이 존재하지 않습니다.");
			result = -1;
		}
		return result;                                                                              
	}
	
	@RequestMapping(value = "qnaAdminList")
	public String qnaAdminList(Qna qna, HttpServletRequest request, String currentPage, Model model) {
		System.out.println("QnaController qnaAdminList Start...");
		String mem_id = (String) request.getSession().getAttribute("mem_id");
		int adminCheck = qs.adminCheck(mem_id);
		System.out.println("QnaController qnaAdminList adminCheck -->"+adminCheck);
		if(adminCheck == 1) {
			int total = qs.qnaAdminListCnt(qna);
			System.out.println("QnaController qnaClientList total-->"+total);
			Paging page = new Paging(total, currentPage);
			qna.setStart(page.getStart());
			qna.setEnd(page.getEnd());
			List<Qna> qnaList = qs.qnaAdminList(qna);
			System.out.println("QnaController qnaAdminList adminCheck-->"+qnaList.size());
			model.addAttribute("qnaList", qnaList);
			model.addAttribute("total", total);
			model.addAttribute("page", page);
		}
		return "cr/qnaAdminList";
	}
	
	@RequestMapping(value = "qnaAdminReply", method = RequestMethod.POST)
	public String qnaAdminReply(Qna qna, HttpServletRequest request, Model model) {
		System.out.println("QnaController qnaAdminList Start...");
		int result = qs.qnaAdminReply(qna);
		model.addAttribute("result", result);
		return "forward:qnaClientContent";
	}
}
