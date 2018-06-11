<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <title>Idle校园二手物品管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="Idle校园二手物品交易管理系统" />
    <meta name="keywords" content="Idle,校园二手物品" />
    <meta name="Author" content="lilingzhi" />
    <meta name="CopyRight" content="javaee 1组" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Style/skin.css" />
</head>
    <body>
        <table width="100%">
            <!-- 顶部部分 -->
            <tr height="82"><td colspan="2" background="<%=path %>/Images/login_top_bg.gif">&nbsp;</td></tr>
            <!-- 主体部分 -->
            <tr style="background:url(<%=path %>/Images/login_bg.jpg) repeat-x height:605;" height="605">
                <!-- 主体左部分 -->
                <td id="left_cont">
                    <table width="100%" height="100%">
                        <tr height="155"><td colspan="2">&nbsp;</td></tr>
                        <tr>
                            <td width="20%" rowspan="2">&nbsp;</td>
                            <td width="60%">
                                <table width="100%">
                                    <tr height="70"><td align="right">
                                    	<img src="<%=path %>/Images/lo.jpg" title="idle" alt="idle" width="208px"/></td>
                                    </tr>
                                    <tr height="274">
                                        <td valign="top" align="right">
                                            <ul>
                                                <li>
	                                                <img src="<%=path %>/Images/icon_demo.gif" />
	                                                &nbsp;1- Idle校园二手物品管理系统
                                                </li>
                                                <li>
                                                	<img src="<%=path %>/Images/icon_demo.gif" />
                                                	&nbsp;2- Idle校园二手物品管理系统
                                                </li>
                                                <li>
                                                	<img src="<%=path %>/Images/icon_demo.gif" />
                                                	&nbsp;3- Idle校园二手物品管理系统
                                                </li>
                                            </ul>
                                        </td>
                                    </tr>
                                </table>
                            <td width="15%" rowspan="2">&nbsp;</td>
                            </td>
                        </tr>
                        <tr><td colspan="2">&nbsp;</td></tr>
                    </table>
                </td>
                <!-- 主体右部分 -->
                <td id="right_cont">
                    <table height="100%">
                        <tr height="30%"><td colspan="3">&nbsp;</td></tr>
                        <tr>
                            <td width="30%" rowspan="5">&nbsp;</td>
                            <td valign="top" id="form">
                                <form action="<%=path %>/LoginServlet?tag=login" method="post">
                                    <table align="top" width="50%">
                                        <tr><td colspan="2"><h4 style="letter-spacing:1px;font-size:16px;">Idle校园二手物品管理系统</h4></td></tr>
                                        <tr><td>管理员：</td><td><input type="text" name="username" /></td></tr>
                                        <tr><td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td><td><input type="password" name="password" /></td></tr>
                                        <tr class="bt" align="center">
                                        	<td colspan="2">&nbsp;&nbsp;
                                        	<input type="submit" value="登录" />&nbsp;&nbsp;&nbsp;
                                        	<input type="reset" value="重置" />
                                        </td>
                                        </tr>
                                    </table>
                                </form>
                            </td>
                            <td rowspan="5">&nbsp;</td>
                        </tr>
                        <tr><td colspan="3">&nbsp;</td></tr>
                    </table>
                </td>
            </tr>
            <!-- 底部部分 -->
            <tr><td id="login_bot" colspan="2">&nbsp;</td></tr>
            <tr id="login_bot"><td colspan="2"><p>Copyright © 2013-2017 Idle 工作室</p></td></tr>
        </table>
    </body>
</html>