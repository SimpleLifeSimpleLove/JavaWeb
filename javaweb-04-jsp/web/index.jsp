<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>JSP表达式</title>
</head>
<body>
<%-- 以下是JSP基础语法 --%>

<%-- 我是JSP的注释, 不会在网页源代码中保留! --%>
<!-- 我是HTML的注释, 会在网页源代码中保留! -->


<%--
JSP表达式
    作用：用来将程序的输出，输出到客户端
    <%= 变量或者表达式 %>
--%>
<%= new Date() %>


<%--
JSP脚本片段
    作用：用来写Java代码
    <% Java代码 %>
--%>
<%--分割线--%>
<hr>
<%
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
        sum += i;
    }
    out.println("<h1>sum = " + sum + "</h1>");
%>


<%--
JSP脚本片段的再实现
    作用：用来写Java代码
    在代码中嵌入HTML元素
--%>
<%--分割线--%>
<hr>
<%
    for (int i = 0; i < 3; i++) {
%>
<h2>Hello, World!  <%= i %> </h2>
<%
    }
%>

<%-- 上面的内容最终都会生成在index_jsp.java中的_jspService()方法中 --%>
<%-- 下面的内容最终都会生成在index_jsp.java这个类中 --%>

<%--
JSP声明
--%>
<%--分割线--%>
<hr>
<%!
    static {
        System.out.println("Loading Servlet!");
    }

    private int globalVar = 0;

    public void hello() {
        System.out.println("hello");
    }
%>

</body>
</html>
