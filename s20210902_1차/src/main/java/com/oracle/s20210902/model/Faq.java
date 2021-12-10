package com.oracle.s20210902.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Faq {
	// db column
	private int f_num;
	private String f_title;
	private String f_content;
	private Date f_date;
	private int q_bcode;
	private int q_mcode;
	
	// common column
	private int bcode;
	private int mcode;
	private String content;
	
	// 조회용
	private String pageNum;
	private int start;
	private int end;
}
