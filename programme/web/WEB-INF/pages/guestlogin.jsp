<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/26
  Time: 11:01
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
    <title>求职者入口</title>
</head>
<body>
    <a href="guest-none">先去看看</a><br/>
    <div>
        <form method="post" action="guestLogin">
            登录<br/>
            ${loginResult}<br/>
            用户名：<input type="text" name="g_name" id="g_name"><span></span><br/>
            密码：<input type="password" name="g_password" id="g_password"><span></span><br/>
            没有账号?<a href="guestregister"><span style="color: cornflowerblue">马上注册</span></a><br/>
            <input type="submit" value="登录">
        </form>
    </div>

</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $("#g_name,#g_password").bind('input propertychange blur',function () {
            if($(this).val()==null||$(this).val()==""){
                $(this).next().html("不能为空")
            }else{
                $(this).next().html("")
            }
        })
    })
</script>
</html>