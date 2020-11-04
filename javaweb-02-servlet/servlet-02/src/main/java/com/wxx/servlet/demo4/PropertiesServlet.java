package com.wxx.servlet.demo4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Date: 2020/11/4 10:42
 * Content:
 */
public class PropertiesServlet extends HttpServlet {
    // 读取资源文件(Properties)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求与相应的编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");  // 设置前端显示的数据类型

        // 第一个/代表当前路径，不能省略
//        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/jdbc.properties");
        InputStream is = this.getServletContext().getResourceAsStream(
                "/WEB-INF/classes/com/wxx/servlet/demo4/druid.properties");
        Properties prop = new Properties();
        prop.load(is);
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        String driverClass = prop.getProperty("driverClass");

        // 输出到前台
        resp.getWriter().print("user : " + user + "<br>");
        resp.getWriter().print("password : " + password + "<br>");
        resp.getWriter().print("url : " + url + "<br>");
        resp.getWriter().print("driverClass : " + driverClass + "<br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
