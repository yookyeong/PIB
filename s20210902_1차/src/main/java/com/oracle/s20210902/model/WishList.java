package com.oracle.s20210902.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishList {
	
	// 위시리스트
	private String mem_id;
	private int w_num;
	private int p_code;
	private int p_size;
	
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

}
