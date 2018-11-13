/*
 * 게시판의 기능(등록,조회,수정,삭제)을 구현 할 Service interface 작성
 */

package com.my.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.my.web.domain.LoginDTO;
import com.my.web.domain.MemberVO;

public interface MemberService {
	 
    // 회원 목록
    public List<MemberVO> selectMemberList() throws Exception;
    
    // 회원 입력
    public void registerMember(MemberVO vo) throws Exception;
    
    // 회원정보 수정
    public void modifyMember(MemberVO vo) throws Exception;
    
    // 회원 삭제
    public void removeMember(Integer code) throws Exception;
    public void removeMember(String mbrId) throws Exception;
 
    // 회원 정보 보기
    public MemberVO viewMemberInfo(Integer code) throws Exception;
    public MemberVO viewMemberInfo(String mbrId) throws Exception;
    
    // 아이디 중복체크
    public boolean duplicateId(String mbrId) throws Exception;
    
    // 로그인
    public MemberVO loginMember(LoginDTO dto) throws Exception;
    
}
