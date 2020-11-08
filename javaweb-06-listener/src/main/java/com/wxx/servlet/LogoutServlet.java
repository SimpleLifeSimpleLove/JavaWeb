package com.wxx.servlet;

import com.wxx.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 2020/11/8 16:25
 * Content:
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 登陆后注销：清理session中的内容
        Object user_session = req.getSession().getAttribute(Constant.USER_SESSION);
        if (user_session != null) {
            req.getSession().removeAttribute(Constant.USER_SESSION);
            resp.sendRedirect("/login.jsp");  // 退出登陆后重定向到登陆页面
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
