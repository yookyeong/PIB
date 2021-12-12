package com.oracle.s20210902.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.oracle.s20210902.common.service.LoginInterceptor;



@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	// interCeptor
	/*
	 * public void addInterceptors(InterceptorRegistry registry) { // '/'를 치면
	 * interceptor해서 LoginInterceptor() 객체를 생성 // '/'를 치면 LoginInterceptor()가 처리해줄게
	 * registry.addInterceptor(new LoingInterceptor()).addPathPatterns("/"); }
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {

        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor)
        					.addPathPatterns(loginInterceptor.loginEssential)
        					.excludePathPatterns(loginInterceptor.loginInessential);
    }
}
