package com.oracle.s20210902.jy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.s20210902.jy.service.MemberService;
import com.oracle.s20210902.model.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping(value = "login")
	public String login(Model model) {
		System.out.println("MemberController login Start");
		return "jy/loginForm";
	}
	
	@PostMapping(value = "MemberLogin")
	@ResponseBody
	public String memberLogin(Model model, Member member, HttpServletRequest request) {
		List<Member> loginUserList = ms.selectMemberForLogin(member);
		
		if(loginUserList.size() != 1) {
			return "-1";
		}
		Member loginUser = loginUserList.get(0);
		HttpSession session = request.getSession();
		
		session.setAttribute("mem_id", loginUser.getMem_id());
		session.setAttribute("mem_name", loginUser.getMem_name());
		session.setAttribute("mem_admin", loginUser.getMem_admin());
		
		return "0";
	}
	
	@RequestMapping(value = "memberList")
	public String MemberList(Model model, Member member) {
		System.out.println("MemberController MemberList Start");
		List<Member> memberList = ms.memberList(member);
		model.addAttribute("memberList", memberList);
		
		return "jy/list";
	}
	
	@RequestMapping(value ="detail")
	public String UserDetail(int mem_no, Model model) {
		System.out.println("MemberController UserDetail Start");
		Member member = ms.userDetail(mem_no);
		model.addAttribute("member", member);
		
		return "jy/userDetail";
	}
	
	@RequestMapping(value = "updateForm")
	public String updateForm(int mem_no, Model model) {
		System.out.println("MemberController updateForm Start");
		Member member = ms.userDetail(mem_no);
		model.addAttribute("member", member);
		
		return "jy/updateForm";
	}
	
	@PostMapping(value = "update")
	public String update (Member member, Model model) {
		System.out.println("MemberController update Start...");
		
		int result = ms.update(member);
		model.addAttribute("member", result);
		
		return "forward:detail";
	}
	
	@RequestMapping(value = "delete")
	public String delete(int mem_no, Model model) {
		System.out.println("Membercontroller delete Start");
		int result = ms.delete(mem_no);
		
		return "redirect:memberList";
	}
	
	@RequestMapping(value = "register")
	public String register(Model model) {
		System.out.println("MemberController register Start");
		return "jy/registerForm";
	}
	/*
	@PostMapping(value = "register1")
	@ResponseBody
	public String register1(Member member, Model model) {
		System.out.println("MemberController register1 start");
		int rst = ms.idCheck(member.getMem_id());
		//System.out.println("-------------->" + rst);
		if(rst > 0) {
			// id 중복
			return "-1";
		}
		
		int result = ms.register(member);
		return "0";
	}
	 */
	
	@PostMapping(value = "checkId")
	@ResponseBody
	public String checkId(Member member, Model model) {
		System.out.println("MemberController checkId start");
		int rst = ms.idCheck(member.getMem_id());
		//System.out.println("-------------->" + rst);
		if(rst > 0) {
			// id 중복
			return "-1";
		}
		return "0";
	}
	

	@PostMapping(value = "register1")
	@ResponseBody
	public String register1(Member member, Model model) {
		System.out.println("MemberController register1 start");
		int result = ms.register(member);
		if(result != 1) {
			return "-1";
		}
		return "0";
	}
	
	@RequestMapping(value = "logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView("redirect:/home");
		return mv;
	}
	
	@RequestMapping(value = "find")
	public String find(Model model) {
		System.out.println("MemberController find Start");
		return "jy/findId";
	}
	
	@PostMapping(value = "findId")
	@ResponseBody
	public Map<String, String> findId(Member member, Model model) {
		System.out.println("MemberController findId Start");
		String id = ms.findId(member);
		
		Map<String, String> mapRtn = new HashMap<String, String>();
		
		if(id == null || "".equals(id)) {
			mapRtn.put("code", "-1");
			return mapRtn;
		}
		mapRtn.put("code", "0");
		mapRtn.put("id", id);
		return mapRtn;
	}

	@PostMapping(value = "findPw")
	@ResponseBody
	public String findPw(Member member, Model model) {
		System.out.println("MemberController findPw Start");
		String pwd = ms.findPw(member);
		if(pwd == null || "".equals(pwd)) {
			return "-1";
		}
		return "0";
	}
	
	
	
	
	
	
	
	
	
}

