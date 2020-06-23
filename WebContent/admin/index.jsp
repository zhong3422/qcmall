<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<title>Insert title here</title>
</head>
<body>


<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">layui 后台布局</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          <span id="user"></span>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">商品</a>
          <dl class="layui-nav-child">
            <dd><a href="#" onclick="javascript:$('#iframe').attr('src','spuList.html');">商品列表</a></dd>
            <dd><a href="#" onclick="javascript:$('#iframe').attr('src','../adminGoodsList');">商品管理</a></dd>
            <dd><a href="#" onclick="javascript:$('#iframe').attr('src','addSpu.jsp');">添加spu</a></dd>
            <dd><a href="#" onclick="javascript:$('#iframe').attr('src','../adminSpu/2');">添加sku</a></dd>
            <dd><a href="#" onclick="javascript:$('#iframe').attr('src','addSpu.jsp');">spu列表</a></dd>
            <dd><a href="#" onclick="javascript:;">列表三</a></dd>
            <dd><a href="#" onclick="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">订单</a>
          <dl class="layui-nav-child">
            <dd><a href="#" onclick="javascript:$('#iframe').attr('src','../adminOrders');">订单列表</a></dd>
            <dd><a href="#" onclick="javascript:$('#iframe').attr('src','ordersList.html');;">订单处理</a></dd>
            <dd><a href="#" onclick="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="">云市场</a></li>
        <li class="layui-nav-item"><a href="">发布商品</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body" id="layui-body">
    <!-- 内容主体区域 -->
    
<!-- 
    <iframe id="iframe" style="width: 100%;height:100%" src="../goods/goodsList.html"></iframe>
 -->
     <iframe id="iframe" style="width: 100%;height:100%" src="../index.jsp"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>

<script>

//var iframeHeight = $("#layui-body").height();
//$("#iframe").height(iframeHeight);





//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
<script type="text/javascript">

$(function () {
	$.ajax({
		url:"../isLogin",
		cache:false,
		type:"get",
		success:function(result){
			console.log(result);
			if(result==""){
				//alert("未登录");
				$("#user").html("未登录");
				$("#user").click(function(){
					//window.open("../users/login.jsp");  
					window.location.href = "../users/login.jsp"; 
				});
			}else{
				$("#user").html(result.username);
			}
			
		}
	});
});

</script>





</body>
</html>