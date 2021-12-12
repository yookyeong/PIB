package com.oracle.s20210902.jm.dao;

import java.util.List;

import com.oracle.s20210902.model.Notice;

public interface NoticeDao {
	int	total();  // Emp Row 수 
	List<Notice> listNotice(Notice notice);
	Notice noticeDetail(int n_num);
	int noticeUpdate(Notice notice);
	List<Notice> noticeListManager();
	int noticeInsert(Notice notice);
	int noticeDelete(int n_num);
}
