package com.my.web.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.my.web.dao.QnaDAO;
import com.my.web.domain.BoardVO;
import com.my.web.domain.PageDTO;
import com.my.web.domain.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {

	@Inject
	private QnaDAO dao;
	
	@Override
	public List<QnaVO> selectBoardList() throws Exception {
		return dao.selectBoardList();
	}

	@Override
	public List<QnaVO> selectBoardListByPage(PageDTO dto) throws Exception {
		return dao.selectBoardListByPage(dto);
	}

	@Override
	public int countBoard() throws Exception {
		return dao.countBoard();
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		dao.insertBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		dao.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(Integer code) throws Exception {
		dao.deleteBoard(code);
	}

	@Override
	public QnaVO selectBoardByCode(Integer code) throws Exception {
		dao.updateViewCnt(code);
		return dao.selectBoardByCode(code);
	}

	// @Transactional
	@Override // 트렌젝션
	public void insertAnswer(QnaVO boardVO) throws Exception {
		dao.upSequance(boardVO.getGroup(), boardVO.getSeq());
		dao.insertAnswer(boardVO);
	}
}