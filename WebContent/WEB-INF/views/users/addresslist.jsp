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
<link rel="stylesheet" href="./layui/css/layui.css">
 <script src="./layui/layui.js"></script>
<script type="text/javascript">
	function add() {
		
		$("#addAddressModal").modal('show');
	}
	
	function save() {
		alert($("#addAddressForm").serialize());
		$.ajax({
			url:"address",
			type:"post",
			data:$("#addAddressForm").serialize(),
			success:function(result){
				alert(result);
			}
		});
		
		
	}
	

</script>
<title>Insert title here</title>
</head>
<body>



<table class="layui-table" lay-filter="test3">
		<thead>
    <tr>
     
      <th lay-data="{ field:'index',  sort: true}"></th>
      <th lay-data="{ field:'id',  sort: true,hide:true}">id</th>
      <th lay-data="{field:'addressee',  sort: true,edit: 'text'}">收货人</th>
      <th lay-data="{field:'address', sort: true,edit: 'text'}">地址</th>
      <th lay-data="{field:'phonenumber', sort: true,edit: 'text'}">联系电话</th>
      <th lay-data="{field:'edit',toolbar: '#barDemo'}">设为默认</th>

    </tr>
  </thead>
  <tbody>
  <c:forEach items="${address}" var="i" varStatus="index">
	<tr>
		<td>${index.index+1 }
		<c:if test="${users.defaultaddress == i.id }">
			<span class="layui-badge layui-bg-green">默认</span>
		</c:if>
		</td>
		<td>${i.id }</td>
		<td>${i.addressee }</td>
		<td>${i.address }</td>
		<td>${i.phonenumber }</td>
		<td></td>
	</tr>
	</c:forEach>
  
  </tbody>
</table>



<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" style="color:White" lay-event="default">设为默认</a>
  <a class="layui-btn layui-btn-xs" style="color:White" layui-btn-xs" lay-event="del">删除</a>
</script>



<button onclick="add()">添加</button>





<div id="addAddressModal" class="modal fade  bd-example-modal-xl" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加收货地址</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body layui-box">
        <form  class="layui-form layui-form-pane" action="" id="addAddressForm" >
				
				
				 <div class="layui-form">
       
        
            
            
             <div class="layui-form-item">
			    <label class="layui-form-label">收货人</label>
			    <div class="layui-input-inline">
			      <input type="text" name="addressee" placeholder="请输入收货人" autocomplete="off" class="layui-input">
			    </div>
 			 </div>
 			 
 			    <div class="layui-form-item" id="area-picker">
             <label class="layui-form-label">行内选择框</label>
            <div class="layui-input-inline" style="width: 200px;">
                <select name="province" class="province-selector" data-value="福建省" lay-filter="province-1">
                    <option value="">请选择省</option>
                </select>
            </div>
            <div class="layui-input-inline" style="width: 200px;">
                <select name="city" class="city-selector" data-value="漳州市" lay-filter="city-1">
                    <option value="">请选择市</option>
                </select>
            </div>
            <div class="layui-input-inline" style="width: 200px;">
                <select name="county" class="county-selector" data-value="诏安县" lay-filter="county-1">
                    <option value="">请选择区</option>
                </select>
            </div>
        </div>
 			 
             <div class="layui-form-item">
			    <label class="layui-form-label">详细地址</label>
			    <div class="layui-input-inline">
			      <input type="text" name="address" placeholder="请输入详细地址 " autocomplete="off" class="layui-input">
			    </div>
 			 </div>
             <div class="layui-form-item">
			    <label class="layui-form-label">联系电话</label>
			    <div class="layui-input-inline">
			      <input type="text" name="phonenumber" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
			    </div>
 			 </div>
            
            
          
          
    </div>
				
				
				
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="save()" >保存</button>
      </div>
    </div>
  </div>
</div>



    <script>
        //配置插件目录
        layui.config({
            base: './area-picker/'
            , version: '1.0'
        });
        //一般直接写在一个js文件中
        layui.use(['layer', 'form', 'layarea'], function () {
            var layer = layui.layer
                , form = layui.form
                , layarea = layui.layarea;

            layarea.render({
                elem: '#area-picker',
                change: function (res) {
                    //选择结果
                    console.log(res);
                }
            });
        });
    </script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.init('test3', { //转化静态表格
      //height: 'full-500'
	  cellMinWidth: 80 
    }); 
  
  
  //监听单元格编辑
  table.on('edit(test3)', function(obj){
    var value = obj.value //得到修改后的值
    ,data = obj.data //得到所在行所有键值
    ,field = obj.field; //得到字段
    layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
    
	$.ajax({
		url:"updateAddress",
		data:"id="+obj.data.id+"&addressee="+obj.data.addressee+"&address="+obj.data.address+"&phonenumber="+obj.data.phonenumber,
		type:"post",
		cache:false,
		success:function(result){
			console.log(result);
			
		}
	});
    
    
  });
  
  
  
  
  
  table.on('tool(test3)', function(obj){
	    var data = obj.data;
	    //console.log(obj)
	    if(obj.event === 'details'){
	    	//alert(data.oId);
	    	
	    	 layer.open({
   		      type: 2,
   		      title: '订单详情',
   		      maxmin: true,
   		      shadeClose: true, //点击遮罩关闭层
   		      area : ['600px' , '420px'],
   		      content: '../getOrdersById?oid='+data.oId
   		    });
	    	
	    	
	    } else if(obj.event === 'del'){
	    	alert(data.id);
		   layer.confirm('真的删除行么', function(index){
		    	//alert("即将删除");
		    	$.ajax({
		    		url:"delAddress",
		    		data:"id="+obj.data.id,
		    		type:"post",
		    		cache:false,
		    		success:function(result){
		    			console.log(result);
				       obj.del();
				       layer.close(index);
		    		}
		    	});
		      });
	    } else if(obj.event === 'default'){
	    	//alert(data.id);
			   layer.confirm('是否设为默认', function(index){
			    	//alert("即将删除");
			    	$.ajax({
			    		url:"setDefaultAddress",
			    		data:"id="+obj.data.id,
			    		type:"post",
			    		cache:false,
			    		success:function(result){
			    			console.log(result);
					       layer.close(index);
					       location.reload(); 
			    		}
			    	});
			      });
		    }
	  });
  
  
});




</script>


</body>
</html>