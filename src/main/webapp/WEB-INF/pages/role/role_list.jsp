<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <title></title>
        <script src="/resources/js/jquery-3.2.1.js"></script>
        <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            function deleteRole(role_id) {
                var r = window.confirm("确定要删除此角色吗？");
                if (r == true){
                    $.ajax({
                        type:"get",
                        url:"/deleteRoleInfo",
                        data:{
                            "role_id":role_id
                        },
                        success:function () {
                            document.getElementById("operate_result_info").style.display = "block";
                            window.location.reload()
                        }
                    })

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
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='/role_add';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="/resources/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>
                        <c:forEach items="${roleModule}" var="rm">
                            <tr>
                                <td>${rm.role_id}</td>
                                <td>${rm.role_name}</td>
                                <td>
                                <c:forEach items="${rm.module_infos}" var="as" varStatus="s">
                                    ${as.name}
                                    <c:if test="${s.last == false}">
                                        ,
                                    </c:if>
                                </c:forEach>
                                </td>
                                <td>
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='/role_modi?role_id=${rm.role_id}';"/>
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteRole(${rm.role_id});" />
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
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
