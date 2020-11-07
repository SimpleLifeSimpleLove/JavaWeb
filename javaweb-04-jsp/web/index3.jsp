<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index3</title>
</head>
<body>

<%-- %@ include : 会将多个页面合成一个 --%>
<%--提取公共页--%>
<%@ include file="common/header.jsp" %>
<h1>网页主体1</h1>
<%--<%--%>
<%--    int i = 10;  // 在 header.jsp 中也有定义, 错误：重复定义--%>
<%--%>--%>
<%--提取公共页--%>
<%@ include file="common/footer.jsp" %>

</body>
</html>
