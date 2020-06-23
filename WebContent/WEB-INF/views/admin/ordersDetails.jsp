<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	function confirm() {
		$.ajax({
			url:"confirm",
			data:"oId="+${orders.id},
			type:"post",
			success:function(result){
				console.log(result);
					alert("收货成功");
					location.reload(); 
				//buildList(result);
			}
		});
	}

</script>
<title>Insert title here</title>
</head>
<body>

<div class="jumbotron" style="background-color: white;">

<h2>订单详情</h2>
<h4>订单号：${orders.id }</h4>
<hr>
<h4>${orders.statu }  </h4>

<div class="progress" >
  <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" style="width: 25%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100">待付款</div>
  <c:if test="${orders.statu eq '待发货'}">
	  <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" style="width: 25%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">待发货</div>
  </c:if>
  <c:if test="${orders.statu eq '待收货'}">
  	  <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" style="width: 25%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">待发货</div>
	  <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" style="width: 25%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">待收货</div>
  </c:if>
  <c:if test="${orders.statu eq '已完成'}">
  <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" style="width: 25%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">待发货</div>
	  <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" style="width: 25%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">待收货</div>
	  <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" style="width: 25%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">已完成</div>
  </c:if>
</div>
<hr>
创建时间：<fmt:formatDate value="${orders.creationtime }" pattern="yyyy-MM-dd HH:mm:ss"/>   
发货时间：<fmt:formatDate value="${orders.deliverytime }" pattern="yyyy-MM-dd HH:mm:ss"/>   
收货时间：<fmt:formatDate value="${orders.completiontime }" pattern="yyyy-MM-dd HH:mm:ss"/> 
<hr>
<h5>收货信息</h5>
<p>收货人：${orders.addressee }</p>
<p>地址：${orders.address }</p>
<p>联系电话：${orders.phonenumber }</p>
<hr>
<table class="table">
				<c:forEach items="${orders.orderitems }" var="i">
				<tr>
					<td>
					<c:if test="${i.goodsSku.goodsSpu.image !=null }">
						<img src="${i.goodsSku.goodsSpu.image }" class="align-self-start mr-3" alt="..." style="width: 100px" >
					</c:if>
					<c:if test="${i.goodsSku.goodsSpu.image eq null }">
						<img src="image/goodsSpu/Default.jpg" class="align-self-start mr-3" alt="..." style="width: 100px">
					</c:if>
						</td>
						<td>${i.goodsSku.name }</td>
						<td>${i.price }*${i.number }</td>
						<td>${i.goodsSku.goodsSpu.description }</td>
						<td>${i.express }</td>
							
						
					
					
					</tr>
				</c:forEach>
				</table>
</div>


<!-- 
<nav class="navbar fixed-bottom navbar-light bg-info text-white">
<a class="navbar-brand" href="#"> </a>
<c:if test="${orders.statu eq '待付款'}">
  <button id="paybtn" type="button" class="btn btn-success" onclick="pay()">付款</button>
</c:if>
<c:if test="${orders.statu eq '待发货'}">
  <button id="paybtn" type="button" class="btn btn-success" onclick="">提醒收货</button>
</c:if>
<c:if test="${orders.statu eq '待收货'}">
  <button id="paybtn" type="button" class="btn btn-success" onclick="confirm()">确认收货</button>
</c:if>
<c:if test="${orders.statu eq '已完成'}">
  <button id="paybtn" type="button" class="btn btn-success" onclick="">评价</button>
</c:if>


</nav>
 -->


<script type="text/javascript">
$("td").attr("style","vertical-align: middle");
</script>


</body>
</html>