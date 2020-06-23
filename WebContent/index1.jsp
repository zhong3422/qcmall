<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="bootstrap-4.4.1-dist/css/bootstrap.min.css" >
<script src="bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./layui/css/layui.css" media="all">
<script src="./layui/layui.js"></script>
</head>
<body>

	
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">商城</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
		<li class="nav-item active">
			<a class="nav-link" href="#">首页</a>
		</li>
			<%if (session.getAttribute("users") != null) {%>
		<li class="nav-item">
				<a class="nav-link" href="users/users.jsp">${users.username }</a>
		</li>
     	
		
		
			<%} else {%>
			
		<li class="nav-item">
				<a class="nav-link"  href="login.jsp">登录</a>
		</li>
			<%}%>
			<li class="nav-item">
      	<a class="nav-link" href="users/orderslist.html">查看订单</a>
     	</li>
     	<li class="nav-item">
        <a class="nav-link" href="users/goodsCarts.html">查看购物车</a>
     	</li>
		<li class="nav-item">
      	<a class="nav-link" href="goods/goodsList.html">全部商品</a>
     	</li>
     	<li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          	管理
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#" href="goods/releaseGoods.jsp">发布商品</a>
        <a  class="dropdown-item" href="getUsersList">获取商品列表——后台</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
	
	<!-- 
	<ul class="layui-nav">
  <li class="layui-nav-item">
    <a href="orders/orderslist2.html">查看订单<span class="layui-badge-dot"></span></a>
  </li>
  <li class="layui-nav-item">
     <a href="users/goodsCarts.html">查看购物车</a>
  </li>
  <li class="layui-nav-item">
     <a href="users/goodsCarts.html">查看购物车</a>
  </li>
  <li class="layui-nav-item">
    <a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
    <dl class="layui-nav-child">
      <dd><a href="javascript:;">修改信息</a></dd>
      <dd><a href="javascript:;">安全管理</a></dd>
      <dd><a href="javascript:;">退了</a></dd>
    </dl>
  </li>
</ul>
	 -->
	
	
	
	
	

	<form action="seachGoods" class="form-inline my-2 my-lg-0" style="margin: 0px auto;width: 350px ">
      <input name="keyword" class="form-control mr-sm-2" type="search" placeholder="请输入商品关键字" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
    </form>




<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel" style="width: 30%;margin: 0 auto;">
  <div class="carousel-inner">
    <div class="carousel-item active">
        <img src="image/goods/Default.jpg" class="d-block w-100 carouselImage"  alt="...">
    </div>
    <div class="carousel-item">
      <img src="image/goods/Default.jpg" class="d-block w-100 carouselImage" alt="...">
    </div>
    <div class="carousel-item">
      <img src="image/goods/Default.jpg" class="d-block w-100 carouselImage" alt="...">
    </div>
  </div>
</div>







	<div>
		<div class="container">
		<div class="row row-cols-4" id="goodsList">
		</div>
		<button onclick=" getData()">加载更多</button>
	</div>
		
	
	</div>

<script type="text/javascript">
var pageNumber=0;
	

	function buildList(result) {
		//alert(result.list)
		$.each(result.list,function(index,item){
			//alert(item.uid+item.username);
			var uidTd=$("<td></td>").append(item.uid);
				console.log(item.gImage);
				var img;
			if(item.image != null){
				img=$("<img>").attr("src",''+item.image).attr("style","width:100%");
			}else{
				img=$("<img>").attr("src","image/goodsSpu/Default.jpg").attr("style","width:100%");;
			}
				$("<div></div>").addClass("col").attr("style","text-align: center").attr("onclick","window.open('spu/"+item.id+"')").append(img).append(item.name).appendTo("#goodsList");
			
		});
	}
	
	
	function buildCarousel(list) {
		//console.log(result.list[1]);
		//alert(result);
		for(var i=0;i<3;i++){
			var src;
			if(list[i].gImage != null){
				src="image/goods/"+list[i].gImage;
			}else{
				src="image/goods/Default.jpg";
			}
		$(".carouselImage").eq(i).attr("src",src);
			
		}
	}
	
	
	
	function getData(){
		pageNumber++;
		$.ajax({
			url:"goodsList",
			data:"pageNumber="+pageNumber,
			type:"get",
			cache:false,
			success:function(result){
				console.log(result);
				buildList(result);
			}
		});
	}
	
	

	
	
	
	$(document).ready(function () { //本人习惯这样写了
		
	getData();
	
	
	
		
	    $(window).scroll(function () {
	        //$(window).scrollTop()这个方法是当前滚动条滚动的距离
	        //$(window).height()获取当前窗体的高度
	        //$(document).height()获取当前文档的高度
	        var bot = 50; //bot是底部距离的高度
	        if ((bot + $(window).scrollTop()) >= ($(document).height() - $(window).height())) {
	           //当底部基本距离+滚动的高度〉=文档的高度-窗体的高度时；
	            //我们需要去异步加载数据了
	           // $.getJSON("url", { page: "2" }, function (str) { alert(str); });
	           //alert("a");
	           getData();
	        }
	    });
	});
	
</script>

<script>
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
</script>
</body>
</html>