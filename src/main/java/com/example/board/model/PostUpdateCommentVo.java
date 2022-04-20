package com.example.board.model;

import lombok.AllArgsConstructor;

/*
    작성자 : 김소진
    작성일 : 2022-04-19
    내용 : 게시글에 댓글 작성/삭제시 게시글 내 댓글 갯수 업데이트를 위함
*/

@AllArgsConstructor
public class PostUpdateCommentVo {
    private int postNo;
    private int updateComment;
}
