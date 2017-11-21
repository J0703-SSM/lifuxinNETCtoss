<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
    <script language="javascript" type="text/javascript">

        function checkName() {
            $("#name_msg").text("");
            var name = $('#name').val();
            if (name == "") {
                $('#name_msg').text("名字不能为空")
                return;
            }
        }
        function checkTime() {
            $("#base_msg").text("");
            var base_duration = $('#base_duration').val();
            if (base_duration == "") {
                $('#base_msg').text("基本时长不能为空")
                return;
            }
        }
        function checkCost() {
            $("#cost_msg").text("");
            var base_cost = $('#base_cost').val();
            if (base_cost == "") {
                $('#cost_msg').text("基本费用不能为空")
                return;
            }
        }
        function checkUnit() {
            $("#unit_msg").text("");
            var unit_cost = $('#unit_cost').val();
            if (unit_cost == "") {
                $('#unit_msg').text("单位费用不能为空")
                return;
            }
        }
        function checkDescr() {
            $("#descr_msg").text("");
            var descr = $('#descr').val();
            if (descr == "") {
                $('#descr_msg').text("说明不能为空!")
                return;
            }
        }

        //保存结果的提示
        function showResult() {
            $.ajax({
                type:"get",
                url:"/addCost",
                data:{
                    "name":$("#name").val(),
                    "base_duration":$("#base_duration").val(),
                    "base_cost":$("#base_cost").val(),
                    "unit_cost":$("#unit_cost").val(),
                    "descr":$("#descr").val()
                },
                success:function () {
                    document.getElementById("save_result_info").style.display = "block";
                    showResultDiv(true);
                    window.setTimeout("showResultDiv(false);", 3000);
                    location.href = "/fee_list";
                }
            })
        }
        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none";
        }

        //切换资费类型
        function feeTypeChange(type) {
            var inputArray = document.getElementById("main").getElementsByTagName("input");
            if (type == 1) {
                inputArray[4].readOnly = true;
                inputArray[4].value = "";
                inputArray[4].className += " readonly";
                inputArray[5].readOnly = false;
                inputArray[5].className = "width100";
                inputArray[6].readOnly = true;
                inputArray[6].className += " readonly";
                inputArray[6].value = "";
            }
            else if (type == 2) {
                inputArray[4].readOnly = false;
                inputArray[4].className = "width100";
                inputArray[5].readOnly = false;
                inputArray[5].className = "width100";
                inputArray[6].readOnly = false;
                inputArray[6].className = "width100";
            }
            else if (type == 3) {
                inputArray[4].readOnly = true;
                inputArray[4].value = "";
                inputArray[4].className += " readonly";
                inputArray[5].readOnly = true;
                inputArray[5].value = "";
                inputArray[5].className += " readonly";
                inputArray[6].readOnly = false;
                inputArray[6].className = "width100";
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
    <div id="save_result_info" class="save_success">保存成功！</div>
    <form action="" method="" class="main_form">
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info">
            <input type="text" name="name" id="name" class="width300" placeholder="50长度的字母、数字、汉字和下划线的组合" value="" onblur="checkName()"/>
            <span class="required">*</span>
            <div class="validate_msg_short" id="name_msg"></div>
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info fee_type">
            <input type="radio" name="radFeeType" id="monthly" onclick="feeTypeChange(1);"/>
            <label for="monthly">包月</label>
            <input type="radio" name="radFeeType" checked="checked" id="package" onclick="feeTypeChange(2);"/>
            <label for="package">套餐</label>
            <input type="radio" name="radFeeType" id="timeBased" onclick="feeTypeChange(3);"/>
            <label for="timeBased">计时</label>
        </div>
        <div class="text_info clearfix"><span>基本时长：</span></div>
        <div class="input_info">
            <input type="text" name="base_duration" id="base_duration" value="" placeholder="1-600之间的整数" class="width100" onblur="checkTime()"/>
            <span class="info">小时</span>
            <span class="required">*</span>
            <div class="validate_msg_long" id="base_msg"></div>
        </div>
        <div class="text_info clearfix"><span>基本费用：</span></div>
        <div class="input_info">
            <input type="text" name="base_cost" placeholder="0-99999.99之间的数值" id="base_cost" value="" class="width100" onblur="checkCost()"/>
            <span class="info">元</span>
            <span class="required">*</span>
            <div class="validate_msg_long" id="cost_msg"></div>
        </div>
        <div class="text_info clearfix"><span>单位费用：</span></div>
        <div class="input_info">
            <input type="text" name="unit_cost" id="unit_cost" placeholder="0-99999.99之间的数值" value="" class="width100" onblur="checkUnit()"/>
            <span class="info">元/小时</span>
            <span class="required">*</span>
            <div class="validate_msg_long" id="unit_msg"></div>
        </div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
            <textarea class="width300 height70" id="descr" name="descr" placeholder="100长度的字母、数字、汉字和下划线的组合" onblur="checkDescr()"></textarea>
            <div class="validate_msg_short" id="descr_msg"></div>
        </div>
        <div class="button_info clearfix">
            <input type="button" value="保存" class="btn_save" onclick="showResult();"/>
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
