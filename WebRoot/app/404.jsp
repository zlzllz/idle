<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
  <meta charset="UTF-8">

  <meta name="description" content="">
  <meta name="keywords" content="">

  <title>404</title>
  
  <link rel="shortcut icon" href="favicon.ico">
  <link href="css/style.css" media="screen" rel="stylesheet" type="text/css">
  <link href="css/grid.css" media="screen" rel="stylesheet" type="text/css">
 
  <script src="js/jquery-1.7.2.min.js" ></script>
  <script src="js/html5.js" ></script>
  <script src="js/jflow.plus.js"></script>
  <script src="js/jquery.carouFredSel-5.2.2-packed.js"></script>
  <script src="js/checkbox.js"></script>
  <script src="js/radio.js"></script>
  <script src="js/selectBox.js"></script>

  <script>
	$(document).ready(function() {
		$("select").selectBox();
	});
  </script>

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
	  $('#list_banners').carouFredSel({
		prev: '#ban_prev',
		next: '#ban_next',
		scroll: 1,
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
         欢迎访问Idle校园二手物品交易网站，你可以<a href="login.jsp"> 登录 </a>或<a href="login.jsp"> 注册</a>.
        </div><!-- .welcome -->
      </div><!-- .grid_6 -->
  
    <div class="clear"></div>
   
    <header id="branding">
      <div class="grid_3">
        <hgroup>
          <h1 id="site_logo"><a href="index.jsp" title=""><img src="images/logo.png" alt="Online Store Theme Logo"/></a></h1>
          <h2 id="site_description">Idle校园二手物品交易</h2>
        </hgroup>
      </div><!-- .grid_3 -->
      
      <div class="grid_3">
      <form class="search">
          <input type="text" name="search" class="entry_form" value="" placeholder="请输入搜索关键字..."/>
	  </form>
      </div><!-- .grid_3 -->
      
      <div class="grid_6">
        <ul id="cart_nav">
          <li>
            <a class="cart_li" href="#">我的订单 <span></span></a>
            <ul class="cart_cont">
              <li class="no_border"><p>最近添加</p></li>
              <li>
                <a href="product.jsp" class="prev_cart"><div class="cart_vert"><img src="images/cart_img.png" alt="" title="" /></div></a>
                <div class="cont_cart">
                  <h4>商品1</h4>
                  <div class="price">1 x 399.00</div>
                </div>
                <a title="close" class="close" href="#"></a>
                <div class="clear"></div>
              </li>
              
              <li>
                <a href="product.jsp" class="prev_cart"><div class="cart_vert"><img src="images/produkt_slid1.png" alt="" title="" /></div></a>
                <div class="cont_cart">
                  <h4>商品2</h4>
                  <div class="price">1 x 399.00</div>
                </div>
                <a title="close" class="close" href="#"></a>
                <div class="clear"></div>
              </li>
	      <li class="no_border">
		<a href="order.jsp" class="view_cart">查看订单详情</a>
	      </li>
            </ul>
          </li>
        </ul>
        
        <nav class="private">
          <ul>
            <li><a href="userinfo.jsp">个人中心</a></li>
		<li class="separator">|</li>
            <li><a href="addpro.jsp">我的发布</a></li>
		<li class="separator">|</li>
            <li><a href="login.jsp">登录</a></li>
		<li class="separator">|</li>
            <li><a href="login.jsp">注册</a></li>
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
            <li class="curent"><a href="index.jsp">首页</a></li>
            <li><a href="allpro.jsp">衣服</a>
            	<ul class="sub">
                <li><a href="allpro.jsp">上衣</a></li>
                <li><a href="allpro.jsp">裤子</a></li>
                <li><a href="allpro.jsp">鞋子</a></li>
              </ul>
            </li>
            <li><a href="allpro.jsp">书籍</a></li>
            <li>
              <a href="allpro.jsp">生活用品</a>
              <ul class="sub">
                <li><a href="allpro.jsp">餐具</a></li>
                <li><a href="allpro.jsp">洗漱用品</a></li>
                <li><a href="allpro.jsp">卫生用品</a></li>
              </ul>
            </li>
            <li><a href="allpro.jsp">化妆品</a></li>
            <li><a href="allpro.jsp">运动器材</a></li>
            <li><a href="allpro.jsp">电子产品</a></li>
            <li><a href="allpro.jsp">箱包</a></li>
          </ul>
        </nav><!-- .primary -->
      </div><!-- .grid_12 -->
    </div><!-- .container_12 -->
  </div><!-- .block_nav_primary -->
  
  <div class="clear"></div>
  
  <section id="main" class="entire_width page-404">
    <div class="container_12">      
       <div id="content">
		
		<div class="grid_4 left_404">
			<h1 class="text_404">404</h1>
			<h6>Page not found...</h6>
                </div><!-- .adress -->
		
		<div class="grid_8">
			<h2>页面跑丢了...</h2>
			<p><strong>可能原因分析如下.</strong></p>
			<ul>
				<li>访问页面的地址输入错误.</li>
				<li>输入的数据格式不对.</li>
			</ul>
			<p><strong>你可以尝试如下方法：</strong><br/>
			以下方法仅供参考根据个人的操作不同效果也不一致.</p>
			<ul>
				<li><a href="#">返回上一页</a>.</li>
				<li>返回页面重新操作，并且输入正确的数据和访问地址.</li>
				<li><a href="#">首页</a> | <a href="#">个人中心</a></li>
			</ul>
                </div><!-- .grid_8 -->
       </div><!-- #content -->
       
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
          <h3>网站相关</h3>
          <nav class="f_menu">
            <ul>
              <li><a href="#">关于我们</a></li>
              <li><a href="#">相关政策</a></li>
              <li><a href="#">约束条件</a></li>
              <li><a href="#">安全措施</a></li>
            </ul>
          </nav><!-- .private -->
        </div><!-- .grid_3 -->

        <div class="grid_3">
          <h3>服务用户</h3>
          <nav class="f_menu">
            <ul>
              <li><a href="contact_us.jsp">联系我们</a></li>
              <li><a href="#">返回</a></li>
              <li><a href="#">首页</a></li>
              <li><a href="#">返回顶部</a></li>
            </ul>
          </nav><!-- .private -->
        </div><!-- .grid_3 -->

        <div class="grid_3">
          <h3>我的账号</h3>
          <nav class="f_menu">
            <ul>
              <li><a href="#">个人中心</a></li>
              <li><a href="#">我的发布</a></li>
              <li><a href="#">我的订单</a></li>
            </ul>
          </nav><!-- .private -->
        </div><!-- .grid_3 -->

        <div class="clear"></div>
      </div><!-- .container_12 -->
    </div><!-- .f_navigation -->

    <div class="f_info">
      <div class="container_12">
        <div class="grid_6">
          <p class="copyright">© idle idle idle, 2017. Collect from <a href="" target="_blank">IDLE校园二手物品交易网站</a></p>
        </div><!-- .grid_6 -->

        <div class="grid_6">
          <div class="soc">
          </div><!-- .soc -->
        </div><!-- .grid_6 -->

        <div class="clear"></div>
      </div><!-- .container_12 -->
    </div><!-- .f_info -->
  </footer>
 
</body>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
</html>