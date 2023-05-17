package com.zkl.filter;

import com.alibaba.fastjson.JSONObject;
import com.zkl.pojo.Result;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkl
 * @date 2023/4/29
 * @time 17:45
 **/
@Slf4j
//@WebFilter(urlPatterns = "/*")//配置拦截资源的路径
public class DemoFilter implements Filter {
    @Override//初始化方法,只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化");

    }

    @Override//拦截到请求后就会被调用
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resq = (HttpServletResponse) servletResponse;
//        获取请求的url
        String url = req.getRequestURI().toString();
        log.info("url:{}", url);
//        判断url是否包含login，如果包含，就直接放行
        if (url.contains("login2")) {
            log.info("登录操作，放行。。");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String jwt = req.getHeader("token");
        if (jwt == null) {
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT-LOGIN");
            String jsonString = JSONObject.toJSONString(error);
            resq.getWriter().write(jsonString);
            return;
        }
        try {
            Claims login = Jwts.parser()
                    .setSigningKey("login")
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败");
            Result error = Result.error("NOT-LOGIN");
            String jsonString = JSONObject.toJSONString(error);
            resq.getWriter().write(jsonString);
            return;
        }
        log.info("令牌合法");
        filterChain.doFilter(servletRequest,servletResponse);
        }


    @Override//销毁方法，只调用一次
    public void destroy() {
        System.out.println("销毁操作");
    }
}
