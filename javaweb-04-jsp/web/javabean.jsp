<%@ page import="com.wxx.pojo.People" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>javabean</title>
</head>
<body>

<%
//    People person = new People();
//    person.setId(1);
//    person.setName("wxx");
//    person.setAge(3);
//    person.setAddress("大连");
////     上述代码可以用 jsp 实现
%>


<%-- 创建javaBean --%>
<jsp:useBean id="person" class="com.wxx.pojo.People" scope="page"/>
<%-- 给属性赋值 --%>
<jsp:setProperty name="person" property="id" value="1"/>
<jsp:setProperty name="person" property="name" value="wxx"/>
<jsp:setProperty name="person" property="age" value="3"/>
<jsp:setProperty name="person" property="address" value="大连"/>
<%-- 获取属性值 --%>
id : <jsp:getProperty name="person" property="id"/> <br>
name : <jsp:getProperty name="person" property="name"/> <br>
age : <jsp:getProperty name="person" property="age"/> <br>
address : <jsp:getProperty name="person" property="address"/> <br>
<%-- 获取属性等价于下面的写法 --%>
<%=person.getId()%>

</body>
</html>
