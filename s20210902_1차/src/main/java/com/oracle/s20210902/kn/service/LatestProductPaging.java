package com.oracle.s20210902.kn.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LatestProductPaging {
	private int currentPage = 1;
	private int rowPage = 3;
	private int pageBlock = 5;
	private int start;
	private int end;
	private int startPage;
	private int endPage;
	private int total;
	private int totalPage;
	
	public LatestProductPaging(int total, String currentPage8) {
		this.total = total;
		if (currentPage8 == null) {
			this.currentPage = 1;
		} else {
			this.currentPage = Integer.parseInt(currentPage8);			
		}
		start = (currentPage - 1) * rowPage + 1;  // 첫페이지에서 보여줄 DB상에서 rn값이 1인 글 
		end   = start + rowPage - 1;              // 첫페이지에서 보여줄 DB상에서 rn값이 10인 글 
		totalPage = (int) Math.ceil((double)total / rowPage);  // 시작시 2
		startPage = currentPage - (currentPage - 1) % pageBlock; // 시작시 1
		endPage = startPage + pageBlock - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
	}
	
}
