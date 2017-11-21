<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>云科技</title>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
    <script language="javascript" type="text/javascript">
        //保存成功的提示消息
        function checkName() {
            $("#name_msg").text("");
            var name = $('#name').val();
            if (name == "") {
                $('#name_msg').text("名字不能为空")
                return;
            }
        }
        function pass1() {
            $("#password_msg").text("");
            var password = $('#password').val();
            if (password == "") {
                $('#password_msg').text("密码不能为空")
                return;
            }
        }
        function aadmin_code() {
            $("#admin_msg").text("");
            var admin_code = $('#admin_code').val();
            if (admin_code == "") {
                $('#admin_msg').text("账号不能为空")
                return;
            }
        }
        function rePawd() {
            $("#rePwd_msg").text("");
            var rePassword = $('#rePassword').val();
            var password = $('#password').val();
            if (rePassword == "") {
                $('#rePwd_msg').text("重复密码不能为空")
                return;
            }
        }
        function tel() {
            $("#tel_msg").text("");
            var telephone = $('#telephone').val();
            if (telephone == "") {
                $('#tel_msg').text("电话号码不能为空!")
                return;
            }
        }
        function email1() {
            $("#email_msg").text("");
            var email = $('#email').val();
            if (email == "") {
                $('#email_msg').text("邮箱不能为空!")
                return;
            }
        }




        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none"
        }

        showResultDiv(true);
        window.setTimeout("showResultDiv(false);", 3000);


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
    <%--<div id="save_result_info" class="save_success">保存成功！</div>--%>
    <form action="/add_admin" method="post" class="main_form">
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input type="text" id="name" name="name" onblur="checkName()"/>
            <span class="required">*</span>
            <div class="validate_msg_long" id="name_msg"></div>
        </div>

        <div class="text_info clearfix"><span>管理员账号：</span></div>
        <div class="input_info">
            <input type="text" id="admin_code" name="admin_code" onblur="aadmin_code()"/>
            <span class="required">*</span>
            <%--30长度以内的字母、数字和下划线的组合--%>
            <div class="validate_msg_long" id="admin_msg"></div>
        </div>

        <div class="text_info clearfix"><span>密码：</span></div>
        <div class="input_info">
            <input type="password" id="password" name="password" onblur="pass1()"/>
            <span class="required">*</span>
            <%--30长度以内的字母、数字和下划线的组合--%>
            <div class="validate_msg_long" id="password_msg"></div>
        </div>

        <div class="text_info clearfix"><span>重复密码：</span></div>
        <div class="input_info">
            <input type="password" id="rePassword" onblur="rePawd()"/>
            <span class="required">*</span>
            <%--两次密码必须相同--%>
            <div class="validate_msg_long" id="rePwd_msg"></div>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">

            <input type="text" id="telephone" class="width200" name="telephone" onblur="tel()"/>
            <span class="required">*</span>
            <%--正确的电话号码格式：手机或固话--%>
            <div class="validate_msg_medium" id="tel_msg"></div>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="text" id="email" class="width200" name="email" onblur="email1()"/>
            <span class="required">*</span>
            <%--50长度以内，正确的 email 格式--%>
            <div class="validate_msg_medium" id="email_msg"></div>
        </div>
        <div class="text_info clearfix"><span>角色：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul>
                    <li><input name="role_name" type="checkbox" value="超级管理员"/>超级管理员</li>
                    <li><input name="role_name" type="checkbox" value="账务账号管理员"/>账务账号管理员</li>
                    <li><input name="role_name" type="checkbox" value="业务账号管理员"/>业务账号管理员</li>
                    <li><input name="role_name" type="checkbox" value="账务账号管理员"/>账务账号管理员</li>
                    <li><input name="role_name" type="checkbox" value="业务账号管理员"/>业务账号管理员</li>
                    <li><input name="role_name" type="checkbox" value="账务账号管理员"/>账务账号管理员</li>
                    <li><input name="role_name" type="checkbox" value="业务账号管理员"/>业务账号管理员</li>
                </ul>
            </div>
            <span class="required">*</span>
            <%--至少选择一个--%>
            <div class="validate_msg_tiny">${add_msg}</div>
        </div>
        <div class="button_info clearfix">
            <%--onclick="showResult();"--%>
            <input type="submit" value="保存" class="btn_save"/>
            <input type="button" value="取消" class="btn_save" onclick="history.back()"/>
        </div>
        <div id="msg" class="validate_msg_medium "></div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的...实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>
</body>
</html>
