package com.maiya.shopcloud.account.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: shopcloud-master
 * @description:
 * @author: siming.wang
 * @create: 2018-10-11 10:13
 **/

@Order(-2147483048)
@WebFilter(filterName = "cookieHttpOnlyFilter", urlPatterns = "/*")
public class CookieHttpOnlyFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws
            IOException, ServletException {
        System.out.println("CookieHttpOnlyFilter wsm start");
        String sessionId = request.getParameter("SESSION");
        Cookie cookie1 = new Cookie("SESSION", sessionId);
        
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //tomcat7 支持该属性，tomcat6不支持

                cookie.setHttpOnly(false);
            }
        }
        filterChain.doFilter(request, response);
        HttpServletResponse response1 = (HttpServletResponse)response;
        System.out.println(response1.getHeaderNames());

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
