<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/26
  Time: 15:09
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
    <title>求职者注册</title>
</head>
<body>
<div>
    <a href="guest-none">先去看看</a><br/>
    <form method="post" action="guestRegister">
        注册<br/>
        ${registerResult}<br/>
        用户名：<input type="text" name="g_name" id="g_name"><span></span><br/>
        密码：<input type="password" name="g_password" id="g_password"><span></span><div style="position:absolute;left:210px;top:100px"><div id="d1"></div><div id="d2"></div><div id="d3"></div><div id="d4"></div></div><br/>
        确认密码：<input type="password" name="g_passwordRe" id="g_passwordRe"><span></span><br/>
        已有账号 <a href="guest"><span style="color: cornflowerblue">立即登录</span></a><br/>
        <input type="submit" value="注册"><a href="../../index.jsp"><input type="button" value="返回"></a>
    </form>
</div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $("#d1,#d2,#d3,#d4").css({"width":"22px","height":"22px","float":"left","display":"inline"})
        $("#g_name").bind('input propertychange blur',function () {
            if($(this).val()==null||$(this).val()==""){
                $(this).next().html("不能为空")
            }else if ($(this).val().length<4){
                $(this).next().html("用户名至少为4位")
            }else {
                $(this).next().html("")
            }
        })
        $("#g_password").bind('input propertychange blur',function () {
            if($(this).val()==null||$(this).val()==""){
                $(this).next().html("不能为空")
            }else if ($(this).val().length<4){
                $(this).next().html("密码至少为4位")
                $("#d1").hide()
                $("#d2").hide()
                $("#d3").hide()
                $("#d4").hide()
            }else if ($(this).val().length>=4&&$(this).val().length<=6){
                $(this).next().html("")
                $("#d1").css("background-color","red")
                $("#d1").html("")
                $("#d1").show()
                $("#d2").css("background-color","white")
                $("#d2").html("低")
                $("#d2").show()
                $("#d3").css("background-color","white")
                $("#d3").html("")
                $("#d3").hide()
                $("#d4").hide()
            }else if ($(this).val().length>=7&&$(this).val().length<=10){
                $(this).next().html("")
                $("#d1").css("background-color","yellow")
                $("#d1").html("")
                $("#d2").show()
                $("#d2").css("background-color","yellow")
                $("#d2").html("")
                $("#d2").show()
                $("#d3").css("background-color","white")
                $("#d3").html("中")
                $("#d3").show()
                $("#d4").hide()
            } else if ($(this).val().length>10){
                $(this).next().html("")
                $("#d1").css("background-color","green")
                $("#d1").html("")
                $("#d1").show()
                $("#d2").css("background-color","green")
                $("#d2").html("")
                $("#d2").show()
                $("#d3").css("background-color","green")
                $("#d3").html("")
                $("#d3").show()
                $("#d4").html("高")
                $("#d4").show()
            } else {
                $(this).next().html("")
            }
        })
        $("#g_passwordRe").bind('input propertychange blur',function () {
            if($(this).val()==null||$(this).val()==""){
                $(this).next().html("不能为空")
            }else if ($(this).val()!=$("#g_password").val()){
                $(this).next().html("密码不相同")
            }else {
                $(this).next().html("")
            }
        })
    })
</script>
</html>