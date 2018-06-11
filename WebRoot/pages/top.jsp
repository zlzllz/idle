<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Style/skin.css" />
    <script type="text/javascript">
        function logout() {
            if(window.confirm('您确定要退出吗？')) {
                top.location = '../login.jsp';
            }
        }       
    </script>
<style type=text/css>
	body{
		background:url(../Images/top_top_bg.gif);
		background-size: 100% 200%;
	}
</style> 
</head>
    <body>
        <table cellpadding="0" width="100%" >
            <tr valign="top">
                <td width="55%" style="padding-top:13px;font:40px Arial,SimSun,sans-serif;color:#FFF">Idle校园二手交易管理系统</td>
                <td width="25%" style="padding-top:13px;font:20px Arial,SimSun,sans-serif;color:#FFF">管理员：<b>Idle</b> 您好，感谢登陆使用！</td>
                <td width="10%"></td>
                <td style="padding-top:10px;" align="center"><a href="javascript:void(0)"><img height="34" style="border:none" src="<%=path %>/Images/out.gif" onclick="logout();" /></td>
            </tr>
        </table>
    </body>
</html>