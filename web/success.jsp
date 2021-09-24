<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: 34431
  Date: 2021/9/16
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <title>登录成功</title>
</head>
<body>
    <h1>欢迎您,${sessionScope.username}</h1>
    <a class="btn-large" href="logout">退出</a>

</body>
</html>
