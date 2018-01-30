<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/28
  Time: 22:23
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
    <title>管理员主页</title>
</head>
<body>
    欢迎你,${admin.a_name}
    <input type="button" value="招聘信息" id="recruitment">
    <div id="rm_recruitment" style="display: none">
        <table id="showallrecruitment">
            <tr>
                <td>招聘职位</td>
                <td>申请人数</td>
            </tr>
            <c:forEach items="${recruitments}" var="rec">
                <tr>
                    <td><a href="checkRecruitment?rm_id=${rec.rm_id}">${rec.rm_name}</a></td>
                    <td><a href="checkRecruitment?rm_id=${rec.rm_id}">${rec.rm_applycount}</a></td>
                </tr>
            </c:forEach>
            <input type="button" value="新建招聘" id="showrecruitment">
        </table>
    </div>
    <div id="newrecruitment" style="display: none;">
        <form action="addRecruitment" method="post">
            <table>
                <tr>
                    <td>职位名：</td>
                    <td><input type="text" name="rm_name"></td>
                    <td>招聘人数：</td>
                    <td><input type="text" name="rm_peopleneeded"></td>
                </tr>
                <tr>
                    <td>所需部门：</td>
                    <td>
                        <select>

                        </select>
                    </td>
                    <td>所需职位：</td>
                    <td>
                        <select>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td>工作地点：</td>
                    <td><input type="text" name="rm_workplace"></td>
                    <td>工资待遇：</td>
                    <td><input type="text" name="rm_money"></td>
                </tr>
                <tr>
                    <td colspan="4">职位需求：</td>
                </tr>
                <tr>
                    <td colspan="4">
                        <textarea name="rm_requirement"></textarea>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="新建招聘" id="addnewRe"></td>
                    <td><input type="button" value="取消创建" id="cancelrecruitment"></td>
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
        $("#showrecruitment").click(function () {
            $("#newrecruitment").show()
        })
        $("#cancelrecruitment").click(function () {
            $("#newrecruitment").hide()
        })
        $("#addnewRe").click(function () {
            alert("新建简历成功！")
        })
    })
</script>
</html>