<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/28
  Time: 20:23
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
    <title>管理员入口</title>
</head>
<body>
<div>
    <form method="post" action="checkAdminister">
        登录<br/>
        ${loginResult}<br/>
        用户名：<input type="text" name="a_name" id="a_name"><span></span><br/>
        密码：<input type="password" name="a_password" id="a_password"><span></span><br/>
        <input type="submit" value="登录"><a href="../../index.jsp"><input type="button" value="返回"></a>
    </form>
</div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $("#a_name,#a_password").bind('input propertychange blur',function () {
            if($(this).val()==null||$(this).val()==""){
                $(this).next().html("不能为空")
            }else{
                $(this).next().html("")
            }
        })
    })
</script>
</html>