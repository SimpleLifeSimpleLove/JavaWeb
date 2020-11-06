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
 * Content: 从 Session 中取东西
 */
public class SessionDemo02 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求与相应的编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");  // 设置前端显示的数据类型

        // 得到 Session
        HttpSession session = req.getSession();
        // 获取 Session 中的内容
        String name = (String) session.getAttribute("name");
        resp.getWriter().write(name + "<br>");
        Person person = (Person) session.getAttribute("person");
        resp.getWriter().write(person.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
