<%--
  Created by IntelliJ IDEA.
  User: iwontae
  Date: 2021/10/16
  Time: 11:59 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" import="java.util" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4><c:out value="${exception.getMessage()}"/></h4>

<ul>

    <c:forEach items="${exception.getStackTrace()}" var="stack">

        <li><c:out value="${stack}"></c:out></li>

    </c:forEach>

</ul>
</body>
</html>
