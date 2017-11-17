<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<title>密码重置</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray templatemo-bg-image-1">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">密码重置</h1>
			<form class="form-horizontal templatemo-forgot-password-form templatemo-container" role="form" action="resetepwdinfo.action" method="post">
				<input type="hidden" name="email" value="<s:property value="email"/>" />	
				<div class="form-group">
		          <div class="col-md-12">
		          	新密码：
		          </div>
		        </div>		
		        <div class="form-group">
		          <div class="col-md-12">
		            <input type="password" class="form-control" maxlength="16" name="pwd" id="pwd" placeholder="新密码">	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	再次输入新密码：
		          </div>
		        </div>		
		        <div class="form-group">
		          <div class="col-md-12">
		            <input type="password" class="form-control" maxlength="16" name="pwd1" id="pwd1" placeholder="再次输入新密码">	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		            <input type="submit" value="提交" class="btn btn-danger">
                    <br><br>
                    <a href="../login.jsp">登录</a> |
                    <a href="../register.jsp">注册</a>
		          </div>
		        </div>
		      </form>
		</div>
	</div>
</body>
</html>
