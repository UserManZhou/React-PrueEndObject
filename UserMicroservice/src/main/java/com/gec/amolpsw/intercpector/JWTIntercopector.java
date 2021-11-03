package com.gec.amolpsw.intercpector;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JWTIntercopector implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader("header");
        System.out.println("header = " + header);
        String requestURI = request.getRequestURI();
        if (header == null || header == ""){
            response.getWriter().write(new ObjectMapper().writeValueAsString(" Please Login get Token"));
            return false;
        }

        return true;
    }
}
