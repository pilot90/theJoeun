package com.my.web.dao;

import java.util.List;

import com.my.web.domain.LoginDTO;
import com.my.web.domain.MemberVO;

public interface MemberDAO {
	
	// 멤버 리스트
	public List<MemberVO> getMemberList() throws Exception;
	
	// 멤버 등록
	public void registerMember(MemberVO vo) throws Exception;
	
	// 코드로 멤버 읽어오기
	public MemberVO getMemberByCode(Integer code) throws Exception;
	
	// 아이디로 멤버 읽어오기
	public MemberVO getMemberById(String mbrId) throws Exception;
	
	// 멤버 수정
	public void updateMember(MemberVO vo) throws Exception;
	
	// 멤버 삭제
	public void removeMember(Integer code) throws Exception;
	
	// 로그인 멤버 읽어오기
	public MemberVO loginMember(LoginDTO dto) throws Exception;
}
