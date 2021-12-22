package org.yu.alonelaunch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yu.alonelaunch.filter.LogEndpointFilter;
import org.yu.alonelaunch.interceptor.YuAuthInterceptor;

import javax.annotation.Resource;

/**
 * This is Description
 *
 * @author wangxd
 * @date 2021-09-05
 */
@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    public YuAuthInterceptor yuAuthInterceptor;

    @Resource
    public LogEndpointFilter logEndpointFilter;

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE");

    }*/

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        log.info("register global exception filter");
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(logEndpointFilter);
        bean.addUrlPatterns("/*");
        // 优先级最高
        bean.setOrder(Integer.MIN_VALUE);
        return bean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(yuAuthInterceptor).addPathPatterns("/**");
    }
}
