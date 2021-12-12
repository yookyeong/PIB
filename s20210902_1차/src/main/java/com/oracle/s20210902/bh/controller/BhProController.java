package com.oracle.s20210902.bh.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.s20210902.bh.service.BhProService;
import com.oracle.s20210902.common.service.Paging;
import com.oracle.s20210902.kn.service.LatestProductService;
import com.oracle.s20210902.model.LatestProduct;
import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.Product;
import com.oracle.s20210902.model.Review;

@Controller
public class BhProController {
	private static final Logger logger = LoggerFactory.getLogger(BhProController.class);
	@Autowired
	private BhProService ps;
	@Autowired
	private LatestProductService lp;
	
	// 상품리스트 전체 페이지
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

		model.addAttribute("total", total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg", pg);
		model.addAttribute("sort", pro.getSort());
		return "bh/bhProAll";
	}

	// 상품 리스트 상의
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

		model.addAttribute("total", total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg", pg);
		model.addAttribute("sort", pro.getSort());
		return "bh/bhProTop";
	}

	// 상품 리스트 하의
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

		model.addAttribute("total", total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg", pg);
		model.addAttribute("sort", pro.getSort());
		return "bh/bhProBottom";
	}

	// 상품 리스트 신발
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

		model.addAttribute("total", total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg", pg);
		model.addAttribute("sort", pro.getSort());
		return "bh/bhProShoe";
	}

	// 상품 리스트 악세사리
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

