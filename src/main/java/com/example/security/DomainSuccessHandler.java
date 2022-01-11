package com.example.security;

import com.example.member.model.MemberVo;
import com.example.member.persistent.RoleResourceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Configuration
public class DomainSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    RoleResourceDao resourceDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        // 유저 성공 로직을 추가 해준다.
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        /*강제 인터셉트 당했을 경우의 데이터 get*/
//        RequestCache requestCache = new HttpSessionRequestCache();
//        SavedRequest savedRequest = requestCache.getRequest(request, response);
//
//        /*로그인 버튼 눌러 접속했을 경우의 데이터 get*/
//        String prevPage = (String) request.getSession().getAttribute("prevPage");
//
//        HttpSession session = request.getSession();
//        if (session != null) {
//            String redirectUrl = (String) session.getAttribute("url_prior_login");
//            if (redirectUrl != null) {
//                // we do not forget to clean this attribute from session
//                session.removeAttribute("url_prior_login");
//                // then we redirect
//
//                /*로그인 완료시 세션저장*/
//                MemberVo member = resourceDao.getUserById(authentication.getName());
//                session.setAttribute("member", member);
//
//                response.sendRedirect(redirectUrl);
//            } else {
//                response.sendRedirect(prevPage);
//            }
//        } else {
//            response.sendRedirect(prevPage);
//        }

        log.info("call failureHandler");

        MemberVo member = resourceDao.getUserById(authentication.getName());
        HttpSession session = request.getSession();
        session.setAttribute("member", member);

        response.sendRedirect("index");
    }
}