package com.example.board.service;

import com.example.board.model.CommentVo;

import java.util.List;

public interface CommentService {

    //	댓글 추가
    void addComment(CommentVo comment);

    //	게시글 댓글 목록 조회
    List<CommentVo> findCommentListByPostNo(int postNo);

    //	게시글 댓글 조회
    CommentVo findCommentByComNo(int comNo);

    // 마지막 댓글 pk조회
    int findCommentMax();

    // 댓글 그룹내 순서 조회
    int findCommentOrder(int parents);

    //	댓글 내용 수정
    void modifyComment(CommentVo comment);

    //	댓글삭제
    void removeComment(CommentVo comment);
}
