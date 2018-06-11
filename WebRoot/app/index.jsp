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
String aaa = (String) request.getSession().getAttribute("abc");
if(aaa == null){
	aaa = "";
}
%>
<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript">
var abc = "<%=aaa %>";
function getData(){
	window.location.href="<%=path %>/ProductsServlet?tag=getAllA";
}
if(abc == ""){
	getData();
	<% aaa = null; %>
}
</script>
  <title>主页面</title>
  <meta http-equiv="content-type" content="text/html;charset=utf-8" />
  <meta name="description" content="Idle校园二手物品交易管理系统" />
  <meta name="keywords" content="Idle,校园二手物品" />
  <meta name="Author" content="lilingzhi" />
  <link rel="shortcut icon" href="favicon.ico">
  <link href="<%=path %>/app/css/style.css" media="screen" rel="stylesheet" type="text/css">
  <link href="<%=path %>/app/css/grid.css" media="screen" rel="stylesheet" type="text/css">
  <script src="<%=path %>/app/js/jquery-1.7.2.min.js" ></script>
  <script src="<%=path %>/app/js/html5.js" ></script>
  <script src="<%=path %>/app/js/jflow.plus.js" ></script>
  <script src="<%=path %>/app/js/jquery.carouFredSel-5.2.2-packed.js"></script>

  <script type="text/javascript">
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
  <script type="text/javascript">
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
  <script type="text/javascript">
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      });
       })
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
			<li><a onclick="check13(this)">我的订单</a></li>
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

  <div class="container_12">
    <div class="grid_12">
        <div class="slidprev"><span>Prev</span></div>
        <div class="slidnext"><span>Next</span></div>
        <div id="slider">
          <div id="slide1">
            <img src="<%=path %>/app/images/content/slide1.jpg" />
            <div class="slid_text">
              <h3 class="slid_title"><span>IDLE推荐物品</span></h3>
              <p><span>idle 是一个全国范围内的校园二手物品交易网站,</span></p>
              <p><span>她可以帮助我们更好的处理闲置物品，</span></p>
              <p><span>并且是一个界面简洁，易操作的网站.</span></p>
            </div>
          </div>

          <div id="slide2">
            <img src="<%=path %>/app/images/content/slide2.jpg" alt="" title="" />
            <div class="slid_text">
              <h3 class="slid_title"><span>IDLE推荐物品</span></h3>
              <p><span>idle 是一个全国范围内的校园二手物品交易网站,</span></p>
              <p><span>她可以帮助我们更好的处理闲置物品，</span></p>
              <p><span>并且是一个界面简洁，易操作的网站.</span></p>
            </div>
          </div>

          <div id="slide3">
            <img src="<%=path %>/app/images/content/slide3.jpg" alt="" title="" />
            <div class="slid_text">
              <h3 class="slid_title"><span>IDLE推荐物品</span></h3>
              <p><span>idle 是一个全国范围内的校园二手物品交易网站,</span></p>
              <p><span>她可以帮助我们更好的处理闲置物品，</span></p>
              <p><span>并且是一个界面简洁，易操作的网站.</span></p>
            </div>
          </div>
        </div><!-- .slider -->
        <div id="myController">
          <div class="control"><span>1</span></div>
          <div class="control"><span>2</span></div>
          <div class="control"><span>3</span></div>
        </div>

    </div><!-- .grid_12 -->
  </div><!-- .container_12 -->
  <div class="copyrights">Collect from <a href="http://www.mycodes.net/"  title="">网站模板</a></div>
  <div class="clear"></div>

  <section id="main" class="home">
    <div class="container_12">
      <div id="top_button">
        <div class="grid_4">
            <img src="<%=path %>/app/images/banner1.png" alt="Banner 1"/>
        </div><!-- .grid_4 -->

        <div class="grid_4" >
            <img src="<%=path %>/app/images/banner2.png" alt="Banner 2"/>
        </div><!-- .grid_4 -->

        <div class="grid_4">
            <img src="<%=path %>/app/images/banner3.png" alt="Banner 3"/>
        </div><!-- .grid_4 -->

        <div class="clear"></div>
      </div><!-- #top_button -->

      <div class="clear"></div>

      <div class="carousel">
        <div class="c_header">
          <div class="grid_10">
            <h2>商品展示区</h2>
          </div><!-- .grid_10 -->

          <div class="grid_2">
            <a id="next_c1" class="next arows" href="#"><span>Next</span></a>
            <a id="prev_c1" class="prev arows" href="#"><span>Prev</span></a>
           </div><!-- .grid_2 -->
        </div><!-- .c_header -->

        <div class="list_carousel">
        <ul id="list_product" class="list_product">
			<c:choose>
				<c:when test="${not empty requestScope.products}">
					<c:forEach var="product" items="${requestScope.products}" >
						<li class="">
				            <div class="grid_3 product">
				              <img class="sale" src="<%=path %>/app/images/sale.png" alt="Sale"/>
				              <div class="prev">
				                <a href="${pageContext.request.contextPath}/ProductsServlet?tag=toProA&pid=${product.id}">
				                <img src="${pageContext.request.contextPath}/pictures/${product.img}" alt="${product.pname }" />
				                </a>
				              </div><!-- .prev -->
				              <h3 class="title">商品名称：${product.pname}--类型：${product.types}</h3>
				              <div class="cart">
				                <div class="price">
				                <div class="vert">
				                  <div class="price_new">现价：${product.currentprice}</div>
				                  <div class="price_old">原价：${product.oldprice}</div>
				                </div>
				                </div>
				                 	<div class="vert">发布用户：${product.user.username}</div>
				                	<div class="vert">日期：${product.releasedate}</div>
				              </div><!-- .cart -->
				            </div><!-- .grid_3 -->
				          </li>
					</c:forEach>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
        </ul><!-- #list_product -->
        </div><!-- .list_carousel -->
      </div><!-- .carousel -->

      <div class="carousel">
        <div class="c_header">
          <div class="grid_10">
            <h2>推荐商品</h2>
          </div><!-- .grid_10 -->

          <div class="grid_2">
            <a id="next_c2" class="next arows" href="#"><span>Next</span></a>
            <a id="prev_c2" class="prev arows" href="#"><span>Prev</span></a>
          </div><!-- .grid_2 -->
        </div><!-- .c_header -->

        <div class="list_carousel">
        <ul id="list_product2" class="list_product">
			<c:choose>
				<c:when test="${not empty requestScope.products}">
					<c:forEach var="product" items="${requestScope.products}" begin="2" step="2">
						<li class="">
				            <div class="grid_3 product">
				              <img class="sale" src="<%=path %>/app/images/sale.png" alt="Sale"/>
				              <div class="prev">
				                <a href="${pageContext.request.contextPath}/ProductsServlet?tag=toProA&pid=${product.id}">
				                <img src="${pageContext.request.contextPath}/pictures/${product.img}" alt="${product.pname }" />
				                </a>
				              </div><!-- .prev -->
				              <h3 class="title">商品名称：${product.pname}--类型：${product.types}</h3>
				              <div class="cart">
				                <div class="price">
				                <div class="vert">
				                  <div class="price_new">现价：${product.currentprice}</div>
				                  <div class="price_old">原价：${product.oldprice}</div>
				                </div>
				                </div>
				                 	<div class="vert">发布用户：${product.user.username}</div>
				                	<div class="vert">日期：${product.releasedate}</div>
				              </div><!-- .cart -->
				            </div><!-- .grid_3 -->
				          </li>
					</c:forEach>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

        </ul><!-- #list_product2 -->
        </div><!-- .list_carousel -->
      </div><!-- .carousel -->

      <div id="content_bottom">
        <div class="grid_4">
          <div class="bottom_block about_as">
            <h3>关于我们</h3>
            <p>我们的爱倒Idle系统是主动适应当前日益发展壮大的电商环境，积极响应国家十三五“绿色”发展的发展理念，坚持节约资源和保护环境，这个平台为大家提供闲置的资源，使资源得以充分利用，减少浪费。</p>
            <p>同时，也方便了用户，使他们能够利用空闲时间方便解决了他们的闲置资源。达到了互惠互利，且保护环境的目的。</p>
            <p>希望有更多的人来使用我们的系统，使之开发的效用达到最大价值。</p>
          </div><!-- .about_as -->
        </div><!-- .grid_4 -->

        <div class="grid_4">
          <div class="bottom_block news">
            <h3>常见问题</h3>
            <ul>
              <li>
                <time datetime="2017-5-20">1、问：爱倒Idle网站上的物品和照片都是真实的吗？</time>
                                       答：爱倒承诺，爱倒网站上的所有物品均由注册用户自己填写，但是后台管理员可以查询信息是否合法，
                                       但是难以保证100%真实，还需广大用户自己提高警惕，注意辨识。
              </li>

              <li>
                <time datetime="2017-5-20">2、问：如何注册？</time>
               	 答：访问我们的首页你可以查看新用户注册须知，上面有相关注意事项。
              </li>

              <li>
                <time datetime="2017-5-20">3、问：可以直接浏览信息吗？</time>
                                      答：不可以的。为了数据的安全性着想，我们都是只有注册用户登陆后才可以展示商品信息的。不能直接浏览，
                                      是为了您的信息安全哟，请见谅！
              </li>
            </ul>
          </div><!-- .news -->
        </div><!-- .grid_4 -->

        <div class="grid_4">
          <div class="bottom_block newsletter">
            <h3>服务介绍</h3>
            <p>每年的大学毕业生成千上万，离校时总会有很多暂时不需要却仍有使用价值的资料及生活用品，丢掉属于资源浪费，
            	带到家里又不现实，这些物品得不到恰当的处理方式，亟需一个平台来使得这些资源得以继续使用，
            	于是便体现了大学生二手交易网站的重要性，通过网站将变闲置资源为宝，
            	既能解决毕业生闲置物品无法处理的问题，也为需要这些物品的同学提供了一个良好的平台，达到互惠共利的局面。</p>
            <p>而且网上购物只需要注册后发布信息，而不需要到处打听哪里有买家或者卖家，在这个时间就是生命的时代，
            	具有针对性的买卖大大提高了生活效率，方便、省时、安全。</p>
          </div><!-- .newsletter -->
        </div><!-- .grid_4 -->

        <div class="clear"></div>
      </div><!-- #content_bottom -->
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
