package com.wxx.servlet.demo3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 2020/11/3 21:58
 * Content:
 */
public class DispatcherServlet extends HttpServlet {
    // 请求转发
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求与相应的编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");  // 设置前端显示的数据类型

        ServletContext context = this.getServletContext();
//        RequestDispatcher dispatcher = context.getRequestDispatcher("/gp");  // 转发的请求路径
//        dispatcher.forward(req, resp);  // 调用forward实现请求转发
        context.getRequestDispatcher("/gp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
