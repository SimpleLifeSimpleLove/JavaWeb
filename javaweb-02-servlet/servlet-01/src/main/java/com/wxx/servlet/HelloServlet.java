package com.wxx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Date: 2020/11/2 21:18
 * Content:
 */
public class HelloServlet extends HttpServlet {

    // 由于get和post只是请求实现的不同方式，可以相互调用，业务逻辑都一样
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求与相应的编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");

        // 通过服务器给客户端的请求 HttpServletResponse 向客户端输出数据, 前端显示数据
        PrintWriter writer = resp.getWriter();
        writer.print("Hello Servlet!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
