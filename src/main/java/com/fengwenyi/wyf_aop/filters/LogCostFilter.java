package com.fengwenyi.wyf_aop.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Erwin Feng
 * @since 2019-07-31 09:22
 */
//@WebFilter(urlPatterns = "/users/*",filterName = "TimeFilter")
public class LogCostFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestUrl = httpServletRequest.getRequestURI();
        System.out.println(requestUrl);
        if (requestUrl.contains("favicon.ico")) {
            return;
        }
        filterChain.doFilter(request, response);
        System.out.println("Execute cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {

    }
}
