<%--
  Created by IntelliJ IDEA.
  User: WXX
  Date: 2020/11/7
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tag2</title>
</head>
<body>

<h1>tag2</h1>

<%--获取tag1.jsp发送来的参数--%>
username : <%= request.getParameter("username") %> <br>
password : <%= request.getParameter("password") %>

</body>
</html>
