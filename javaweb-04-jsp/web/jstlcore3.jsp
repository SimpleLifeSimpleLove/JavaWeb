<%@ page import="java.util.ArrayList" %>
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
<h4>forEach测试</h4>

<%
    ArrayList<String> people = new ArrayList<>();
    people.add("张三");
    people.add("李四");
    people.add("王五");
    people.add("赵六");
    request.setAttribute("list", people);
%>

<%--
    var : 每一次遍历出来的变量
    items : 要遍历的对象
    begin : 遍历起始索引位置
    end : 遍历结束索引位置
    step : 步长
--%>
<c:forEach var="person" items="${list}">
    <c:out value="${person}"/> <br>
</c:forEach>

<hr>

<c:forEach var="person" items="${list}" begin="0" end="3" step="2">
    <c:out value="${person}"/> <br>
</c:forEach>


</body>
</html>
