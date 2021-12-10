package com.oracle.s20210902.cr.dao;

import java.util.List;

import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.Qna;

public interface QnaDao {

	List<Qna> selectQmcode();

	List<Qna> qnaClientList(Qna qna);

	int qnaListAll(Qna qna);

	Qna qnaClientContent(Qna qna);

	int qnaClientWrite(Qna qna);


	List<Order1> orderList(Order1 order1);

	List<Qna> qnaQmcodeList();

	int qnaClientUpdatePro(Qna qna);

	int adminCheck(String mem_id);

	List<Qna> qnaAdminList(Qna qna);

	int qnaAdminListCnt(Qna qna);



}
