<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" type="text/css" href="../static/view-design/dist/styles/iview.css">
    <script type="text/javascript" src="../static/vue/dist/vue.min.js"></script>
    <script type="text/javascript" src="../static/view-design/dist/iview.min.js"></script>
<link rel="stylesheet" href="../bootstrap-4.4.1-dist/css/bootstrap.min.css">
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<title>${spu.name }详情</title>
</head>
<body>

${spu.goodsSaleAttrs[0].goodsSaleAttrValues[0]  }

<div class="card-body" style="text-align: center;">
		<div class="row no-gutters">
			<div class="col-md-4">
					<c:if test="${spu.image !=null }">
						<img alt="" src="../${spu.image }" class="card-img" style="width: 70%">
					</c:if>
					<c:if test="${spu.image eq null }">
						<img alt="" src="../image/goodsSpu/Default.jpg" class="card-img"  style="width: 70%">
					</c:if>
			</div>
			<div class="col-md-8">
				<div class="card-body">
				<div>
					<h4 class="card-title">${spu.name }<span id="name"></span></h4>

					<p>
						价格：<span id="price" style="color: red">${spu.price }</span>
					</p>
					<c:forEach items="${spu.goodsSaleAttrs }" var="saleAttrs">
<div class="item">
${saleAttrs.saleAttr.name }
	<c:forEach items="${saleAttrs.goodsSaleAttrValues }" var="values">
	
	<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="${values.value }" name="${saleAttrs.saleAttr.name }" class="custom-control-input" value="${values.id }">
  <label class="custom-control-label" for="${values.value }">${values.value }</label>
</div>	
	
	</c:forEach>
</div>
</c:forEach>
					<p>
						库存：<span id="inventory"></span></p>
					<p>
						销量：${spu.salesvolume }</p>
					<p>
						更多：${spu.description }</p>
						
					<p>
						<button onclick="numReduce()">-</button>
						<input type="number" id="num" value="1"
							style="width: 10%; text-align: center;">
						<button onclick="numAdd()">+</button>
					</p>
					<button
							style="background-color: lightcoral; color: white; border: none"
							onclick="addToCart()" data-toggle="modal"
							data-target=".bd-example-modal-sml">加入购物车</button>
					<button
						style="background-color: lightcoral; color: white; border: none"
						data-toggle="modal" data-target=".bd-example-modal-sml"
						onclick="forebuy()">购买</button>
				</div>
					

<c:forEach items="${spu.goodsImages }" var="item">
					
					
					
					<c:if test="${!(item.path eq null)}">
						<img alt="" src="../${item.path }" class="card-img" style="width: 70%">
					</c:if>
					
					</c:forEach>



				</div>
			</div>
		</div>
	</div>




	<div id="addToCartSuccess" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <p>加入购物车成功</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">ok</button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="loginModal" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog  modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-body">
							<form name="loginForm" action="../login" method="post" id="loginForm">
				<div class="form-group">
					<label>用户名</label> <input type="text" name="username"
						class="form-control " placeholder="用户名">
				</div>
				<div class="form-group">
					<label>密码</label> <input type="password" name="password"
						class="form-control" placeholder="密码" >
				</div>
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1"
						name="isSavePassword" checked="checked"> <label
						class="form-check-label" for="exampleCheck1">记住密码</label>
				</div>
					<button type="button" class="btn btn-primary btn-block rounded-pill"
					 onclick="login()">登陆1</button>
			</form>
				</div>

				<div class="modal-footer">
					<button data-dismiss="modal"
						class="btn btn-default  btn-block   btn-sm" type="button">取消</button>
				</div>
			</div>
		</div>
	</div>


<script type="text/javascript">
	var keys;
	var skuId;
	
	$(function () {
		$.ajax({
			url:"../getSkuKey",
			data:"id=${spu.id}",
			type:"get",
			cache:false,
			success:function(result){
				console.log(result);
				//console.log(result[0]);
				//console.log(result.keys);
				
				keys=result;
				console.log(keys);
				
				$.each(keys,function(key,values){
				  	console.log(key);
				  	console.log(values);
				  	
				  });
				
			
				
				//buildList(result);
			}
		});
		
		//$(".item").find("input").eq(0).prop("checked",true);
		$("input").click(function(){
			//alert($("input[type='radio']:checked").val());
//			console.log($("input[type='radio']:checked").eq(1));
			var k="";
			$.each($("input[type='radio']:checked"),function(index,item){
				//console.log(item.value);
				k=k+item.value+"|"
			});
			console.log(k);
			
			getSkuId(k);
			
		});
		
		
		function getSkuId(k) {
			$.each(keys,function(key,values){
			  	//console.log(key);
			  	//console.log(values);
			  	if(k == key){
			  		console.log("sku是："+values);
			  		skuId=values;
			  		//alert("sku是："+values);
			  		
			  		$.ajax({
						url:"../sku/"+values,
						data:"",
						type:"get",
						cache:false,
						success:function(result){
							console.log(result);
							$("#name").html(result.name);
							$("#price").html(result.price);
							$("#inventory").html(result.inventory);
							
						}
					});
			  		
			  		return false;
			  	}else{
			  		console.log("sku为空"+k);
			  	}
			  	
			  	
			  });
		}
		
		
		
		
	});


</script>
<script type="text/javascript">

	function numReduce() {
		var n=$('#num').val();
		if(n>1){
			n--;
			$('#num').val(n);
		}
	}
	
	function numAdd() {
		var n=$('#num').val();
		//if(n<${goods.gInventory }){
			n++;
			$('#num').val(n);
		//}
	}

	function addToCart() {
		if(!<%=session.getAttribute("users")!=null%>){
			//alert("请先登录");
			$('#loginModal').modal('show');
			return true;
		}
			$.ajax({
				url:"../goodsCarts",
				dataType:'json',
				contentType:'application/json;charset=UTF-8',
				//data:"skuId=${goods.gId }&&number="+$("#num").val(),
				data:JSON.stringify({
					"skuId":skuId,
					"number":$("#num").val()
				}),
				type:"post",
				success:function(result){
					//alert(result);
			//$('#addToCartSuccess').modal('show');
			 new Vue().$Message.success('成功加入购物车');
					console.log(result);
					//buildList(result);
				}
			});
		//alert("lll");
	}
	
	
function login() {
		

		$.ajax({
			url:"../login",
			type:"post",
			data:$("#loginForm").serialize(),
			success:function(result){
				//alert(result);
				if(result == "Success"){
					//alert("密码正确");
					$('#loginModal').modal('hide');
					location.reload(); 
				}else{
					alert("密码错误");
				}
			}
		});
		
	}
	
</script>


</body>
</html>