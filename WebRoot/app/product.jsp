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
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
  <meta http-equiv="content-type" content="text/html;charset=utf-8" />
  <meta name="description" content="Idle校园二手物品交易管理系统" />
  <meta name="keywords" content="Idle,校园二手物品" />
  <meta name="Author" content="lilingzhi" />
  <title>商品详情页面</title>
  <link rel="shortcut icon" href="favicon.ico">
  <link href="<%=path %>/app/css/style.css" media="screen" rel="stylesheet" type="text/css">
  <link href="<%=path %>/app/css/grid.css" media="screen" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="<%=path %>/app/css/jquery.jqzoom.css" type="text/css">
  <script src="<%=path %>/app/js/jquery-1.7.2.min.js" ></script>
  <script src="<%=path %>/app/js/html5.js" ></script>
  <script src="<%=path %>/app/js/jflow.plus.js" ></script>
  <script src="<%=path %>/app/js/jquery.carouFredSel-5.2.2-packed.js"></script>
  <script src="<%=path %>/app/js/checkbox.js"></script>
  <script src="<%=path %>/app/js/radio.js"></script>
  <script src="<%=path %>/app/js/selectBox.js"></script>
  <script src="<%=path %>/app/js/jquery.jqzoom-core.js" ></script>

  <script type="text/javascript">
	$(document).ready(function() {
		$('.jqzoom').jqzoom({
			zoomType: 'standard',
			lens:true,
			preloadImages: true,
			alwaysOn:false
		});
	});
  </script>
  <script type="text/javascript">
	$(document).ready(function() {
		$("select").selectBox();
	});
  </script>
  <script type="text/javascript">
	$(document).ready(function() {
		$('#wrapper_tab a').click(function() {
			if ($(this).attr('class') != $('#wrapper_tab').attr('class') ) {
				$('#wrapper_tab').attr('class',$(this).attr('class'));
			}
			return false;
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
          $('#list_banners').carouFredSel({
		prev: '#ban_prev',
		next: '#ban_next',
		scroll: 1,
		auto: false
	  });
	  $('#thumblist').carouFredSel({
		prev: '#img_prev',
		next: '#img_next',
		scroll: 1,
		auto: false,
		circular: false,
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
       <div class="breadcrumbs">
	      <a href="<%=path %>/ProductsServlet?tag=getAllA">首页</a><span>&#8250;</span><a href="#">分类</a>
	      <span>&#8250;</span><span class="current">当前页面</span>
       </div><!-- .breadcrumbs -->
    </div><!-- .grid_12 -->
  </div><!-- .container_12 -->

  <div class="clear"></div>

  <section id="main">
    <div class="container_12">
       <div id="sidebar" class="grid_3">
	      <aside id="categories_nav">
		     <h3>分类</h3>
		     
		     <nav class="left_menu">
			    <ul>
				   <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=yiFu">衣服 <span></span></a></li>
				   <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=shuJi">书籍 <span></span></a></li>
				   <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=shengHuo">生活用品 <span></span></a></li>
				   <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=huaZhuang">化妆品 <span></span></a></li>
				   <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=yunDong">运动器材 <span></span></a></li>
				   <li><a href="<%=path %>/ProductsServlet?tag=getPart&types=dianZi">电子产品 <span></span></a></li>
				   <li class="last"><a href="<%=path %>/ProductsServlet?tag=getPart&types=baoBao">箱包 <span></span></a></li>
			    </ul>
		     </nav><!-- .left_menu -->
	      </aside><!-- #categories_nav -->

	      <aside id="specials" class="specials">
		     <h3>特殊推荐</h3>
		     <ul>
				<c:choose>
					<c:when test="${not empty requestScope.products}">
						<c:forEach var="product" items="${requestScope.products}" step="2">
							<li>
							   <div class="prev">
								  <a href="${pageContext.request.contextPath}/ProductsServlet?tag=toProA&pid=${product.id}">
								  <img src="${pageContext.request.contextPath}/pictures/${product.img}" alt="${product.pname}" /></a>
							   </div>
							   
							   <div class="cont">
								  <a href="${pageContext.request.contextPath}/ProductsServlet?tag=toProA&pid=${product.id}">${product.pname}</a>
								  <div class="prise"><span class="old">${product.currentprice}</span>${product.oldprice}</div>
							   </div>   
						    </li>
						</c:forEach>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>                
		     </ul>
	      </aside><!-- #specials -->
       </div><!-- .sidebar -->

       <div id="content" class="grid_9">
	      <h1 class="page_title"> ${product.pname}</h1>
		<div class="product_page">
			<div class="grid_4 img_slid" id="products">
				<img class="sale" src="<%=path %>/app/images/sale.png" alt="Sale"/>
				<div class="preview slides_container">
					<div class="prev_bg">
						<a href="<%=path %>/app/images/produkt_slid.png" class="jqzoom" rel='gal1' title="">
							<img src="${pageContext.request.contextPath}/pictures/${product.img}"/>
						</a>
					</div>
				</div><!-- .prev -->
			</div><!-- .grid_4 -->
			<div class="grid_5">
				<div class="entry_content">
					<br>
					<h3>商品发布者：${product.user.username}</h3>
					<h3>商品类型：${product.types}</h3>
					<h3>发布日期：${product.releasedate}</h3>
					<h3>商品描述：</h3>
					<P style="width=120px;word-wrap:break-word;">${product.description}</P>
					<div class="ava_price">
						<div class="price">
							<div class="price_new">现价：${product.currentprice}</div>
							<div class="price_old">原价：${product.oldprice}</div>
						</div><!-- .price -->
					</div><!-- .ava_price -->
					<div class="block_cart">
						<div class="cart">
							<a href="<%=path %>/OrderServlet?tag=saveA&pid=${product.id}&username=<%=username %>" class="bay">下订单</a>
						</div>
						<div class="clear"></div>
					</div><!-- .block_cart -->
				</div><!-- .entry_content -->
			</div><!-- .grid_5 -->

			<div class="clear"></div>
			<div class="grid_9" >
				<div id="wrapper_tab" class="tab1">
					<a href="#" class="tab1 tab_link"><h4>用户留言</h4></a>
					<div class="tab1 tab_body">
						<br/><hr/>
						<ul class="comments">
							<c:choose>
								<c:when test="${not empty requestScope.nList}">
									<c:forEach var="note" items="${requestScope.nList}" step="3">
										<li><br/>
											<div class="autor">留言用户：${note.user.username }</div>--
											<time datetime="${note.notedate }">${note.notedate }</time>
											<br/><br/>
											<p>留言内容：${note.content} </p>
										</li>
										<hr/>
									</c:forEach>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</ul><!-- .comments -->
						
						<div class="clear"></div>
						<form class="add_comments" action="${pageContext.request.contextPath }/NoteServlet?tag=saveA" method="post">
							<input type="hidden" value="${product.id}" name="p_id" />
							<input type="hidden" value="<%=username %>" name="username" />
							<div class="clear"></div><br/>
							<h4>新增留言区</h4>
							<div class="text_review">
								<strong>填写留言</strong><sup class="surely">*</sup><br/>
								<textarea name="content"></textarea>
							</div><!-- .text_review -->
							<input type="submit" value="提交留言" />
						</form><!-- .add_comments -->
					<div class="clear"></div>
					</div><!-- .tab2 .tab_body -->

					<div class="tab3 tab_body">
						<h4>Custom Tab</h4>
					<div class="clear"></div>
					</div><!-- .tab3 .tab_body -->
					<div class="clear"></div>
				</div>​<!-- #wrapper_tab -->
				<div class="clear"></div>
			</div><!-- .grid_9 -->

			<div class="clear"></div>

			<div class="related">
				<div class="c_header">
					<div class="grid_7">
						<h2>类似商品推荐</h2>
					</div><!-- .grid_7 -->
				</div><!-- .c_header -->

				<div class="list_carousel">

				<ul id="list_product" class="list_product">
					<c:choose>
						<c:when test="${not empty requestScope.products}">
							<c:forEach var="product" items="${requestScope.products}" step="3">
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
		</div><!-- .product_page -->
		<div class="clear"></div>

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
