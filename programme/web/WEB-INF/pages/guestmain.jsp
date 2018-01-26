<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/26
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>求职者主页</title>
</head>
<body>
    欢迎你，${guest.g_name}
</body>
</html>