<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContextDemo01</title>
</head>
<body>

<%-- 内置对象 --%>
<%
    pageContext.setAttribute("name1", "wxx01");  // 保存的数据只在一个页面中有效
    request.setAttribute("name2", "wxx02");  // 保存的数据只在一次请求中有效，请求转发也会携带这个数据
    session.setAttribute("name3", "wxx03");  // 保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4", "wxx04");  // 保存的数据在服务器中有效，从打开服务器到关闭服务器
%>

<%-- 内置对象 --%>
<%
    // 从 pageContext 取出数据
    // 如何寻找属性的？从底层到高层(作用域) page --> request --> session --> application
    // 类似于JVM中的双亲委派机制
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5");

//    pageContext.forward("/pageContextDemo02.jsp");  // 这样可以取到 name2, name3, name4
%>

<%-- 使用EL表达式输出 ${} 等价于 <%= %> --%>
<h1>取出的值为：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<%--不存在的话，前端页面什么都不输出--%>
<h3>${name5}</h3>
<%--不存在的话，输出null--%>
<h3><%= name5%></h3>


</body>
</html>
