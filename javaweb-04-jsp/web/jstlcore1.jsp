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
<h4>if测试</h4>

<hr>

<form action="jstlcore1.jsp" method="get">
    <%--
        EL表达式获取表单中的数据
        ${param.参数名}
    --%>
    <input type="text" name="username" value="${param.username}"> <br>
    <input type="submit" value="登陆">
</form>

<%-- 判断如果提交的用户名是管理员，则登陆成功 --%>
<c:if test="${param.username == 'admin'}" var="isAdmin">
    <c:out value="管理员欢迎您!" />
</c:if>
<c:out value="${isAdmin}"/>

</body>
</html>
