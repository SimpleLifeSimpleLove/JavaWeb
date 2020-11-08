package com.wxx.filter;

import com.wxx.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 2020/11/8 16:16
 * Content:
 */
public class SysFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (request.getSession().getAttribute(Constant.USER_SESSION) == null) {  // 未登录，不允许访问sys文件夹下的内容
            response.sendRedirect("/error.jsp");
        }

        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
