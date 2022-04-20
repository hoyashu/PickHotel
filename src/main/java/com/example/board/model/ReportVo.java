package com.example.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportVo {
    private int no; //신고 번호
    private int reporterNo; //신고한 회원 번호
    private int postNo; //게시글 번호
    private int commentNo; // 댓글 번호
    private String type; //신고 접수 유형(“board”/”comment”)
    private String reportDate; //신고 접수 일자
}
