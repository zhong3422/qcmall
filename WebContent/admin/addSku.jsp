<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <script src="../js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<title>Insert title here</title>
</head>
<body>

<form action="../spu" id="form" method="post">

	<table>
		<tr>
			<td>spu名称</td>
			<td><input name="name"> </td>
		</tr>
		<tr>
			<td>价格</td>
			<td><input name="price"></td>
		</tr>
		<tr>
			<td>详情</td>
			<td><input name="description"></td>
		</tr>
		<tr>
			<td>分类</td>
			<td><input name="t"> </td>
		</tr>
		<tr id="saleAttrTr">
			<td><select id="saleAttrSelect" name="saleAttrId"></select></td>
			<td class="saleAttrSelectTd">
					<button type="button" class="addSaleAttrValue">添加</button>
			</td>
		</tr>
		<tr>
			<td><button type="button" id="addSpu">提交</button></td>
		</tr>
	
	
	
	</table>
	
	<div id="saleAttrs">
		<select id="saleAttrSelect1" name="saleAttrId">
			
		</select>
	</div>
		<button type="button" id="addSaleAttr">添加属性</button>
		<!-- 
		
		<tr id="saleAttrTr">
			<td><select id="saleAttrSelect" name="saleAttrId"></select></td>
			<td class="saleAttrSelectTd">
					<div class="layui-btn-container tag" lay-filter="demo" lay-allowclose="true" lay-newTag="true">
				   
				    <!--自定义新增标签按钮元素 button-new-tag -->
				    <!--<button type="button" class="layui-btn layui-btn-primary layui-btn-sm layui-btn-radius button-new-tag">+ New Tag</button>-->
					</div>
			</td>
		</tr>
		
		
		
	<div class="layui-btn-container tag" lay-filter="demo" lay-allowclose="true" lay-newTag="true">
    <button lay-id="11" type="button" class="tag-item">网站设置</button>
    <button lay-id="22" type="button" class="tag-item">用户管理</button>
    <button lay-id="33" type="button" class="tag-item">权限分配</button>
    <button lay-id="44" type="button" class="tag-item">商品管理</button>
    <button lay-id="55" type="button" class="tag-item">订单管理</button>
		 -->
    <!--自定义新增标签按钮元素 button-new-tag -->
    <!--<button type="button" class="layui-btn layui-btn-primary layui-btn-sm layui-btn-radius button-new-tag">+ New Tag</button>-->

	
	
	
	<button>提交1</button>

</form>
<script type="text/javascript">



	$(".addSaleAttrValue").click(function(){
		
		$("<input name='saleAttrValue'>").appendTo($(this).parents("td"));
		
		
	});




	$("#addSpu").click(function(){
		//alert($("#form").serialize());
		var data1="";
		
			var d="";
		$.each($(".saleAttrSelectTd"),function(index,value){
			//console.log($(value).find("input").length);
			for(var i=0;i<$(value).find("input").length;i++){
				d=d+"&saleAttrIndex="+index;
			}
		});
			console.log(d);
		
		
		//alert($(".saleAttrSelectTd").length);
		//$.each($(".saleAttrSelectTd"),function(index,value){
		  	//console.log(value.find("button"));
		  	//console.log($("value").find("button").eq(1).text());
		  //	console.log($("value button"));
		  	//for(var i=0;i<)
		  	
		  	
		 	//$("<option>"+value.name+"</option>").val(value.id).appendTo("#saleAttrSelect");
		  	
	//	  });
		
		var data=$("#form").serialize()+d;
		alert(data);
		
		$.ajax({
			url:"../spu",
			type:"post",
			data:data,
			success:function(result){
				alert(result);
			}
		});
		
		
		
	});
	
	
	$("#addSaleAttr").click(function(){
		//$("<select  name='saleAttr'></select>").appendTo("#saleAttrs");
		//$("#saleAttrSelect").clone(true).appendTo("#saleAttrs");
		$("#saleAttrTr").clone(true).appendTo("table");
	});
	$.ajax({
		url:"../saleAttr",
		type:"get",
		data:"",
		success:function(result){
			
			//alert(result);
			console.log(result);
			$.each(result,function(index,value){
			  	console.log(value.name);
			 	$("<option>"+value.name+"</option>").val(value.id).appendTo("#saleAttrSelect");
			  	
			  });
			
			
		}
	});
	
	

</script>
<!-- 
<script>
    //config的设置是全局的
    layui.config({
        base: '../layui-tag/modules/' //假设这是你存放拓展模块的根目录
    }).extend({ //设定模块别名
        tag: 'tag' //如果 tag.js 是在根目录，也可以不用设定别名
    }).use('tag', function () {
        var $ = layui.jquery
            , tag = layui.tag; //Tag的切换功能，切换事件监听等，需要依赖tag模块

        //全局设置
        /*tag.set({
          likeHref: 'modules/tag.css', //tag.css所在的路径
          skin: 'layui-btn layui-btn-primary layui-btn-sm layui-btn-radius',//标签样式
          tagText: '添加标签' //标签添加按钮提示文本
        });*/

        //指定渲染 lay-filter="test" 圆角风格的TAG
        tag.render("test", {
            skin: 'layui-btn layui-btn-primary layui-btn-sm layui-btn-radius',//标签样式
            tagText: '<i class="layui-icon layui-icon-add-1"></i>添加标签' //标签添加按钮提示文本
        });

        //触发事件
        var active = {
            tagAdd: function () {
                //新增一个Tag项
                tag.add('demo', {
                    text: '新选项' + (Math.random() * 1000 | 0) //用于演示
                    , id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                    
                })
            }
            , tagDelete: function (othis) {
                //删除指定Tag项
                tag.delete('demo', '44'); //删除：“商品管理”
                othis.addClass('layui-btn-disabled');
            }
        };

        $('.site-demo-active').on('click', function () {
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        tag.on('click(demo)', function (data) {
            console.log('点击');
            console.log(this); //当前Tag标签所在的原始DOM元素
            console.log(data.index); //得到当前Tag的所在下标
            console.log(data.elem); //得到当前的Tag大容器
            console.log($(this));
            console.log($(this).text());
        });

        tag.on('add(demo)', function (data) {
            console.log('新增');
            console.log(this); //当前Tag标签所在的原始DOM元素
            console.log(data.index); //得到当前Tag的所在下标
            console.log(data.elem); //得到当前的Tag大容器
            console.log(data.othis); //得到新增的DOM对象
            //return false; //返回false 取消新增操作； 同from表达提交事件。
        });

        tag.on('delete(demo)', function (data) {
            console.log('删除');
            console.log(this); //当前Tag标签所在的原始DOM元素
            console.log(data.index); //得到当前Tag的所在下标
            console.log(data.elem); //得到当前的Tag大容器
            //return false; //返回false 取消删除操作； 同from表达提交事件。
        });
    });
</script>
 -->



</body>
</html>