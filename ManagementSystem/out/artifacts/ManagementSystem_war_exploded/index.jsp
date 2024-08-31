<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 12/1/2024
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" name="eid" placeholder="eid">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="Login" >
  </form>
  </body>
</html>
