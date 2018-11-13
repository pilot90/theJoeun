package com.my.web.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.my.web.domain.BoardVO;
import com.my.web.domain.PageDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
    
    @Autowired //@Inject
    private SqlSession sqlSession;
    private static String namespace = "com.my.web.mapper.BoardMapper";
    
    @Override
    public List<BoardVO> selectBoardList() throws Exception {
    	return sqlSession.selectList(namespace+".selectBoardList");
    }
    
    @Override
    public void insertBoard(BoardVO boardVO) throws Exception {
    	sqlSession.insert(namespace+ ".insertBoard", boardVO);
    }
 
    @Override
    public void updateBoard(BoardVO boardVO) throws Exception {
        sqlSession.update(namespace+".updateBoard", boardVO);
    }
 
    @Override
    public void deleteBoard(Integer code) throws Exception {
        sqlSession.delete(namespace + ".deleteBoard", code);
    }
 
    @Override
    public BoardVO selectBoardByCode(Integer code) throws Exception {
        return sqlSession.selectOne(namespace + ".selectBoardByCode", code);
    }

	@Override // 페이지
	public List<BoardVO> selectBoardListByPage(PageDTO dto) throws Exception {
		return sqlSession.selectList(namespace + ".selectBoardListByPage", dto);
	}

	@Override
	public int countBoard() throws Exception {
		return sqlSession.selectOne(namespace + ".countBoard");
	}

	@Override
	public void updateViewCnt(Integer code) throws Exception {
		sqlSession.update(namespace + ".updateViewCnt", code);
	}
}
