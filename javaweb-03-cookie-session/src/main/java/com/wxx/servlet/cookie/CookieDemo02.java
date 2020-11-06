package com.wxx.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Date: 2020/11/5 21:43
 * Content:
 * 保存用户上一次访问的时间
 */
public class CookieDemo02 extends HttpServlet {

    // 服务器告诉你(客户端)，你来的时间，把这个时间封装成为一个信件(Cookie)，你下次带来，服务器就知道了
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求与相应的编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");  // 设置前端显示的数据类型

        // 创建一个 Cookie, 名字必须要与要删除的名字一致
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(0);  // 设置 Cookie 的有效期为0天, 这种情况下，Cookie 会立即失效
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
