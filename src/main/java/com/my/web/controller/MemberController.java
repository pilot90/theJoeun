package com.my.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.web.domain.LoginDTO;
import com.my.web.domain.MemberVO;
import com.my.web.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registGET() throws Exception {
		return "member/registForm";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String registPOST(MemberVO memberVo, Model model) throws Exception {
		memberService.registerMember(memberVo);
		
		// TODO : 로그인 처리
		model.addAttribute("member", memberVo);
		
		return "member/registResult";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET() throws Exception {
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(LoginDTO dto, HttpServletRequest request) throws Exception{
		//System.out.println(dto.toString());
		MemberVO vo = memberService.loginMember(dto);
		if(vo == null) { 
			return "redirect:/member/login";
		}
		HttpSession session = request.getSession(); // 세션에다 로그인 정보 넣기
		session.setAttribute("login", vo);
		return "redirect:/qna/list";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		// session.invalidate(); // 세션 정보 싸그리 삭제
		MemberVO  vo = (MemberVO) session.getAttribute("login");
		if(vo == null ) { 
			return "redirect:/board/list.do";
		}
		session.removeAttribute("login"); // 세션에 로그인 정보 삭제.
		return "redirect:/qna/list";
	}
	
	// AJAX 처리
	@ResponseBody
	@RequestMapping(value="/duplicate/{mbrId}", method=RequestMethod.POST)
	public ResponseEntity<String> duplicateId(@PathVariable("mbrId") String mbrId) throws Exception {
		ResponseEntity<String> entity = null;
		try {
			if(memberService.duplicateId(mbrId)) { // 아이디 중복 되는 경우
				entity = new ResponseEntity<String>("DUPLICATED", HttpStatus.OK);
			} else  { // 사용가능한 경우
				entity = new ResponseEntity<String>("AVAILEABLE", HttpStatus.OK);
			}
		} catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
