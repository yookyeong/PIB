package com.oracle.s20210902.cr.service;

import java.util.List;

import com.oracle.s20210902.model.Order1;
import com.oracle.s20210902.model.Qna;

public interface QnaService {
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

	int qnaAdminReply(Qna qna);

	int qnaAdminReadContent(Qna qna);

	int qnaReplyStatusCheck(Qna qna);





}
