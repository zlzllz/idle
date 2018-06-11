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
</head>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!-- 头部开始 -->
            <tr>
                <td width="17" valign="top" background="<%=path %>/Images/mail_left_bg.gif">
                    <img src="<%=path %>/Images/left_top_right.gif" width="17" height="29" />
                </td>
                <td valign="top" background="<%=path %>/Images/content_bg.gif">
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="././Images/content_bg.gif">
                        <tr><td height="31"><div class="title">欢迎界面</div></td></tr>
                    </table>
                </td>
                <td width="16" valign="top" background="<%=path %>/Images/mail_right_bg.gif"><img src="./Images/nav_right_bg.gif" width="16" height="29" /></td>
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
                            <!--左边内容-->
                            <td colspan="2" valign="top">
                                <h2 style="margin:0 0 10px 10px;">&nbsp;感谢您使用Idle校园二手商品管理系统！</h2>
                                <img src="<%=path %>/Images/ts.gif" width="16" height="16" style="margin-left:10px;"> 提示：<br/>
                                <p style="text-indent:20px;line-height:25px;margin-left:10px;font-size:15px;">
                                	您现在使用的是javaee方向1班-第一小组-（李灵枝，张琦，杨璐宇，曹晨洁，韩玉飞）开发的一套Idle
                                	校园二手商品管理系统！如果您有任何疑问请拨打这五位同学热线进行咨询！
                                	<br/>&nbsp;&nbsp;&nbsp;&nbsp;此系统是您进行校园二手商品交易的首
                                	选平台。
                                </p>
                            </td>
                            <!--间隔-->
                            <td width="7%">&nbsp;</td>
                            <!--右边内容-->
                            <td width="40%" valign="top">
                                <table width="100%" height="150" border="0" cellpadding="0" cellspacing="0" style="border: 1px solid #CCCCCC;">
                                    <tr>
                                        <td width="7%" height="27" background="<%=path %>/Images/news_title_bg.gif">
                                            <img src="<%=path %>/Images/news_title_bg.gif" width="2" height="27">
                                        </td>
                                        <td width="93%" background="<%=path %>/Images/news_title_bg.gif" class="left_bt">常见问题</td>
                                    </tr>
                                    <tr><td height="5" colspan="2">&nbsp;</td></tr>
                                    <tr>
                                        <td height="100" valign="top" colspan="2" id="news">
                                            <marquee direction="up" scrollamount="2" vspace="30px" width="400px" height="100px" onmouseout="this.start()" onmouseover="this.stop()">
                                                <ul>
                                                    <li>1、问：爱倒Idle网站上的物品和照片都是真实的吗？</li>
                                                    <li>答：爱倒承诺，爱倒网站上的所有物品均由注册用户自己</li>
                                                    <li>填写，但是后台管理员可以查询信息是否合法，但是难以</li>
                                                    <li>保证真实，还需广大用户自己提高警惕，注意辨识。</li>
                                                    <li>2、问：如何使用本系统？</li>
                                                    <li>答：访问我们的首页你可以查看新用户注册须知，上</li>
                                                    <li>面有相关注意事项。</li>
                                                    <li>问：前台页面可以直接浏览信息吗？</li>
                                                    <li>答：不可以的。为了数据的安全性着想，我们都是只有</li>
                                                    <li>注册用户登陆后才可以展示商品信息的。不能直接浏览</li>
                                                    <li>是为了您的信息安全哟，请见谅！</li>
                                                </ul>
                                            </marquee>
                                        </td>
                                    </tr>
                                    <tr><td height="5" colspan="2">&nbsp;</td></tr>
                                </table>
                            </td>
                        </tr>
                        <tr height="20"><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                        <!--第二行-->
                        <tr>
                            <td colspan="2" valign="top">
                                <table width="100%" height="230" border="0" cellpadding="0" cellspacing="0" style="border: 1px solid #CCCCCC;">
                                    <tr>
                                        <td width="7%" background="<%=path %>/Images/news_title_bg.gif">
                                            <img src="<%=path %>/Images/news_title_bg.gif" width="2" height="27">
                                        </td>
                                        <td width="93%" background="<%=path %>/Images/news_title_bg.gif" class="left_bt">服务介绍</td>
                                    </tr>
                                    <tr >
                                        <td height="186" valign="top" colspan="2" style="text-indent:20px;line-height:25px;margin-left:10px;font-size:15px;">
                                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        	每年的大学毕业生成千上万，离校时总会有很多暂时不需要却仍有使用价值的资料及生活用品，
                                        	丢掉属于资源浪费，带到家里又不现实，这些物品得不到恰当的处理方式，亟需一个平台来使得
                                        	这些资源得以继续使用，于是便体现了大学生二手交易网站的重要性，通过网站将变闲置资源为
                                        	宝，既能解决毕业生闲置物品无法处理的问题，也为需要这些物品的同学提供了一个良好的平台，
                                        	达到互惠共利的局面。而且网上购物只需要注册后发布信息，而不需要到处打听哪里有买家或者卖
                                        	家，在这个时间就是生命的时代，具有针对性的买卖大大提高了生活效率，方便、省时、安全。
										</td>
                                    </tr>
                                    <tr><td height="5" colspan="2"></td></tr>
                                </table>
                            </td>
                            <td>&nbsp;</td>
                            <td valign="top">
                                <table width="100%" height="230" border="0" cellpadding="0" cellspacing="0" style="border: 1px solid #CCCCCC;">
                                    <tr>
                                        <td width="7%" background="<%=path %>/Images/news_title_bg.gif">
                                            <img src="<%=path %>/Images/news_title_bg.gif" width="2" height="27">
                                        </td>
                                        <td width="93%" height="27" background="<%=path %>/Images/news_title_bg.gif" class="left_bt">关于我们</td>
                                    </tr>
                                    <tr><td height="186" valign="top">&nbsp;</td>
                                    	<td height="102" valign="top" style="text-indent:20px;line-height:25px;margin-left:10px;font-size:15px;">
                                    	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    	我们的爱倒Idle系统是主动适应当前日益发展壮大的电商环境，积极响应国家十三五“绿色”发展
                                    	的发展理念，坚持节约资源和保护环境，这个平台为大家提供闲置的资源，使资源得以充分利用，
                                    	减少浪费。同时，也方便了用户，使他们能够利用空闲时间方便解决了他们的闲置资源。达到了互
                                    	惠互利，且保护环境的目的。希望有更多的人来使用我们的系统，使之开发的效用达到最大价值。
                                    	</td>
                                    </tr>
                                    <tr><td height="5" colspan="2">&nbsp;</td></tr>
                                </table>
                            </td>
                        </tr>
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
    </body>
</html>