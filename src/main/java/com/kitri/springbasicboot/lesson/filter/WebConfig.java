package com.kitri.springbasicboot.lesson.filter;

import com.kitri.springbasicboot.lesson.intercepter.LogIntercepter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// 오버라이드로 설정 등록(bean 사용 대신)
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        // LogFilter를 filter로 등록
        filterFilterRegistrationBean.setFilter(new LogFilter());
        filterFilterRegistrationBean.setOrder(1);

        return filterFilterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean logFilter2(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        // LogFilter를 filter로 등록
        filterFilterRegistrationBean.setFilter(new Log2Filter());
        filterFilterRegistrationBean.setOrder(1);

        return filterFilterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogIntercepter());
    }
}
