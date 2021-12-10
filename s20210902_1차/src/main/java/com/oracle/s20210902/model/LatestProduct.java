package com.oracle.s20210902.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LatestProduct {
	private String 	mem_id;			// 아이디
	private int		p_code;			// 상품코드
	private String	date;			// 죄회일
	
	// 게시판 조회용
	private String search;   
	private String keyword;
	private String pageNum;  
	private int start; 		 
	private int end;
	
	// product 조회용
	private String	p_name;			//상품명
	private String	p_img;			//이미지
	private int		p_price;		//가격
	
	
}
