package com.oracle.s20210902.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Qna {
	// db column
	private String mem_id;
	private int q_num;
	private int p_code;
	private int p_size;
	private String q_content;
	private String q_image;
	private String q_reply;
	private int q_re_status;
	private Date q_date;
	private int q_bocde;
	private int q_mcode;
	
	// common column
	private int bcode;
	private int mcode;
	private String content;
		
	// 조회용
	private int rn;
	private String pageNum;
	private int start;
	private int end;	//paging
	
	//product
	private String p_name;
	private String size_name;
	
	
}
