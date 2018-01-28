<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/26
  Time: 14:09
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
    <title>求职者主页</title>
</head>
<body>
    欢迎你，${guest.g_name}
    <input type="button" value="个人简历" id="resume"><input type="button" value="查看招聘" id="recruitment">
    <div id="rm_recruitment" style="display: none">
        <c:forEach items="${recruitments}" var="rec">
            ${rec}<br/>
        </c:forEach>
    </div>
    <div style="display: none" id="r_resume">
        <c:if test="${resumecount!=0}">
            ${resume}
            <input type="button" value="修改简历" id="updateresume">
        </c:if>
        <c:if test="${resumecount==0}">
            <input type="button" value="新建招聘" id="showresume">
        </c:if>
    </div>
    <div id="newresume" style="display: none;">
        <form action="addResume" method="post">
            <table>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="r_name"></td>
                    <td>年龄：</td>
                    <td><input type="text" name="r_age"></td>
                </tr>
                <tr>
                    <td>名族：</td>
                    <td><input type="text" name="r_ethnicity"></td>
                    <td>电话：</td>
                    <td><input type="text" name="r_phone"></td>
                </tr>
                <tr>
                    <td>身高：</td>
                    <td><input type="text" name="r_height"></td>
                    <td>体重：</td>
                    <td><input type="text" name="r_weight"></td>
                </tr>
                <tr>
                    <td>婚姻状况：</td>
                    <td><input type="text" name="r_marrige"></td>
                    <td>毕业学校：</td>
                    <td><input type="text" name="r_schoolofgraduation"></td>
                </tr>
                <tr>
                    <td colspan="2">家庭住址：</td>
                    <td colspan="2"><input type="text" name="r_address"></td>
                </tr>
                <tr>
                    <td colspan="4">自我评价：</td>
                </tr>
                <tr>
                    <td colspan="4">
                        <textarea name="r_selfassessment"></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">实习经历：</td>
                </tr>
                <tr>
                    <td colspan="4">
                        <textarea name="r_r_intership"></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">曾获奖项：</td>
                </tr>
                <tr>
                    <td colspan="4">
                        <textarea name="r_award"></textarea>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="新建简历"></td>
                    <td><input type="button" value="取消创建" id="cancelresume"></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $("#recruitment").click(function () {
            $("#rm_recruitment").show()
        })
        $("#resume").click(function () {
            $("#r_resume").show()
        })
        $("#showresume").click(function () {
            $("#newresume").show()
        })
        $("#cancelresume").click(function () {
            $("#newresume").hide()
        })
    })
</script>
</html>