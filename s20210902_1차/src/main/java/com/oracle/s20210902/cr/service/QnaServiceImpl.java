package com.oracle.s20210902.cr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210902.cr.dao.QnaDao;
import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.Qna;


@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDao qd;
	
	@Override
	public List<Qna> selectQmcode() {
		System.out.println("QnaServiceImpl selectQmcode Start...");
		List<Qna> qMcodeList = qd.selectQmcode();
		return qMcodeList;
	}

	@Override
	public List<Qna> qnaClientList(Qna qna) {
		System.out.println("QnaServiceImpl qnaClientList Start...");
		List<Qna> qnaList = qd.qnaClientList(qna);
		return qnaList;
	}

	@Override
	public int qnaListAll(Qna qna) {
		System.out.println("QnaServiceImpl qnaListAll Start...");
		int total = qd.qnaListAll(qna);
		return total;
	}

	@Override
	public Qna qnaClientContent(Qna qna) {
		System.out.println("QnaServiceImpl qnaClientContent Start...");
		Qna qnaContent = qd.qnaClientContent(qna);
		return qnaContent;
	}

	@Override
	public int qnaClientWrite(Qna qna) {
		System.out.println("QnaServiceImpl qnaClientWrite Start...");
		int result = qd.qnaClientWrite(qna);
		return result;
	}

	@Override
	public List<Order1> orderList(Order1 order1) {
		System.out.println("QnaServiceImpl orderList Start...");
		List<Order1> orderList = qd.orderList(order1);
		return orderList;
	}

	@Override
	public List<Qna> qnaQmcodeList() {
		System.out.println("QnaServiceImpl qnaQmcodeList Start...");
		List<Qna> qnaQmcodeList = qd.qnaQmcodeList();
		return qnaQmcodeList;
	}

	@Override
	public int qnaClientUpdatePro(Qna qna) {
		System.out.println("QnaServiceImpl qnaClientUpdatePro Start...");
		int result = qd.qnaClientUpdatePro(qna);
		return result;
	}

	@Override
	public int adminCheck(String mem_id) {
		System.out.println("QnaServiceImpl adminCheck Start...");
		int adminCheck = qd.adminCheck(mem_id);
		return adminCheck;
	}

	@Override
	public List<Qna> qnaAdminList(Qna qna) {
		System.out.println("QnaServiceImpl qnaAdminList Start...");
		List<Qna> qnaAdminList = qd.qnaAdminList(qna);
		return qnaAdminList;
	}

	@Override
	public int qnaAdminListCnt(Qna qna) {
		System.out.println("QnaServiceImpl qnaAdminListCnt Start...");
		int total = qd.qnaAdminListCnt(qna);
		return total;
	}
	
}
