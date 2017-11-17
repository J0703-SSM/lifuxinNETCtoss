<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
    <script language="javascript" type="text/javascript">
        //保存成功的提示消息
        function showResult() {
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
        function checkName() {
            $("#name_msg").text("");
            var role_name = $('#role_name').val();
            if (role_name == "") {
                $("#name_msg").text("名字不能为空")
                return;
            }
            var reg = /^[\u4E00-\u9FA5A-Za-z0-9]{2,10}$/;
            if (!reg.test(role_name)) {
                $("#name_msg").text("名称为2-10长度的字母、数字和汉字的组合");
            } else {
                $("#name_msg").text("名称校验通过...").removeClass("error_msg").attr("style", "color:green;font-family:'微软雅黑';");
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
    <!--保存操作后的提示信息：成功或者失败-->
    <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，角色名称重复！-->
    <form action="/add_role" method="post" class="main_form">
        <div class="text_info clearfix"><span>角色名称：</span></div>
        <div class="input_info">
            <input type="text" class="width200" placeholder="2-10长度的字母、数字和汉字的组合" name="role_name" id="role_name" onblur="checkName()"/>
            <span class="required">*</span>
            <div class="validate_msg_medium" style="color: red" id="name_msg">${addRoleName_msg}</div>
        </div>
        <div class="text_info clearfix"><span>设置权限：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul>
                    <li><input type="checkbox" name="name" value="管理员管理"/>管理员管理</li>
                    <li><input type="checkbox" name="name" value="角色管理"/>角色管理</li>
                    <li><input type="checkbox" name="name" value="资费管理"/>资费管理</li>
                    <li><input type="checkbox" name="name" value="账务账号"/>账务账号</li>
                    <li><input type="checkbox" name="name" value="业务账号"/>业务账号</li>
                    <li><input type="checkbox" name="name" value="账单"/>账单</li>
                    <li><input type="checkbox" name="name" value="报表"/>报表</li>
                </ul>
            </div>
            <span class="required">*</span>
            <div class="validate_msg_tiny">${add_msg}</div>
        </div>
        <div class="button_info clearfix">
            <%-- onclick="showResult();"--%>
            <input type="submit" value="保存" class="btn_save"/>
            <input type="button" value="取消" class="btn_save" onclick="history.back()"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>
</body>
</html>
