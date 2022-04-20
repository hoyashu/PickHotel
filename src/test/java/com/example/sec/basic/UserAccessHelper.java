package com.example.sec.basic;

import com.example.board.model.PostVo;
import com.example.board.service.PostService;
import lombok.AllArgsConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AllArgsConstructor
public class UserAccessHelper {

    private final PostService postService;

    public static PostVo makePost(int writerNo, String subject, String content) {

        return PostVo.builder()
                .writerNo(writerNo)
                .open(true)
                .subject(subject)
                .content(content)
                .build();
    }

    public int createPost(int writerNo, String subject, String content) {
        return postService.addPost(makePost(writerNo, subject, content));
    }

    public void assertPost(PostVo post, int writerNo, String subject, String content) {
        //게시글이 게시글id를 가지고 있는가?
        assertNotNull(post.getPostNo());
        //게시글 생성시간은 잘 찍혔는가?
        assertNotNull(post.getCreateDate());
        //작성자no와 post에 writerNo와 같은가?
        assertEquals(writerNo, post.getWriterNo());
        //subject이 post에 subject와 같은가?
        assertEquals(subject, post.getSubject());
        //content가 post에 content와 같은가?
        assertEquals(content, post.getContent());
    }

}
