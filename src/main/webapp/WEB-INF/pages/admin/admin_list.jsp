﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
    <script language="javascript" type="text/javascript">
        //显示角色详细信息
        function showDetail(flag, a) {
            var detailDiv = a.parentNode.getElementsByTagName("div")[0];
            if (flag) {
                detailDiv.style.display = "block";
            }
            else
                detailDiv.style.display = "none";
        }
        //重置密码
        function resetPwd() {
            if ($(":checkbox:checked").length == 0) {
                alert("请至少选择一条数据！");
            } else {
                var cbValue = "";
                $(":checkbox:checked").each(function () {
                    cbValue += $(this).val() + ","
                })

                $.ajax({
                    type: "get",
                    url: "admin_resetPwd",
                    data: {
                        cbValue: cbValue
                    },
                    success: function (result) {
                        if (result.message != 0) {
                            $("#result_info").html(result.message);
                            document.getElementById("operate_result_info").style.display = "block";
                        }
                    }
                })
            }
        }
        //删除
        function deleteAdmin() {
            var r = window.confirm("确定要删除此管理员吗？");
            document.getElementById("operate_result_info").style.display = "block";
        }
        //全选
        function selectAdmins(inputObj) {
            var inputArray = document.getElementById("datalist").getElementsByTagName("input");
            for (var i = 1; i < inputArray.length; i++) {
                if (inputArray[i].type == "checkbox") {
                    inputArray[i].checked = inputObj.checked;
                }
            }
        }


    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="/resources/images/logo.png" alt="logo" class="left"/>
    <a href="#">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <ul id="menu">
        <li><a href="/index" class="index_on"></a></li>
        <li><a href="/role_list" class="role_off"></a></li>

        <li><a href="/admin_list" class="admin_off"></a></li>
        <li><a href="/fee_list" class="fee_off"></a></li>
        <li><a href="/account_list" class="account_off"></a></li>

        <li><a href="service/service_list.jsp" class="service_off"></a></li>
        <li><a href="../pages/bill/bill_list.jsp" class="bill_off"></a></li>
        <li><a href="report/report_list.jsp" class="report_off"></a></li>

        <li><a href="/user_info" class="information_off"></a></li>
        <li><a href="/user_modi_pwd" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="/findHigh" method="post">
        <!--查询-->
        <div class="search_add">
            <div>
                模块：
                <select id="selModules" name="module_id" class="select_search">
                    <option value="-1">---请选择---</option>
                    <c:forEach items="${allModule}" var="all">
                        <option value="${all.module_id}">${all.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>角色：<input type="text" name="role_name" value="" class="text_search width200"/></div>

            <div><input type="submit" value="搜索" class="btn_search"/></div>

            <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();"/>
            <input type="button" value="增加" class="btn_add" onclick="location.href='/admin_add';"/>
        </div>
    </form>
        <!--删除和密码重置的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="/resources/images/close.png" onclick="this.parentNode.style.display='none';"/>
            <span>密码重置成功</span><!--密码重置失败！数据并发错误。-->
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th class="th_select_all">
                        <input type="checkbox" onclick="selectAdmins(this);"/>
                        <span>全选</span>
                    </th>
                    <th>管理员ID</th>
                    <th>姓名</th>
                    <th>登录名</th>
                    <th>电话</th>
                    <th>电子邮件</th>
                    <th>授权日期</th>
                    <th class="width100">拥有角色</th>
                    <th></th>
                </tr>

                <c:forEach items="${adminInfos}" var="info">
                    <tr>
                        <td><input  value="${info.admin_id}" type="checkbox"/></td>
                        <td>${info.admin_id}</td>
                        <td>${info.admin_code}</td>
                        <td>${info.name}</td>
                        <td>${info.telephone}</td>
                        <td>${info.email}</td>
                        <td>${info.enrolldate}</td>
                        <td>
                            <a class="summary" onmouseover="showDetail(true,this);"
                               onmouseout="showDetail(false,this);">${info.role_infos[0].role_name}</a>
                            <!--浮动的详细信息-->
                            <div class="detail_info">
                                <c:forEach items="${info.role_infos}" var="infos" varStatus="s">
                                    ${infos.role_name}
                                    <c:if test="${s.last == false}">
                                        ,
                                    </c:if>
                                </c:forEach>
                            </div>
                        </td>
                        <td class="td_modi">
                            <input type="button" value="修改" class="btn_modify"
                                   onclick="location.href='/admin_modi';"/>
                            <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin();"/>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <!--分页-->
        <%--<div id="pages">--%>
            <%--<a href="#">上一页</a>--%>
            <%--<a href="#" class="current_page">1</a>--%>
            <%--<a href="#">2</a>--%>
            <%--<a href="#">3</a>--%>
            <%--<a href="#">4</a>--%>
            <%--<a href="#">5</a>--%>
            <%--<a href="#">下一页</a>--%>
        <%--</div>--%>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <span>版权所有(C)云科技有限公司 </span>
</div>
</body>
</html>
