<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String username = (String) request.getAttribute("username");
if(username == null){
	username = "";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="<%=path %>/Js/prototype.lite.js" type="text/javascript"></script>
    <script src="<%=path %>/Js/moo.fx.js" type="text/javascript"></script>
    <script src="<%=path %>/Js/moo.fx.pack.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="<%=path %>/Style/skin.css" />
    <script type="text/javascript">
        window.onload = function () {
            var contents = document.getElementsByClassName('content');
            var toggles = document.getElementsByClassName('type');

            var myAccordion = new fx.Accordion(
            toggles, contents, {opacity: true, duration: 400}
            );
            myAccordion.showThisHideOpen(contents[0]);
            for(var i=0; i<document .getElementsByTagName("a").length; i++){
                var dl_a = document.getElementsByTagName("a")[i];
                    dl_a.onfocus=function(){
                        this.blur();
                    }
            }
        }
    </script>
</head>

<body>
    <table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
        <tr>
            <td width="182" valign="top">
                <div id="container"><br/><br/>
                    <h1 class="type"><a href="javascript:void(0)">用户管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="<%=path %>/Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="<%=path %>/UserServlet?tag=getAll" target="main">查询用户</a></li>
                            <li><a href="<%=path %>/iuser/add.jsp" target="main">添加用户</a></li>
                        </ul>
                    </div>
                    <h1 class="type"><a href="javascript:void(0)">快递管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="<%=path %>/Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="<%=path %>/ExpressServlet?tag=getAll" target="main">查询快递</a></li>
                            <li><a href="<%=path %>/iexpress/add.jsp" target="main">添加快递</a></li>
                        </ul>
                    </div>
                    <h1 class="type"><a href="javascript:void(0)">商品管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="<%=path %>/Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="<%=path %>/ProductsServlet?tag=getAll" target="main">查询商品</a></li>
                            <li><a href="<%=path %>/ProductsServlet?tag=getU1" target="main">添加商品</a></li>
                        </ul>
                    </div>
                    <!-- *********** -->
                    <h1 class="type"><a href="javascript:void(0)">留言管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="<%=path %>/Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="<%=path %>/NoteServlet?tag=getAll" target="main">查询留言</a></li>
                            <!-- ***********
                            <li><a href="<%=path %>/NoteServlet?tag=getPU2" target="main">添加留言</a></li>
                        	<!-- *********** -->
                        </ul>
                    </div>
                    <h1 class="type"><a href="javascript:void(0)">回复管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="<%=path %>/Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="<%=path %>/ReplyServlet?tag=getAll" target="main">查询回复</a></li>
                            <!-- *********** 
                            <li><a href="<%=path %>/ReplyServlet?tag=getPU2" target="main">添加回复</a></li>
                            <!-- *********** -->
                        </ul>
                    </div>
                    <h1 class="type"><a href="javascript:void(0)">订单管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="<%=path %>/Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="<%=path %>/OrderServlet?tag=getAll" target="main">查询订单</a></li>
                            <li><a href="<%=path %>/OrderServlet?tag=getPU2" target="main">添加订单</a></li>
                        </ul>
                    </div>
                    <!-- *********** 
                    <h1 class="type"><a href="javascript:void(0)">其他管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="javascript:void(0)" target="main">AAAA</a></li>
                            <li><a href="javascript:void(0)" target="main">BBBB</a></li>
                        </ul>
                    </div>
                     *********** -->
                </div>
            </td>
        </tr>
    </table>
</body>
</html>
