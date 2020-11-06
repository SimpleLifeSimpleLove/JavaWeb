package com.wxx.servlet.session;

import com.wxx.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Date: 2020/11/6 18:33
 * Content: Session 注销
 */
public class SessionDemo03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求与相应的编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");  // 设置前端显示的数据类型

        // 得到 Session
        HttpSession session = req.getSession();
        // 注销 Session
        session.removeAttribute("name");
        session.removeAttribute("person");
        session.invalidate();  // 手动注销 Session, 但是只要再次访问浏览器会立即生成一个新的 Session
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
