package com.example.board.model;

import com.example.common.paging.CommonVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    작성자 : 김소진
    작성일 : 2022-04-19
    내용 : 게시판 목록 출력을 위함
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardSummaryVo extends CommonVo {
    private int boardNo;  // 게시판 번호
    private String groupName;  // 속할 게시판 그룹명
    private String title;  // 게시판 이름
    private String type;  //게시판 유형 (basic/review “자유게시판/리뷰게시판”)
    private Integer usePhoto; //사진 첨부 사용여부 (1 : on, 0: off)
    private Integer useVideo; // 동영상 첨부 사용여부 (1 : on, 0: off)
    private Integer useFile; // 파일 첨부 사용여부 (1 : on, 0: off)
    private Integer useComment;  // 댓글 사용여부 (1 : on, 0: off)
    private String creatDatetime; // 게시판 생성 일시
    private int postCount; //게시판 내 게시글 개수
    private int boGrade; //게시판 접근 등급
}
	 
 
