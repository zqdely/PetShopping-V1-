<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>宠物商店注册</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
	<style type="text/css">
	    span{ color: red; font-size: 12px;}
	</style>
</head>
<body class="templatemo-bg-gray templatemo-bg-image-1">
	<h1 class="margin-bottom-15">宠物商店</h1>
	<div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="register.action" method="post">
				<div class="form-inner">
					<div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="name" class="control-label">用户名</label>		<!-- for 属性规定 label 与哪个表单元素绑定，此处是与下边的id="name"的输入框绑定的 -->
			            <input type="text" name="user.name" class="form-control" id="name" onblur="javascript:namejud()" placeholder="用户名" required="required"><span id="nameinfo"></span>															<!--required="required"属性规定必需在提交之前填写输入字段。-->
			          </div>              
			        </div>	
					<div class="form-group">
			          <div class="col-md-6">
			            <label for="password" class="control-label">密码</label>
			            <input type="password" name="user.password" class="form-control" maxlength="16" id="password" onblur="checkPwd()" placeholder="密码" required><span id="passinfo"></span>
			          </div>
			          <div class="col-md-6">
			            <label for="password" class="control-label">重复输入密码</label>
			            <input type="password" name="repassword" class="form-control" maxlength="16" id="password_confirm" onblur="javascript:checkRepwd()" placeholder="再次输入密码" required><span id="repassinfo"></span>
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="username" class="control-label">邮箱</label>
			            <input type="email" name="user.email" class="form-control" id="email" onblur="javascript:emailfunction()" placeholder="邮箱" required><span id="emailinfo"> </span>			            		            		            
			          </div>              
			        </div>
					<div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="address" class="control-label">地址</label>
			            <input type="text" name="user.address" class="form-control" id="address" placeholder="地址">		            		            		            
			          </div>              
			        </div>							
			        <div class="form-group">
			          <div class="col-md-6">		          	
			            <label for="phone" class="control-label">电话</label>
			            <input type="text" name="user.phone" class="form-control" id="phone" onblur="checkPhone();" placeholder="电话"><span id="phoneinfo"> </span>		            		            		            
			          </div>
			          <div class="col-md-6 templatemo-radio-group">
			          	<label class="radio-inline">
		          			<input type="radio" name="user.sex" id="optionsRadios1" value="男" > 男
		          		</label>
		          		<label class="radio-inline">
		          			<input type="radio" name="user.sex" id="optionsRadios2" value="女"> 女
		          		</label>
			          </div>             
			        </div>
			        
			        <div class="form-group">
			          <div class="col-md-12">
			            <label><input type="checkbox">我同意 <a href="javascript:;" data-toggle="modal" data-target="#templatemo_modal">注册条款</a> 和 <a href="#">使用守则</a></label>
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			            <input type="submit" value="注册" class="btn btn-info">
			            <a href="login.jsp" class="pull-right">登录</a>
			          </div>
			        </div>	
				</div>				    	
		      </form>		      
		</div>
	</div>

	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function namejud(){
			var value = $("#name").val();
			if(value==""){
				$("#nameinfo").html("请输入用户名");
				$("#name").focus();
			}else{
				$.get("registerNameServlet.action?name="+value,null,function(result){
					if(result.info=="用户名可用"){
						$("#nameinfo").html("");
					}else{
						$("#nameinfo").html(result.info);
						$("#name").focus();
					}
				});
			}	
		}
		function emailfunction(){
			var value=$("#email").val();
			if(value==""){
				$("#emailinfo").html("请输入邮箱");
				$("#email").focus();
			}else{
				$.get("registerNameServlet.action?email="+value,null,function(result){
					if(result.emailinfo=="邮箱可用"){
						$("#emailinfo").html("");
					}else{
						$("#emailinfo").html(result.emailinfo);
						$("#email").focus();
					}
				});
			}	
		}
		/*密码*/
		 var pass;
		 function checkPwd(){
			   pass=$("#password").val();
			   var ismi=/^\w{6,10}$/;
			   if( pass==""){
				   $("#passinfo").html("密码由英文字母、数字和下划线组成的6-12位字符");
				   return false;
			   }else if(ismi.test(pass)==false){ 	
				   $("#passinfo").html("密码由英文字母、数字和下划线组成的6-12位字符"); 
				   return false; 	 
			   }else{
				   $("#passinfo").hide(); 	 
				   return true; 
			   }
		  };
		  /*确认密码*/
		  function checkRepwd(){
			   var text_pass=$("#password_confirm").val();
			   var $repass=$("#repassinfo");
			   var isque=/^[a-zA-Z0-9]{4,10}$/;
			   if( text_pass==""){
				   $repass.html("密码不能为空！"); 	 
				   return false;
			   }else if(text_pass!=pass){
				   $repass.html("两次输入密码不一致！"); 	
				   $("#rpass").val(""); 
				   return false; 	 
			   }else{
				   $repass.html(""); 	 
				   return true; 
			   }
		  };
		  /*电话*/
		  function checkPhone(){
			   var phone=$("#phone").val();
			   var $rephone=$("#phoneinfo");
			   var isphone=/^[1][358][0-9]{9}$/;
			   if(phone==""){
			      $rephone.html(""); 	 
				  return true; 
			   }else if(isphone.test(phone)==false){
				   $rephone.html("手机号码输入不正确！"); 	
				   return false; 	 
			   }else{
				   $rephone.html(""); 	 
				   return true; 
			   }
		 };
	</script>
</body>
</html>
