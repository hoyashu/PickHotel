package com.example.board.service;

import com.example.board.model.CommentVo;
import lombok.AllArgsConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AllArgsConstructor
public class CommentTestHelper {

    private final CommentService commentService;

    public static CommentVo makeComment(int memNo, String content) {

        return CommentVo.builder()
                .memNo(memNo)
                .content(content)
                .build();
    }

    public void createComment(int memNo, String content) {
        commentService.addComment(makeComment(memNo, content));
    }

    public void assertComment(CommentVo comment, int memNo, String content) {
        //댓글이 댓글id를 가지고 있는가?
        assertNotNull(comment.getComNo());
        //댓글 생성시간은 잘 찍혔는가?
        assertNotNull(comment.getWriteday());
        //작성자no와 comment의 memNo가 같은가?
        assertEquals(memNo, comment.getMemNo());
        //content가 comment에 content와 같은가?
        assertEquals(content, comment.getContent());
    }

}
