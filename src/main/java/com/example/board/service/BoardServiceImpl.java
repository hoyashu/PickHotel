package com.example.board.service;

import com.example.board.model.BoardVo;
import com.example.board.persistent.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    // 게시판 등록
    @Override
    public void insertBoard(BoardVo board) {
        this.boardDao.insertBoard(board);
    }

    // 게시판 수정
    @Override
    public void updateBoard(BoardVo board) {
        System.out.println("reviseBoard 실행");
        this.boardDao.updateBoard(board);

    }

    // 게시판 삭제
    @Override
    public void deleteBoard(int boardNo) {
        this.boardDao.removeBoard(boardNo);
    }

    // 게시판 상세 조회
    @Override
    public BoardVo selectBoard(int boardNo) {
        System.out.println("retrieveBoard 실행");
        return this.boardDao.selectBoard(boardNo);
    }

    // 게시판 수 조회
    @Override
    public int selectBoardTotalCount() {
        return this.boardDao.selectBoardTotalCount();
    }

    // 게시판 전체조회
    @Override
    public List<BoardVo> retrieveBoardList() {
        return this.boardDao.selectBoardList();
    }

}