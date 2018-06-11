<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String username = (String) request.getSession().getAttribute("username");
if(username == null){
	username = "";
}
%>
<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="content-type" content="text/html;charset=utf-8" />
  <meta name="description" content="Idle校园二手物品交易管理系统" />
  <meta name="keywords" content="Idle,校园二手物品" />
  <meta name="Author" content="lilingzhi" />
  <title>更新用户信息</title>
  <link rel="shortcut icon" href="favicon.ico">
  <link href="<%=path %>/app/css/style.css" media="screen" rel="stylesheet" type="text/css">
  <link href="<%=path %>/app/css/grid.css" media="screen" rel="stylesheet" type="text/css">
  <script src="<%=path %>/app/js/jquery-1.7.2.min.js" ></script>
  <script src="<%=path %>/app/js/html5.js" ></script>
  <script src="<%=path %>/app/js/jflow.plus.js" ></script>
  <script src="<%=path %>/app/js/jquery.carouFredSel-5.2.2-packed.js"></script>
  <script src="<%=path %>/app/js/checkbox.js"></script>
  <script src="<%=path %>/app/js/radio.js"></script>
  <script src="<%=path %>/app/js/selectBox.js"></script>

  <script>
       $(document).ready(function(){
	      $("#myController").jFlow({
		     controller: ".control", // must be class, use . sign
		     slideWrapper : "#jFlowSlider", // must be id, use # sign
		     slides: "#slider",  // the div where all your sliding divs are nested in
		     selectedWrapper: "jFlowSelected",  // just pure text, no sign
		     width: "984px",  // this is the width for the content-slider
		     height: "480px",  // this is the height for the content-slider
		     duration: 400,  // time in miliseconds to transition one slide
		     prev: ".slidprev", // must be class, use . sign
		     next: ".slidnext", // must be class, use . sign
		     auto: true
	      });
       });
  </script>
  <script>
       $(function() {
	  $('#list_product').carouFredSel({
		prev: '#prev_c1',
		next: '#next_c1',
		auto: false
	  });
          $('#list_product2').carouFredSel({
		prev: '#prev_c2',
		next: '#next_c2',
		auto: false
	  });
	  $(window).resize();
	});
  </script>
  <script>
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      });
       })
  </script>
  <script>
       $(document).ready(function() {
	      $("select").selectBox();
       });
  </script>
  <script type="text/javascript">
        function logout() {
            if(window.confirm('您确定要退出吗？')) {
                window.location.href = '<%=path %>/LoginServletA?tag=logOut';
            }
        }       
  </script>
