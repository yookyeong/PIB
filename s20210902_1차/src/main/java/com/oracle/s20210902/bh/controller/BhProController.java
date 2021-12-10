package com.oracle.s20210902.bh.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.s20210902.bh.service.BhProService;
import com.oracle.s20210902.common.service.Paging;
import com.oracle.s20210902.model.Product;
import com.oracle.s20210902.model.Review;

@Controller
public class BhProController {
	private static final Logger logger = LoggerFactory.getLogger(BhProController.class);
	@Autowired
	private BhProService ps;
	
	@RequestMapping(value = "bhPro")
	public String bhPro(Product pro, String currentPage, Model model) {
		System.out.println("BhProController bhProAll Start...");
		
		int total = ps.total(pro);
		System.out.println("BhProController total=>" + total);
		Paging pg = new Paging(total, currentPage);
		pro.setStart(pg.getStart());
		pro.setEnd(pg.getEnd());
		System.out.println("BhProController bhPro getEndPage()->" + pg.getEndPage());
		
		List<Product> listPro = ps.listPro(pro);
		System.out.println("BhProController bhPro listPro.size()->" + listPro.size());
		int p_c_mcode = listPro.get(0).getP_c_mcode();
		
		model.addAttribute("total",   total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg",      pg);
		return "bh/bhProAll";	
	}
	
	@RequestMapping(value = "bhProT")
	public String bhProT(Product pro, String currentPage, Model model) {
		System.out.println("BhProController bhProTop Start...");
		pro.setP_c_mcode(210);
		int total = ps.total(pro);
		System.out.println("BhProController total=>" + total);
		Paging pg = new Paging(total, currentPage);
		pro.setStart(pg.getStart());
		pro.setEnd(pg.getEnd());
		System.out.println("BhProController bhProT getEndPage()->" + pg.getEndPage());
		
		List<Product> listPro = ps.listPro(pro);
		System.out.println("BhProController bhProT listPro.size()->" + listPro.size());
		int p_c_mcode = listPro.get(0).getP_c_mcode();
		
		model.addAttribute("total",   total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg",      pg);
		return "bh/bhProTop";	
	}
	
	@RequestMapping(value = "bhProB")
	public String bhProB(Product pro, String currentPage, Model model) {
		System.out.println("BhProController bhProBottom Start...");
		pro.setP_c_mcode(220);
		int total = ps.total(pro);
		System.out.println("BhProController total=>" + total);
		Paging pg = new Paging(total, currentPage);
		pro.setStart(pg.getStart());
		pro.setEnd(pg.getEnd());
		System.out.println("BhProController bhProB getEndPage()->" + pg.getEndPage());
		
		List<Product> listPro = ps.listPro(pro);
		System.out.println("BhProController bhProB listPro.size()->" + listPro.size());
		int p_c_mcode = listPro.get(0).getP_c_mcode();
		
		model.addAttribute("total",   total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg",      pg);
		return "bh/bhProBottom";	
	}
	
	@RequestMapping(value = "bhProS")
	public String bhProS(Product pro, String currentPage, Model model) {
		System.out.println("BhProController bhProShoe Start...");
		pro.setP_c_mcode(240);
		int total = ps.total(pro);
		System.out.println("BhProController total=>" + total);
		Paging pg = new Paging(total, currentPage);
		pro.setStart(pg.getStart());
		pro.setEnd(pg.getEnd());
		System.out.println("BhProController bhProS getEndPage()->" + pg.getEndPage());
		
		List<Product> listPro = ps.listPro(pro);
		System.out.println("BhProController bhProS listPro.size()->" + listPro.size());
		int p_c_mcode = listPro.get(0).getP_c_mcode();
		
		model.addAttribute("total",   total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg",      pg);
		return "bh/bhProShoe";	
	}
	
	@RequestMapping(value = "bhProA")
	public String bhProA(Product pro, String currentPage, Model model) {
		System.out.println("BhProController bhProAce Start...");
		pro.setP_c_mcode(230);
		int total = ps.total(pro);
		System.out.println("BhProController total=>" + total);
		Paging pg = new Paging(total, currentPage);
		pro.setStart(pg.getStart());
		pro.setEnd(pg.getEnd());
		System.out.println("BhProController bhProA getEndPage()->" + pg.getEndPage());
		
		List<Product> listPro = ps.listPro(pro);
		System.out.println("BhProController bhProA listPro.size()->" + listPro.size());
		int p_c_mcode = listPro.get(0).getP_c_mcode();
		
		model.addAttribute("total",   total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg",      pg);
		return "bh/bhProAce";	
	}
	
	@GetMapping(value = "bhDetail")
	public String bhDetail(int p_code, Model model) {
		System.out.println("BhProController Start bhProDetail...");
		Product pro = ps.bhDetail(p_code);
		model.addAttribute("product", pro);
		return "bh/bhProDetail";
	}
	@GetMapping(value = "reviewForm")
	public String reviewForm(Model model) {
		System.out.println("BhProController Start reviewForm...");
		return "bh/bhReviewForm";
	}
	
	@GetMapping(value = "reviewChange")
	public String reviewChange(Model model) {
		System.out.println("BhProController Start reviewForm...");
		return "bh/bhReviewChange";
	}
	
	@RequestMapping(value = "bhReviewWrite", method = RequestMethod.POST)
		public String bhReviewWrite( HttpServletRequest request, Review review, MultipartFile file1, Model model ) 
			  throws Exception {
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		
		System.out.println("uploadForm POST Start");
		logger.info("originalName: " + file1.getOriginalFilename());
	    logger.info("size: " + file1.getSize());
	    logger.info("contentType: " + file1.getContentType());
	    logger.info("uploadPath: " + uploadPath);
	    String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
	    logger.info("savedName: " + savedName);
	    review.setR_img(savedName);
	    int result = ps.bhReviewWrite(review);
	    model.addAttribute("savedName", savedName);
	    return "bh/bhProDetail";
	  }	 
	
	  private String uploadFile(String originalName, byte[] fileData , String uploadPath) 
			  throws Exception {
	     UUID uid = UUID.randomUUID();
	     System.out.println("uploadPath->"+uploadPath);
	     // Directory 생성      --->  java.io.File
		 File fileDirectory = new File(uploadPath);
		 if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			System.out.println("업로드용 폴더 생성 : " + uploadPath);
		 }
		 String savedName = uid.toString() + "_" + originalName;
	     logger.info("UUID savedName: " + savedName);
	     File target = new File(uploadPath, savedName);
	     FileCopyUtils.copy(fileData, target);   // org.springframework.util.FileCopyUtils
	    
	    return savedName;
	  }	 
	
}
