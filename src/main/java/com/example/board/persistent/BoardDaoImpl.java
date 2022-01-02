package com.example.board.persistent;

import com.example.board.model.BoardVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    //게시판 등록
    @Override
    public void insertBoard(BoardVo board) {
        this.sqlSessionTemplate.insert("BoardDao.insertBoard", board);

    }

    //게시판 수정
    @Override
    public void updateBoard(BoardVo board) {
        this.sqlSessionTemplate.update("BoardDao.updateBoard", board);

    }

    //게시판 삭제
    @Override
    public void removeBoard(int boardno) {
        this.sqlSessionTemplate.delete("BoardDao.deleteBoard", boardno);
    }


    //게시판 목록 조회
    @Override
    public List<BoardVo> selectBoardList() {
        return this.sqlSessionTemplate.selectList("BoardDao.selectBoardList");

    }

    //게시판 총목록 개수
//	@Override
//	public int selectBoardTotalCount() {
//		return this.sqlSessionTemplate.selectOne("Board.selectBoardCount");
//	}

    // 게시판 상세조회
    @Override
    public BoardVo selectBoard(int boardNo) {
        System.out.println("selectMember 실행");
        return this.sqlSessionTemplate.selectOne("BoardDao.selectBoard", boardNo);
    }

    @Override
    public int selectBoardTotalCount() {
        // TODO Auto-generated method stub
        return 0;
    }

}
