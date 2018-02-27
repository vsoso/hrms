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
    <title>员工主页</title>
</head>
<body>
    欢迎你,${employee.e_name}
    <c:if test="${sessionScope.employee.e_workstatus!=0}">
        <a href="startWork?at_eid=${sessionScope.employee.e_id}"><input type="button" value="上班打卡" id="startWork"></a>
        <a href="endWork?at_eid=${sessionScope.employee.e_id}"><input type="button" value="下班打卡" id="endWork"></a><br/>
        <c:forEach items="${companies}" var="com">
            <c:if test="${com.c_id==sessionScope.employee.e_cid}">${com.c_name}</c:if>
        </c:forEach>
        <c:forEach items="${depts}" var="dep">
            <c:if test="${dep.d_id==sessionScope.employee.e_did}">${dep.d_name}</c:if>
        </c:forEach>
        <c:forEach items="${jobs}" var="job">
            <c:if test="${job.j_id==sessionScope.employee.e_jid}">${job.j_name}</c:if>
        </c:forEach>
        入职日期：${sessionScope.employee.e_hiretime}
    </c:if>
    <c:if test="${sessionScope.employee.e_workstatus==0}">
        <br/>你已离职，可以使用求职者入口再次求职
    </c:if>
    <br/>
    <input type="button" value="个人信息" id="employee">
    <input type="button" value="查看薪资" id="salary">
    <input type="button" value="奖惩情况" id="reward">
    <input type="button" value="培训信息" id="train">
    <input type="button" value="考勤信息" id="attandence">
    <input type="button" value="公司通讯录" id="allEmployee">
    <div id="a_allEmp" style="display: none">
        <table>
            <tr>
                <td>员工姓名</td>
                <td>所属部门</td>
                <td>所属职位</td>
                <td>入职时间</td>
                <td>联系电话</td>
                <td>入职日期</td>
            </tr>
            <c:forEach items="${sessionScope.employees}" var="emp">
                <tr>
                    <td>${emp.e_realname}</td>
                    <td>
                        <c:forEach items="${depts}" var="dep">
                            <c:if test="${dep.d_id==emp.e_did}">
                                ${dep.d_name}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${jobs}" var="job">
                            <c:if test="${job.j_id==emp.e_jid}">
                                ${job.j_name}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${emp.e_hiretime}</td>
                    <td>${emp.e_phone}</td>
                    <td>${emp.e_hiretime}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="e_employee" style="display: none">
        <form action="updateEmployee">
            <input type="hidden" value="${sessionScope.employee.e_id}" name="e_id">
            <input type="hidden" value="${sessionScope.employee.e_name}" name="e_name">
            <input type="hidden" value="${sessionScope.employee.e_password}" name="e_password">
            <table>
                <tr>
                    <td>姓名</td>
                    <td><span>${sessionScope.employee.e_realname}</span><input name="e_realname" style="display: none" value="${sessionScope.employee.e_realname}"></td>
                    <td>年龄</td>
                    <td><span>${sessionScope.employee.e_age}</span><input name="e_age" style="display: none" value="${sessionScope.employee.e_age}"></td>
                </tr>
                <tr>
                    <td>民族</td>
                    <td><span>${sessionScope.employee.e_ethnicity}</span><input name="e_ethnicity" style="display: none" value="${sessionScope.employee.e_ethnicity}"></td>
                    <td>联系电话</td>
                    <td><span>${sessionScope.employee.e_phone}</span><input name="e_phone" style="display: none" value="${sessionScope.employee.e_phone}"></td>
                </tr>
                <tr>
                    <td>婚姻情况</td>
                    <td><span>${sessionScope.employee.e_marrige}</span><input name="e_marrige" style="display: none" value="${sessionScope.employee.e_marrige}"></td>
                    <td>联系地址</td>
                    <td><span>${sessionScope.employee.e_address}</span><input name="e_address" style="display: none" value="${sessionScope.employee.e_address}"></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <input type="button" value="修改个人资料" id="updateEmp">
                        <input type="submit" value="保存修改" id="confirmUpdateEmp" style="display: none">
                        <input type="button" value="取消修改" id="cancelUpdateEmp" style="display: none">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="s_salary" style="display: none">
        <table>
            <tr>
                <td>工资月份</td>
                <td>基本工资</td>
                <td>迟到旷工扣除</td>
                <td>奖惩合计</td>
                <td>保险及税金扣除</td>
                <td>合计</td>
                <td></td>
            </tr>
            <c:forEach items="${salaries}" var="sala">
                <tr>
                    <td>${sala.s_date}</td>
                    <td>
                        ${sala.s_basic}
                        <c:if test="${sessionScope.employee.e_workstatus==1}">
                            (试用期*0.8）
                        </c:if>
                    </td>
                    <td>-${sala.s_bonus}</td>
                    <td>${sala.s_reward}</td>
                    <td>-${sala.s_money/0.88*0.12}</td>
                    <td>${sala.s_money}</td>
                    <td>
                        <c:if test="${sala.s_status==1}">
                            <a href="questionSalary?s_id=${sala.s_id}&s_eid=${sessionScope.employee.e_id}"><input value="复议" type="button" class="reSal"></a>
                        </c:if>
                        <c:if test="${sala.s_status==2}">
                            管理员已核对，请查看奖惩信息核对
                        </c:if>
                        <c:if test="${sala.s_status==0}">
                            管理员核对中
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="r_reward" style="display: none">
        <table>
            <tr>
                <td>奖惩时间</td>
                <td>奖惩理由</td>
                <td>奖惩金额</td>
            </tr>
            <c:forEach items="${rewards}" var="rew">
                <tr>
                    <td>${rew.re_time}</td>
                    <td>${rew.re_reason}</td>
                    <td>${rew.re_money}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="a_attandence" style="display: none">
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
    <div id="t_train" style="display: none">
        <table>
            <tr>
                <td>培训内容</td>
                <td>培训时间</td>
                <td>培训地址</td>
            </tr>
            <c:forEach items="${trains}" var="train">
                <td>${train.t_train}</td>
                <td>${train.t_time}</td>
                <td>${train.t_address}</td>
            </c:forEach>
        </table>
    </div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $("#allEmployee").click(function () {
            $("#a_allEmp").show()
            $("#e_employee").hide()
            $("#s_salary").hide()
            $("#r_reward").hide()
            $("#a_attandence").hide()
            $("#t_train").hide()
        })
        $("#employee").click(function () {
            $("#a_allEmp").hide()
            $("#e_employee").show()
            $("#s_salary").hide()
            $("#r_reward").hide()
            $("#a_attandence").hide()
            $("#t_train").hide()
        })
        $("#salary").click(function () {
            $("#a_allEmp").hide()
            $("#e_employee").hide()
            $("#s_salary").show()
            $("#r_reward").hide()
            $("#a_attandence").hide()
            $("#t_train").hide()
        })
        $("#reward").click(function () {
            $("#a_allEmp").hide()
            $("#e_employee").hide()
            $("#s_salary").hide()
            $("#r_reward").show()
            $("#a_attandence").hide()
            $("#t_train").hide()
        })
        $("#attandence").click(function () {
            $("#a_allEmp").hide()
            $("#e_employee").hide()
            $("#s_salary").hide()
            $("#r_reward").hide()
            $("#a_attandence").show()
            $("#t_train").hide()
        })
        $("#train").click(function () {
            $("#a_allEmp").hide()
            $("#e_employee").hide()
            $("#s_salary").hide()
            $("#r_reward").hide()
            $("#a_attandence").hide()
            $("#t_train").show()
        })
        $("#updateEmp").click(function () {
            $("#confirmUpdateEmp").show()
            $("#cancelUpdateEmp").show()
            $(this).parent().parent().parent().children("tr").children("td").children("span").hide()
            $(this).parent().parent().parent().children("tr").children("td").children("input").show()
            $(this).hide()
        })
        $("#cancelUpdateEmp").click(function () {
            $(this).parent().parent().parent().children("tr").children("td").children("span").show()
            $(this).parent().parent().parent().children("tr").children("td").children("input").hide()
            $("#updateEmp").show()
            $("#confirmUpdateEmp").hide()
            $("#cancelUpdateEmp").hide()
        })
        $("#startWork").click(function () {
            alert("上班打卡成功")
        })
        $("#endWork").click(function () {
            alert("下班打卡成功")
        })
        $(".reSal").click(function () {
            alert("申请复议成功")
        })
    })
</script>
</html>