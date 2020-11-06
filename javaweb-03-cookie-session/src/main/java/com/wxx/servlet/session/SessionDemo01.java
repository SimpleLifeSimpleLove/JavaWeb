package com.wxx.servlet.session;

import com.wxx.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Date: 2020/11/6 18:33
 * Content: 向 Session 中存东西
 */
public class SessionDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求与相应的编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");  // 设置前端显示的数据类型

        // 得到 Session
        HttpSession session = req.getSession();

        // 给 Session 中存东西
        session.setAttribute("name", "王肖肖");
        session.setAttribute("person", new Person("王肖肖", 23));

        // 获取 Session 的ID
        String sessionId = session.getId();

        // 判断 Session 是不是新创建的
        if (session.isNew()) {
            resp.getWriter().write("Session创建成功, ID为 : " + sessionId);
        } else {
            resp.getWriter().write("Session已经在服务器存在了, ID为 : " + sessionId);
        }

//        // Session在创建的时候做了什么事情?
//        Cookie cookie = new Cookie("JSESSIONID", sessionId);
//        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
