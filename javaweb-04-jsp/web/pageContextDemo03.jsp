<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContextDemo01</title>
</head>
<body>

<%--
public void setAttribute (String name,
			    Object attribute,
			    int scope)
  {
    switch (scope) {
    case PAGE_SCOPE:
      mPage.put (name, attribute);
      break;
    case REQUEST_SCOPE:
      mRequest.put (name, attribute);
      break;
    case SESSION_SCOPE:
      mSession.put (name, attribute);
      break;
    case APPLICATION_SCOPE:
      mApp.put (name, attribute);
      break;
    default:
      throw new IllegalArgumentException  ("Bad scope " + scope);
    }
  }
--%>

<%-- 内置对象 --%>
<%
//    pageContext.setAttribute("name", "wxx", PageContext.APPLICATION_SCOPE);
//    session.setAttribute("name", "wxx");
    // 上面两种写法是等价的
%>

<%
//    pageContext.forward("/index.jsp");
    request.getRequestDispatcher("/index.jsp").forward(request, response);
    // 上面两种写法可以实现相同的功能
%>


</body>
</html>
