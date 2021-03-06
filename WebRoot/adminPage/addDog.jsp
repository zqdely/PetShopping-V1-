<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.jbit.petshopping.entity.Dogtype"%>
<%@page import="cn.jbit.petshopping.biz.impl.DogTypeBizImpl"%>
<%@page import="cn.jbit.petshopping.biz.DogTypeBiz"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap Admin</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="<%=path %>/adminPage/lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css"
	href="<%=path %>/adminPage/stylesheets/theme.css">
<link rel="stylesheet"
	href="<%=path %>/adminPage/lib/font-awesome/css/font-awesome.css">

<script src="<%=path %>/adminPage/lib/jquery-1.7.2.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
     function checkPrice(){
		 var price=$("#price").val();
		 var $pinfo=$("#pinfo");
		 var isprice=/(^[1-9]\d*(\.\d{1,2})?$)|(^[0]{1}(\.\d{1,2})?$)/;
		 if( price==""){
		     $pinfo.html("价格不能为空"); 	
			 return false;
	     }else if(isprice.test(price)==false){
		     $pinfo.html("价格必须为合法数字(正数，最多两位小数)");  	 
			 return false; 	 
		 }else{
	         $pinfo.html("<img src='../adminPage/images/ok.png'/>");   	 
			 return true; 
		 }
	 };
	 function checkName(){
		 var name=$("#name").val();
		 var $nainfo=$("#nainfo");
		 if( name==""){
		     $nainfo.html("商品名称不能为空"); 	
			 return false; 	 
		 }else{
	         $nainfo.html("<img src='../adminPage/images/ok.png'/>");  	 
			 return true; 
		 }
	 };
	 function checkInfo(){
		 var iinfo=$("#iinfo").val();
		 var $info=$("#info");
		 if( iinfo==""){
		     $info.html("商品信息不能为空"); 	
			 return false; 	 
		 }else{
	         $info.html("<img src='../adminPage/images/ok.png'/>");   	 
			 return true; 
		 }
	 };

	 function checkBir(){
		 var brithday=$("#brithday").val();
		 var $binfo=$("#binfo");
		 var isbir=/^((((19|20)\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\d|30))|(((19|20)\d{2})-(0?[13578]|1[02])-31)|(((19|20)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$/;
		 if( brithday==""){
		     $binfo.html("宠物生日不能为空"); 	
			 return false;
	     }else if(isbir.test(brithday)==false){
		     $binfo.html("生日格式书写不正确(2012-12-12)");  	 
			 return false; 	 
		 }else{
	         $binfo.html("<img src='../adminPage/images/ok.png'/>"); 	 
			 return true; 
		 }
	 };
</script>
<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
span{
   color: red;
   font-size: 12px;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<script type="text/javascript" src="js/mySelf.js"></script>
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->
	<jsp:include page="top.jsp"></jsp:include>

	<jsp:include page="leftmenu.jsp"></jsp:include>


	<div class="content">

		<div class="header">

			<h1 class="page-title">添加宠物</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="index.jsp">首页</a> <span class="divider">/</span>
			</li>
			<li>宠物管理 <span class="divider">/</span>
			</li>
			<li class="active">添加宠物</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
                <div class="btn-toolbar">
				    <button class="btn">添加宠物</button>
				    <a href="pageDogs.action"><button class="btn btn-primary">宠物列表</button></a>
				  <div class="btn-group"></div>
				</div>
				
				<div class="well">
					 <%
						DogTypeBiz dtb=new DogTypeBizImpl();
						List<Dogtype> list=dtb.findAllType();
					 %>
					<div id="myTabContent" class="tab-content">
						<div class="block-body">
			                <form enctype="multipart/form-data" method="post" action="upload">
			                    <label>宠物名称</label>
			                    <input type="text" name="dog.dogname" id="name" onblur="checkName();" required="required">
			                    <span id="nainfo"></span>
			                    <label>宠物价格</label>
			                    <input type="text" name="dog.price" id="price" onblur="checkPrice();" required="required">
			                    <span id="pinfo" style="color:red">价格只能为数字，最多有两位小数</span>
			                    <label>宠物生日</label>
			                    <input type="text" name="brithday" id="brithday" onblur="checkBir();" required="required">
			                    <span id="binfo" style="color:red">示例：2012-12-12</span>
			                    
			                    <label>宠物图片</label>
			                    <div id="localImag"><img id="preview" style="diplay:none" /></div>
			                    <input type="file" name="myFile" id="doc" onchange="javascript:setImagePreview();" style="width: 222px;"/>
			                    
			                    <label>宠物简要信息</label>
			                   
			                    <input type="text" name="dog.intro" id="iinfo" onblur="checkInfo();" required="required">
			                    <span id="info"></span>
			                    <label>宠物详细信息</label>
			                    <textarea  rows="2" class="input-xlarge" style="width: 206px;" name="dog.info">
			                    </textarea>
			                    <label>宠物种类</label>
			                    <select name="typeid">
			                    	<option value="0">请选择宠物种类</option>
			                    	<%for(Dogtype type:list){ %>
			                    	<option value="<%=type.getTypeid()%>"><%=type.getTypename()%></option>
			                    	<%} %>
			                    </select>
			                    <label class="remember-me"><input type="checkbox"> 我同意这些 <a href="terms-and-conditions.html">条款
			
			</a></label>
			                    <div class="clearfix"></div>
			                    <input type="submit" value="提交">
			                    <input type="reset" value="重置">
			                </form>
			            </div>
						<div class="tab-pane fade" id="profile">
							<form id="tab2">
								<label>New Password</label> <input type="password"
									class="input-xlarge">
								<div>
									<button class="btn btn-primary">Update</button>
								</div>
							</form>
						</div>
					</div>

				</div>

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">Delete Confirmation</h3>
					</div>
					<div class="modal-body">

						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>Are you sure you want
							to delete the user?
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
						<a href="delete"><button class="btn btn-danger"
								data-dismiss="modal">Delete</button>
						</a>
					</div>
				</div>



				<jsp:include page="footer.jsp"></jsp:include>

			</div>
		</div>
	</div>



	<script src="<%=path %>/adminPage/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>

</body>
</html>


