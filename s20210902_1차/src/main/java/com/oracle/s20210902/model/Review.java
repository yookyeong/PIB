package com.oracle.s20210902.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
	private String mem_id;
	private int r_num;
	private int p_code;
	private int p_size;
	private String r_content;
	private int r_score;
	private int reply;
	private int re_indent;
	private int re_step;
	private String r_img;
	
	
	private String search;   
	private String keyword;
	private String pageNum;  
	private int start; 		 
	private int end;

}
