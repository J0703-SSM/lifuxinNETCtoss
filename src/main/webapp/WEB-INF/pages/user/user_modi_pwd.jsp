<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <title></title>
        <script src="/resources/js/jquery-3.2.1.js"></script>
        <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css" />
        <script language="JavaScript" type="text/javascript">
            function showResult() {
                if ($("#oldPwd").val() == "" || $("#newPwd") == "" || $("#rePwd").val() == ""){
                    $("#msg").html("*请填写完整信息");
                    return false;
                }else {
                    $("#msg").html("");
                }
                if ($("#oldPwd").val() != ${applicationScope.admin_info.password}){
                    $("#old_msg").html("*旧密码输入错误");
                    return false;
                }else {
                    $("#old_msg").html("")
                }

                if ($("#newPwd").val() != $("#rePwd").val()){
                    $("#re_msg").html("*对不起你两次输入的密码不相同,请重新输入")
                    return false;
                }else {
                    $("#re_msg").html("");
                }
                if ($("#oldPwd").val() == $("#newPwd").val()){
                    $("#new_msg").html("*新密码和旧密码不能相同")
                    return false;
                }else {
                    $("#new_msg").html("");
                }

                $.ajax({
                    type:"get",
                    url: "/updatePassword",
                    data: {
                        "oldPwd": $("#oldPwd").val(),
                        "newPwd": $("#newPwd").val(),
                        "rePwd": $("#rePwd").val()
                    },
                    success:function (result) {
                        <%--alert("旧密码"+${applicationScope.admin_info.password})--%>
                        <%--alert(result.errorCode+"--"+result.message)--%>
                        document.getElementById("operate_result_info").style.display = "block";
                    }
                });


            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="/resources/images/logo.png" alt="logo" class="left"/>
            <a href="/quit">[退出]</a>
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
        <div id="main">
            <!--保存操作后的提示信息：成功或者失败-->
            <%--<div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，旧密码错误！-->--%>
            <div id="operate_result_info" class="operate_success">
                <img src="/resources/images/close.png"
                     onclick="this.parentNode.style.display='none';window.location.reload()"/>
                修改密码成功,请点击退出重新登录!
            </div>
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                    <input id="oldPwd" type="password" class="width200"/><span class="required"></span>
                    <div id="old_msg" class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input id="newPwd" type="password"  class="width200" /><span class="required"></span>
                    <div id="new_msg" class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input id="rePwd" type="password" class="width200"  /><span class="required"></span>
                    <div id="re_msg" class="validate_msg_medium"></div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save"  onclick="showResult();" />
                    <input type="button" value="取消" class="btn_save" onclick="history.back()"/>
                    <div id="msg" style="color: red"  class="validate_msg_medium"></div>
                </div>-
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)云科技有限公司 </p>
        </div>
    </body>
</html>
