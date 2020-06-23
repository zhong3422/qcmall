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
<script src="js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="./layui/css/layui.css" media="all">
<script src="./layui/layui.js"></script>
<title>Insert title here</title>
</head>
<body>


	<table class="layui-table" lay-filter="test3">
		<thead>
    <tr>
     
      <th lay-data="{field:'id', sort: true}">id</th>
      <th lay-data="{field:'name',  sort: true}">商品名称</th>
      <th lay-data="{field:'price',  sort: true,}">单价</th>
      <th lay-data="{field:'number', }">数量</th>
      <th lay-data="{field:'express',  edit: 'text'}">物流</th>

    </tr>
  </thead>
  <tbody>
	
				<c:forEach items="${orders.orderitems }" var="i">
				<tr>
						<td>${i.oId }</td>
						<td>${i.goodsSku.name }</td>
						<td>${i.price }</td>
						<td>${i.number }</td>
						<td>${i.express }</td>
							
						
					
					
					</tr>
				</c:forEach>
  </tbody>
				</table>

<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.init('test3', { //转化静态表格
      //height: 'full-500'
    }); 
  
  
  //监听单元格编辑
  table.on('edit(test3)', function(obj){
    var value = obj.value //得到修改后的值
    ,data = obj.data //得到所在行所有键值
    ,field = obj.field; //得到字段
    layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
    
	$.ajax({
		url:"updateordersitems",
		data:"id="+obj.data.id+"&express="+obj.data.express,
		type:"get",
		cache:false,
		success:function(result){
			console.log(result);
			buildList(result);
		}
	});
    
    
  });
});
</script>


</body>
</html>