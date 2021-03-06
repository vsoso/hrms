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
    <input type="button" value="个人简历" id="resume"><input type="button" value="查看招聘" id="recruitment"><input type="button" value="面试邀请" id="interview">
    <div id="i_interview" style="display: none">
        <table>
            <tr>
                <td>应聘职位</td>
                <td>所属公司</td>
                <td>面试时间</td>
                <td>面试地点</td>
                <td></td>
            </tr>
            <c:forEach items="${interviews}" var="inte">
                <tr>
                    <td>
                        <c:forEach items="${recruitments}" var="rec">
                            <c:if test="${rec.rm_id==inte.i_rmid}">
                                ${rec.rm_name}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${recruitments}" var="rec">
                            <c:if test="${rec.rm_id==inte.i_rmid}">
                                <c:forEach items="${companies}" var="com">
                                    <c:if test="${rec.rm_cid==com.c_id}">
                                        ${com.c_name}
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${inte.i_interviewtime}</td>
                    <td>${inte.i_interviewaddress}</td>
                    <td>
                        <c:if test="${inte.i_gstatus==0}">
                            <a href="acceptInterview?i_id=${inte.i_id}"><input type="button" value="接受面试" id="accIn"></a>
                            <input type="button" value="放弃面试" id="refIn"><a href="refuseInterview?i_id=${inte.i_id}" style="display: none"><input type="button" id="refInt"></a>
                        </c:if>
                        <c:if test="${inte.i_gstatus==1}">
                            已接受
                        </c:if>
                        <c:if test="${inte.i_gstatus==2}">
                            已放弃
                        </c:if>
                        <c:if test="${inte.i_gstatus==3}">
                            已被该公司录取，请使用员工登录查看更多信息（账号密码相同）
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
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
                    <td>
                        <a href="seeRecruitment?rm_id=${rec.rm_id}">
                            <c:forEach items="${companies}" var="com">
                                <c:if test="${com.c_id==rec.rm_cid}">
                                    ${com.c_name}
                                </c:if>
                            </c:forEach>
                        </a>
                    </td>
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
                        <td><span class="oldre">${resume.r_name}</span><input type="text" name="r_name" class="upre" value="${resume.r_name}" required="required"></td>
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
            $("#rm_recruitment").show()
            $("#i_interview").hide()
        })
        $("#resume").click(function () {
            $("#rm_recruitment").hide()
            $("#r_resume").show()
            $("#i_interview").hide()
        })
        $("#showresume").click(function () {
            $("#r_resume").hide()
            $("#newresume").show()
        })
        $("#cancelresume").click(function () {
            $("#newresume").hide()
        })
        $("#interview").click(function () {
            $("#r_resume").hide()
            $("#rm_recruitment").hide()
            $("#i_interview").show()
        })
        $("#accIn").click(function () {
            alert("你已接受面试邀请，请准时出席")
        })
        $("#refIn").click(function () {
            if(confirm("确认要放弃此次面试吗")==true){
                $("#refInt").trigger("click")
            }
        })
    })
</script>
</html>