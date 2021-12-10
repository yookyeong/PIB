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
	
	@RequestMapping(value = "qnaClientList")
	public String qnaClientList(HttpServletRequest request, String currentPage, Model model) {
		System.out.println("QnaController qnaClientList Start...");
		Qna qna = new Qna();
//		qna.setMem_id(request.getSession().getId());
		qna.setMem_id("park0505");
		int total = qs.qnaListAll(qna);
		System.out.println("QnaController qnaClientList total-->"+total);
		Paging page = new Paging(total, currentPage);
		qna.setStart(page.getStart());
		qna.setEnd(page.getEnd());
		List<Qna> qnaList = qs.qnaClientList(qna);
//		System.out.println("QnaController qnaClientList qnaList.size()-->"+qnaList.size());
		model.addAttribute("total", total);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("page", page);
		return "cr/qnaClientList";
	}
	
	
	@RequestMapping(value = "qnaClientWriteForm")
	public String qnaClientWriteForm(HttpServletRequest request, Model model) {
		System.out.println("QnaController qnaClientWriteForm Start...");
		
		List<Qna> qMcodeList = qs.selectQmcode();
		model.addAttribute("qMocodeList", qMcodeList);
		/* model.addAttribute("orderList", orderList); */
		return "cr/qnaClientWriteForm";
	}

	@RequestMapping(value = "qnaClientContent")
	public String qnaClientContent(Qna qna, Model model, HttpServletRequest request) {
		System.out.println("QnaController qnaClientContent Start...");
//		String adminId = request.getSession().getId();
		String adminId = "jeyun0224";
		int adminCheck = qs.adminCheck(adminId);
		System.out.println("QnaController qnaAdminList adminCheck -->"+adminCheck);
		qna.setMem_id("park0505");
		Qna qnaContent = qs.qnaClientContent(qna);
		System.out.println("QnaController qnaClientContent qna.getQ_num() -->"+qnaContent.getQ_num());
		model.addAttribute("qna", qnaContent);
		return "cr/qnaClientContent";
	}
	
	@RequestMapping(value = "qnaClientWritePro", method = RequestMethod.POST)
	public String qnaClientWritePro(Qna qna, HttpServletRequest request, MultipartFile file1, Model model) throws IOException {
		System.out.println("QnaController qnaCleintWritePro Start...");
		qna.setMem_id("park0505");
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		System.out.println("uploadForm POST Start...");
		logger.info("originalName : "+file1.getOriginalFilename());
		logger.info("size : "+file1.getSize());
		logger.info("contentType : "+file1.getContentType());
		logger.info("uploadPath : "+uploadPath);
		String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
		logger.info("savedName : "+savedName);
		qna.setQ_image("upload/"+savedName);
		int result = qs.qnaClientWrite(qna);
		model.addAttribute("result", result);
		return "forward:qnaClientList";
	}
	
	@RequestMapping(value = "qnaClientUpdateForm")
	public String qnaClientUpdateForm(Qna qna, Model model) {
		System.out.println("QnaController qnaClientUpdateForm Start...");
		qna.setMem_id("park0505");
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
			String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
			String deleteFileName = uploadPath + qna.getQ_image().substring(7);
			System.out.println("QnaController qnaClientUpdatePro deleteFileName -->"+deleteFileName);
			int delResult = upFileDelete(deleteFileName);
			System.out.println("QnaController qnaClientUpdatePro delResult-->"+delResult);
			
			logger.info("originalName : "+file1.getOriginalFilename());
			logger.info("size : "+file1.getSize());
			logger.info("contentType : "+file1.getContentType());
			logger.info("uploadPath : "+uploadPath);
			String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
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
		//String mem_id = request.getSession().getId();
		String mem_id = "jeyun0224";
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
}
