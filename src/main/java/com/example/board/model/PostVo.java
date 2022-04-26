package com.example.board.model;

import com.example.member.model.MemberVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    private BoardGroupVo boardGroupInfo;  // 게시판 그룹명을 가져오기 위한 게시판 그룹 객체
    @NotNull(message = "[개발자] 게시판 번호가 누락되었습니다.")
    private int boardNo;
    private BoardVo boardInfo;  // 게시판이름을 가져오기 위한 게시판 객체

    @NotEmpty(message = "게시글 제목을 입력하세요.")
    private String subject;

    @NotEmpty(message = "게시글 내용을 입력하세요.")
    private String content;
    private int writerNo;
    private MemberVo memberInfo;  // 실시간 회원닉네임을 가져오기 위한 회원 객체
    //private String nick;

    private String tag;
    private String[] tags;
    private int views;
    private int comment;
    //private List<CommentVo> commentVoList;
    private String createDate;
    private String createDateTime;
    private int blind;
    private String thumb;

    //private boolean open; //ready, open
}
