package com.oracle.s20210902.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice {
	
	private int n_num;
	private String n_title;
	private String n_content;
	private Date n_date;
	private String n_reg_date;
	
	// 조회용
	private String search;   private String keyword;
	private String pageNum;  
	private int start; 		 private int end;
}
