<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/29
  Time: 14:24
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
    <title>标题</title>
</head>
<body>
    <div>
        <h4>${recruitment.rm_cid}</h4>
        招聘职位名：${recruitment.rm_name} 招聘人数：${recruitment.rm_peopleneeded}<br/>
        工资待遇：${recruitment.rm_money} 工作地点：${recruitment.rm_workplace}<br/>
        职位需求：<br/>
        ${recruitment.rm_requirement}<br/>
        <a href="applyForJob"><input type="button" value="应聘并提交简历" id="sub"></a><a href="toGuestMain"><input type="button" value="返回主页"></a>
    </div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $("#sub").click(function () {
            alert("简历已提交！")
        })
    })
</script>
</html>