<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tag1</title>
</head>
<body>

<h1>tag1</h1>
<%--
    JSP标签 : jsp:include 等
    设置页面转发，并设置携带的参数
    http://localhost:8080/javaweb04/tag1.jsp?username=wxx&password=123456
--%>
<jsp:forward page="jsptag2.jsp">
    <jsp:param name="username" value="wxx"/>
    <jsp:param name="password" value="123456"/>
</jsp:forward>

</body>
</html>
