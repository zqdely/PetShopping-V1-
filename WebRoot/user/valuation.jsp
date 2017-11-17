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
<jsp:include page="../userPage/top_menu_other.jsp"></jsp:include>
<!--header//-->
<!--Single Page starts Here-->
<div class="product-main">
	 <div class="container">
		 <ol class="breadcrumb">
		  <li><a href="<%=path %>/userPage/index.jsp">首页</a></li>
		  <li class="active">商品详情</li>
		 </ol>
		 <s:if test="order.products!=null">
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
									<img class="etalage_thumb_image" src="<%=path %>/update/<s:property value="order.products.picture"/>" />
									<img class="etalage_source_image" src="<%=path %>/update/<s:property value="order.products.picture"/>" />
									</a>
								 </li>
								 
								 <div class="clearfix"></div>
							 </ul>
						 </div>
						 
						 <input type="hidden" name="id" value="<s:property value="products.productid"/>" />
						 <input type="hidden" name="type" value="product" />
						 <div class="details-left-info">
								<h3><s:property value="products.name" /></h3>
									<h4><s:property value="products.intro" /></h4>							
								<p>￥ <s:property value="products.price"/> <!-- <a href="#">Click for offer</a> --></p>
								<p class="qty">购买数量 : </p><s:property value="order.sellcount"/>
								
								</div>
								<div class="flower-type">
								<p>类型  : <a href="#"><s:property value="order.products.protype.protypename"/></a></p>
								<p>库存  : <a href="#"><s:property value="order.products.procount" /></a></p>
								</div>
								<h5>详细信息  : </h5>
								<p class="desc"><s:property value="order.products.info" /></p>
								<form action="addValuation">
								<h5>评价: </h5>
								<s:textarea name="valuation.content"></s:textarea>
								<input type="hidden" name="orderid" value="<s:property value="order.id"/>">
								<s:submit>评价</s:submit>
								</form>
						 </div>
						 		
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
									<img class="etalage_thumb_image" src="<%=path %>/update/<s:property value="order.dog.picture"/>" />
									<img class="etalage_source_image" src="<%=path %>/update/<s:property value="order.dog.picture"/>" />
									</a>
								 </li>
								 
								 <div class="clearfix"></div>
							 </ul>
						 </div>
						 
						 <input type="hidden" name="id" value="<s:property value="order.dog.dogid"/>" />
						 <input type="hidden" name="type" value="dog" />
						 <div class="details-left-info">
								<h3><s:property value="order.dog.dogname" /></h3>
									<h4><s:property value="order.dog.intro" /></h4>							
								<p>￥ <s:property value="order.dog.price"/> <!-- <a href="#">Click for offer</a> --></p>
								<p class="qty">购买数量 : </p><s:property value="order.sellcount"/>
								
								<div class="flower-type">
								<p>类型  : <a href="#"><s:property value="order.dog.dogtype.typename"/></a></p>
								</div>
								<h5>详细信息  : </h5>
								<p class="desc"><s:property value="order.dog.info" /></p>
								<form action="addValuation">
								<h5>评价: </h5>
								<s:textarea name="valuation.content"></s:textarea><br/>
								<input type="hidden" name="orderid" value="<s:property value="order.id"/>">
								<input type="submit" value="提交">
								</form>
						 <div class="clearfix"></div>
						 </div>
										 	
					 </div>
				 </div>
			 </div>	
		 </s:else>	 
		 <div class="clearfix"></div>
		 <div class="single-bottom2">
		
	 	 </div>
</div>
<!--fotter-->
	<jsp:include page="footer.jsp"></jsp:include>
<!--fotter//-->

</body>
</html>
