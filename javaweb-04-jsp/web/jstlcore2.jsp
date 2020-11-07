<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入JSTL核心标签库，我们才能使用JSTL标签 --%>
<%-- 导入该包会出现问题，解决方式：手动将jstl的包复制到tomcat安装目录中的lib文件夹下 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- jstl核心标签库 --%>
<h4>when测试</h4>

<%-- 定义一个变量score，值为85 --%>
<c:set var="score" value="85"/>

<c:choose>
    <c:when test="${score > 90}">
        你的成绩为优秀.
    </c:when>
    <c:when test="${score > 80}">
        你的成绩为良好.
    </c:when>
    <c:when test="${score > 60}">
        你的成绩为一般.
    </c:when>
    <c:when test="${score <= 60}">
        你的成绩为不及格.
    </c:when>
</c:choose>


</body>
</html>
