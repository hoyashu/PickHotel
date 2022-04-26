package com.example.board.model;

import com.example.common.paging.CommonVo;
import com.example.member.model.MemberVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    작성자 : 김소진
    작성일 : 2022-04-19
    내용 : 게시글 목록 출력 (목록을 가져올때 content객체를 가져와서 필요 이상의 작동을 제어함)
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostSummaryVo extends CommonVo {
    private int postNo;
    private int boardNo;
    private String subject;
    private int writerNo;
    //private String nick;
    private MemberVo memberInfo;  // 실시간 회원닉네임을 가져오기 위한 회원 객체

    private int views;
    private int comment;
    private String createDate;
    private String createDateTime;
    private int blind;
    private String thumb;

//    public static PostSummaryVo of(PostVo post) {
//        return PostSummaryVo.builder()
//                .postNo(post.getBoardNo())
//                .subject(post.getSubject())
//                .writerNo(post.getWriterNo())
//                .writerNo(post.getWriterNo())
//                .views(post.getViews())
//                .comment(post.getCommentVoList() == null ? 0 : post.getCommentVoList().size())
//                .createDate(post.getCreateDate())
//                .blind(post.getBlind())
//                .build();
//    }
}
