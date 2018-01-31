<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/30
  Time: 9:35
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

<table>
    <tr>
        <td>姓名：</td>
        <td>${resume.r_name}</td>
        <td>年龄：</td>
        <td>${resume.r_age}</td>
    </tr>
    <tr>
        <td>民族：</td>
        <td>${resume.r_ethnicity}</td>
        <td>电话：</td>
        <td>${resume.r_phone}</td>
    </tr>
    <tr>
        <td>身高：</td>
        <td>${resume.r_height}</td>
        <td>体重：</td>
        <td>${resume.r_weight}</td>
    </tr>
    <tr>
        <td>婚姻状况：</td>
        <td>${resume.r_marrige}</td>
        <td>毕业学校：</td>
        <td>${resume.r_schoolofgraduation}</td>
    </tr>
    <tr>
        <td>家庭住址：</td>
        <td colspan="3">${resume.r_address}</td>
    </tr>
    <tr>
        <td>自我评价：</td>
        <td colspan="3">
            ${resume.r_selfassessment}
        </td>
    </tr>
    <tr>
        <td>实习经历：</td>
        <td colspan="3">
            ${resume.r_intership}
        </td>
    </tr>
    <tr>
        <td>曾获奖项：</td>
        <td colspan="3">
            ${resume.r_award}
        </td>
    </tr>
    <tr>
        <td></td>
        <td><input type="button" value="发送面试邀请" id="sendinterview"></td>
        <td><a href="toadminrecruitment"><input type="button" value="返回"></a></td>
        <td></td>
    </tr>
</table>
<div id="createinterview" style="display: none">
    <form action="addInterview" method="post">
        <input type="hidden" name="i_gid" value="${resume.r_gid}">
        <input type="hidden" name="i_rmid" value="${recruitment.rm_id}">
        <input type="hidden" name="i_cid" value="${recruitment.rm_cid}">
        <table>
            <tr>
                <td>面试时间：</td>
                <td colspan="3"><input type="time" name="i_interviewtime"></td>
            </tr>
            <tr>
                <td>面试地点：</td>
                <td colspan="3"><input type="text" name="i_interviewaddress"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="button" value="创建面试邀请" id="confirminterview"></td>
                <td><input type="button" value="取消创建邀请" id="giveupinterview"></td>
                <td></td>
            </tr>
        </table>
    </form>
</div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $("#sendinterview").click(function () {
            $("#createinterview").show()
        })
        $("#giveupinterview").click(function () {
            $("#createinterview").hide()
        })
        $("#confirminterview").click(function () {
            if(confirm("确定发送面试邀请吗？")==true){
                alert("已发送面试邀请")
                $("#confirminterview").attr("type","submit")
            }
        })
    })
</script>
</html>