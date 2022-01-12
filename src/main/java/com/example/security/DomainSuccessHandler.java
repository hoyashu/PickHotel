package com.example.security;


import com.example.member.persistent.MemberDao;
import com.example.member.persistent.RoleResourceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Slf4j
@Configuration
public class DomainSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    RoleResourceDao resourceDao;

    @Autowired
    MemberDao memberDao;

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
        log.info("call successHandler");

        String id = authentication.getName();

        Cookie oldCookie = null;
        Cookie[] cookies = request.getCookies();

        //request에서 넘어온 쿠키가 있는 경우
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginCount")) {
                    oldCookie = cookie;
                }
            }
        }


        if (oldCookie != null) {
            log.info("oldCookie:{}", oldCookie.getValue());

            if (!oldCookie.getValue().contains("[" + id + "]")) {

                this.memberDao.UpdateVisitCount(id);
                oldCookie.setValue(oldCookie.getValue() + "_[" + id + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
            }
        } else {

            this.memberDao.UpdateVisitCount(id);
            Cookie newCookie = new Cookie("loginCount", "[" + id + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }

        response.sendRedirect("index");
    }
}