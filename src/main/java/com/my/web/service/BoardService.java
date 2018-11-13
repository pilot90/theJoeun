/*
 * 게시판의 기능(등록,조회,수정,삭제)을 구현 할 Service interface 작성
 */

package com.my.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.my.web.domain.BoardVO;
import com.my.web.domain.PageDTO;

public interface BoardService {
	 
    /**
     * 게시물 리스트 조회
     * @return List<BoardVO>
     * @throws Exception
     */
    public List<BoardVO> selectBoardList() throws Exception;
    
    /**
     * 게시물 페이지별 리스트 조회
     * @param PageDTO
     * @return List<BoardVO>
     * @throws Exception
     */
    public List<BoardVO> selectBoardListByPage(PageDTO dto) throws Exception;
    
    /**
     * 총 게시글 수
     * @return int
     * @throws Exception
     */
    public int countBoard() throws Exception;
    
    /**
     * 게시물 작성
     * @param boardVO
     * @throws Exception
     */
    public void insertBoard(BoardVO boardVO) throws Exception;
    
    /**
     * 게시물 수정
     * @param boardVO
     * @throws Exception
     */
    public void updateBoard(BoardVO boardVO) throws Exception;
    
    /**
     * 게시물 삭제
     * @param code
     * @throws Exception
     */
    public void deleteBoard(Integer code) throws Exception;
 
    /**
     * 게시글 조회
     * @param code
     * @return
     * @throws Exception
     */
    public BoardVO selectBoardByCode(Integer code) throws Exception;
       
}
