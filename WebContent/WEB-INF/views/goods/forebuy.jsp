<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="bootstrap-4.4.1-dist/css/bootstrap.min.css" >
<script src="js/jquery-3.4.1.min.js"></script>
<script src="bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var orderid;
	function pay2() {
		
		$.ajax({
			url:"neworders",
			type:"post",
			data:$("#ordersForm").serialize(),
			success:function(result){
				$("#payCode").attr("src",result.data.img);
				//alert(result);
				console.log(result);
				console.log(result.data.img);
				$("#oderId").text(result.data.orderid);
				orderid=result.data.orderid;
				$('#payModal').modal('show');
				getOrderStatu();
			}
		});
		
	}

	function getOrderStatu(){
		setTimeout(function(){
		$.ajax({
			url:"getOrderStatu",
			type:"get",
			cache:false,
			data:"oid="+orderid,
			success:function(result){
				if(result.statu !="待付款"){
					//alert("支付成功");
					$('#paySuccess').modal('show');
				}else{
					//setTimeout(getOrderStatu(),5000);
					getOrderStatu();
				}
				
				
			}
		});
		},2000);
	}
	
	
	function pay3() {
		alert("lll");
		var url="neworders?"+$("#ordersForm").serialize();
		//alert(url);
		$("#payCode").attr("src",url);
		$('#payModal').modal('show');
		
		
	}


	function numReduce() {
		var n=$('#num').val();
		if(n>1){
			n--;
			$('#num').val(n);
		}
	}
	
	function numAdd() {
		var n=$('#num').val();
		
			n++;
			$('#num').val(n);
		
	}
	
	
	
	$(document).ready(function(){
		 //加的效果
		 $(".add").click(function(){
			// alert("llll");
		   var n=$(this).prev().val();
		   var num=parseInt(n)+1;
		   if(num==0){ return;}
		      $(this).prev().val(num);
		      price= num * $(this).parents("tr").find("td:eq(2)").text();
		      $(this).parents("tr").find("td:eq(4)").text(price);
		     
		      
		 });
		 //减的效果
		 $(".reduce").click(function(){
		   var n=$(this).next().val();
		   var num=parseInt(n)-1;
		   if(num==0){ return}
		   $(this).next().val(num);
		   price= num * $(this).parents("tr").find("td:eq(2)").text();
		      $(this).parents("tr").find("td:eq(4)").text(price);
		  });
		 
		 $(".price").on("DOMNodeInserted",function(){
			    //var text = $(this).val();
			    //alert("lll");
			    var totalPrice=0;
			    $.each($(".price"),function(index,p){
			    	//alert($(p).text());
			    	totalPrice+=parseFloat($(p).text());
			    });
			    $("#paybtn").text("支付（"+totalPrice+"）")
			 });
		 
		 
		 
		 var totalPrice=0;
		    $.each($(".price"),function(index,p){
		    	//alert($(p).text());
		    	totalPrice+=parseFloat($(p).text());
		    });
		    $("#paybtn").text("支付（"+totalPrice+"）")
		 
		 
		 
	});
	
	
	
	
	

</script>
<title>Insert title here</title>
</head>
<body>

<div class="card text-center">
请选择收货地址：



<form action="neworders" method="post" id="ordersForm">
<select class="form-control" style="width: 500px" name="address">
<c:forEach items="${address }" var="i">
<option>收货人：${i.addressee }，收货地址：${i.address }，联系电话：${i.phonenumber }</option>
</c:forEach>

</select>
<table class="table table-striped">
	<tr>
		<th></th>
		<th>商品</th>
		<th>单价</th>
		<th>数量</th>
		<th>价格</th>
	</tr>
	

<c:forEach items="${orderitems }" var="i">  

<tr>
		<td>
			<c:if test="${i.goodsSku.goodsSpu.image !=null }">
				<img src="${i.goodsSku.goodsSpu.image }"
					class="align-self-start mr-3" alt="..." style="width: 80px">
			</c:if>
			<c:if test="${i.goodsSku.goodsSpu.image eq null }">
				<img src="image/goodsSpu/Default.jpg" class="align-self-start mr-3"
					alt="..." style="width: 80px">
			</c:if>
		</td>
		<td>${i.goodsSku.name }<input name="gid" hidden="true" value="${i.goodsSku.id }"></td>
		<td>${i.goodsSku.price }</td>
		<td>
			<button class="reduce" type="button" >-</button>
			<input id="num" name="number" value="${i.number }" style="width: 50px">
			<button class="add" type="button" >+</button>
			 </td>
		<td class="price">${i.goodsSku.price * i.number}</td>
	</tr>



	
</c:forEach>
</table>



	
	<div class="fixed-bottom p-3 mb-2 bg-info text-white" style="text-align: right;">
		<button id="paybtn" type="button" class="btn btn-success" onclick="pay2()">支付</button>
	</div>
</form>


</div>

	
	<div id="payModal" class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">请扫码支付</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<table>
      	<tr>
      		<td>
        		<img alt="二维码" src="" style="width: 200px;height: 200px" id="payCode">
      		</td>
      		<td>单号：<span id="oderId"></span></td>
      	</tr>
      	</table>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary">已支付</button>
      </div>
    </div>
  </div>
</div>
	
		<div id="paySuccess" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <p>支付成功</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">ok</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>