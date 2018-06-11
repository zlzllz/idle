<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Style/skin.css" />
</head>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!-- 头部开始 -->
            <tr>
                <td width="17" valign="top" background="<%=path %>/Images/mail_left_bg.gif">
                    <img src="<%=path %>/Images/left_top_right.gif" width="17" height="29" />
                </td>
                <td valign="top" background="<%=path %>/Images/content_bg.gif">
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="<%=path %>/Images/content_bg.gif">
                        <tr><td height="31"><div class="title">用户管理</div></td></tr>
                    </table>
                </td>
                <td width="16" valign="top" background="<%=path %>/Images/mail_right_bg.gif"><img src="<%=path %>/Images/nav_right_bg.gif" width="16" height="29" /></td>
            </tr>
            <!-- 中间部分开始 -->
            <tr>
                <!--第一行左边框-->
                <td valign="middle" background="<%=path %>/Images/mail_left_bg.gif">&nbsp;</td>
                <!--第一行中间内容-->
                <td valign="top" bgcolor="#F7F8F9">
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                        <tr>
	                        <select id="search" onchange="searchType(this)">
								<option>请选择查询方式</option>
								<option value="getAll">全部</option>
								<option value="getById">ID</option>
								<option value="getByUsername">用户名</option>
								<option value="getBySex">性别</option>
								<option value="getByTel">电话</option>
								<option value="getByAddress">地址</option>
								<option value="getByIdnum">身份证号</option>
								<option value="getByCardnum">银行卡号</option>
							</select>
							<input type="text" id="searchValue"/><input type="button" value="查询" onclick="search()" />
                        </tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 产品列表开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%" class="cont tr_color">
                                    <tr>
                                        <td colspan="2">
                                            <form action="" method="post" >
                                                    <table class="cont tr_color" width="100%">
											    	<tr><th colspan="10" align="center">个人信息表</th></tr>
											    	<tr align="center" class="d">
											    		<th>ID</th>
											    		<th>用户名</th>
											    		<th>密码</th>
											    		<th>性别</th>
											    		<th>电话</th>
											    		<th>地址</th>
											    		<th>身份证号</th>
											    		<th>银行卡号</th>
											    		<th>权限等级</th>
											    		<th>操作</th>
											    	</tr>
											    	<c:choose>
											    	<c:when test="${not empty requestScope.users}">
											    		<c:forEach var="user" items="${requestScope.users}" >
											    			<tr align="center" class="d">
											    			<td>${user.id }</td>
											    			<td>${user.username }</td>
											    			<td>${user.password }</td>
											    			<td>${user.sex }</td>
											    			<td>${user.tel }</td>
											    			<td>${user.address }</td>
											    			<td>${user.idnum }</td>
											    			<td>${user.cardnum }</td>
											    			<td>${user.grade }</td>
											    			<td><a href="iuser/update.jsp?id=${user.id}">修改</a>
											    				<a href="${pageContext.request.contextPath}/UserServlet?tag=delete&id=${user.id}">删除</a>
											    			</td>
											    			</tr>
											    		</c:forEach>
											    	</c:when>
											    	<c:otherwise>
											    		<tr><td colspan="10" align="center">当前数据库没有数据</td></tr>
											    	</c:otherwise>
											    </c:choose>
											    </table>
                                            </form>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!-- 产品列表结束 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td>&nbsp;</td><td>&nbsp;</td>
                        </tr>
                    </table>
                </td>
                <td background="<%=path %>/Images/mail_right_bg.gif">&nbsp;</td>
            </tr>
            <!-- 底部部分 -->
            <tr>
                <td valign="bottom" background="<%=path %>/Images/mail_left_bg.gif">
                    <img src="<%=path %>/Images/buttom_left.gif" width="17" height="17" />
                </td>
                <td background="<%=path %>/Images/buttom_bgs.gif">
                    <img src="<%=path %>/Images/buttom_bgs.gif" width="17" height="17">
                </td>
                <td valign="bottom" background="<%=path %>/Images/mail_right_bg.gif">
                    <img src="<%=path %>/Images/buttom_right.gif" width="16" height="17" />
                </td>           
            </tr>
        </table>
<script type="text/javascript">
	var sType;
	function searchType(obj){
		sType = obj.value;//得到要调用的方法
	}
	function search(){
		if((sType != null) && (sType != "请选择查询方式")){
			var data = "tag="+sType+"&param="+document.getElementById("searchValue").value;
			location.href="${pageContext.request.contextPath}/UserServlet?"+data;
    	}
   	}
</script>
    </body>
</html>