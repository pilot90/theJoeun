package com.my.web.dao;

import java.util.List;

import com.my.web.domain.BoardVO;
import com.my.web.domain.PageDTO;
import com.my.web.domain.QnaVO;

public interface QnaDAO {
	
	/*
	 * 게시물 리스트 조회
	 * @return List<BoarVO>
	 * @throws Exception
	 */
	public List<QnaVO> selectBoardList() throws Exception;
	
	/*
	 * 페이지별 리스트
	 * @return List<BoarVO>
	 * @throws Exception
	 */
	public List<QnaVO> selectBoardListByPage(PageDTO dto) throws Exception;
	
	/*
	 * 총 게시글 수
	 * @return int
	 * @throws Exception
	 */
	public int countBoard() throws Exception;
	
	/*
	 * 게시물 등록
	 * @param boardVO
	 * @throws Exception
	 */
	public void insertBoard(BoardVO boardVO) throws Exception;
	 
	/*
	 * 게시물 수정
	 * @param boardVO
	 * @throws Exception
	 */
	public void updateBoard(BoardVO boardVO) throws Exception;
	 
	/*
	 * 게시물 삭제
	 * @param code
	 * @throws Exception
	 */
	public void deleteBoard(Integer code) throws Exception;
	 
	/*
	 * 게시물 조회
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public QnaVO selectBoardByCode(Integer code) throws Exception;
	
	/*
	 * 조회수 증가
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public void updateViewCnt(Integer code) throws Exception;
	
	/*
	 * 답글 게시물 등록
	 * @param QnaVO
	 * @throws Exception
	 */
	public void insertAnswer(QnaVO boardVO) throws Exception;
	
	/*
	 * 답글 순서 업데이트
	 * @param int group
	 * @param int seq
	 * @throws Exception
	 */
	public void upSequance(Integer group, Integer seq) throws Exception;
	
	/*
	 * 댓글 수 업데이트
	 * @param int code
	 * @param int amount
	 * @throws Exception
	 */
	public void updateReplyCnt(Integer code, int amount) throws Exception;
	
	/*
	 * 댓글 삭제될 떄 해당 게시물 번호를 알아내는 기능
	 * @param int group
	 * @param int seq
	 * @throws Exception
	 */
	public int getCode(Integer code) throws Exception;
}

