package com.example.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/*
    작성자 : 김소진
    작성일 : 2022-04-19
    내용 : 게시글
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostVo {
    @NotNull(message = "[개발자] 게시글 번호가 누락되었습니다.")
    private int postNo;
    private String groupName;

    @NotNull(message = "[개발자] 게시판 번호가 누락되었습니다.")
    private int boardNo;
    private String boardTitle;

    @NotEmpty(message = "게시글 제목을 입력하세요.")
    private String subject;

    @NotEmpty(message = "게시글 내용을 입력하세요.")
    private String content;
    private int writerNo;
    private String writerNick;
    private String tag;
    private String[] tags;
    private int views;
    private int commont;
    private List<CommentVo> commentVoList;
    private String createDate;
    private int blind;

    private boolean open; //ready, open
}
