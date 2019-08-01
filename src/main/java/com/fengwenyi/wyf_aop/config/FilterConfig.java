package com.fengwenyi.wyf_aop.config;

import com.fengwenyi.wyf_aop.filters.LogCostFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erwin Feng
 * @since 2019-07-31 09:44
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<LogCostFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogCostFilter());
        // 配置过滤规则
//        List<String> urls = new ArrayList<>();
//        urls.add("/*");
//        filterRegistrationBean.setUrlPatterns(urls);
         filterRegistrationBean.addUrlPatterns("/*");
        // 设置拦截器的名称
        filterRegistrationBean.setName("LogCostFilter");
        // 设置拦截器拦截顺序
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}
