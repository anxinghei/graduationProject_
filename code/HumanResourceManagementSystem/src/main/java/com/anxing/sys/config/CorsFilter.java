package com.anxing.sys.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mq_xu
 * @ClassName CORSFilter
 * @Description 跨域过滤器类
 * @Date 2019/10/3
 * @Version 1.0
 **/
//@WebFilter(urlPatterns = "/*")
public class CorsFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        //允许客户端请求头携带
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type,Access-Token");
        //允许给客户端响应头携带
        response.setHeader("Access-Control-Expose-Headers", "Access-Token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("跨域过滤器初始化");
    }

    @Override
    public void destroy() {
        logger.info("跨域过滤器销毁");
    }

}
