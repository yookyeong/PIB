package com.oracle.s20210902.jy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210902.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSession session; 
	
	// select 로그인 유저 정보
	@Override
	public List<Member> selectMemberForLogin(Member member) {
		List<Member> MemberList = null;
		System.out.println("MemberDaoImpl.selectMemberForLogin Start...");
		try {
			MemberList = session.selectList("selectMemberForLogin", member);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl.selectMemberForLogin Exception : " + e.getMessage());
		}
		return MemberList;
	}

	@Override
	public List<Member> memberList(Member member) {
		System.out.println("MemberDaoImpl memberList Start...");
		List<Member> memberList = null;
		try {
			memberList = session.selectList("memberListAll", member);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl memberList Exception : " + e.getMessage());
		}
		return memberList;
	}

	@Override
	public Member userDetail(int mem_no) {
		System.out.println("MemberDaoImpl userDetail Start");
		Member member = null;
		try {
			member = session.selectOne("userDetail", mem_no);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl userDetail Exception : " + e.getMessage());
		}
		return member;
	}

	@Override
	public int update(Member member) {
		System.out.println("MemberDaoImpl update Start");
		int result = 0;
		try {
			result = session.update("MemberDao.update", member);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl update Exception : " + e.getMessage());
		}																				
		return result;
	}

	@Override
	public int delete(int mem_no) {
		System.out.println("MemberDaoImpl delete Start");
		int result = 0;
		try {
			result = session.delete("delete", mem_no);
			System.out.println("MemberDaoImpl delete result->"+result);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl delete Exception : " + e.getMessage());
		}
		return result;
	}

	@Override
	public int register(Member member) {
		System.out.println("MemberDaoImpl register Start");
		int result = 0;
		try {
			result = session.insert("register", member);
			System.out.println("MemberDaoImpl register result->"+result);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl register Exception : " + e.getMessage());
			
		}
		return result;
	}

	@Override
	public int idCheck(String memId) {
		return session.selectOne("idCheck", memId);
	}

	@Override
	public String findId(Member member) {
		return session.selectOne("findId", member);
	}

	@Override
	public String findPw(Member member) {
		return session.selectOne("findPw", member);
	}

	@Override
	public int managerDelete(Member member) {
		return session.update("managerDelete", member);
	}

	@Override
	public int managerRestore(Member member) {
		return session.update("managerRestore", member);
	}
}
