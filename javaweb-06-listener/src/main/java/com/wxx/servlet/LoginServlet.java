package com.wxx.servlet;

import com.wxx.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 2020/11/8 16:05
 * Content:
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端请求参数
        String username = req.getParameter("username");

        if ("admin".equals(username)) {  // 管理员登陆成功
            req.getSession().setAttribute(Constant.USER_SESSION, req.getSession().getId());  // 存储用户信息
            resp.sendRedirect("/sys/success.jsp");  // 重定向到新的页面
        } else {
            resp.sendRedirect("/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
