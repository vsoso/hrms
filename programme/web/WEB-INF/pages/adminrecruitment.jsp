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
    <title>标题</title>
</head>
<body>
<a href="toadminmain"><input type="button" value="返回"></a>
<form action="updateRecruitment" method="post">
    <input type="hidden" name="rm_id" value="${recruitment.rm_id}">
    <input type="hidden" name="rm_cid" value="${recruitment.rm_cid}">
    <table>
        <tr>
            <td>招聘职位：</td>
            <td><span class="oldrm">${recruitment.rm_name}</span><input type="text" name="rm_name" value="${recruitment.rm_name}" class="uprm"></td>
            <td>招聘人数：</td>
            <td><span class="oldrm">${recruitment.rm_peopleneeded}</span><input type="text" name="rm_peopleneeded" value="${recruitment.rm_peopleneeded}" class="uprm"></td>
        </tr>
        <tr>
            <td>所需部门：</td>
            <td>
                <span>
                    <c:forEach items="${depts}" var="dep">
                        <c:if test="${dep.d_id==recruitment.rm_did}">
                            ${dep.d_name}
                        </c:if>
                    </c:forEach>
                </span>
            </td>
            <td>所需职位：</td>
            <td>
                <span>
                    <c:forEach items="${jobs}" var="job">
                        <c:if test="${job.j_id==recruitment.rm_jid}">
                            ${job.j_name}
                        </c:if>
                    </c:forEach>
                </span>
            </td>
        </tr>
        <tr>
            <td>工作地点：</td>
            <td><span class="oldrm">${recruitment.rm_workplace}</span><input type="text" name="rm_workplace" value="${recruitment.rm_workplace}" class="uprm"></td>
            <td>工资待遇：</td>
            <td><span class="oldrm">${recruitment.rm_money}</span><input type="text" name="rm_money" value="${recruitment.rm_money}" class="uprm"></td>
        </tr>
        <tr>
            <td colspan="4">职位需求：</td>
        </tr>
        <tr>
            <td colspan="4">
                <span class="oldrm">${recruitment.rm_requirement}</span>
                <textarea name="rm_requirement" class="uprm">${recruitment.rm_requirement}</textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="button" value="修改招聘" id="updatenewRe"><input type="button" value="保存修改" id="saveandupdaterecruitment" style="display: none"><input type="button" value="取消修改" id="cancelupdaterecruitment" style="display: none"></td>
            <td><a id="todeleterecruitment"><input type="button" value="结束招聘" id="deleterecruitment"></a></td>
            <td></td>
        </tr>
    </table>
</form>
<div>
    应聘者：
    <c:forEach items="${applications}" var="app">
        <c:forEach items="${resumes}" var="res">
            <a href="checkGuest?g_id=${res.r_gid}">
                <c:if test="${app.ap_gid==res.r_gid}">
                    <c:out value="${res.r_name}"/>
                </c:if>
            </a>
        </c:forEach>
    </c:forEach>
</div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $(".uprm").hide()
        $("#updatenewRe").click(function () {
            $(".uprm").show()
            $(".oldrm").hide()
            $(this).hide()
            $("#saveandupdaterecruitment,#cancelupdaterecruitment").show()
        })
        $("#cancelupdaterecruitment").click(function () {
            $(".uprm").hide()
            $(".oldrm").show()
            $("#updatenewRe").show()
            $("#saveandupdaterecruitment,#cancelupdaterecruitment").hide()
        })
        $("#saveandupdaterecruitment").click(function () {
            if(confirm("确定修改招聘信息吗？")==true){
                $("#saveandupdaterecruitment").attr("type","submit")
            }
        })
        $("#deleterecruitment").click(function () {
            if(confirm("确定删除该条招聘吗？这将无法再看到已应聘该职位的求职者")==true){
                $("#todeleterecruitment").attr("href","deleteRecruitment?rm_id=${recruitment.rm_id}")
            }
        })
    })
</script>
</html>