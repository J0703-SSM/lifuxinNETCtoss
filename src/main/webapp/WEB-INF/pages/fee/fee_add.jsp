﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存结果的提示
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
            <img src="../images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
                <li><a href="../../WEB-INF/pages/index.jsp" class="index_off"></a></li>
                <li><a href="../role/role_list.jsp" class="role_off"></a></li>

                <li><a href="/admin_list" class="admin_off"></a></li>

                <li><a href="/fee_list" class="fee_on"></a></li>
                <li><a href="../account/account_list.jsp" class="account_off"></a></li>
                <li><a href="../service/service_list.jsp" class="service_off"></a></li>
                <li><a href="../bill/bill_list.jsp" class="bill_off"></a></li>
                <li><a href="../report/report_list.jsp" class="report_off"></a></li>
                <li><a href="../user/user_info.jsp" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.jsp" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_fail">保存失败，资费名称重复！</div>
            <form action="/addCost" method="post" class="main_form">
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                    <input type="text" name="name" class="width300" value=""/>
                    <span class="required">*</span>
                    <div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="radFeeType" id="monthly" onclick="feeTypeChange(1);" />
                    <label for="monthly">包月</label>
                    <input type="radio" name="radFeeType" checked="checked" id="package" onclick="feeTypeChange(2);" />
                    <label for="package">套餐</label>
                    <input type="radio" name="radFeeType" id="timeBased" onclick="feeTypeChange(3);" />
                    <label for="timeBased">计时</label>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <input type="text" name="base_duration" value="" class="width100" />
                    <span class="info">小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">1-600之间的整数</div>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <input type="text" name="base_cost" value="" class="width100" />
                    <span class="info">元</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">0-99999.99之间的数值</div>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <input type="text" name="unit_cost" value="" class="width100" />
                    <span class="info">元/小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">0-99999.99之间的数值</div>
                </div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70" name="descr"></textarea>
                    <div class="validate_msg_short error_msg">100长度的字母、数字、汉字和下划线的组合</div>
                </div>                    
                <div class="button_info clearfix">
                    <%--onclick="showResult();"--%>
                    <input type="submit" value="保存" class="btn_save"/>
                    <input type="button" value="取消" class="btn_save"/>
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
           <span>版权所有(C)云科技有限公司 </span>
        </div>
    </body>
</html>
