<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>全部商品</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,200,600,800,700,500,300,100,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Arimo:400,700,700italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/component.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="New Fashions Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" 
		/>
<script src="js/jquery.easydropdown.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/simpleCart.min.js"> </script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- start menu -->
</head>
<body>
<!--header-->
<jsp:include page="top_menu_other.jsp"></jsp:include>
<!--header//-->
<div class="product-model">	 
	 <div class="container">
	    <s:if test="%{dogs.size!=0 && products==null}">
		 <ol class="breadcrumb">
		  <li><a href="index.jsp">首页</a></li>
		  <li class="active">狗狗</li>
		 </ol>
			<h2>全部商品</h2>			
		 <div class="col-md-9 product-model-sec">
				
		         <s:iterator value="dogs">
					 <a href="goodinfoall.action?productid=<s:property value='dogid'/>&type=dog"><div class="product-grid love-grid">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="<%=path %>/update/<s:property value='picture'/>" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">查看详细信息</button>
							</h4>
							</div>
						</div>
							</a>					
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4><s:property value="dogname"/></h4>
								<span class="item_price">￥<s:property value="price"/></span><br/>
								<a href="goodinfoall.action?productid=<s:property value='dogid'/>&type=dog"><span class="desc"><s:property value="intro"/></span></a>
							</div>											
							<div class="clearfix"> </div>
						</div>						
					</div>
				</s:iterator>				
			</s:if>
			<s:elseif test="%{dogs==null && products.size!=0}">
			 <ol class="breadcrumb">
		       <li><a href="index.jsp">首页</a></li>
		       <li class="active">狗粮</li>
		     </ol>
			  <h2>全部商品</h2>	
			  <div class="col-md-9 product-model-sec">
			    <s:iterator value="products">
					 <a href="goodinfoall.action?productid=<s:property value="productid"/>&type=product"><div class="product-grid love-grid">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="<%=path %>/update/<s:property value="picture"/>" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">查看详细信息</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4><s:property value="name"/></h4>
								<span class="item_price">￥<s:property value="price"/></span><br/>
								<a href="goodinfoall.action?productid=<s:property value="productid"/>&type=product"><span class="desc"><s:property value="intro"/></span></a>
							</div>											
							<div class="clearfix"> </div>
						</div>
						</div>
				</s:iterator>			
			</s:elseif>											 
	 </div>
	 <div class="rsidebar span_1_of_left">
				<section  class="sky-form" style="height: 100px;">
						<h4>搜索</h4>
							<div class="row row1 scroll-pane">
								<div class="col col-4">
									<label><input type="text" name="search" placeholder="搜索内容" checked=""><i></i><input type="submit" value="提交"></label>
								</div>
							</div>
				  </section>
				 <section  class="sky-form">
					 <div class="product_right">
						 <h3 class="m_2">狗狗分类</h3>
							<div class="tab1">
							 <ul class="place">								
								 <li class="sort">JEANS</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
						     </div>
					      </div>						  
						  <div class="tab2">
							 <ul class="place">								
								 <li class="sort">SHIRTS</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
						     </div>
					      </div>
						  <div class="tab3">
							 <ul class="place">								
								 <li class="sort">SUITS</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
						     </div>
					      </div>
						  <div class="tab4">
							 <ul class="place">								
								 <li class="sort">CASUAL</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
						     </div>
					      </div>
						  <div class="tab5">
							 <ul class="place">								
								 <li class="sort">SHORTS</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
									<a href="#"><p>sub category1</p></a>
						     </div>
					      </div>
						  
						  <!--script-->
						<script>
							$(document).ready(function(){
								$(".tab1 .single-bottom").hide();
								$(".tab2 .single-bottom").hide();
								$(".tab3 .single-bottom").hide();
								$(".tab4 .single-bottom").hide();
								$(".tab5 .single-bottom").hide();
								
								$(".tab1 ul").click(function(){
									$(".tab1 .single-bottom").slideToggle(300);
									$(".tab2 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
								})
								$(".tab2 ul").click(function(){
									$(".tab2 .single-bottom").slideToggle(300);
									$(".tab1 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
								})
								$(".tab3 ul").click(function(){
									$(".tab3 .single-bottom").slideToggle(300);
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})
								$(".tab4 ul").click(function(){
									$(".tab4 .single-bottom").slideToggle(300);
									$(".tab5 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})	
								$(".tab5 ul").click(function(){
									$(".tab5 .single-bottom").slideToggle(300);
									$(".tab4 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})	
							});
						</script>
						<!-- script -->	
			 
					 <h4>狗狗年龄</h4>
					 <div class="row row1 scroll-pane">
						 <div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Upto - 10% (20)</label>
						 </div>
						 <div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>40% - 50% (5)</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>30% - 20% (7)</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>10% - 5% (2)</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other(50)</label>
						 </div>
					 </div>
				 </section>		      
				   <section  class="sky-form">
						<h4>价格</h4>
							<div class="row row1 scroll-pane">
								<div class="col col-4">
									<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>$50.00 and Under (30)</label>
								</div>
								<div class="col col-4">
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$100.00 and Under (30)</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$200.00 and Under (30)</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$300.00 and Under (30)</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$400.00 and Under (30)</label>
								</div>
							</div>
				   </section>		       
			 </div>			 
			 <div class="clearfix"></div>

		</div>
</div>
	
<!--fotter-->
<jsp:include page="footer.jsp"></jsp:include>
<!--fotter//-->

</body>
</html>
