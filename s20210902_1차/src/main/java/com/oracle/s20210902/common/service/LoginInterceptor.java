package com.oracle.s20210902.common.service;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	public List loginEssential
    		= Arrays.asList("/*qna*", "/wish*", "/cart*");
	
	public List loginInessential
    		= Arrays.asList();
	// 3번
	// 나중에 수행되는 메소드
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
						  Object handler, ModelAndView modelAndView) throws IOException {
		System.out.println("LoginleInterceptor 3. postHanle Start...");
	}
	
	// 먼저 수행되는 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		String loginId = (String)request.getSession().getAttribute("mem_id");

        if(loginId != null){return true;}
        
        else{    
            response.sendRedirect("loginMessage");
            return false;
        }
	}
}
