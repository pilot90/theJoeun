/*
 * 비즈니스 로직이 들어갈 Service 클래스 구현
 */

package com.my.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.web.dao.BoardDAO;
import com.my.web.domain.BoardVO;
import com.my.web.domain.PageDTO;

@Service
public class BoardServiceImpl implements BoardService{
    
    @Autowired
    private BoardDAO boardDao;
    
    @Override
    public List<BoardVO> selectBoardList() throws Exception {
        List<BoardVO> list = null;
        list = boardDao.selectBoardList();
        return list;
    }
 
    @Override
    public void insertBoard(BoardVO boardVO) throws Exception {
        boardDao.insertBoard(boardVO);
    }
 
    @Override
    public void updateBoard(BoardVO boardVO) throws Exception {
    	boardDao.updateBoard(boardVO);
    }
 
    @Override
    public void deleteBoard(Integer code) throws Exception {
    	boardDao.deleteBoard(code);
    }
 
    @Override
    public BoardVO selectBoardByCode(Integer code) throws Exception {
    	boardDao.updateViewCnt(code);
        BoardVO vo = boardDao.selectBoardByCode(code);        
        return vo; 
    }

	@Override
	public List<BoardVO> selectBoardListByPage(PageDTO dto) throws Exception {
		List<BoardVO> list = null;
		list = boardDao.selectBoardListByPage(dto);
		return list;
	}

	@Override
	public int countBoard() throws Exception {
		return boardDao.countBoard();
	}
		
}
