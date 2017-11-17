<%@page import="cn.jbit.petshopping.entity.Dog"%>
<%@page import="cn.jbit.petshopping.biz.impl.DogBizImpl"%>
<%@page import="cn.jbit.petshopping.biz.DogBiz"%>
<%@page import="cn.jbit.petshopping.entity.Products"%>
<%@page import="cn.jbit.petshopping.biz.impl.ProductsBizImpl"%>
<%@page import="cn.jbit.petshopping.biz.ProductsBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>首页</title>
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
<jsp:include page="top_menu.jsp"></jsp:include>
<!--header-->
<div class="features" id="features">
	 <div class="container">
		 <div class="tabs-box">
			<ol class="breadcrumb">
			  <li><a href="index.html">首页</a></li>
			  <li class="active">热卖狗狗</li>
			 </ol>
			<div class="clearfix"> </div>
		 <div class="tab-grids">
			 <div id="tab1" class="tab-grid1">			   				  
				 <%
				 	DogBiz dd = new DogBizImpl();
				 	List<Dog> dog = dd.hotThreeDog();
				 	for(Dog dogs:dog){
				 	%>
				 	 <a href="goodinfoall.action?productid=<%=dogs.getDogid() %>&type=dog"><div class="product-grid">
				 	<div class="more-product-info"><span>NEW</span></div>
				 		<div class="product-img b-link-stripe b-animate-go  thickbox">						   
							<img src="<%=path %>/update/<%=dogs.getPicture() %>" class="img-responsive" alt=""/>
							
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">查看详细信息
							</button>
							</h4>
							</div>
						</div>
						</a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4><%=dogs.getDogname() %></h4>
								<span class="item_price">￥<%=dogs.getPrice() %></span><br/>
								<a href="goodinfoall.action?productid=<%=dogs.getDogid() %>&type=dog"><span class="desc"><%=dogs.getIntro() %></span></a>
								<!-- 将<a href="javascript:login1()">变成submit的js方法
								<script type="text/javascript">
									   function login1(){
									       $("#form1").submit() ;
									   }
								</script> -->
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>			
				 	<%
				 	}
				  %>					  						
					
				  
		 </div>				
		 </div>
			<!-- tabs-box -->
			<!-- Comman-js-files -->
			<script>
			$(document).ready(function() {
				$("#tab2").hide();
				$("#tab3").hide();
				$(".tabs-menu a").click(function(event){
					event.preventDefault();
					var tab=$(this).attr("href");
					$(".tab-grid1,.tab-grid2,.tab-grid3").not(tab).css("display","none");
					$(tab).fadeIn("slow");
				});
				$("ul.tabs-menu li a").click(function(){
					$(this).parent().addClass("active a");
					$(this).parent().siblings().removeClass("active a");
				});
			});
			</script>
			<!-- Comman-js-files -->
	 </div>
</div>
<!-- 热卖商品 -->
<div class="features" id="features">
	 <div class="container">
		 <div class="tabs-box">
			<ol class="breadcrumb">
			  <li><a href="index.html">首页</a></li>
			  <li class="active">热卖商品</li>
			 </ol>
			<div class="clearfix"> </div>
		 <div class="tab-grids">
			 <div id="tab1" class="tab-grid1">			   				  
				 <%
				 	ProductsBiz pb = new ProductsBizImpl();
				 	List<Products> product = pb.HotProduct();
				 	for(Products products:product){
				 	%>
				 	 <a href="goodinfoall.action?productid=<%=products.getProductid() %>&type=product"><div class="product-grid">
				 	<div class="more-product-info"><span>NEW</span></div>
				 		<div class="product-img b-link-stripe b-animate-go  thickbox">						   
							<img src="<%=path %>/update/<%=products.getPicture() %>" class="img-responsive" alt=""/>
							
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">查看详细信息
							</button>
							</h4>
							</div>
						</div>
						</a>						
						<div class="product-info simpleCart_shelfItem"> 
							<div class="product-info-cust">
								<h4><%=products.getName() %></h4>
								<span class="item_price">￥<%=products.getPrice() %></span><br/>
								<a href="goodinfoall.action?productid=<%=products.getProductid() %>&type=product"><span class="desc"><%=products.getIntro() %></span></a>
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>			
				 	<%
				 	}
				  %>					  						
					
					
				  
		 </div>				
		 </div>
			<!-- tabs-box -->
			<!-- Comman-js-files -->
			<script>
			$(document).ready(function() {
				$("#tab2").hide();
				$("#tab3").hide();
				$(".tabs-menu a").click(function(event){
					event.preventDefault();
					var tab=$(this).attr("href");
					$(".tab-grid1,.tab-grid2,.tab-grid3").not(tab).css("display","none");
					$(tab).fadeIn("slow");
				});
				$("ul.tabs-menu li a").click(function(){
					$(this).parent().addClass("active a");
					$(this).parent().siblings().removeClass("active a");
				});
			});
			</script>
			<!-- Comman-js-files -->
	 </div>
</div>

<!--fotter-->
<div class="fotter">
	 <div class="container">
	 <div class="col-md-6 contact">
		  <form>
			 <input type="text" class="text" value="Name..." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Name...';}">
			 <input type="text" class="text" value="Email..." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email...';}">
			 <textarea onFocus="if(this.value == 'Message...') this.value='';" onBlur="if(this.value == '') this.value='Message...';" >Message...</textarea>	
			 <div class="clearfix"></div>
			 <input type="submit" value="SUBMIT">
		 </form>

	 </div>
	 <div class="col-md-6 ftr-left">
		 <div class="ftr-list">
			 <ul>
				 <li><a href="#">Home</a></li>
				 <li><a href="about.html">About</a></li>
				 <li><a href="blog.html">Blog</a></li>
				 <li><a href="products.html">Top Seller</a></li>
				 <li><a href="shop.html">New Models</a></li>
				 <li><a href="404.html">Combos</a></li>
				 <li><a href="products.html">Collection</a></li>
				 <li><a href="contact.html">Contact</a></li>
			 </ul>
		 </div>
		 <div class="ftr-list2">
			 <ul>				 
				 <li><a href="#">Combos</a></li>
				 <li><a href="#">Trendy</a></li>
				 <li><a href="#">Fashion</a></li>
				 <li><a href="#">College</a></li>
				 <li><a href="#">Party</a></li>
				 <li><a href="#">Dress</a></li>
				 <li><a href="#">Kurtas & kurtis</a></li>
			 </ul>
		 </div>
		 <div class="clearfix"></div>
		 <h4>FOLLOW US</h4>
		 <div class="social-icons">
		 <a href="#"><span class="in"> </span></a>
		 <a href="#"><span class="you"> </span></a>
		 <a href="#"><span class="be"> </span></a>
		 <a href="#"><span class="twt"> </span></a>
		 <a href="#"><span class="fb"> </span></a>
		 </div>
	 </div>	 
	 <div class="clearfix"></div>
	 </div>
</div>
<!--fotter//-->
<jsp:include page="footer.jsp"></jsp:include>
<!--fotter//-->

</body>
</html>
