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
        <table id="showallrecruitment">
            <tr>
                <td>职位</td>
                <td>公司</td>
                <td>待遇</td>
            </tr>
            <c:forEach items="${recruitments}" var="rec">
                <tr>
                    <td><a href="seeRecruitment?rm_id=${rec.rm_id}">${rec.rm_name}</a></td>
                    <td><a href="seeRecruitment?rm_id=${rec.rm_id}">${rec.rm_cid}</a></td>
                    <td><a href="seeRecruitment?rm_id=${rec.rm_id}">${rec.rm_money}</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div style="display: none" id="r_resume">
        <c:if test="${resumecount!=0}">
            <form action="updateResume" method="post">
                <table>
                    <tr>
                        <td>姓名：</td>
                        <td><span class="oldre">${resume.r_name}</span><input type="text" name="r_name" class="upre" value="${resume.r_name}"></td>
                        <td>年龄：</td>
                        <td><span class="oldre">${resume.r_age}</span><input type="text" name="r_age" class="upre" value="${resume.r_age}"></td>
                    </tr>
                    <tr>
                        <td>民族：</td>
                        <td><span class="oldre">${resume.r_ethnicity}</span><input type="text" name="r_ethnicity" class="upre" value="${resume.r_ethnicity}"></td>
                        <td>电话：</td>
                        <td><span class="oldre">${resume.r_phone}</span><input type="text" name="r_phone" class="upre" value="${resume.r_phone}"></td>
                    </tr>
                    <tr>
                        <td>身高：</td>
                        <td><span class="oldre">${resume.r_height}</span><input type="text" name="r_height" class="upre" value="${resume.r_height}"></td>
                        <td>体重：</td>
                        <td><span class="oldre">${resume.r_weight}</span><input type="text" name="r_weight" class="upre" value="${resume.r_weight}"></td>
                    </tr>
                    <tr>
                        <td>婚姻状况：</td>
                        <td><span class="oldre">${resume.r_marrige}</span><input type="text" name="r_marrige" class="upre" value="${resume.r_marrige}"></td>
                        <td>毕业学校：</td>
                        <td><span class="oldre">${resume.r_schoolofgraduation}</span><input type="text" name="r_schoolofgraduation" class="upre" value="${resume.r_schoolofgraduation}"></td>
                    </tr>
                    <tr>
                        <td>家庭住址：</td>
                        <td colspan="3"><span class="oldre">${resume.r_address}</span><input type="text" name="r_address" class="upre" value="${resume.r_address}"></td>
                    </tr>
                    <tr>
                        <td>自我评价：</td>
                        <td colspan="3">
                            <span class="oldre">${resume.r_selfassessment}</span><textarea name="r_selfassessment" class="upre">${resume.r_selfassessment}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>实习经历：</td>
                        <td colspan="3">
                            <span class="oldre">${resume.r_intership}</span><textarea name="r_intership" class="upre">${resume.r_intership}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>曾获奖项：</td>
                        <td colspan="3">
                            <span class="oldre">${resume.r_award}</span><textarea name="r_award" class="upre">${resume.r_award}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="button" value="修改简历" id="updateresume"><input type="button" value="保存修改" id="saveandupdateresume" style="display: none"><input type="button" value="取消修改" id="cancelupdateresume" style="display: none"></td>
                        <td><a id="todeleteresume"><input type="button" value="删除简历" id="deleteresume"></a></td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </c:if>
        <c:if test="${resumecount==0}">
            <input type="button" value="新建简历" id="showresume">
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
                    <td>民族：</td>
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
                    <td>家庭住址：</td>
                    <td colspan="3"><input type="text" name="r_address"></td>
                </tr>
                <tr>
                    <td>自我评价：</td>
                    <td colspan="3">
                        <textarea name="r_selfassessment"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>实习经历：</td>
                    <td colspan="3">
                        <textarea name="r_intership"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>曾获奖项：</td>
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
        $(".upre").hide()
        $("#updateresume").click(function () {
            $(".oldre").hide()
            $(".upre").show()
            $(this).hide()
            $("#saveandupdateresume,#cancelupdateresume").show()
        })
        $("#cancelupdateresume").click(function () {
            $(".oldre").show()
            $(".upre").hide()
            $("#updateresume").show()
            $("#saveandupdateresume,#cancelupdateresume").hide()
        })
        $("#saveandupdateresume").click(function () {
            if(confirm("确定保存吗？")==true){
                $("#saveandupdateresume").attr("type","submit")
            }
        })
        $("#deleteresume").click(function () {
            if(confirm("确定删除吗？")==true){
                $("#todeleteresume").attr("href","deleteResume")
            }
        })
        $("#recruitment").click(function () {
            $("#r_resume").hide()
            $("#newresume").hide()
            $("#rm_recruitment").show()
        })
        $("#resume").click(function () {
            $("#newresume").hide()
            $("#rm_recruitment").hide()
            $("#r_resume").show()
        })
        $("#showresume").click(function () {
            $("#r_resume").hide()
            $("#newresume").show()
        })
        $("#cancelresume").click(function () {
            $("#newresume").hide()
        })
    })
</script>
</html>