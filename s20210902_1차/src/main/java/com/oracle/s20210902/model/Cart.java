package com.oracle.s20210902.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	
	// cart조회
	private String mem_id;
	private int c_num;
	private int p_code;
	private int p_size;
	private int c_qty;
	
	// 게시판 조회
	private String search;   
	private String keyword;
	private String pageNum;
	private int start;
	private int end;
	
	// 상품조회
	private String p_img; 
	private String p_name; 
	private int p_price;
		
	// common 조회
	private String content;
	
	// 가상컬럼(총금액)
	private int sumValue;
	
	
	
	

}
