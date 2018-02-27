<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/1/28
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <input type="button" value="面试信息" id="interview">
    <input type="button" value="部门职位" id="deptAndJob">
    <input type="button" value="员工信息" id="employee">
    <input type="button" value="培训信息" id="train">
    <input type="button" value="奖惩记录" id="reward">
    <div id="r_reward" style="display: none">
        <table>
            <tr>
                <td>员工姓名</td>
                <td>奖惩时间</td>
                <td>奖惩理由</td>
                <td>奖惩金额</td>
            </tr>
            <c:forEach items="${rewards}" var="rew">
                <tr>
                    <td>
                        <c:forEach items="${employees}" var="emplo">
                            <c:if test="${emplo.e_id==rew.re_eid}">
                                ${emplo.e_realname}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${rew.re_time}</td>
                    <td>${rew.re_reason}</td>
                    <td>${rew.re_money}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="t_train" style="display:none">
        <table>
            <tr>
                <td>培训内容</td>
                <td>培训时间</td>
                <td>培训地址</td>
                <td>培训部门</td>
                <td></td>
            </tr>
            <c:forEach items="${trains}" var="train">
                <form action="updateTrain">
                    <input type="hidden" value="${train.t_id}" name="t_id">
                    <tr>
                        <td><span>${train.t_train}</span><textarea style="display: none" class="updaTrain" name="t_train">${train.t_train}</textarea></td>
                        <td><span>${train.t_time}</span><input style="display: none" value="${train.t_time}" class="updaTrain" name="t_time"></td>
                        <td><span>${train.t_address}</span><input style="display: none" value="${train.t_address}" class="updaTrain" name="t_address"></td>
                        <td>
                            <span>
                                <c:forEach items="${depts}" var="dep">
                                    <c:if test="${dep.d_id==train.t_did}">${dep.d_name}</c:if>
                                </c:forEach>
                            </span>
                            <select style="display: none" name="t_did" class="updaTrain">
                                <c:forEach items="${depts}" var="dep">
                                    <option value="${dep.d_id}">${dep.d_name}</option>
                                </c:forEach>
                            </select>
                            <input style="display: none" class="updaTrain" value="保存修改" type="submit"><input style="display: none" class="cancelupdateTrain" value="取消修改" type="button">
                        </td>
                        <td>
                            <input type="button" value="修改培训信息" class="updateTrain">
                            <input type="button" value="删除培训" class="deleteTrain"><a href="deleteTrain?t_id=${train.t_id}"><input type="hidden"></a>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
        <input type="button" value="新增培训" id="showNewTrain">
        <div id="newTrain" style="display: none">
            <form action="addTrain">
                培训内容：<textarea name="t_train"></textarea><br/>
                培训时间：<input name="t_time"><br/>
                培训地址：<input name="t_address"><br/>
                培训部门：
                <select name="t_did">
                    <c:forEach items="${depts}" var="dep">
                        <option value="${dep.d_id}">${dep.d_name}</option>
                    </c:forEach>
                </select><br/>
                <input type="submit" id="addNewTrain" value="创建培训"><input type="button" id="cancelNewTrain" value="取消创建">
            </form>
        </div>
    </div>
    <div id="e_employee" style="display:none">
        <table>
            <tr>
                <td>员工姓名</td>
                <td>所属部门</td>
                <td>所属职位</td>
                <td>入职日期</td>
                <td>基本薪资</td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach items="${employees}" var="emp">
                <tr>
                    <td>${emp.e_realname}</td>
                    <td class="showDeptAndJob">
                        <c:forEach items="${depts}" var="dep">
                            <c:if test="${dep.d_id==emp.e_did}">
                                ${dep.d_name}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td class="showDeptAndJob">
                        <c:forEach items="${jobs}" var="job">
                            <c:if test="${job.j_id==emp.e_jid}">
                                ${job.j_name}
                            </c:if>
                        </c:forEach>
                    </td>
                    <form class="toNewJob" action="updateEmployeeJob" style="display: none">
                        <input type="hidden" value="${emp.e_id}" name="e_id">
                        <td class="toNewJob" style="display: none">
                            <select class="edept" name="e_did">
                                <option value="0">请选择</option>
                                <c:forEach items="${depts}" var="dp">
                                    <option value="${dp.d_id}">${dp.d_name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td class="toNewJob" style="display: none">
                            <select class="eposition" name="e_jid">
                                <option value="0">请选择</option>
                            </select>
                            <input type="submit" value="确定" class="confirmEChange"><input type="button" value="取消" class="cancelEChange">
                        </td>
                    </form>
                    <td>${emp.e_hiretime}</td>
                    <td class="bawg">
                        <form action="updateEmpMoney" style="display: none" class="upEMform">
                            <input type="hidden" value="${emp.e_id}" name="e_id">
                            <input style="display: none" value="${emp.e_basicwage}" name="e_basicwage">
                            <input style="display: none" value="确定" type="submit" class="confirmUpdateMoney">
                            <input style="display: none" value="取消" type="button" class="cancelUpdateMoney">
                        </form>
                        <span>${emp.e_basicwage}</span>
                    </td>
                    <td>
                        <input type="button" value="调换岗位" class="empNewJob" name="${emp.e_id}">
                        <input type="button" value="调整薪资" class="updateMoney">
                        <input type="button" value="进行奖惩" class="empReward" name="${emp.e_id}">
                        <input type="button" value="工资结算" class="empSalary" name="${emp.e_id}">
                        <a href="checkEmployeeAttendance?e_id=${emp.e_id}"><input type="button" value="查看考勤"></a>
                        <form action="fireEmployee">
                            <input type="hidden" value="${emp.e_id}" name="e_id">
                            <input type="hidden" value="${emp.e_name}" name="e_name">
                            <input type="button" value="辞退员工" class="fireEmp">
                        </form>
                        <c:if test="${emp.e_workstatus==1}">
                            <form action="updateEmpWorkStatus">
                                <input type="hidden" value="${emp.e_id}" name="e_id">
                                <input type="submit" value="试用期转正">
                            </form>
                        </c:if>
                    </td>
                    <td>
                        <c:forEach items="${allSalaries}" var="asal">
                            <c:if test="${asal.s_eid==emp.e_id}">
                                <c:if test="${asal.s_status==0}">
                                    <span>${asal.s_date}月工资申请复议</span>
                                    <input type="button" value="复议结果" class="reSal" name="${emp.e_id}">
                                    <input type="hidden" name="${asal.s_id}" class="hid">
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="i_interview" style="display: none">
        <table>
            <tr>
                <td>在招职位</td>
                <td>求职人员</td>
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
                        <c:forEach items="${resumes}" var="resu">
                            <c:if test="${resu.r_gid==inte.i_gid}">
                                ${resu.r_name}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${inte.i_interviewtime}</td>
                    <td>${inte.i_interviewaddress}</td>
                    <td>
                        <c:if test="${inte.i_gstatus==0}">
                            等待求职者确认
                        </c:if>
                        <c:if test="${inte.i_gstatus==1}">
                            <c:forEach items="${recruitments}" var="rec">
                                <c:if test="${rec.rm_id==inte.i_rmid}">
                                    <input type="button" value="面试结果" class="i_result"><a href="recruitEmployee?intid=${inte.i_id}&gid=${inte.i_gid}&rec=${rec.rm_id}" style="display: none"><input type="button"></a>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <c:if test="${inte.i_gstatus==2}">
                            求职者放弃该次面试
                        </c:if>
                        <c:if test="${inte.i_gstatus==3}">
                            已录用该员工
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="rm_recruitment" style="display: none">
        <table id="showallrecruitment">
            <tr>
                <td>招聘职位</td>
            </tr>
            <c:forEach items="${recruitments}" var="rec">
                <tr>
                    <td><a href="checkRecruitment?rm_id=${rec.rm_id}">${rec.rm_name}</a></td>
                </tr>
            </c:forEach>
            <input type="button" value="新建招聘" id="showrecruitment">
        </table>
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
                            <select id="dept" name="rm_did">
                                <option value="0">请选择</option>
                                <c:forEach items="${depts}" var="dp">
                                    <option value="${dp.d_id}">${dp.d_name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>所需职位：</td>
                        <td>
                            <select id="position" name="rm_jid">
                                <option value="0">请选择</option>
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
    </div>
    <div id="dAj_deptAndJob" style="display: none">
        <table id="showalldept">
            <tr>
                <td>部门名</td>
                <td>创建时间</td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach items="${depts}" var="dep">
                <tr>
                    <form action="updateDepartment">
                        <input type="hidden" name="d_id" value="${dep.d_id}">
                        <td><span>${dep.d_name}</span><input style="display: none" value="${dep.d_name}" class="updaDept" name="d_name"></td>
                        <td>${dep.d_createtime}</td>
                        <td><input type="button" value="修改部门" class="updateDept"><input type="submit" value="保存" class="upDept" style="display: none"><input type="button" value="取消" class="upDept" style="display: none"></td>
                        <td><input type="button" value="删除部门" class="deleteDept"><a href="deleteDepartment?d_id=${dep.d_id}"><input type="hidden"></a></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
        <input type="button" value="新增部门" id="addNewDept">
        <div id="newDept" style="display: none">
            <form action="addDepartment">
                <input name="d_name"><br/>
                <input type="submit" value="确认"><input type="button" value="取消" id="cancelAddDept">
            </form>
        </div>
        <div style="position:absolute;left:500px;top:35px">
        <table id="showalljob">
            <tr>
                <td>所属部门</td>
                <td>职位名</td>
                <td>创建时间</td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach items="${jobs}" var="job">
                <tr>
                    <form action="updateJob">
                        <input type="hidden" name="j_id" value="${job.j_id}">
                        <td>
                            <c:forEach items="${depts}" var="dep">
                                <c:if test="${dep.d_id==job.j_did}">
                                    ${dep.d_name}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td><span>${job.j_name}</span><input style="display: none" value="${job.j_name}" class="updaJob" name="j_name"></td>
                        <td>${job.j_createtime}</td>
                        <td><input type="button" value="修改职位" class="updateJob"><input type="submit" value="保存" class="upJob" style="display: none"><input type="button" value="取消" class="upJob" style="display: none"></td>
                        <td><input type="button" value="删除职位" class="deleteJob"><a href="deleteJob?j_id=${job.j_id}"><input type="hidden"></a></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
        <input type="button" value="新增职位" id="addNewJob">
        <div id="newJob" style="display: none">
            <form action="addJob">
                选择所属部门：
                <select name="j_did">
                    <c:forEach items="${depts}" var="dep">
                        <option value="${dep.d_id}">${dep.d_name}</option>
                    </c:forEach>
                </select>
                <input name="j_name"><br/>
                <input type="submit" value="确认"><input type="button" value="取消" id="cancelAddJob">
            </form>
        </div>
        </div>
    </div>
</body>
<script src="js/jquery-3.2.1.js"></script>
<script>
    $(document).ready(function () {
        $("#reward").click(function () {
            $("#rm_recruitment").hide()
            $("#i_interview").hide()
            $("#dAj_deptAndJob").hide()
            $("#t_train").hide()
            $("#e_employee").hide()
            $("#r_reward").show()
        })
        $("#deptAndJob").click(function () {
            $("#rm_recruitment").hide()
            $("#i_interview").hide()
            $("#dAj_deptAndJob").show()
            $("#t_train").hide()
            $("#e_employee").hide()
            $("#r_reward").hide()
        })
        $("#recruitment").click(function () {
            $("#rm_recruitment").show()
            $("#i_interview").hide()
            $("#dAj_deptAndJob").hide()
            $("#t_train").hide()
            $("#e_employee").hide()
            $("#r_reward").hide()
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
        $("#interview").click(function () {
            $("#i_interview").show()
            $("#rm_recruitment").hide()
            $("#dAj_deptAndJob").hide()
            $("#t_train").hide()
            $("#e_employee").hide()
            $("#r_reward").hide()
        })
        $(".i_result").click(function () {
            if(confirm("确定录用为员工吗？")==true){
                $(this).next().children("input").trigger("click")
            }
        })
        $(".deleteDept").click(function () {
            if(confirm("删除前请确保该部门下已无员工")==true){
                $(this).next().children("input").trigger("click")
            }
        })
        $("#addNewDept").click(function () {
            $("#newDept").show()
        })
        $("#cancelAddDept").click(function () {
            $("#newDept").hide()
        })
        $(".updateDept").click(function () {
            $(this).parent().parent().children("td").children("input").show()
            $(this).parent().parent().children("td").children("span").hide()
            $(this).hide()
            $(this).parent().children(".updept").show()
        })
        $(".upDept").click(function () {
            $(this).parent().parent().children("td").children(".updaDept").hide()
            $(this).parent().parent().children("td").children("span").show()
            $(this).hide()
            $(this).parent().children(".updateDept").show()
            $(this).parent().children(".upDept").hide()
        })
        $(".deleteJob").click(function () {
            if(confirm("删除前请确保该职位下已无员工")==true){
                $(this).next().children("input").trigger("click")
            }
        })
        $("#addNewJob").click(function () {
            $("#newJob").show()
        })
        $("#cancelAddJob").click(function () {
            $("#newJob").hide()
        })
        $(".updateJob").click(function () {
            $(this).parent().parent().children("td").children("input").show()
            $(this).parent().parent().children("td").children("span").hide()
            $(this).hide()
            $(this).parent().children(".upJob").show()
        })
        $(".upJob").click(function () {
            $(this).parent().parent().children("td").children(".updaJob").hide()
            $(this).parent().parent().children("td").children("span").show()
            $(this).hide()
            $(this).parent().children(".updateJob").show()
            $(this).parent().children(".upJob").hide()
        })
        $("#dept").change(function () {
            var d=$(this).val()
            $.ajax({
                url:"getJobByDept",
                data:{"d":d},
                javaType:"json",
                success:function (positions) {
                    $("#position").empty()
                    var p=eval(positions)
                    var str="";
                    $.each(positions,function (index,value) {
                        str+="<option value="+value.j_id+">"+value.j_name+"</option>"
                    })
                    $("#position").append(str)
                }
            })
        })
        $("#edept").change(function () {
            var d=$(this).val()
            $.ajax({
                url:"getJobByDept",
                data:{"d":d},
                javaType:"json",
                success:function (positions) {
                    $("#eposition").empty()
                    var p=eval(positions)
                    var str="";
                    $.each(positions,function (index,value) {
                        str+="<option value="+value.j_id+">"+value.j_name+"</option>"
                    })
                    $("#eposition").append(str)
                }
            })
        })
        $(".edept").change(function () {
            var d=$(this).val()
            $.ajax({
                url:"getJobByDept",
                data:{"d":d},
                javaType:"json",
                success:function (positions) {
                    $(".eposition").empty()
                    var p=eval(positions)
                    var str="";
                    $.each(positions,function (index,value) {
                        str+="<option value="+value.j_id+">"+value.j_name+"</option>"
                    })
                    $(".eposition").append(str)
                }
            })
        })
        $(".empNewJob").click(function () {
            $(this).parent().parent().children(".toNewJob").show()
            $(this).parent().parent().children(".toNewJob").children(".toNewJob").show()
            $(this).parent().parent().children(".showDeptAndJob").hide()
            $("#e_id").val($(this).attr("name"))
        })
        $(".cancelEChange").click(function () {
            $(this).parent().parent().children(".toNewJob").hide()
            $(this).parent().parent().children(".showDeptAndJob").show()
        })
        $(".confirmEChange").click(function () {
            alert("调换岗位成功，请通知员工相关具体事项")
        })
        $("#employee").click(function () {
            $("#e_employee").show()
            $("#rm_recruitment").hide()
            $("#i_interview").hide()
            $("#dAj_deptAndJob").hide()
            $("#t_train").hide()
            $("#r_reward").hide()
        })
        $(".updateMoney").click(function () {
            $(this).parent().parent().children(".bawg").children("span").hide()
            $(this).parent().parent().children(".bawg").children(".upEMform").show()
            $(this).parent().parent().children(".bawg").children().children("input").show()
        })
        $(".cancelUpdateMoney").click(function () {
            $(this).parent().children("input").hide()
            $(this).parent().parent().children("span").show()
            $(this).parent().hide()
        })
        $(".confirmUpdateMoney").click(function () {
            alert("薪资调整成功")
        })
        $(".fireEmp").click(function () {
            if(confirm("确认使该员工离职吗？")==true){
                prompt("请输入辞退原因：")
                $(this).attr("type","submit")
            }
        })
        $("#showNewTrain").click(function () {
            $("#newTrain").show()
        })
        $("#cancelNewTrain").click(function () {
            $("#newTrain").hide()
        })
        $("#addNewTrain").click(function () {
            alert("新建培训成功")
        })
        $(".deleteTrain").click(function () {
            if(confirm("确定取消该次培训吗")==true){
                $(this).next().children("input").trigger("click")
            }
        })
        $("#train").click(function () {
            $("#i_interview").hide()
            $("#rm_recruitment").hide()
            $("#dAj_deptAndJob").hide()
            $("#t_train").show()
            $("#e_employee").hide()
            $("#r_reward").hide()
        })
        $(".updateTrain").click(function () {
            $(this).parent().parent().children("td").children(".updaTrain").show()
            $(this).parent().parent().children("td").children(".cancelupdateTrain").show()
            $(this).parent().parent().children("td").children("span").hide()
        })
        $(".cancelupdateTrain").click(function () {
            $(this).parent().children("input").hide()
            $(this).parent().parent().children("td").children(".updaTrain").hide()
            $(this).parent().parent().children("td").children(".cancelupdateTrain").hide()
            $(this).parent().parent().children("td").children("span").show()
        })
        $(".empReward").click(function () {
            var eid=$(this).attr("name")
            var reason=prompt("请输入奖惩理由")
            var money=prompt("请输入奖惩金额")
            var cid=${admin.a_cid}
            $.ajax({
                url:"rewardEmployee",
                data:{"re_eid":eid,"re_reason":reason,"re_money":money,"re_cid":cid},
                async:false,
                success:function () {
                    alert("添加奖惩记录成功")
                }
            })

        })
        $(".empSalary").click(function () {
            var eid=$(this).attr("name")
            $.ajax({
                url:"getLastSalaryByEid",
                data:{"s_eid":eid},
                success:function (obj) {
                    if(obj=="already"){
                        alert("已结算上月工资")
                    }else{
                        $.ajax({
                            url:"accountSalary",
                            data:{"s_eid":eid,"s_cid":${admin.a_cid}}
                        })
                        alert("结算成功")
                    }
                 }
             })
        })
        $(".reSal").click(function () {
            var money=prompt("请输入工资复议结果")
            var reason="工资出入补偿"
            var eid=$(this).attr("name")
            var sid=$(this).parent().children(".hid").attr("name")
            var cid=${admin.a_cid}
            $.ajax({
                url:"replyQuestionSalary",
                data:{"re_eid":eid,"re_reason":reason,"re_money":money,"s_id":sid,"re_cid":cid},
                async:false,
                success:function () {
                    alert("已将差额添加到奖惩记录")
                }
            })
            $(this).hide()
            $(this).parent().children("span").hide()
        })
    })
</script>
</html>