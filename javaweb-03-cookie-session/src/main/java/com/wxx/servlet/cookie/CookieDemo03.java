package com.wxx.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Date: 2020/11/5 21:43
 * Content:
 * 中文数据传递：通过URLDecoder.decode和URLDecoder.decode解决乱码问题
 */
public class CookieDemo03 extends HttpServlet {

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
            // 存在 Cookie
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    // 获取 Cookie 中的值，解码
                    out.write("name = " + URLDecoder.decode(cookie.getValue(), "urf-8"));
                }
            }
        } else {
            out.write("这是您的第一次访问!");
        }

        // 创建一个 Cookie, 名字必须要与要删除的名字一致，编码
        Cookie cookie = new Cookie("name", URLEncoder.encode("王肖肖", "utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
