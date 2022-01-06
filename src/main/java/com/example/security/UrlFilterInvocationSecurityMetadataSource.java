package com.example.security;

import com.example.member.model.RoleResourcesVo;
import com.example.member.persistent.MemberDao;

import com.example.member.persistent.RoleResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;


public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private RoleResourceDao roleResourceDao;

    private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> requestMap = new LinkedHashMap<>();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        HttpServletRequest request = ((FilterInvocation) object).getRequest();

        List<RoleResourcesVo> roleResources = roleResourceDao.getRoleResources();

        for (RoleResourcesVo roleResource : roleResources) {
            requestMap.put(new AntPathRequestMatcher(roleResource.getResourceName()),
                                    Arrays.asList(new SecurityConfig(roleResource.getRoleName())));
        }

        System.out.println("request : " + request.getRequestURI());
        System.out.println("requestMap : " + requestMap);

        if (requestMap != null) {
            var flag = requestMap.entrySet().stream()
                    .filter(entry -> entry.getKey().matches(request))
                    .findFirst()
                    .map(Map.Entry::getValue)
                    .orElseGet(ArrayList::new);

            System.out.println("flag " + flag);
            return flag;
        }
        return null;
    }

    @Override
    // 모든 권한 목록을 가져온다
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return requestMap.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

}