<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
    <script language="javascript" type="text/javascript">
        //保存成功的提示信息
        function showResult() {

            if ($("#name").val() == "" || $("tel").val() == "" || $("#email").val() == ""){
                $("#msg").html("* 请将信息填写完整")
                return false;
            }else {
                $("#msg").html("");
            }

            //姓名
            if (isString($("#name").val())) {
                $("#name_msg").html("*请输入中文姓名!");
                return false;
            } else {
                $("#name_msg").html("正确");
            }
            //手机号
            if (!isMobile($("#tel").val())) {
                $("#tel_msg").html("*请输入正确移动电话");
                return false;
            } else {
                $("#tel_msg").html("正确");
            }
            //邮箱
            if (!isEmail($("#email").val())) {
                $("#email_msg").html("*请输入正确邮箱");
                return false;
            } else {
                $("#email_msg").html("正确");
            }

            $.ajax({
                type:"get",
                url:"/updateAdminInfo",
                data:{
                    "name":$("#name").val(),
                    "telephone":$("#tel").val(),
                    "email":$("#email").val()
                },
                success:function () {

                }
            })
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }
        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none";
        }

        function isMobile(tel) {
            reg = /^(\+\d{2,3}\^-)?\d{11}$/;
            return reg.test(tel);
        }
        function isEmail(email) {
            reg = /^\w{3,}@\w+(\.\w+)+$/;
            return reg.test(email);
        }
        function isString(name) {
            reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
            return reg.test(name);
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
    <!--保存操作后的提示信息：成功或者失败-->
    <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，数据并发错误！-->
    <form action="" method="" class="main_form">
        <div class="text_info clearfix"><span>管理员账号：</span></div>
        <div class="input_info"><input type="text" readonly="readonly" class="readonly"
                                       value="${applicationScope.admin_info.admin_code}"/></div>
        <div class="text_info clearfix"><span>权限：</span></div>
        <div class="input_info">
            <input type="text" readonly="readonly" class="readonly width400"
                   value="<c:forEach items="${ms}" var="ms" varStatus="s">${ms.name}<c:if test="${s.last == false}">,</c:if></c:forEach>"/>
        </div>
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input id="name" name="name" type="text" value="${applicationScope.admin_info.name}"/>
            <span class="required">*</span>
            <%--20长度以内的汉字、字母的组合--%>
            <div id="name_msg" class="validate_msg_long"></div>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input id="tel" name="telephone" type="text" class="width200" value="${applicationScope.admin_info.telephone}"/>
            <%--电话号码格式：手机或固话--%>
            <div id="tel_msg" class="validate_msg_medium"></div>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input id="email" name="email" type="text" class="width200" value="${applicationScope.admin_info.email}"/>
            <%--50长度以内，符合 email 格式--%>
            <div id="email_msg" class="validate_msg_medium"></div>
        </div>
        <div class="text_info clearfix"><span>创建时间：</span></div>
        <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${applicationScope.admin_info.enrolldate}"/>
        </div>
        <div id="msg" class="validate_msg_medium "></div>
        <div class="button_info clearfix">
            <input type="button" value="保存" class="btn_save" onclick="showResult();"/>
            <input type="button" value="取消" class="btn_save"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司 </p>
</div>
</body>
</html>
