<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/29
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h4>
            <c:forEach items="${companies}" var="com">
                <c:if test="${com.c_id==recruitment.rm_cid}">
                    ${com.c_name}
                </c:if>
            </c:forEach>
        </h4>
        招聘职位名：${recruitment.rm_name} 招聘人数：${recruitment.rm_peopleneeded}<br/>
        工资待遇：${recruitment.rm_money} 工作地点：${recruitment.rm_workplace}<br/>
        职位需求：<br/>
        ${recruitment.rm_requirement}<br/>
        <a id="applyForJob"><input type="button" value="应聘并提交简历" id="sub"></a><a href="toGuestMain"><input type="button" value="返回主页"></a>
    </div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $("#sub").click(function () {
            if(${guest.g_applicationstatus==1}){
                alert("你已被公司录取，无法投递简历")
            }else{
                alert("简历已提交！")
                $("#applyForJob").attr("href","applyForJob")
            }
        })
    })
</script>
</html>