package com.oracle.s20210902.jm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public int total() {
		int tot = 0;
		System.out.println("noticeDaoImpl total Start ..." );
		try {
			//    Mapper    ------>   Map ID (Naming Rule)
			tot = session.selectOne("jmNoticeTotal");
		} catch (Exception e) {
			System.out.println("noticeDaoImpl total Exception->"+e.getMessage());
		}
		
		return tot;
	}

	@Override
	public List<Notice> listNotice(Notice notice) {
		List<Notice> noticeList = null;
		System.out.println("noticeDaoImpl listnotice Start ..." );
		try {
			// 일반적                           Naming Rule 
			 noticeList = session.selectList("jmNoticeListAll", notice);
			// <> != >= <=
			// noticeList = session.selectList("jmNoticeListAll2", notice);
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl listNotice Exception->"+e.getMessage());
		}
		return noticeList;
	}

	@Override
	public Notice noticeDetail(int n_num) {
		System.out.println("NoticeDaoImpl detail start..");
		Notice notice = new Notice();
		try {
			//                       mapper ID   ,    Parameter
			notice = session.selectOne("jmNoticeSelOne",    n_num);
			System.out.println("NoticeDaoImpl detail getN_num->"+notice.getN_num());
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl detail Exception->"+e.getMessage());
		}
	return notice;
	}

	@Override
	public int noticeUpdate(Notice notice) {
		System.out.println("NoticeDaoImpl update start..");
		int kkk = 0;
		try {
			kkk  = session.update("jmNoticeUpdate",notice);
		} catch (Exception e) {
			System.out.println("noticeDaoImpl update Exception->"+e.getMessage());
		}
		return kkk;
	}

	// notice 관리자만 Select
	@Override
	public List<Notice> noticeListManager() {
		List<Notice> noticeList = null;
		System.out.println("NoticeDaoImpl NoticelistManager Start ..." );
		try {
			// Naming Rule 
			noticeList = session.selectList("jmSelectManager");
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl listManager Exception->"+e.getMessage());
		}
		return noticeList;	
	}

	@Override
	public int noticeInsert(Notice notice) {
		int result = 0;
		System.out.println("NoticeDaoImpl insert Start ..." );
		try {
			result = session.insert("insertNotice",notice);
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl insert Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int noticeDelete(int n_num) {
		System.out.println("NoticeDaoImpl update start..");
		int result = 0;
		try {
			result  = session.delete("noticeDelete",n_num);
			System.out.println("NoticeDaoImpl delete result->"+result);
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl delete Exception->"+e.getMessage());
		}

		return result;
	}

}
