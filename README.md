# AOP

面向切面编程

## 过滤器

过滤器需要继承 `javax.servlet.Filter`。

1、编写自定义过滤器

```java
package com.fengwenyi.wyf_aop.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 * @author Erwin Feng
 * @since 2019-08-01 16:37
 */
public class TimeFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
    
}
```

2、怎么样过滤器生效

方式一：通过Spring配置的方式

```java
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
        // List<String> urls = new ArrayList<>();
        // urls.add("/*");
        // filterRegistrationBean.setUrlPatterns(urls);
         filterRegistrationBean.addUrlPatterns("/*");
        // 设置拦截器的名称
        filterRegistrationBean.setName("LogCostFilter");
        // 设置拦截器拦截顺序
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}
```

方式二：使用Servlet

```
@WebFilter(urlPatterns = "/users/*",filterName = "UsersFilter")
```


问题：filter一个请求过滤两次地问题~

打印结果：

```
http://localhost:8080/index
http://localhost:8080/favicon.ico
```

## 拦截器

## Aspect