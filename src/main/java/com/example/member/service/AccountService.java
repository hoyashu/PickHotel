package com.example.member.service;

import com.example.member.model.MemberRoleVo;
import com.example.member.model.MemberVo;

import com.example.member.persistent.MemberDao;
import com.example.member.persistent.RoleResourceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private RoleResourceDao roleResourceDao;

    @Autowired
    private MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("1. AccountService loadUserByUsername {}", username);
        return getLoginUser(username);
    }

    protected UserDetails getLoginUser(String id) throws UsernameNotFoundException {

        MemberVo member = null;
        List<GrantedAuthority> authorityList = null;

        try {
            member = roleResourceDao.getUserById(id);

            boolean state = false;

            if (1 != Integer.parseInt(memberDao.SelectWithDraw(id))){
                state = true;
            }

            log.info("2. AccountService getLoginUser User {}", member);

            if (member == null) {
                throw new UsernameNotFoundException("no user found [email=" + id + "]");
            }

            List<MemberRoleVo> memberRoles = roleResourceDao.getRolesById(id);

            List<String> roles = new ArrayList<>();
            for (MemberRoleVo memberRole : memberRoles) {
                roles.add(memberRole.getRoleName().replace("ROLE_",""));
            }
            log.info("=======================================================");
            log.info("3. User id : {}", id);
            log.info("3. User Roles : {}", roles);
            log.info("3. member.getId() : {}", member.getId());
            log.info("3. member.getPwd() : {}", member.getPwd());
            log.info("=======================================================");

            return org.springframework.security.core.userdetails.User.builder()
                    .username(member.getId())
                    .password(member.getPwd())
                    .roles(roles.toArray(new String[roles.size()])) //List<SimpleGrantedAuthority>
                    .disabled(state)
                    .build();


        } catch(Exception ex) {
            log.error("failed to get LoginUser.", ex);

            if(ex instanceof UsernameNotFoundException) {
                log.error("failed to get LoginUser.", ex);
                UsernameNotFoundException e = (UsernameNotFoundException)ex;
                throw e;
            }
            throw new UsernameNotFoundException("could not select user.", ex);
        }
    }
}
