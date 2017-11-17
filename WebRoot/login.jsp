<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>	
<head>
	<title>注册</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/css/bootstrap-social.css" rel="stylesheet" type="text/css">	
	<link href="<%=path %>/css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-image-1">
	<div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-login-form-2" role="form" action="<%=path %>/login.action" method="post">
				<div class="row">
					<div class="col-md-12">
						<h1>吉祥宠物商店</h1>
					</div>
				</div>
				<div class="row">
					<div class="templatemo-one-signin col-md-6">
				        <div class="form-group">
				          <div class="col-md-12">		          	
				            <label for="username" class="control-label">用户名</label>
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-user"></i>
				            	<input type="text" class="form-control" id="username" name="username" placeholder="用户名" required>
				            </div>		            		            		            
				          </div>              
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <label for="password" class="control-label">密码</label>
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-lock"></i>
				            	<input type="password" class="form-control" name="user.password" id="password" placeholder="密码" required>
				            </div>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <div class="checkbox">
				                <label>
				                  <input type="checkbox"> 记住我
				                </label>
				            </div>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <input type="submit" value="登录" class="btn btn-warning">
				          </div>
				        </div>
				        <div class="form-group">
				          	<div class="col-md-12">
				        		<a href="<%=path %>/ResetPassword.jsp" class="text-center">忘记密码</a>
				       	 	</div>
				    	</div>
					</div>
					<div class="templatemo-other-signin col-md-6">
						<label class="margin-bottom-15">
							您还没有我们的账号吗？赶紧 <a rel="nofollow" href="http://lipis.github.io/bootstrap-social/">注册一个</a> 为自己寻找一个合适的朋友。
						</label>
						<a class="btn btn-block btn-social btn-facebook margin-bottom-15" href="<%=path %>/register.jsp">
						    <i class="fa fa-facebook"></i> 注册
						</a>
						<a class="btn btn-block btn-social btn-twitter margin-bottom-15">
						    <i class="fa fa-twitter"></i> Sign in with Twitter
						</a>
						<a class="btn btn-block btn-social btn-google-plus">
						    <i class="fa fa-google-plus"></i> Sign in with Google
						</a>
					</div>   
				</div>				 	
		      </form>		      		      
		</div>
	</div>	
</body>
</html>
