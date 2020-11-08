package com.wxx.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Date: 2020/11/8 13:37
 * Content:
 */
public class CharacterEncodingFilter implements Filter {
    // 初始化，Web服务器启动，就已经初始化了，随时等待过滤对象出现
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    /*
        chain : 链
            1.过滤器中的所有代码，在过滤特定请求的时候会被执行
            2.必须让过滤器继续通行
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 设置请求与相应的编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");  // 设置前端显示的数据类型

        System.out.println("CharacterEncodingFilter执行前...");
        chain.doFilter(request, response);  // 让我们的请求继续走，如果不写，程序到这里就被拦截!
        System.out.println("CharacterEncodingFilter执行后...");
    }

    // 销毁，Web服务器关闭的时候，过滤器会被销毁
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁");
    }
}
