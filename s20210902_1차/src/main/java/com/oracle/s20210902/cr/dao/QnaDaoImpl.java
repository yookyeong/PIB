package com.oracle.s20210902.cr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.Qna;


@Repository
public class QnaDaoImpl implements QnaDao {

	@Autowired
	private SqlSession session; 
	
	@Override
	public List<Qna> selectQmcode() {
		List<Qna> qMcodeList =  null;
		System.out.println("QnaDaoImpl selectQmcode Start...");
		try {
			qMcodeList = session.selectList("crQnaSelectMcode");
		}catch (Exception e) {
			System.out.println("QnaDaoImpl selectQmcode Exception -->"+e.getMessage());
		}
		return qMcodeList;
	}

	@Override
	public List<Qna> qnaClientList(Qna qna) {
		List<Qna> qnaList =  null;
		System.out.println("QnaDaoImpl qnaClientList Start...");
		try {
			qnaList = session.selectList("crQnaClientList", qna);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaClientList Exception -->"+e.getMessage());
		}
		return qnaList;
	}

	@Override
	public int qnaListAll(Qna qna) {
		int total = 0;
		System.out.println("QnaDaoImpl qnaListAll Start...");
		try {
			total = session.selectOne("crQnaListCnt", qna);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaListAll Exception -->"+e.getMessage());
		}
		return total;
	}

	@Override
	public Qna qnaClientContent(Qna qna) {
		Qna qnaContent = null;
		System.out.println("QnaDaoImpl qnaClientContent Start...");
		try {
			String db_p_code = null;
			db_p_code = session.selectOne("crQnaSelectPcode", qna);
			if(db_p_code == null) {
				qnaContent = session.selectOne("crQnaClientContentNull", qna);
			}else {
				qnaContent = session.selectOne("crQnaClientContent", qna);
			}
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaClientContent Exception -->"+e.getMessage());
		}
		return qnaContent;
	}

	@Override
	public int qnaClientWrite(Qna qna) {
		int result = 0;
		System.out.println("QnaDaoImpl qnaClientWrite Start...");
		try {
			result = session.insert("crQnaClientInsert", qna);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaClientWrite Exception -->"+e.getMessage());
		}
		return result;
	}

	@Override
	public List<Order1> orderList(Order1 order1) {
		List<Order1> orderList =  null;
		System.out.println("QnaDaoImpl orderList Start...");
		try {
			orderList = session.selectList("crOrderList", order1);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl orderList Exception -->"+e.getMessage());
		}
		return orderList;
	}

	@Override
	public List<Qna> qnaQmcodeList() {
		List<Qna> qnaQmcodeList =  null;
		System.out.println("QnaDaoImpl qnaQmcodeList Start...");
		try {
			qnaQmcodeList = session.selectList("crQnaMcodeList");
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaQmcodeList Exception -->"+e.getMessage());
		}
		return qnaQmcodeList;
	}

	@Override
	public int qnaClientUpdatePro(Qna qna) {
		int result = 0;
		System.out.println("QnaDaoImpl qnaClientUpdatePro Start...");
		try {
			result = session.update("crQnaClientUpdatePro", qna);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaClientUpdatePro Exception -->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int adminCheck(String mem_id) {
		int adminCheck = 0;
		System.out.println("QnaDaoImpl adminCheck Start...");
		try {
			adminCheck = session.selectOne("crAdminCheck", mem_id);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl adminCheck Exception -->"+e.getMessage());
		}
		return adminCheck;
	}

	@Override
	public List<Qna> qnaAdminList(Qna qna) {
		List<Qna> qnaAdminList =  null;
		System.out.println("QnaDaoImpl qnaAdminList Start...");
		try {
			System.out.println("QnaDaoImpl qnaAdminList qna.getQ_re_status()-->"+qna.getQ_re_status());
			qnaAdminList = session.selectList("crQnaAdminList", qna);
			System.out.println("QnaDaoImpl qnaAdminList qnaAdminList.size()-->"+qnaAdminList.size());
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaAdminList Exception -->"+e.getMessage());
		}
		return qnaAdminList;
	}

	@Override
	public int qnaAdminListCnt(Qna qna) {
		int total = 0;
		System.out.println("QnaDaoImpl qnaAdminListCnt Start...");
		try {
			total = session.selectOne("crQnaAdminListCnt", qna);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaAdminListCnt Exception -->"+e.getMessage());
		}
		return total;
	}

	@Override
	public int qnaAdminReply(Qna qna) {
		int result = 0;
		System.out.println("QnaDaoImpl qnaAdminReply Start...");
		try {
			result = session.update("crQnaAdminReply", qna);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaAdminReply Exception -->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int qnaAdminReadContent(Qna qna) {
		int result = 0;
		System.out.println("QnaDaoImpl qnaAdminReadContent Start...");
		try {
			result = session.update("crQnaAdminReadContent", qna);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaAdminReadContent Exception -->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int qnaReplyStatusCheck(Qna qna) {
		int reStatus = 0;
		System.out.println("QnaDaoImpl qnaReplyStatusCheck Start...");
		try {
			reStatus = session.selectOne("crQnaReplyStatusCheck", qna);
		}catch (Exception e) {
			System.out.println("QnaDaoImpl qnaReplyStatusCheck Exception -->"+e.getMessage());
		}
		return reStatus;
	}

	

}
