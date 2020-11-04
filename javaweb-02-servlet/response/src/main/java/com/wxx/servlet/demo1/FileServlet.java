package com.wxx.servlet.demo1;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Date: 2020/11/4 16:38
 * Content:
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取下载文件的路径
//        String realPath = "D:\\Code\\github\\JavaWeb\\javaweb-02-servlet\\response\\target\\classes\\wxx.png";
        String realPath = "D:\\Code\\github\\JavaWeb\\javaweb-02-servlet\\response\\target\\classes\\王肖肖.png";
        System.out.println("下载文件的路径：" + realPath);
        // 2.下载文件的名称是啥？
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        System.out.println(fileName);
        // 3.设置想办法让浏览器能够支持(Content-Disposition)我们需要下载的东西, 中文文件名使用URLEncoder.encode编码，否则有可能乱码
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        // 4.获取下载文件的输入流
        FileInputStream fis = new FileInputStream(realPath);
        // 5.创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        // 6.获取 OutputStream 对象
        ServletOutputStream os = resp.getOutputStream();
        // 7.将 FileInputStream 流写入到 buffer 缓冲区, 使用 OutputStream 将缓冲区的数据输出到客户端
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        // 实际生产中一定要使用try-catch-finally处理
        fis.close();
        os.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
