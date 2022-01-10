package com.example.config;

import com.example.member.service.RoleHierarchyService;
import com.example.security.DomainFailureHandler;
import com.example.security.DomainSuccessHandler;
import com.example.security.UrlFilterInvocationSecurityMetadataSource;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DomainFailureHandler domainFailureHandler;

    @Autowired
    private DomainSuccessHandler domainSuccessHandler;

    @Autowired
    private RoleHierarchyService roleHierarchyService;


    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //중요
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //WebSecurity : Security filter chain을 적용할 필요가 전혀 없는 요청인 경우
        //정적 컨텐츠의 액세스는 인증을 걸지 않는다.
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//        web.ignoring().antMatchers("/webjars/**", "/static/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("call SecurityConfig configure");

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/img/**", "/user/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")                  //UsernamePasswordAuthenticationFilter 수행한다. 디폴트(/login)
                .successHandler(domainSuccessHandler)
                .failureHandler(domainFailureHandler)
                .usernameParameter("id")                    //디폴트 : username
                .passwordParameter("pwd")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("SESSION", "JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .permitAll();
//                .and()
//                .addFilterBefore(customFilterSecurityInterceptor(), FilterSecurityInterceptor.class);

    }

    @Bean
    public FilterSecurityInterceptor customFilterSecurityInterceptor() throws Exception {
        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
        filterSecurityInterceptor.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource());
        filterSecurityInterceptor.setAccessDecisionManager(affirmativeBased());
        filterSecurityInterceptor.setAuthenticationManager(authenticationManagerBean());
        return filterSecurityInterceptor;
    }

    private AccessDecisionManager affirmativeBased() {
        AffirmativeBased affirmativeBased = new AffirmativeBased(getAccessDecisionVoters());
        return affirmativeBased;
    }

    private java.util.List<AccessDecisionVoter<? extends Object>> getAccessDecisionVoters() {
        return Arrays.asList(new RoleVoter());
    }

    @Bean
    public FilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource() throws Exception {
        //return new UrlFilterInvocationSecurityMetadataSource1(urlResourcesMapFactoryBean().getObject());
        return new UrlFilterInvocationSecurityMetadataSource();
    }

    // 인증 매니저
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /*
    ----------------------------------------------------------------------------
             Role Hierarchy
    ----------------------------------------------------------------------------
    */

    @Bean
    public RoleHierarchyImpl roleHierarchy(){
        String allHierarchy = roleHierarchyService.findAllHierarchy();
        System.out.println("allHierarchy : " + allHierarchy + "allHierarchy");
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(allHierarchy);
        return roleHierarchy;
    }

    @Bean
    public AccessDecisionVoter<? extends Object> roleVoter(){
        RoleHierarchyVoter roleHierarchyVoter = new RoleHierarchyVoter(roleHierarchy());
        return roleHierarchyVoter;
    }

}