		model.addAttribute("total", total);
		model.addAttribute("listPro", listPro);
		model.addAttribute("pg", pg);
		model.addAttribute("sort", pro.getSort());
		return "bh/bhProAce";
	}

	// 상픔 상세 페이지
	@RequestMapping(value = "bhDetail")
	public String bhDetail(int p_code, String currentPage, Model model, HttpServletRequest request) {
		System.out.println("BhProController Start bhProDetail...");
		String str = null;
		String mem_id = (String) request.getSession().getAttribute("mem_id");		// kn 추가
		System.out.println("BhProController bhProDetail p_code->"+p_code);			// kn 추가
		System.out.println("BhProController bhProDetail mem_id->"+mem_id);			// kn 추가
		// 상품 상세설명
		Product pro = ps.bhDetail(p_code);
		// 리뷰 리스트
		Review review = new Review();
		review.setP_code(p_code);

		int total = ps.total(review);
		System.out.println("BhProController total=>" + total);
		Paging pg = new Paging(total, currentPage);
		review.setStart(pg.getStart());
		review.setEnd(pg.getEnd());
		System.out.println("BhProController bhRev getEndPage()->" + pg.getEndPage());

		List<Review> listRev = ps.listRev(review);
		System.out.println("BhProController bhRev listRev.size()->" + listRev.size());

		System.out.println("admin id check mem_id -> " + mem_id);
		
		// 최근 본 상품 리스트 저장, 최근 본 상품 리스트 정렬( 세션 request,  p_code)					
		LatestProduct latestProduct = new LatestProduct();							// kn 추가
		latestProduct.setMem_id(mem_id);											// kn 추가
		latestProduct.setP_code(p_code);											// kn 추가
		int selectStatus = lp.selectLatestProduct(latestProduct);					// kn 추가
		if(selectStatus == 1) {														// kn 추가
			int updateStatus = lp.updateLatestProduct(latestProduct);				// kn 추가
		}else {																		// kn 추가
			int saveStatus 	= lp.insertLatestProduct(latestProduct);				// kn 추가
		}
		
		model.addAttribute("total", total);
		model.addAttribute("listRev", listRev);
		model.addAttribute("pg", pg);
		model.addAttribute("product", pro);
		return "bh/bhProDetail";
	}

	// 상품 리뷰 작성 폼
	@RequestMapping(value = "bhReviewForm")
	public String bhReviewForm(Review review, Model model) {
		System.out.println("BhProController bhReviewForm Start...");
		model.addAttribute("review", review);
		return "bh/bhRevWrite";
	}

	

	// 구매 했는지 확인하는...
	@RequestMapping(value = "getProCheck")
	@ResponseBody
	public List<Order1> getProCheck(int p_code, String mem_id) {
		System.out.println("BhProController Start getProCheck...");
		System.out.println("p_code check" + p_code);
		System.out.println("mem_id check" + mem_id);
		Order1 order = new Order1();
		order.setP_code(p_code);
		order.setMem_id(mem_id);
		List<Order1> ordered = ps.bhProExist(order);
		System.out.println("BhProController getProCheck ordered.getP_size()->" + ordered.size());
		return ordered;
	}

	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {
		UUID uid = UUID.randomUUID();
		System.out.println("uploadPath->" + uploadPath);
		// Directory 생성 ---> java.io.File
		File fileDirectory = new File(uploadPath);
		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			System.out.println("업로드용 폴더 생성 : " + uploadPath);
		}
		String savedName = uid.toString() + "_" + originalName;
		logger.info("UUID savedName: " + savedName);
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target); // org.springframework.util.FileCopyUtils

		return savedName;
	}
	
	// 상품 리뷰 작성

	@RequestMapping(value = "bhRevW", method = RequestMethod.POST)
	public String bhRevW(Review review, HttpServletRequest request, Model model, MultipartFile file1) throws Exception {
		System.out.println("BhProController Start bhRevW...");
		review.setMem_id((String) request.getSession().getAttribute("mem_id"));
		if(file1.getSize() != 0) {
			String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
			System.out.println("uploadForm POST Start");
			logger.info("originalName: " + file1.getOriginalFilename());
			logger.info("size: " + file1.getSize());
			logger.info("contentType: " + file1.getContentType());
			logger.info("uploadPath: " + uploadPath);
			String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
			logger.info("savedName: " + savedName);
			review.setR_img("upload/" + savedName);
			
			System.out.println("BhProController Start review.getMem_id()-->" + review.getMem_id());
			System.out.println("BhProController Start review.getP_code()-->" + review.getP_code());
			System.out.println("BhProController Start review.getP_size()-->" + review.getP_size());
			System.out.println("BhProController Start review.getR_content()-->" + review.getR_content());
		}else {
			System.out.println("BhProController bhReviewWrite image null Start...");
			review.setR_img("");
		}
		int result = ps.insertRev(review);
		model.addAttribute("p_code", review.getP_code());
		model.addAttribute("result", result);
		return "bh/reviewWritePro";
	}
	
	//상품 리뷰 수정 폼
	@RequestMapping(value = "bhUpdateForm")
	public String bhUpdateForm(Review review, Model model, HttpServletRequest request) {
		review.setMem_id((String)request.getSession().getAttribute("mem_id"));
		Review reviewGet = ps.selectRevGet(review);
		System.out.println("BhProController bhUpdateForm Start...");
		model.addAttribute("review", reviewGet);
		return "bh/bhRevUpDel";
	}
	
	// 상품 리뷰 수정
	@RequestMapping(value = "bhRevU", method = RequestMethod.POST)
	public String bhRevU(Review review, HttpServletRequest request, Model model, MultipartFile file1) throws Exception {
		System.out.println("BhProController Start bhRevU...");
		int result = 0;
		review.setMem_id((String) request.getSession().getAttribute("mem_id"));
		if (file1.getSize() == 0) {
			System.out.println("BhProController bhRevU review.r_img -->" + review.getR_img());
			result = ps.updateRev(review);
		} else {
			String uploadPath = request.getSession().getServletContext().getRealPath("/");
			String deleteRevImg = uploadPath + review.getR_img();
			System.out.println("uploadForm POST Start");
			int delRevImg = RevImgDel(deleteRevImg);
			System.out.println("BhProController bhRevU delRevImg-->" + delRevImg);
		
			String uploadPath2 = request.getSession().getServletContext().getRealPath("/upload/");
			logger.info("originalName: " + file1.getOriginalFilename());
			logger.info("size: " + file1.getSize());
			logger.info("contentType: " + file1.getContentType());
			logger.info("uploadPath: " + uploadPath);
			String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath2);
			logger.info("savedName: " + savedName);
			review.setR_img("upload/" + savedName);
			
			result = ps.updateRev(review);
			System.out.println("ps.update(review) result-->" + result);
		}
		
		model.addAttribute("p_code", review.getP_code());
		model.addAttribute("result", result);
		return "bh/reviewUpdatePro";
	}
	
	private int RevImgDel(String deleteRevImg) {
		int result = 0;
		logger.info("RevImgDel result-->" + deleteRevImg);
		File file = new File(deleteRevImg);
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("파일 삭제");
				result = 1;
			}else {
				System.out.println("삭제 실패");
				result = 0;
			}
		}else {
			System.out.println("파일 없음");
			result = -1;
		}
		return result;
	}

	//상품 리뷰 삭제
	@RequestMapping(value = "bhRevD")
	public String bhRevD(Review review, Model model, HttpServletRequest request) {
		System.out.println("BhProController Start reviewFormDelete...");
		review.setMem_id((String)request.getSession().getAttribute("mem_id"));
		System.out.println("BhProController reviewFormDelete review.getP_code"+review.getP_code());
		System.out.println("BhProController reviewFormDelete review.getP_size"+review.getP_size());
		System.out.println("BhProController reviewFormDelete review.getMem_id"+review.getMem_id());
		int result = ps.deleteRev(review);
		System.out.println("BhProController reviewFormDelete result-->"+result);
		model.addAttribute("p_code", review.getP_code());
		model.addAttribute("result", result);
		return "bh/reviewDeletePro";
	}
	

}
