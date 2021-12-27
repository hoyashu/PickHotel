package com.example.board;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class PostVo {
    //@NotNull(message = "게시글 번호를 정확히 해주세요.")
    private int postNo;
    //@NotBlank(message = "게시판 번호를 정확히 해주세요.")
    private int boardNo;
    private String subject;
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
