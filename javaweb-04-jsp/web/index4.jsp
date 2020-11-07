<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- jsp:include : 页面拼接，本质还是三个页面 --%>
<%--JSP标签，这个比较常用--%>
<jsp:include page="common/header.jsp"/>
<h1>网页主体2</h1>
<%
    int i = 10;  // 在 header.jsp 中也有定义, 正确
%>
<jsp:include page="common/footer.jsp"/>

</body>
</html>
