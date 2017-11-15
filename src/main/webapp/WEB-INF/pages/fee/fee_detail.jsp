<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
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
        <li><a href="/login" class="index_off"></a></li>
        <li><a href="../role/role_list.jsp" class="role_off"></a></li>

        <li><a href="/admin_list" class="admin_off"></a></li>

        li><a href="/fee_list" class="fee_on"></a></li>

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
    <form action="" method="" class="main_form">
        <div class="text_info clearfix"><span>资费ID：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.cost_id}"/></div>
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.name}"/></div>
        <div class="text_info clearfix"><span>资费状态：</span></div>
        <div class="input_info">
            <select class="readonly" disabled>
                <c:if test="${cost.status == 0}">
                    <option>暂停</option>
                </c:if>
                <c:if test="${cost.status != 0}">
                    <option>开通</option>
                </c:if>
            </select>
        </div>
        <div class="text_info clearfix"><span>资费类型：</span></div>
        <div class="input_info fee_type">
            <c:if test="${cost.name.contains('包月')}">
            <input type="radio" name="radFeeType" checked="checked" id="monthly" disabled="disabled"/>
            <label for="monthly">包月</label>
            </c:if>
            <c:if test="${cost.name.contains('套餐')}">
                <input type="radio" name="radFeeType" checked="checked" id="package" disabled="disabled"/>
                <label for="package">套餐</label>
            </c:if>
            <c:if test="${cost.name.contains('计时')}">
                <input type="radio" name="radFeeType" checked="checked" id="timeBased" disabled="disabled"/>
                <label for="timeBased">计时</label>
            </c:if>
        </div>
        <div class="text_info clearfix"><span>基本时长：</span></div>
        <div class="input_info">
            <input type="text" class="readonly" readonly value="${cost.base_duration}"/>
            <span>小时</span>
        </div>
        <div class="text_info clearfix"><span>基本费用：</span></div>
        <div class="input_info">
            <input type="text" class="readonly" readonly value="${cost.base_cost}"/>
            <span>元</span>
        </div>
        <div class="text_info clearfix"><span>单位费用：</span></div>
        <div class="input_info">
            <input type="text" class="readonly" readonly value="${cost.unit_cost}"/>
            <span>元/小时</span>
        </div>
        <div class="text_info clearfix"><span>创建时间：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.creaTime}"/></div>
        <div class="text_info clearfix"><span>启动时间：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${cost.starTime}"/></div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
            <textarea class="width300 height70 readonly" readonly>${cost.descr}</textarea>
        </div>
        <div class="button_info clearfix">
            <input type="button" value="返回" class="btn_save" onclick="location.href='/fee_list';"/>
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
