package com.oracle.s20210902.jm.service;

import java.util.List;

import com.oracle.s20210902.model.Notice;

public interface NoticeService {
	int total();
	List<Notice> listNotice(Notice notice);
	Notice noticeDetail(int n_num);
	int noticeUpdate(Notice notice);
	List<Notice> noticeListManager();
	int noticeInsert(Notice notice);
	int noticeDelete(int n_num);

}