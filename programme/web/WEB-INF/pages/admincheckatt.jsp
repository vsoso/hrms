<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/29
  Time: 22:12
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
    <title>员工考勤</title>
</head>
<body>
<a href="toadminmain"><input type="button" value="返回"></a>
<div>
    <table>
        <tr>
            <td>考勤日期</td>
            <td>上班时间</td>
            <td>上班考勤</td>
            <td>下班时间</td>
            <td>下班考勤</td>
        </tr>
        <c:forEach items="${attendances}" var="atte">
            <tr>
                <td>${atte.at_day}</td>
                <td>${atte.at_starttime}</td>
                <td>
                    <c:if test="${atte.at_startresult==0}">
                        迟到超过3小时
                    </c:if>
                    <c:if test="${atte.at_startresult==1}">
                        正常
                    </c:if>
                    <c:if test="${atte.at_startresult==2}">
                        迟到1小时内
                    </c:if>
                    <c:if test="${atte.at_startresult==3}">
                        迟到3小时内
                    </c:if>
                </td>
                <td>${atte.at_endtime}</td>
                <td>
                    <c:if test="${atte.at_endresult==0}">
                        早退超过3小时
                    </c:if>
                    <c:if test="${atte.at_endresult==1}">
                        正常
                    </c:if>
                    <c:if test="${atte.at_endresult==2}">
                        早退1小时内
                    </c:if>
                    <c:if test="${atte.at_endresult==3}">
                        早退3小时内
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {

    })
</script>
</html>