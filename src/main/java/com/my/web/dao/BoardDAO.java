package com.my.web.dao;

import java.util.List;

import com.my.web.domain.BoardVO;
import com.my.web.domain.PageDTO;

public interface BoardDAO {
	
	/*
     * 게시물 리스트 조회
     * @return List<BoarVO>
     * @throws Exception
     */
    List<BoardVO> selectBoardList() throws Exception;
    
    /*
     * 페이지별 리스트
     * @return List<BoarVO>
     * @throws Exception
     */
    List<BoardVO> selectBoardListByPage(PageDTO dto) throws Exception;
    
    /*
     * 총 게시글 수
     * @return int
     * @throws Exception
     */
    int countBoard() throws Exception;
    
    /*
     * 게시물 등록
     * @param boardVO
     * @throws Exception
     */
    void insertBoard(BoardVO boardVO) throws Exception;
 
    /*
     * 게시물 수정
     * @param boardVO
     * @throws Exception
     */
    void updateBoard(BoardVO boardVO) throws Exception;
 
    /*
     * 게시물 삭제
     * @param code
     * @throws Exception
     */
    void deleteBoard(Integer code) throws Exception;
 
    /*
     * 게시물 조회
     * @param code
     * @return
     * @throws Exception
     */
    BoardVO selectBoardByCode(Integer code) throws Exception;
    
    /*
     * 조회수 증가
     * @param code
     * @return
     * @throws Exception
     */
    void updateViewCnt(Integer code) throws Exception;
}
