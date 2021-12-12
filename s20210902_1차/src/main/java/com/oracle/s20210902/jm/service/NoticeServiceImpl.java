package com.oracle.s20210902.jm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.jm.dao.NoticeDao;
import com.oracle.s20210902.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
		@Autowired
		private NoticeDao nd;

		@Override
		public int total() {
			System.out.println("NoticeServiceImpl Start total..." );
			int totCnt = nd.total();
			System.out.println("NoticeServiceImpl total totCnt->"+totCnt );
			return totCnt;
		}

		@Override
		public List<Notice> listNotice(Notice notice) {
			List<Notice> noticeList = null;
			System.out.println("NoticeServiceImpl listnotice Start..." );
			noticeList = nd.listNotice(notice);
			System.out.println("NoticeServiceImpl listnotice noticeList.size()->" +noticeList.size());
			
			return noticeList;
		}

		@Override
		public Notice noticeDetail(int n_num) {
			System.out.println("NoticeServiceImpl detail ...");
			Notice notice = null;
			notice = nd.noticeDetail(n_num);
			return notice;
		}

		@Override
		public int noticeUpdate(Notice notice) {
			System.out.println("NoticeServiceImpl update ...");
			int kkk = 0;
			kkk = nd.noticeUpdate(notice);
			return kkk;
		}

		// 관리자 notice만 Get
		@Override
		public List<Notice> noticeListManager() {
			List<Notice> noticeList = null;
			System.out.println("NoticeServiceImpl listManager Start..." );
			noticeList =  nd.noticeListManager();  
			System.out.println("NoticeServiceImpl listnotice noticeList.size()->" +noticeList.size());
			return noticeList;
		}


		@Override
		public int noticeInsert(Notice notice) {
			int result = 0;
			System.out.println("NoticeServiceImpl insert Start..." );
			result = nd.noticeInsert(notice);
			return result;
		}

		@Override
		public int noticeDelete(int n_num) {
			int result = 0;
			System.out.println("NoticeServiceImpl delete Start..." );
			result =  nd.noticeDelete(n_num);
			return result;
		}


	}

	
	

