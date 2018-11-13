package com.my.web.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.my.web.dao.MemberDAO;
import com.my.web.domain.LoginDTO;
import com.my.web.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO memberDao;
	
	@Override
	public List<MemberVO> selectMemberList() throws Exception {
		return memberDao.getMemberList();
	}

	@Override
	public void registerMember(MemberVO vo) throws Exception {
		memberDao.registerMember(vo);
	}

	@Override
	public void modifyMember(MemberVO vo) throws Exception {
		memberDao.updateMember(vo);
	}

	@Override
	public void removeMember(Integer code) throws Exception {
		memberDao.removeMember(code);
	}

	@Override
	public void removeMember(String mbrId) throws Exception {
		MemberVO member = memberDao.getMemberById(mbrId);
		memberDao.removeMember(member.getMbrCode());
	}

	@Override
	public MemberVO viewMemberInfo(Integer code) throws Exception {
		return memberDao.getMemberByCode(code);
	}

	@Override
	public MemberVO viewMemberInfo(String mbrId) throws Exception {
		return memberDao.getMemberById(mbrId);
	}

	@Override
	public boolean duplicateId(String mbrId) throws Exception {
		MemberVO vo = null;
		vo = memberDao.getMemberById(mbrId);
		if(vo != null) return true;
		return false;
	}

	@Override
	public MemberVO loginMember(LoginDTO dto) throws Exception {
		MemberVO vo = null;
		vo = memberDao.loginMember(dto);
		return vo;
	}
}
