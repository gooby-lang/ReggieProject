package com.jyf.reggieproject.filter;

import com.alibaba.fastjson.JSON;
import com.jyf.reggieproject.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否已经登录的过滤器
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取本次请求的URI
        String requestURI = request.getRequestURI();
        log.info("本次请求URI为{}", requestURI);

        //判断本次请求是否需要处理
        String[] urls = new String[] {
                "/employee/login",
                "/employee/logout",
                "/static/**"
        };
        boolean ok = check(urls, requestURI);
        if (ok) {
            log.info("URL放行");
            filterChain.doFilter(request, response);
            return ;
        }

        //判断登录状态
        Object employee = request.getSession().getAttribute("employee");
        if (employee != null) {
            log.info("已经登录放行");
            filterChain.doFilter(request, response);
            return ;
        }
        //如果未登录则返回未登录结果，通过输出流方式向客户端页面响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    /**
     * 检查本次请求是否需要放行
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
