package com.my.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.my.web.domain.BoardVO;
import com.my.web.domain.PageDTO;
import com.my.web.domain.QnaVO;

@Repository
public class QnaDAOImpl implements QnaDAO {

	@Inject
	private SqlSession session;
	private static String namespace = "com.my.web.mapper.QnaMapper";
	
	@Override
	public List<QnaVO> selectBoardList() throws Exception {
		return session.selectList(namespace + ".selectBoardList");
	}

	@Override
	public List<QnaVO> selectBoardListByPage(PageDTO dto) throws Exception {
		return session.selectList(namespace + ".selectBoardListByPage", dto);
	}

	@Override
	public int countBoard() throws Exception {
		return session.selectOne(namespace + ".countBoard");
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		session.insert(namespace+ ".insertBoard", boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		session.update(namespace+".updateBoard", boardVO);
	}

	@Override
	public void deleteBoard(Integer code) throws Exception {
		session.delete(namespace + ".deleteBoard", code);
	}

	@Override
	public QnaVO selectBoardByCode(Integer code) throws Exception {
		return session.selectOne(namespace + ".selectBoardByCode", code);
	}

	@Override
	public void updateViewCnt(Integer code) throws Exception {
		session.update(namespace + ".updateViewCnt", code);
	}

	@Override
	public void insertAnswer(QnaVO boardVO) throws Exception {
		session.insert(namespace + ".insertAnswer", boardVO);
	}

	@Override
	public void upSequance(Integer group, Integer seq) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 두개 이상의 인자를 하나의 파라메터로 넘기기 위해
		paramMap.put("group", group);
		paramMap.put("seq", seq);
		session.update(namespace + ".upSequance", paramMap);
	}
	
	@Override
	public void updateReplyCnt(Integer code, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("code", code);
		paramMap.put("amount", amount);
		session.update(namespace + ".updateReplyCnt", paramMap);
	}

	@Override
	public int getCode(Integer code) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
