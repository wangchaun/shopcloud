/*
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

*/
/**
 * @program: shopcloud-master
 * @description:
 * @author: siming.wang
 * @create: 2018-10-11 10:13
 **//*


@Order(-2147483048)
@WebFilter(filterName = "cookieHttpOnlyFilter", urlPatterns = "/*")
public class CookieHttpOnlyFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
            IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;



        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true"); //是否支持cookie跨域
        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
*/
