package com.oracle.s20210902.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order1 {
	// order1
	private int o_num;
	private String o_date;
	private String o_address;
	private int o_cancel;
	
		// product 조회
		private int p_code;
		private int p_size;
		private int p_qty;
		private int p_price;
		private String p_img;
		private String p_name;
		
		// member 조회
		private String mem_id;
		private String mem_name;
		private String mem_email;
		
		// common 조회
		private String content;
		
		// 게시판 조회
		private String search;   
		private String keyword;
		private String pageNum;  
		private int start; 		
		private int end;
		
		// 가상컬럼(총금액)
		private int sumValue;
		
		// 주소받기
		private String o_accept;
		private String o_tel;
		private String text1;
		private String text2;
		private String text3;
		private String text4;
		
		// 검색
		private String q;
		
		// 장바구니
		private int c_qty;
		
		//
		private int c_num;
		
		
		
	
}
