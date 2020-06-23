<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../bootstrap-4.4.1-dist/css/bootstrap.min.css">
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<h3> ${spu.name } <span id="name"></span> </h3>

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


<script type="text/javascript">
	var keys;
	
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
			  		//alert("sku是："+values);
			  		
			  		$.ajax({
						url:"../sku/"+values,
						data:"",
						type:"get",
						cache:false,
						success:function(result){
							console.log(result);
							$("#name").html(result.name);
							
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


</body>
</html>