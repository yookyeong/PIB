package com.oracle.s20210902.jy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.s20210902.jy.service.MemberService;
import com.oracle.s20210902.model.Member;

@Controller
public class MemberManagerController {
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping(value = "mng/list")
	public String memberDeleteAjax(Model model, Member member) {
		System.out.println("MemberManagerController MemberList Start");
		List<Member> memberList = ms.memberList(member);
		model.addAttribute("memberList", memberList);
		
		return "jy/manager/list";
	}
	
	@ResponseBody
	@PostMapping(value = "mng/delete" )
	public Map<String, Object> managerDelete(Member member, Model model) {
		System.out.println("MemberManagerController managerDelete Start");
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		int result = ms.managerDelete(member);
		//
		if(result <= 0) {
			//result의 값이 0이라는 것은 managerDelete 로직이 제대로 실행안됐다는 뜻
			rtnMap.put("code", "-1");
			return rtnMap;
		}

		
		List<Member> memberList = ms.memberList(member);
		rtnMap.put("memberList", memberList);
		
		rtnMap.put("code", "0");
		return rtnMap;
	}

	@ResponseBody
	@PostMapping(value = "mng/restore" )
	// jsp에서 post로 넘겼는데 requestMapping으로 받을수 있음? // method=RequestMethod.POST
	public Map<String, Object> managerRestore(Member member, Model model) {
		System.out.println("MemberManagerController managerRestore Start");
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		//ajax에 rtnMap에서 code값을 쓰기위해서 Map사용
		
		int result = ms.managerRestore(member);
		//
		if(result <= 0) {
			//result의 값이 0이라는 것은 managerDelete 로직이 제대로 실행안됐다는 뜻
			rtnMap.put("code", "-1");
			return rtnMap;
		}

		
		List<Member> memberList = ms.memberList(member);
		rtnMap.put("memberList", memberList);
		
		rtnMap.put("code", "0");
		return rtnMap;
	}
	
	@RequestMapping(value ="mng/detail")
	public String UserDetail(int mem_no, Model model) {
		System.out.println("MemberController UserDetail Start");
		Member member = ms.userDetail(mem_no);
		model.addAttribute("member", member);
		
		return "jy/manager/detail";
	}
	
	@RequestMapping(value = "mng/update")
	public String updateForm(int mem_no, Model model) {
		System.out.println("MemberController updateForm Start");
		Member member = ms.userDetail(mem_no);
		model.addAttribute("member", member);
		
		return "jy/manager/update";
	}
	
	@RequestMapping(value = "mng/detailUserDelete")
	public String managerDeleteList(Member member) {
		System.out.println("MemberController managerDeleteList Start");
		int result = ms.managerDelete(member);
		return "forward:/mng/list";
		
	}
	
	
	
}