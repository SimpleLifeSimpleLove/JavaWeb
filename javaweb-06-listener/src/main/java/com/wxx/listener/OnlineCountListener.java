package com.wxx.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Date: 2020/11/8 15:12
 * Content: 统计网站在线人数：统计session
 */
public class OnlineCountListener implements HttpSessionListener {

    // 创建session监听：看你的一举一动
    // 一旦创建session，就会触发这个事件(观察者模式)
    public void sessionCreated(HttpSessionEvent se) {
        // 获取 ServletContext
        ServletContext context = se.getSession().getServletContext();

        // 获取 ServletContext 中的属性
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = 1;
        } else {
            onlineCount++;
        }
        context.setAttribute("onlineCount", onlineCount);
    }

    // 销毁session监听
    // 一旦销毁session，就会触发这个事件(观察者模式)
    public void sessionDestroyed(HttpSessionEvent se) {
// 获取 ServletContext
        ServletContext context = se.getSession().getServletContext();

        // 获取 ServletContext 中的属性
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = 0;
        } else {
            onlineCount--;
        }
        context.setAttribute("onlineCount", onlineCount);
    }
}
