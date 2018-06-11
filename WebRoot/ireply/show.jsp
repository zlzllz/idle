<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
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
                        <tr><td height="31"><div class="title">回复管理<div></td></tr>
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
							<option value="getById">回复ID</option>
							<option value="getByU_id">用户名</option>
							<option value="getByN_id">留言内容</option>
							<option value="getByDate">回复时间</option>
							<option value="getByReplycontent">回复内容</option>
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
                                            <form action="" method="post">
                                                <table width="100%" class="cont tr_color">
										    	<tr><th colspan="6">订单详情表</th></tr>
										    	<tr>
										    		<th>ID</th>
										    		<th>回复者姓名</th>
										    		<th>留言内容</th>
										    		<th>回复时间</th>
										    		<th>回复内容</th>
										    		<th>操作</th>
										    	</tr>
										    	<c:choose>
										    	<c:when test="${not empty requestScope.replys}">
										    		<c:forEach var="reply" items="${requestScope.replys}" >
										    			<tr align="center" class="d">
										    			<td>${reply.id }</td>
										    			<td>${reply.user.username }</td>
										    			<td>${reply.note.content}</td>
										    			<td>${reply.replydate }</td>
										    			<td>${reply.replycontent }</td>
										    			<td><a href="${pageContext.request.contextPath}/ReplyServlet?tag=getPU&id=${reply.id}&username=${reply.user.username}">修改</a>
										    				<a href="${pageContext.request.contextPath}/ReplyServlet?tag=delete&id=${reply.id}">删除</a>
										    			</td>
										    			</tr>
										    		</c:forEach>
										    	</c:when>
										    	<c:otherwise>
										    		<tr><td colspan="6" align="center">当前数据库没有数据</td></tr>
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
		if(sType=="getByDate"){
			alert("日期格式为:2017-05-20");
		}
	}
	function search(){
		if((sType != null) && (sType != "请选择查询方式")){
			var data = "tag="+sType+"&param="+document.getElementById("searchValue").value;
			location.href="${pageContext.request.contextPath}/ReplyServlet?"+data;
    	}
   	}
</script>
    </body>
</html>