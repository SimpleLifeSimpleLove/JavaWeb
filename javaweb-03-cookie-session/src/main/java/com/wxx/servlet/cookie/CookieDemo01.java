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
public class CookieDemo01 extends HttpServlet {

    // 服务器告诉你(客户端)，你来的时间，把这个时间封装成为一个信件(Cookie)，你下次带来，服务器就知道了
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求与相应的编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");  // 设置前端显示的数据类型

        // 获取输出到浏览器的流
        PrintWriter out = resp.getWriter();
        // 服务端从客户端获取Cookie
        Cookie[] cookies = req.getCookies();  // 返回时数组，说明 Cookie 可能存在多个
        // 判断 Cookie 是否存在
        if (cookies != null) {
            out.write("您上次访问的时间是 : ");
            // 存在 Cookie
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastLoginTime")) {
                    // 获取 Cookie 中的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        } else {
            out.write("这是您的第一次访问!");
        }

        // 服务器给客户端相应一个 Cookie, 如果客户端已经存在 Cookie,则更新
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(24 * 60 * 60);  // 设置 Cookie 的有效期为1天, 这种情况下，即使关闭浏览器，Cookie还存在,不安全!
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
