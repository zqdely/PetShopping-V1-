<%@page import="cn.jbit.petshopping.entity.Products"%>
<%@page import="cn.jbit.petshopping.biz.impl.ProductsBizImpl"%>
<%@page import="cn.jbit.petshopping.biz.ProductsBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<title>Single</title>
<link href="<%=path %>/userPage/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=path %>/userPage/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Raleway:400,200,600,800,700,500,300,100,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Arimo:400,700,700italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="<%=path %>/userPage/css/component.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="New Fashions Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" 
		/>
<script src="<%=path %>/userPage/js/jquery.min.js"></script>
<script src="<%=path %>/userPage/js/simpleCart.min.js"> </script>
<!-- start menu -->
<link href="<%=path %>/userPage/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%=path %>/userPage/js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- start menu -->
</head>
<body>
<!--header-->
<jsp:include page="top_menu_other.jsp"></jsp:include>
<!--header//-->
<!--Single Page starts Here-->
<div class="product-main">
	 <div class="container">
		 <ol class="breadcrumb">
		  <li><a href="<%=path %>/userPage/index.jsp">首页</a></li>
		  <li class="active">商品详情</li>
		 </ol>
		 <s:if test="#session.type!='dog'">
			 	<div class="ctnt-bar cntnt">
				 <div class="content-bar">
					 <div class="single-page">					 
						 <!--Include the Etalage files-->
							<link rel="stylesheet" href="<%=path %>/userPage/css/etalage.css">
							<script src="<%=path %>/userPage/js/jquery.etalage.min.js"></script>
						 <!-- Include the Etalage files -->
						 <script>
								jQuery(document).ready(function($){
						
									$('#etalage').etalage({
										thumb_image_width: 300,
										thumb_image_height: 400,
										source_image_width: 700,
										source_image_height: 800,
										show_hint: true,
										click_callback: function(image_anchor, instance_id){
											alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
										}
									});
									// This is for the dropdown list example:
									$('.dropdownlist').change(function(){
										etalage_show( $(this).find('option:selected').attr('class') );
									});
						
								});
							</script>
							<!--//details-product-slider-->
						 <div class="details-left-slider">
							  <ul id="etalage">
								 <li>
									<a href="optionallink.html">
									<img class="etalage_thumb_image" src="<%=path %>/update/<s:property value="products.picture"/>" />
									<img class="etalage_source_image" src="<%=path %>/update/<s:property value="products.picture"/>" />
									</a>
								 </li>
								 
								 <div class="clearfix"></div>
							 </ul>
						 </div>
						 <form id="form2" action="addgoodcart.action" method="post">
						 <input type="hidden" name="id" value="<s:property value="products.productid"/>" />
						 <input type="hidden" name="type" value="product" />
						 <div class="details-left-info">
								<h3><s:property value="products.name" /></h3>
									<h4><s:property value="products.intro" /></h4>							
								<p>￥ <s:property value="products.price"/> <!-- <a href="#">Click for offer</a> --></p>
								<p class="qty">购买数量 : </p><input min="1" type="number" id="quantity" name="quantitynum" value="1" class="form-control input-small">
								<div class="btn_form">
									<a href="#" onclick="javascript:login1()">添加到购物车</a>
									<script type="text/javascript">
									   function login1(){
									       $("#form2").submit() ;
									   }
									</script>
								</div>
								<div class="flower-type">
								<p>类型  : <a href="#"><s:property value="products.protype.protypename"/></a></p>
								<p>库存  : <a href="#"><s:property value="products.procount" /></a></p>
								</div>
								<h5>详细信息  : </h5>
								<p class="desc"><s:property value="products.info" /></p>
						 </div>
						 </form>
						 <div class="clearfix"></div>				 	
					 </div>
				 </div>
			 </div>	
		 </s:if>
		 <s:else>
		 	<div class="ctnt-bar cntnt">
				 <div class="content-bar">
					 <div class="single-page">					 
						 <!--Include the Etalage files-->
							<link rel="stylesheet" href="<%=path %>/userPage/css/etalage.css">
							<script src="<%=path %>/userPage/js/jquery.etalage.min.js"></script>
						 <!-- Include the Etalage files -->
						 <script>
								jQuery(document).ready(function($){
						
									$('#etalage').etalage({
										thumb_image_width: 300,
										thumb_image_height: 400,
										source_image_width: 700,
										source_image_height: 800,
										show_hint: true,
										click_callback: function(image_anchor, instance_id){
											alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
										}
									});
									// This is for the dropdown list example:
									$('.dropdownlist').change(function(){
										etalage_show( $(this).find('option:selected').attr('class') );
									});
						
								});
							</script>
							<!--//details-product-slider-->
						 <div class="details-left-slider">
							  <ul id="etalage">
								 <li>
									<a href="optionallink.html">
									<img class="etalage_thumb_image" src="<%=path %>/update/<s:property value="dog.picture"/>" />
									<img class="etalage_source_image" src="<%=path %>/update/<s:property value="dog.picture"/>" />
									</a>
								 </li>
								 
								 <div class="clearfix"></div>
							 </ul>
						 </div>
						 <form id="form1" action="addgoodcart.action" method="post">
						 <input type="hidden" name="id" value="<s:property value="dog.dogid"/>" />
						 <input type="hidden" name="type" value="dog" />
						 <div class="details-left-info">
								<h3><s:property value="dog.dogname" /></h3>
									<h4><s:property value="dog.intro" /></h4>							
								<p>￥ <s:property value="dog.price"/> <!-- <a href="#">Click for offer</a> --></p>
								<p class="qty">购买数量 : </p><input min="1" type="number" id="quantity" name="quantitynum" value="1" class="form-control input-small">
								<div class="btn_form">
									<a href="#" onclick="javascript:login()">添加到购物车</a>
									<script type="text/javascript">
									   function login(){
									       $("#form1").submit();
									   }
									</script>
								</div>
								<div class="flower-type">
								<p>类型  : <a href="#"><s:property value="dog.dogtype.typename"/></a></p>
								</div>
								<h5>详细信息  : </h5>
								<p class="desc"><s:property value="dog.info" /></p>
						 </div>
						 </form>
						 <div class="clearfix"></div>				 	
					 </div>
				 </div>
			 </div>	
		 </s:else>	 
		 <div class="clearfix"></div>
		 <div class="single-bottom2">
			 <h6>热卖商品</h6>
				 <div class="rltd-posts">
			  	<%
				 	ProductsBiz pb = new ProductsBizImpl();
				 	List<Products> product = pb.HotProduct();
				 	for(Products products:product){
				 	
				 	%>
				 	 <div class="col-md-3 pst1">
						 <img src="<%=path %>/update/<%=products.getPicture() %>" alt=""/>
						 <h4><a href="goodinfoall.action?productid=<%=products.getProductid() %>&type=product"><%=products.getName() %></a></h4>
						 <a class="pst-crt" href="addgoodcart.action?id=<%=products.getProductid() %>&type=product&quantitynum=1">添加到购物车</a>
					 </div>			
				 	<%
				 	}
				  %>		 
				
					 <div class="clearfix"></div>
				</div>
		 </div>	
	 </div>
</div>
<!--fotter-->
	<jsp:include page="footer.jsp"></jsp:include>
<!--fotter//-->

</body>
</html>
