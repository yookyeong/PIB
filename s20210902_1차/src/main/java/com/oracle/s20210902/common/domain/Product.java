package com.oracle.s20210902.common.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
	@Id
	private int p_code;     //상품코드
	private int p_size;     //사이즈
	private String p_name;  //상품명
	private int p_c_bcode;   //상품대분류
	private int p_c_mcode;   //상품중분류
	private int p_hit;      //조회수
	private String p_date;  //등록일
	private String p_img;   //이미지
	private int p_qty;      //수량
	private int p_price;    //가격
	
	
	// 조회용
	@Transient
	private String search;
	@Transient
	private String keyword;
	@Transient
	private String pageNum;
	@Transient
	private int start;
	@Transient
	private int end;

}
