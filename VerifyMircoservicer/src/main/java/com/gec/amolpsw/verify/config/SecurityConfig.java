package com.gec.amolpsw.verify.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gec.amolpsw.verify.detailsService.UserInfSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserInfSerivce userInfSerivce;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userInfSerivce).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .permitAll()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("text/html");
                        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString("OK YES" + "|" + authentication.getPrincipal().toString()));
                        httpServletResponse.getWriter().close();
                        onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        //????????????????????????????????????????????????
                        httpServletResponse.setContentType("text/json;charset=utf-8");
                        String result = null;
                        if (e instanceof AccountExpiredException) {
                            //????????????
                           result =  new ObjectMapper().writeValueAsString("????????????");
                        } else if (e instanceof BadCredentialsException) {
                            //????????????
                            result =  new ObjectMapper().writeValueAsString("????????????");
                        } else if (e instanceof CredentialsExpiredException) {
                            //????????????
                            result = new ObjectMapper().writeValueAsString("????????????");
                        } else if (e instanceof DisabledException) {
                            //???????????????
                            result = new ObjectMapper().writeValueAsString("????????????");
                        } else if (e instanceof LockedException) {
                            //????????????
                            result = new ObjectMapper().writeValueAsString("????????????");
                        } else if (e instanceof InternalAuthenticationServiceException) {
                            //???????????????
                            result = new ObjectMapper().writeValueAsString("???????????????");
                        }else{
                            //????????????
                            result =  new ObjectMapper().writeValueAsString("????????????");
                        }
                        //??????HttpServletResponse??????????????????
                        httpServletResponse.getWriter().write(result);
                        httpServletResponse.getWriter().close();
                    }
                })
                .usernameParameter("name").passwordParameter("userpassword")
                .and()
                .authorizeRequests()
                .antMatchers("/user/UserManage/**").hasRole("admin")
                .anyRequest()
                .authenticated()
                .and().csrf().disable()
                .sessionManagement().maximumSessions(1)
                .expiredSessionStrategy(new SessionInformationExpiredStrategy() {
                    @Override
                    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
                        HttpServletResponse response = sessionInformationExpiredEvent.getResponse();
                        response.setContentType("text/json;charset=utf-8");
                        response.getWriter().write("????????????");
                    }
                });
        http.logout().logoutUrl("/loginout").permitAll();
        http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                httpServletResponse.setContentType("text/html");
                httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString("NO request Resource"));
            }
        });

    }

}
