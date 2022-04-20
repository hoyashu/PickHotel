//package com.example.sec.basic;
//
//import com.example.member.model.MemberVo;
//import com.example.member.model.UserAccount;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.test.context.support.WithSecurityContextFactory;
//
//public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithMockCustomUser> {
//
//    @Override
//    public SecurityContext createSecurityContext(WithMockCustomUser customUser) {
//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//
//        MemberVo member = new MemberVo();
//        member.setMemNo(1);
//        member.setName(customUser.username());
//        member.setNick(customUser.name());
//        member.setGrade(customUser.grade());
//
//        UserAccount principal =
//                new UserAccount(member, true, customUser.role());
//        Authentication auth =
//                new UsernamePasswordAuthenticationToken(principal, "password", customUser.role());
//        context.setAuthentication(auth);
//        return context;
//    }
//}