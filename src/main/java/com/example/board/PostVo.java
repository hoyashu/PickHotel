package com.example.board;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
@NoArgsConstructor
public class PostVo {
    @NotNull(message = "[개발자] 게시글 번호가 누락되었습니다.")
    private int postNo;

    @NotNull(message = "[개발자] 게시판 번호가 누락되었습니다.")
    private int boardNo;

    @NotEmpty(message = "게시글 제목을 입력하세요.")
    private String subject;

    @NotEmpty(message = "게시글 내용을 입력하세요.")
    private String content;
    private String createDate;
    private int writerNo;
    private String writerNick;
    private String tag;
    private int views;
    private int blind;
    private ArrayList<AttachVo> attachList = new ArrayList<AttachVo>();
    private ReviewVo review;
}
