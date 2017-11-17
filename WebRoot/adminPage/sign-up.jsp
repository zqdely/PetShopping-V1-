<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.jbit.petshopping.biz.ProtypeBiz"%>
<%@ page import="cn.jbit.petshopping.biz.impl.ProtypeBizImpl"%>
<%@ page import="cn.jbit.petshopping.entity.Protype"%>
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

			<h1 class="page-title">添加商品</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="index.jsp">首页</a> <span class="divider">/</span>
			</li>
			<li>商品管理 <span class="divider">/</span>
			</li>
			<li class="active">修改商品</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
				    <button class="btn">修改商品</button>
				    <a href="propage.action"><button class="btn btn-primary">商品列表</button></a>
				  <div class="btn-group"></div>
				</div>
				<div class="well">
					
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
			<form action="updateProducts.action" enctype="multipart/form-data" method="post">
                    <input type="hidden" name="pdid" value="<s:property value='pdid'/>"/>
                    <label>商品名称</label>
                    <input type="text" name="products.name" value="<s:property value='products.name'/>"/>
                    <label>商品价格</label>
                    <input type="text" name="products.price" value="<s:property value='products.price'/>"/>
                    <label>修改商品图片</label>
                    <div id="localImag"><img id="preview" style="diplay:none" /></div>
                    <input type="file" name="uploadFile" id="doc" onchange="javascript:setImagePreview();" style="width: 222px;"/>
                    <input type="hidden" name="picture" value="<s:property value='products.picture'/>"> 
                    <label>商品简要信息</label>
                    <input type="text" name="products.intro" value="<s:property value='products.intro'/>"/>
                    <label>商品详细信息</label>
                    <textarea name="products.info" rows="2" class="input-xlarge" style="width: 206px;">
<s:property value="products.info"/>
                    </textarea>
                    <label>商品种类</label>
                    <input type="hidden" name="typeid" value="<s:property value='products.protype.protypeid'/>"> 
                    <select name="protypeid">
	                    <option value="0" selected="selected"><s:property value='products.protype.protypename'/></option>
	                   
	                    <%
	                      ProtypeBiz pb=new ProtypeBizImpl();
	                      List<Protype> protype=pb.fingAll();
	                      for(Protype list:protype){
	                     %>  
	                      <option value="<%=list.getProtypeid()%>"><%=list.getProtypename()%></option>
	                      <%} %>
                    </select> 
                    <label>库存数量</label>
                    <input type="text" name="products.procount" value="<s:property value='products.procount'/>"><br/>
                    <input type="submit" value="提交">&nbsp;&nbsp;
                    <div class="clearfix"></div>
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