</head>
<body>
  <div class="container_12">
    <div id="top">
      <div class="grid_3">
        <div class="phone_top">
           联系我们-010-6666666
        </div><!-- .phone_top -->
      </div><!-- .grid_3 -->
   
      <div class="grid_6">
        <div class="welcome">
         欢迎访问Idle校园二手物品交易网站，你可以
         <a onclick="check21(this)"> 登录 </a>或
         <a onclick="check22(this)"> 注册</a>或
         <a onclick="logout();"> 退出</a>.
        </div><!-- .welcome -->
      </div><!-- .grid_6 -->
  
    <div class="clear"></div>
   
    <header id="branding">
      <div class="grid_3">
        <hgroup>
          <h1 id="site_logo"><a href="<%=path %>/app/index.jsp">
          <img src="<%=path %>/app/images/lo.jpg" width="260px" height="70px"/></a></h1>
          <h2 id="site_description">Idle校园二手物品交易</h2>
        </hgroup>
      </div><!-- .grid_3 -->
      
      <div class="grid_3">
      <form class="search" action="<%=path %>/ProductsServlet?tag=getByDes&param=书" method="post">
          <input type="text" name="search" placeholder="请输入搜索关键字..."/>
          <input type="submit" value=" 搜索" id="llz">
	  </form>
      </div><!-- .grid_3 -->
      
      <div class="grid_6">
        
        <nav class="private">
          <ul>
            <li><a onclick="check11(this)">个人中心</a></li>
		<li class="separator">|</li>
            <li><a onclick="check12(this)">我的发布</a></li>
		<li class="separator">|</li>
			<li><a onclick="check13(yhis)">我的订单</a></li>
		<li class="separator">|</li>
            <li><a onclick="check21(this)">登录</a></li>
		<li class="separator">|</li>
            <li><a onclick="check22(this)">注册</a></li>
          </ul>
        </nav><!-- .private -->        
      </div><!-- .grid_6 -->
    </header><!-- #branding -->
  </div><!-- .container_12 -->
  
  <div class="clear"></div>
  
  <div id="block_nav_primary">
    <div class="container_12">
      <div class="grid_12">
        <nav class="primary">
          <ul>
            <li class="curent"><a href="<%=path %>/ProductsServlet?tag=getAllA">首页</a></li>
            <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=yiFu">衣服</a></li>
            <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=shuJi">书籍</a></li>
            <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=shengHuo">生活用品</a></li>
            <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=huaZhuang">化妆品</a></li>
            <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=yunDong">运动器材</a></li>
            <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=dianZi">电子产品</a></li>
            <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=baoBao">箱包</a></li>
          </ul>
        </nav><!-- .primary -->
      </div><!-- .grid_12 -->
    </div><!-- .container_12 -->
  </div><!-- .block_nav_primary -->

  <div class="clear"></div>

  <section id="main" class="entire_width">
    <div class="container_12">
       <div class="grid_12">
       <h1 class="page_title">用户信息</h1>
		
		<form action="<%=path %>/UserServlet?tag=updateA" method="post">
		<input type="hidden" name="id" value="<%=request.getParameter("id") %>"/>
		<input type="hidden" name="grade" value="<%=request.getParameter("grade") %>"/>
       <table class="cart_product">
			<tr><th>用户名</th><td><input type="text" name="username" /></td></tr>
			<tr><th>密码</th><td><input type="text" name="password" /></td></tr>
			<tr><th>性别</th><td><select name="sex">
				<option value="女">女</option><option value="男">男</option>
                </select></td></tr>
			<tr><th>电话</th><td><input type="text" name="tel"/></td></tr>
			<tr><th>地址</th><td><input type="text" name="address" /></td></tr>
			<tr><th>身份证号</th><td><input type="text" name="idnum" /></td></tr>
			<tr><th>银行卡号</th><td><input type="text" name="cardnum" /></td></tr>
			<tr align="center">
				<th>操作</th>
				<td><input type="submit" value="确认提交" style="width:66px"/></td>
			</tr>
       </table>
       </form>
       </div><!-- .grid_12 -->
      <div class="clear"></div>
      <div class="clear"></div>
    </div><!-- .container_12 -->
  </section><!-- #main -->

  <div class="clear"></div>

  <footer>
    <div class="f_navigation">
      <div class="container_12">
        <div class="grid_3">
          <h3>联系我们</h3>
          <ul class="f_contact">
            <li>北京市昌平区十三陵镇石牌坊南</li>
            <li>+010-6666666</li>
            <li>mail@idleidleidle.com</li>
          </ul><!-- .f_contact -->
        </div><!-- .grid_3 -->

        <div class="grid_3">
          <h3>开发团队</h3>
          <nav class="f_menu">
            <ul>
              <li>李灵枝&nbsp;&nbsp;张琦</li>
              <li>韩玉飞</li>
              <li>杨璐宇&nbsp;&nbsp;曹晨洁</li>
            </ul>
          </nav><!-- .private -->
        </div><!-- .grid_3 -->

        <div class="grid_3">
          <h3>服务用户</h3>
          <nav class="f_menu">
            <ul>
              <li><a href="#" onclick="JavaScript:history.back(-1);">返回上一页</a></li>
              <li><a href="<%=path %>/ProductsServlet?tag=getAllA">首页</a></li>
              <li><a href="#">返回顶部</a></li>
            </ul>
          </nav><!-- .private -->
        </div><!-- .grid_3 -->

        <div class="grid_3">
          <h3>我的账号</h3>
          <nav class="f_menu">
            <ul>
              <li><a onclick="check11(this)">个人中心</a></li>
              <li><a onclick="check12(this)">我的发布</a></li>
              <li><a onclick="check13(this)">我的订单</a></li>
            </ul>
          </nav><!-- .private -->
        </div><!-- .grid_3 -->

        <div class="clear"></div>
      </div><!-- .container_12 -->
    </div><!-- .f_navigation -->

    <div class="f_info">
      <div class="container_12">
        <div class="grid_6">
          <p class="copyright">© idle idle idle, 2017. Collect from <a href="http://www.mycodes.net/" title="" target="_blank">IDLE校园二手物品交易网站</a></p>
        </div><!-- .grid_6 -->

        <div class="grid_6">
          <div class="soc">
          </div><!-- .soc -->
        </div><!-- .grid_6 -->

        <div class="clear"></div>
      </div><!-- .container_12 -->
    </div><!-- .f_info -->
  </footer>

<script type="text/javascript">
	var username = "<%=username %>";
function check11(obj){
	if(username == ""){
		alert("请先登录再使用该功能。");
		obj.setAttribute("onclick",'');
	}else{
		obj.href="<%=path %>/UserServlet?tag=getUser&username="+username;
		obj.click("return false");
	}  
}
function check12(obj){
	if(username == ""){
		alert("请先登录再使用该功能。");
		obj.setAttribute("onclick",'');
	}else{
		obj.href="<%=path %>/ProductsServlet?tag=getProA&username="+username;
		obj.click("return false");
	}  
}
function check13(obj){
	if(username == ""){
		alert("请先登录再使用该功能。");
		obj.setAttribute("onclick",'');
	}else{
		obj.href="<%=path %>/OrderServlet?tag=getOrder&username="+username;
		obj.click("return false");
	}  
}
function check21(obj){
	if(username != ""){
		alert("您已经登录。");
		obj.setAttribute("onclick",'');
	}else{
		obj.href="<%=path %>/app/login.jsp";
		obj.click("return false");
	}
}
function check22(obj){
	if(username != ""){
		alert("您已经登录。");
		obj.setAttribute("onclick",'');
	}else{
		obj.href="<%=path %>/app/reg.jsp";
		obj.click("return false");
	}
}
</script>
</body>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
</html>
