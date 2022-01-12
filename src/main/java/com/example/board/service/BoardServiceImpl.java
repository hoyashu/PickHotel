package com.example.board.service;

import com.example.board.model.BoardVo;
import com.example.board.persistent.BoardDao;
import com.example.common.paging.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    // 게시판 등록
    @Override
    public void registerBoard(BoardVo board) {
        this.boardDao.insertBoard(board);
    }

    // 게시판 상세 조회
    @Override
    public BoardVo retrieveBoard(int boardNo) {
        System.out.println("retrieveBoard 실행");
        return this.boardDao.selectBoard(boardNo);
    }

    //게시판 전체조회
    @Override
    public List<BoardVo> retrieveBoardList() {
        return this.boardDao.selectBoardList();
    }

    // 유형별 게시판 목록 조회
    @Override
    public List<BoardVo> retrieveBoardListByType(String type) {
        return this.boardDao.selectBoardListByType(type);
    }

    // 페이징을 위한 게시판 전체조회
    @Override
    public List<BoardVo> retrievePageBoardList(BoardVo params) {
        List<BoardVo> boardList = Collections.emptyList();

        int boardTotalCount = this.boardDao.selectPageBoardTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(boardTotalCount);
        params.setPaginationInfo(paginationInfo);

        if (boardTotalCount > 0) {
            boardList = this.boardDao.selectPageBoardList(params);
        }
        return boardList;
    }

    @Override
    public int retrieveBoardGroupCount(int groupNo) {
        return 0;
    }

    // 게시판 게시글 갯수 수정을 위한 조회
    @Override
    public int reviseBoardPost(int boardNo, int postCount) {
        return this.boardDao.updateBoardPost(boardNo, postCount);
    }

    // 게시판 수정
    @Override
    public void reviseBoard(BoardVo board) {
        this.boardDao.updateBoard(board);
    }

    // 게시판 삭제
    @Override
    public void removeBoard(int boardNo) {
        this.boardDao.removeBoard(boardNo);
    }
}
