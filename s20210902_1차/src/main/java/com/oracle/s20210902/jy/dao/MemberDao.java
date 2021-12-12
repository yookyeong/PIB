package com.oracle.s20210902.jy.dao;

import java.util.List;

import com.oracle.s20210902.model.Member;

public interface MemberDao {
	// select 로그인 유저정보
	List<Member> selectMemberForLogin(Member member) ;

	List<Member> memberList(Member member);

	Member userDetail(int mem_no);

	int update(Member member);

	int delete(int mem_no);

	int register(Member member);

	int idCheck(String memId);

	String findId(Member member);

	String findPw(Member member);

	int managerDelete(Member member);

	int managerRestore(Member member);
}
