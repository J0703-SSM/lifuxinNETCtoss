<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
    <script language="JavaScript" type="text/javascript">
        function sub() {
            var from = document.getElementsByName("formName")[0];
            from.submit();
        }
        <%--点击更新验证--%>
        function changeImage() {
            $("#verifyCodeImage").attr('src', '/getVerifyCode?date=' + Math.random());
        }
        <%-- 对输入框的验证,用户名的验证 --%>
        function checkName() {
            $("#name_msg").text("");
            var admin_code = $('#admin_code').val();
            if (admin_code == "") {
                $('#name_msg').text("名字不能为空")
                return;
            }
            var reg = /^[\u4E00-\u9FA5A-Za-z0-9]{2,10}$/;
            if (!reg.test(admin_code)) {
                $("#name_msg").text("请正确填写登录名");
            } else {
                $("#name_msg").text("名称校验通过...").removeClass("error_msg").attr("style", "color:green;font-family:'微软雅黑';");
            }
        }
        <%-- 对密码进行验证 --%>
        function pass() {
            $("#password_msg").text("");
            var password = $('#password').val();
            if (password == "") {
                $('#password_msg').text("密码不能为空")
                return;
            }
            var reg = /^[\u4E00-\u9FA5A-Za-z0-9]{4,10}$/;
            if (!reg.test(password)) {
                $("#password_msg").text("请正确填写密码");
            } else {
                $("#password_msg").text("密码校验通过...").removeClass("error_msg").attr("style", "color:green;font-family:'微软雅黑';");
            }
        }
        <%-- 对验证码进行验证 --%>
        function verify() {
            $("#verifyCodeInput_msg").text("");
            var verifyCodeInput = $('#verifyCodeInput').val();
            if (verifyCodeInput == "") {
                $('#verifyCodeInput_msg').text("验证码不能为空")
                return;
            }
        }
    </script>
</head>
<body class="index">
<div class="login_box">
    <form name="formName" action="/login" method="post">
        <table>
            <tr>
                <td class="login_info">账&nbsp;&nbsp;&nbsp;号：</td>
                <td colspan="2"><input name="admin_code" id="admin_code"
                                       placeholder="2-10长度的字母、数字" type="text" class="width150" onblur="checkName()"/>
                </td>
                <td class="login_error_info" style="color: red" id="name_msg"><span class="required">${log_msg}</span>
                </td>
            </tr>
            <tr>
                <td class="login_info">密&nbsp;&nbsp;&nbsp;码：</td>
                <td colspan="2"><input name="password" id="password"
                                       placeholder="4-10长度的字母、数字" type="password" class="width150" onblur="pass()"/>
                </td>
                <td class="login_error_info" style="color: red" id="password_msg"><span
                        class="required">${psw_msg}</span></td>
            </tr>
            <tr>
                <td class="login_info">验证码：</td>
                <td class="width70"><input name="verifyCodeInput" type="text" class="width70"
                                           id="verifyCodeInput" onblur="verify()"/></td>
                <td><img src="/getVerifyCode" alt="验证码" title="点击更换" id="verifyCodeImage" onclick="changeImage()"/></td>
                <td><span class="required" id="verifyCodeInput_msg">${codemsg}</span></td>
            </tr>
            <tr>
                <td></td>
                <td class="login_button" colspan="2">
                    <a onclick="sub();" href="javascript:;"><img src="../../resources/images/login_btn.png"/></a>
                </td>
                <%--<td><span class="required">用户名或密码错误，请重试</span></td>--%>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
