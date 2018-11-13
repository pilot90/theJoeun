package com.my.web.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.my.web.domain.LoginDTO;
import com.my.web.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.my.web.mapper.MemberMapper";

	@Override
	public List<MemberVO> getMemberList() throws Exception {
		return sqlSession.selectList(namespace +".getMemberList");
	}

	@Override
	public void registerMember(MemberVO vo) throws Exception {
		sqlSession.insert(namespace + ".registerMember", vo);		
	}

	@Override
	public MemberVO getMemberByCode(Integer code) throws Exception {
		return sqlSession.selectOne(namespace + ".getMemberByCode", code);
	}

	@Override
	public MemberVO getMemberById(String mbrId) throws Exception {
		return sqlSession.selectOne(namespace + ".getMemberById", mbrId);
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		sqlSession.update(namespace + ".updateMember", vo);
	}

	@Override
	public void removeMember(Integer code) throws Exception {
		sqlSession.delete(namespace + ".removeMember", code);
	}

	@Override
	public MemberVO loginMember(LoginDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + ".loginMember", dto);
	}

}
