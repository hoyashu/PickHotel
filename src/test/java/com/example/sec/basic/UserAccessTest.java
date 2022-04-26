package com.example.sec.basic;

import com.example.board.model.PostVo;
import com.example.board.service.PostService;
import com.example.demo.PickHotel2Application;
import com.example.member.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = PickHotel2Application.class)
@RunWith(SpringRunner.class)

//@WebMvcTest
//- 웹에서 테스트하기 힘든 컨트롤러를 테스트하는데 적합한다.
//- 웹상에서 요청과 응답에 대해 테스트할 수 있을 뿐만 아니라 시큐리티 혹은 필터까지 자동으로 테스트하며 수동으로 추가/삭제까지 가능하다.

@AutoConfigureMockMvc
@Slf4j
public class UserAccessTest {

    //게시글 조회
    String board0detail = "/board/32/post/150";
    String board1detail = "/board/33/post/103";
    String board2detail = "/board/34/post/95";
    String board3detail = "/board/42/post/153";

    //게시글 작성
    String boardwrite = "/member/uploadFile";

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PostService postService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ObjectMapper mapper;

    //    @Test
//    @Transactional
//    public void login_success() throws Exception {
//        String username = "jake";
//        String password = "123";
//
//        MemberVo user = this.createUser(username, password);
//        mockMvc.perform(formLogin().user(user.getUsername()).password(password))
//                .andExpect(authenticated());
//    }
//
//    @Test
//    @Transactional
//    public void login_fail() throws Exception {
//        String username = "jake";
//        String password = "123";
//
//        UserAccount user = this.createUser(username, password);
//        mockMvc.perform(formLogin().user(user.getUsername()).password("12345"))
//                .andExpect(unauthenticated());
//    }
//
//    private UserAccount createUser(MemberVo member, String password) {
//        UserAccount account = new UserAccount();
//        account.setMember(member);
//        account.set(password);
//        account.setRole("USER");
//        accountService.createNew(account);
//        return account;
//    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @DisplayName("1. 누구나 메인페이지에 접근할 수 있다.")
    @Test
    @WithAnonymousUser
    public void anonymous_can_index() throws Exception {
        String resp = mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Nested
    @DisplayName("게시글 조회")
    class boardDetail {
        @Nested
        @DisplayName("비회원은")
        class anonymousUser {
            @DisplayName("비회원 게시판 글을 조회할 수 있다.")
            @Test
            @WithAnonymousUser
            public void anonymous_can_board() throws Exception {
                mockMvc.perform(get(board0detail))
                        .andDo(print())
                        // 상태 200이 되는지 검증
                        .andExpect(status().isOk())
                        .andExpect(view().name("page/post_detail"));
            }

            @DisplayName("1등급 게시판 글을 조회할 수 없고, 로그인 페이지로 리다이렉트한다.")
            @Test
            @WithAnonymousUser
            public void anonymous_cant_board() throws Exception {
                mockMvc.perform(get(board1detail))
                        .andDo(print())
                        // 상태 302이 되는지 검증
                        // 302 : 스프링 시큐리티 설정으로 인해 인증되지 않은 사용자의 요청은 이동시키때문에 발생한 오류이다.
                        // 기존의 @Test 어노테이션으로 해당 URI를 불러오면 인증이 되어있지 않기 때문에 로그인 페이지로 리다이렉트 되어 302 에러가 발생한다.
                        // 따라서 200 상태가 되어 테스트를 통과하기 위해선 해당 페이지에 인증절차를 거친뒤 진행되어야 한다.
                        .andExpect(status().is(302))
                        //리타이렉트 검증
                        .andExpect(redirectedUrl("/login"));
            }
        }

        @Nested
        @DisplayName("1등급은")
        class grade1 {
            @DisplayName("1등급 게시판 글을 조회할 수 있다.")
            @Test
            @WithUserDetails(value = "airbnb1@java.com", userDetailsServiceBeanName = "accountService")
            public void grade1_can_board() throws Exception {
                mockMvc.perform(get(board1detail))
                        .andDo(print())
                        // 상태 200이 되는지 검증
                        .andExpect(status().isOk())
                        .andExpect(view().name("page/post_detail"));
            }

            @DisplayName("2등급 게시판 글을 볼수 없으며, 등급 안내 페이지으로 포워딩한다.")
            @Test
            @WithUserDetails(value = "airbnb1@java.com", userDetailsServiceBeanName = "accountService")
            public void grade1_cant_board() throws Exception {
                mockMvc.perform(get(board2detail))
                        .andDo(print())
                        // 상태 200이 되는지 검증
                        .andExpect(status().isOk())
                        //포워딩 검증
                        .andExpect(forwardedUrl("/member/site_grade"));
            }
        }

        @Nested
        @DisplayName("2등급은")
        class grade2 {
            @DisplayName("1등급 게시판 글을 조회할 수 있다.")
            @Test
            @WithUserDetails(value = "airbnb2@java.com", userDetailsServiceBeanName = "accountService")
            public void grade2_can_board() throws Exception {
                mockMvc.perform(get(board1detail))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(view().name("page/post_detail"));
            }

            @DisplayName("3등급 게시판 글을 조회할 수 없고, 등급 안내 페이지으로 포워딩한다.")
            @Test
            @WithUserDetails(value = "airbnb2@java.com", userDetailsServiceBeanName = "accountService")
            public void grade3_can_board() throws Exception {
                mockMvc.perform(get(board3detail))
                        .andDo(print())
                        .andExpect(status().isOk())
                        //포워딩 검증
                        .andExpect(forwardedUrl("/member/site_grade"));
            }
        }

        @Nested
        @DisplayName("관리자는")
        class admin {
            @DisplayName("비회원 게시판 글을 조회할 수 있다.")
            @Test
            @WithUserDetails(value = "admin@java.com", userDetailsServiceBeanName = "accountService")
            public void admin_can_anyboard_0() throws Exception {
                String bio = "관리자는 게시판 등급에 상관없이 접근할 수 있다.";
                mockMvc.perform(get(board0detail))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(view().name("page/post_detail"));
            }

            @DisplayName("1등급 게시판 글을 조회할 수 있다.")
            @Test
            @WithUserDetails(value = "admin@java.com", userDetailsServiceBeanName = "accountService")
            public void admin_can_anyboard_1() throws Exception {
                String bio = "관리자는 게시판 등급에 상관없이 접근할 수 있다.";
                mockMvc.perform(get(board1detail))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(view().name("page/post_detail"));
            }

            @DisplayName("2등급 게시판 글을 조회할 수 있다.")
            @Test
            @WithUserDetails(value = "admin@java.com", userDetailsServiceBeanName = "accountService")
            public void admin_can_anyboard_2() throws Exception {
                String bio = "관리자는 게시판 등급에 상관없이 접근할 수 있다.";
                mockMvc.perform(get(board2detail))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(view().name("page/post_detail"));
            }
        }
//    @DisplayName("1. user로 user페이지를 접근할 수 있다.")
//    @Test
//    @WithMockUser(username = "user1", roles = {""})
//    void test_user_access_userpage() throws Exception {
//        /// 게시판 등급 1을 사용하는 boardList/33페이지를 접근하면 접근되어야 한다.
//        String resp = mockMvc.perform(get("/boardList/33"))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        SecurityMessage message = mapper.readValue(resp, SecurityMessage.class);
//        assertEquals("user page", message.getMessage());
//    }
    }

    @Nested
    @DisplayName("게시글 작성")
    class boardWrite {
        @DisplayName("일반 게시판 작성")
        @Test
        @WithUserDetails(value = "admin@java.com", userDetailsServiceBeanName = "accountService")
        public void write() throws Exception {
            // given
            String boardNo = "42";
            String title = "게시글 제ㅇㅇ목";
            String content = "content";
            //String writerNo = "4";


            //MockMultipartFile image = new MockMultipartFile("image", "image.png", "image/png", "<<png data>>" .getBytes());
            MockMultipartFile image = new MockMultipartFile("image", "", "multipart/form-data", "{\"image\": \"Users\\sojin\\Downloads\\testimg.JPG\"}" .getBytes());

            File fis = new File("/Users/sojin/Downloads/testimg.JPG");
            FileInputStream fi1 = new FileInputStream(fis);
            MockMultipartFile file = new MockMultipartFile("file", fis.getName(), "multipart/form-data", fi1);

            //when
//            mockMvc.perform(MockMvcRequestBuilders.fileUpload(boardwrite)
//                    .file(file) //(post(boardwrite)
//                    .param("boardNo", boardNo)
//                    .param("subject", title)
//                    .param("content", content)
//                    .param("writerNo", writerNo)
//            );
            mockMvc.perform(multipart(boardwrite)
                            .file(image)
                            .param("boardNo", boardNo)
                            .param("subject", title)
                            .param("content", content)
                    //.param("writerNo", writerNo)
            ).andDo(print());

            PostVo post = PostVo.builder()
                    .boardNo(32)
                    .subject(title)
                    .content(content)
                    .writerNo(4)
                    .build();

//            ResultActions resultActions = mockMvc.perform(post(board0write)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            // 본문(Body) 영역은 문자열로 표현하기 위해 ObjectMapper를 통해 문자열 JSON으로 변환한다. (맵타입이 json형식의 string으로 변환된다)
//                            .content(mapper.writeValueAsString(post)))
//                    .andExpect(status().isOk());
            //then
            List<PostVo> all = postService.findPostListByBoard(42);
            assertThat(all.get(0).getSubject()).isEqualTo(title);
            assertThat(all.get(0).getContent()).isEqualTo(content);

//            resultActions.andExpect(jsonPath("data").exists())
//                    .andExpect(jsonPath("data").hasJsonPath())
//                    .andExpect(jsonPath("data.id").exists())
//                    .andExpect(jsonPath("message").value("success"))
//                    .andExpect(jsonPath("data.id").value(1))
//                    .andExpect(status().isCreated()).andDo(print());

        }

    }
}

