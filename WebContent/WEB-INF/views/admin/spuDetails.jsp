<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<form id="attrDiv">
<c:forEach items="${spu.goodsSaleAttrs }" var="saleAttrs">
<div class="item">
${saleAttrs.saleAttr.name }
<input hidden="true" name="saleAttrId" value="${saleAttrs.saleAttr.id }">
	<c:forEach items="${saleAttrs.goodsSaleAttrValues }" var="values">
	
	<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="${values.value }" name="${saleAttrs.saleAttr.id }" class="custom-control-input" value="${values.id }">
  <label class="custom-control-label" for="${values.value }">${values.value }</label>
</div>	
	
	</c:forEach>
</div>
</c:forEach>
</form>
<button id="addModalBtn"  onclick="showAddSkuModal()" data-toggle="modal" data-target="#addSkuModal">添加</button>



<div id="addSkuModal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
       <form id="addForm">
       
       
	<table>
		<tr>
			<td>sku名称</td>
			<td><input name="name"> </td>
		</tr>
		<tr>
			<td>价格</td>
			<td><input name="price"></td>
		</tr>
		<tr>
			<td>库存</td>
			<td><input name="inventory"></td>
		</tr>
		
		<tr id="saleAttrTr">
			<td><select id="saleAttrSelect" name="saleAttrId"></select></td>
			<td class="saleAttrSelectTd">
					<button type="button" class="addSaleAttrValue">添加</button>
			</td>
		</tr>
		<tr>
			<td><button type="button" id="addSku">提交</button></td>
		</tr>
	
	
	
	</table>
	
	
	<c:forEach items="${spu.goodsSaleAttrs }" var="saleAttrs">
		${saleAttrs.saleAttr.name }
		<input hidden="true" name="saleAttrId" value="${saleAttrs.saleAttr.id }">
		<input hidden="true" name="spuId" value=" ${spu.id }">
	</c:forEach>
	
	
	
	
       
       </form>
       
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">ok</button>
      </div>
    </div>
  </div>
</div>




<script type="text/javascript">
	var keys;
	var k="";
	$("#addModalBtn").hide();
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
		$("#attrDiv input").click(function(){
			//alert($("input[type='radio']:checked").val());
//			console.log($("input[type='radio']:checked").eq(1));
			k="";
			$.each($("input[type='radio']:checked"),function(index,item){
				//console.log(item.value);
				k=k+item.value+"|"
			});
			console.log(k);
			
			getSkuId(k);
		});
		
		
		function getSkuId(k) {
			
			if(keys.length==null){
				console.log("空");
				if($("input[type='radio']:checked").length==${fn:length(spu.goodsSaleAttrs)}){
				$("#addModalBtn").show();
				}
			}
				console.log(keys.length);
			
			$.each(keys,function(key,values){
			  	//console.log(key);
			  	//console.log(values);
			  	if(k == key){
			  		console.log("sku是："+values);
			  		//alert("sku是："+values);
			  		$("#addModalBtn").hide();
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
			  		if($("input[type='radio']:checked").length==${fn:length(spu.goodsSaleAttrs)}){
						$("#addModalBtn").show();
						}
			  	}
			  	
			  	
			  });
		}
		
		
		$("#addSku").click(function(){
			var addData=$("#addForm").serialize()+"&valueString="+k;
			alert(addData);
			//alert($("#attrDiv").serialize());
			$.ajax({
				url:"../addSku",
				data:addData,
				type:"post",
				cache:false,
				success:function(result){
					
				}
			});
			
		});
		
		
		
		
		
	});


</script>


</body>
</html>