package com.example.sec.basic;

import com.example.demo.PickHotel2Application;
import com.example.member.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = PickHotel2Application.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Slf4j
public class UserAccessTest {

    @Autowired
    private MockMvc mockMvc;

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

    @DisplayName("1. 누구나 메인페이지에 접근할 수 있다.")
    @Test
    @WithAnonymousUser
    public void anonymous_can_index() throws Exception {
        String resp = mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        //SecurityMessage message = mapper.readValue(resp., SecurityMessage.class);
        //log.info("이거지여 : {}", message);
        log.info("이거지여 : {}", resp);

    }

    @Nested
    @DisplayName("게시글 조회 테스트")
    class boardDetail {
        @DisplayName("1. 비회원 - 비회원 게시판")
        @Test
        @WithAnonymousUser
        public void anonymous_cant_board() throws Exception {
            String bio = "0등급으로 설정된 게시판은 비회원도 조회할 수 있다.";
            mockMvc.perform(get("/board/32/post/150"))
                    .andDo(print())
                    .andExpect(status().isOk()) // 상태 200이 되는지 검증
                    .andExpect(view().name("page/post_detail"));

        }

        @DisplayName("1. 1등급 - 1등급 게시판")
        @Test
        @WithUserDetails(value = "airbnb1@java.com", userDetailsServiceBeanName = "accountService")
        public void grade1_can_board() throws Exception {
            String bio = "1등급 회원은 1등급 게시판에 접근할 수 있다. 도착페이지는 상세페이지다.";
            mockMvc.perform(get("/board/33/post/103"))
                    .andDo(print())
                    .andExpect(status().isOk()) // 상태 200이 되는지 검증
                    .andExpect(view().name("page/post_detail"));
        }

        @DisplayName("1. 1등급 - 2등급 게시판 - 등급안내")
        @Test
        @WithUserDetails(value = "airbnb1@java.com", userDetailsServiceBeanName = "accountService")
        public void grade1_cant_board() throws Exception {
            String bio = "1등급 회원은 2등급 게시판에 접근할 수 없다. 등급 안내 페이지으로 포워딩한다..";
            mockMvc.perform(get("/board/34/post/95"))
                    .andDo(print())
                    .andExpect(status().isOk()) // 상태 200이 되는지 검증
                    //"등급안내 페이지"로 포워딩이 되는가?
                    .andExpect(forwardedUrl("/member/site_grade"));
        }

        @DisplayName("1. 2등급 - 1등급 게시판")
        @Test
        @WithUserDetails(value = "airbnb2@java.com", userDetailsServiceBeanName = "accountService")
        public void grade2_can_board() throws Exception {
            String bio = "2등급 회원은 1등급 게시판에 접근할 수 있다.";
            mockMvc.perform(get("/board/33/post/103"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("page/post_detail"));
        }

        @DisplayName("1. 관리자 - 비회원게시판")
        @Test
        @WithUserDetails(value = "admin@java.com", userDetailsServiceBeanName = "accountService")
        public void admin_can_anyboard_0() throws Exception {
            String bio = "관리자는 게시판 등급에 상관없이 접근할 수 있다. - 비회원 게시판";
            mockMvc.perform(get("/board/32/post/150"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("page/post_detail"));
        }

        @DisplayName("1. 관리자 - 1등급 게시판")
        @Test
        @WithUserDetails(value = "admin@java.com", userDetailsServiceBeanName = "accountService")
        public void admin_can_anyboard_1() throws Exception {
            String bio = "관리자는 게시판 등급에 상관없이 접근할 수 있다. - 1등급 게시판";
            mockMvc.perform(get("/board/33/post/103"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("page/post_detail"));
        }

        @DisplayName("1. 관리자 - 2등급 게시판")
        @Test
        @WithUserDetails(value = "admin@java.com", userDetailsServiceBeanName = "accountService")
        public void admin_can_anyboard_2() throws Exception {
            String bio = "관리자는 게시판 등급에 상관없이 접근할 수 있다. - 2등급 게시판";
            mockMvc.perform(get("/board/34/post/95"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("page/post_detail"));
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
}

