package com.oracle.s20210902.dh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.s20210902.dh.service.ReviewService;
import com.oracle.s20210902.model.Review;


@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService rs;
	
		// p_code, p_size, reply 가지고감
		@RequestMapping(value = "dhReviewForm")
		public String dhReviewForm(Review review, Model model) {
			System.out.println("BhProController dhReviewForm Start...");
			System.out.println("BhProController dhReviewForm review.getR_num()-->"+review.getR_num());
			model.addAttribute("review", review);
			return "dh/dhRevWrite";
		}
		
		// r_content, p_size, p_code 넘어옴, mem_id 세션으로 가져와서 review에 set
		@RequestMapping(value = "dhReply", method = RequestMethod.POST)
		public String dhRevW(Review review, Model model, HttpServletRequest request) {
			System.out.println("BhProController dhRevW Start...");
			String mem_id = (String) request.getSession().getAttribute("mem_id");
			System.out.println("ReviewController dhRevW review.getR_num()"+ review.getR_num());
			review.setMem_id(mem_id);
			
			int result2 = rs.insert(review);
			System.out.println("result2result2result2 -> " + result2);
			int p_code = review.getP_code();
			
			model.addAttribute("result2", result2);
			model.addAttribute("p_code", p_code);
			
			return "dh/dhReplyPro";
		}
		
		@RequestMapping(value = "dhReviewDelete")
		public String dhReviewDelete(Review review, Model model) {
			System.out.println("ReviewController dhReviewDelete Start...");
			System.out.println("ReviewController dhReviewDelete review.getP_code ->"+review.getP_code());
			System.out.println("ReviewController dhReviewDelete review.getP_size ->"+review.getP_size());
			System.out.println("ReviewController dhReviewDelete review.getR_num ->"+review.getR_num());
			int p_code = review.getP_code();
			int result = rs.delete(review);
			
			model.addAttribute("p_code", p_code);
			model.addAttribute("result", result);
			
			
			return "dh/dhReviewDeletePro";
		}

	
	

}
