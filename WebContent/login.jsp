<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="./js/jquery-3.4.1.min.js"></script>
<link href="./bootstrap-4.4.1-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="./bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<title>登陆</title>
<style>
</style>
</head>

<script type="text/javascript">
	function login() {
		//alert($("#loginForm").serialize());
		//var a="aaa";
		$.ajax({
			url:"login",
			type:"post",
			data:$("#loginForm").serialize(),
			success:function(result){
				//alert(result);
				//alert(a);
				if(result == "Success"){
					//alert("密码正确");
					//$('#loginModal').modal('hide');
					//location.reload(); 
					history.go(-1);
				}else{
					alert("密码错误");
				}
			}
		});
		
		
	}


</script>

<script>

	
	$(function(){
		  $("#registername").keyup(function(e){		  
		     
		     $.ajax({
					url:"usernameDetection",
					type:"post",
					data:$("#registerForm").serialize(),
					success:function(result){
						
						if(result){
							$("#registername").attr("class","form-control is-valid");
							$("#rigisterButton").attr("class","btn btn-primary btn-block rounded-pill");
						}else{
							$("#registername").attr("class","form-control is-invalid");
							$("#rigisterButton").attr("class","btn btn-primary btn-block rounded-pill disabled");
							
						}
					}
				});
		     
		     
		  });
		  
		  
		  $("#passowrd").keyup(function(e){		  
		   
			  if($("#passowrd").val==$("#passowrd1").val){
					$("#passowrd1").attr("class","form-control is-valid");
					$("#rigisterButton").attr("class","btn btn-primary btn-block rounded-pill");
			  }else{
				  $("#passowrd1").attr("class","form-control is-invalid");
					$("#rigisterButton").attr("class","btn btn-primary btn-block rounded-pill disabled");
			  }
			  
		  });
		  $("#passowrd1").keyup(function(e){		  
			  if($("#passowrd").val==$("#passowrd1").val){
					$("#passowrd1").attr("class","form-control is-valid");
					$("#rigisterButton").attr("class","btn btn-primary btn-block rounded-pill");
			  }else{
				  $("#passowrd1").attr("class","form-control is-invalid");
					$("#rigisterButton").attr("class","btn btn-primary btn-block rounded-pill disabled");
			  }
		   
			
			  
			  
		  });
		 
		    
		});
	
	
	
	
	
</script>

<body class="jumbotron jumbotron-fluid">

	



	




	<!-- 登陆中弹框 -->
	<div class="modal fade" id="inlogin" tabindex="-1"
		data-backdrop="static" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog  modal-dialog-centered" role="document">
			<div class="modal-content">

				<div class="modal-body">
					登陆中……
					<div class="spinner-border text-primary" role="status"></div>

				</div>

			</div>
		</div>
	</div>







	<!-- 注册弹框 -->
	<div class="modal fade" id="register" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog  modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<form id="registerForm" name="registerForm" action="../DoRegister" method="post">
						<div class="form-group">
							<label>用户名</label>
							<div class="input-group-prepend">
								<input id="registername" type="text" name="username"
									class="form-control" placeholder="用户名">
								<div class="invalid-tooltip">该账号已存在</div>
							</div>

						</div>
						<div class="form-group">
							<label>密码</label> <input id="passowrd" type="password" name="password"
								class="form-control" placeholder="密码">
						</div>
						<div class="form-group">
							<label>确认密码</label> <input id="passowrd1" type="password" 
								class="form-control" placeholder="密码">
						</div>

						<button id="rigisterButton" type="button"
							class="btn btn-primary btn-block rounded-pill"
							data-toggle="modal" data-target="#inlogin">注册</button>

					</form>
				</div>

				<div class="modal-footer">
					<button data-dismiss="modal"
						class="btn btn-default  btn-block   btn-sm" type="button">取消</button>
				</div>
			</div>
		</div>
	</div>













	<div>
		<div class="container">
			<!-- <h1>欢迎来到Meaningless网</h1> -->
			<h1>欢迎来到QC商城</h1>
			<form name="loginForm" action="../login" method="post" id="loginForm">
				<div class="form-group">
					<label>用户名</label> <input type="text" name="username"
						class="form-control " placeholder="用户名" value="${cookie.usernameCookie.value }">
				</div>
				<div class="form-group">
					<label>密码</label> <input type="password" name="password"
						class="form-control" placeholder="密码" value="${cookie.passwordCookie.value }">
				</div>
				<!-- 
				<div class="form-group">
					<label>验证码</label> <input type="password" name="checkcode"
						class="form-control" placeholder="验证码" >
						<img alt="验证码" src="../checkcode">
				</div>
				 -->
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1"
						name="isSavePassword" checked="checked"> <label
						class="form-check-label" for="exampleCheck1">记住密码</label>
				</div>
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="autoLogin"
						name="autoLogin" checked="checked"> <label
						class="form-check-label" for="autoLogin">自动登录</label>
				</div>
				<button type="submit" class="btn btn-primary btn-block rounded-pill"
					data-toggle="modal" data-target="#inlogin">登陆</button>
					<button type="button" class="btn btn-primary btn-block rounded-pill"
					 onclick="login()">登陆1</button>
			</form>
			<div class="form-row">
				<div class="col">
					<a href="getPassword.jsp">忘记密码</a>
				</div>
				<div align="right" class="col">
					<button type="button" class="btn btn-link" data-toggle="modal"
						data-target="#register">注册账号</button>
				</div>
			</div>


		</div>
	</div>



</body>
</html>