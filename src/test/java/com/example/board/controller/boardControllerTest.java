package com.example.board.controller;

import com.example.board.model.AttachVo;
import com.example.board.model.PostVo;
import com.example.board.service.AttachService;
import com.example.board.service.BoardService;
import com.example.board.service.PostService;
import com.example.demo.PickHotel2Application;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.FileInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = PickHotel2Application.class)
@RunWith(SpringRunner.class)

//@WebMvcTest
//- 웹에서 테스트하기 힘든 컨트롤러를 테스트하는데 적합한다.
//- 웹상에서 요청과 응답에 대해 테스트할 수 있을 뿐만 아니라 시큐리티 혹은 필터까지 자동으로 테스트하며 수동으로 추가/삭제까지 가능하다.

@AutoConfigureMockMvc
@Slf4j
public class boardControllerTest {

    //게시글 작성
    String boardwrite = "/member/uploadFile";

    @Autowired
    FileController fileController;
    @Autowired
    PostService postService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BoardService boardService;
    @Autowired
    private AttachService attachService;

    @Nested
    @DisplayName("게시글 작성")
    class boardWrite {
        @DisplayName("일반 게시판 작성")
        @Test
        @WithUserDetails(value = "admin@java.com", userDetailsServiceBeanName = "accountService")
        public void write() throws Exception {
            // given
            //ArgumentCaptor<PostVo> postCreateRequestArgumentCaptor = ArgumentCaptor.forClass(PostVo.class);
            int boardNo = 42;
            String subject = "게시글 제목임댱!";
            String content = "content";

            PostVo post = PostVo.builder()
                    .boardNo(boardNo)
                    .subject(subject)
                    .content(content)
                    .build();


            //https://stackoverflow.com/questions/21800726/using-spring-mvc-test-to-unit-test-multipart-post-request
            MockMultipartFile firstFile = new MockMultipartFile("images", "test1.png", MediaType.IMAGE_PNG_VALUE, new FileInputStream("/Users/sojin/Pictures/me.png"));
            //MockMultipartFile secondFile = new MockMultipartFile("images", "test2.png", MediaType.IMAGE_PNG_VALUE, new FileInputStream("/Users/sojin/Pictures/me2.png"));

            //when
            mockMvc.perform(MockMvcRequestBuilders.multipart(boardwrite)
                            .file(firstFile)
                            //.file(secondFile)
                            .param("boardNo", Integer.toString(post.getBoardNo()))
                            .param("subject", post.getSubject())
                            .param("content", post.getContent())
                    )
                    .andDo(print());

            //then
            List<PostVo> all = postService.findPostListByBoard(boardNo);
            System.out.println("ddddd");
            System.out.println(all);
            assertThat(all.get(0).getBoardNo()).isEqualTo(boardNo);
            assertThat(all.get(0).getSubject()).isEqualTo(subject);
            assertThat(all.get(0).getContent()).isEqualTo(content);

            List<AttachVo> alla = attachService.retrievePostAttach(all.get(0).getPostNo());
            assertThat(alla.get(0).getFileSize()).isEqualTo(firstFile.getSize());

            //이거 어떻게 사용하는 건지 모르겠다..
            //verify(postService).addPost(postCreateRequestArgumentCaptor.capture());
            //verify(boardService).reviseBoardPost(all.get(0).getPostNo(), 1);
        }

        @DisplayName("존재하지_않는_게시글_조회")
        @Test
        @WithUserDetails(value = "admin@java.com", userDetailsServiceBeanName = "accountService")
        public void 존재하지_않는_게시글_조회() throws Exception {
            // given
            String noPage = "/board/32/post/999999";

            //when
            mockMvc.perform(get(noPage))
                    // 상태 200이 되는지 검증
                    .andExpect(status().isNotFound())
                    //rest api일때 사용 {
//                    .andExpect(jsonPath("message").exists())
//                    .andExpect(jsonPath("message").value("error"))
//                    .andExpect(jsonPath("errors[0]").exists())
//                    .andExpect(jsonPath("errors[0].field").doesNotExist())
//                    .andExpect(jsonPath("errors[0].message").exists())
//                    .andExpect(jsonPath("errors[0].message").value("해당 포스트가 존재하지 않습니다."))
                    .andDo(print());
        }
    }
}
