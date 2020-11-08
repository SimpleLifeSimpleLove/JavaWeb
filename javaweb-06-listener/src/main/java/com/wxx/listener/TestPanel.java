package com.wxx.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Date: 2020/11/8 15:38
 * Content:
 */
public class TestPanel {

    public static void main(String[] args) {
        Frame frame = new Frame("Hello World!");  // 新建一个窗体
        Panel panel = new Panel(null);  // 新建一个面板

        frame.setLayout(null);  // 设置窗体布局
        frame.setBounds(300, 300, 500, 500);
        frame.setBackground(new Color(107, 207, 239));  // 设置背景颜色

        panel.setBounds(50, 50, 300,300);
        panel.setBackground(new Color(213, 132, 132));

        frame.add(panel);
        frame.setVisible(true);

        // 监听事件，监听关闭事件(适配器模式)
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("即将关闭......");
                System.exit(0);
            }
        });
    }
}
