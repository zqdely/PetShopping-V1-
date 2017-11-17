<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>全部商品</title>
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
<!--header-->

<div class="features" id="features">
	 <div class="container">
		 <div class="tabs-box">
			<ol class="breadcrumb">
			  <li><a href="index.html">首页</a></li>
			  <li class="active">宠物之家</li>
			  <!-- <li><jsp:include page="search.jsp"></jsp:include></li> -->
			 </ol>
			<div class="clearfix"> </div>
		 <div class="tab-grids">
			 <div id="tab1" class="tab-grid1">			   				  
				 <a href="single.html"><div class="product-grid">					  
						<div class="more-product-info"><span>NEW</span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">						   
							<img src="<%=path %>/userPage/images/bs1.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>BELLE B&W</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>			
					
					 <a href="<%=path %>/userPage/good_all_info.jsp"><div class="product-grid">
						 <div class="more-product-info"></div>						
						 <div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="<%=path %>/userPage/images/bs2.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">查看详细信息</button>
							</h4>
							</div>
						 </div>	</a>					
						 <div class="product-info simpleCart_shelfItem">
							 <div class="product-info-cust">
								<h4>CLUBYORK</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							 </div>							 				
							 <div class="clearfix"> </div>
						 </div>
					 </div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="<%=path %>/userPage/images/bs3.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div>	</a>					
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>ROADSTER</h4>
								<span class="item_price">$220.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>												
							<div class="clearfix"> </div>
						</div>
					 </div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/bs4.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>BLACKFLPS</h4>
								<span class="item_price">$150.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>												
							<div class="clearfix"> </div>
						</div>
					 </div>	
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"><span>NEW</span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/bs5.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div>	</a>					
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>RED CHECKS</h4>
								<span class="item_price">$140.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">		
							</div>														
							<div class="clearfix"> </div>
						</div>
					 </div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/bs6.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>NEW LOOK</h4>
								<span class="item_price">$100.00</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>												
							<div class="clearfix"> </div>
						</div>
					</div>
					<div class="clearfix"></div>
			 </div>				
				
			 <div id="tab2" class="tab-grid2">
				 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/c1.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>NEWLOOK</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/c2.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div>	</a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>NEWLOOK</h4>
								<span class="item_price">$120.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>												
							<div class="clearfix"> </div>
						</div>
					</div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"><span>NEW</span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/c3.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div></a>							
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>NEWLOOK</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"><span>NEW</span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/c4.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div>	</a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>NEWLOOK</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>														
							<div class="clearfix"> </div>
						</div>
					 </div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/c5.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div></a>							
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>NEWLOOK</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/c6.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>NEWLOOK</h4>
								<span class="item_price">$180.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>
					<div class="clearfix"></div>
			 </div>
		 
			 <div id="tab3" class="tab-grid3">
				  <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/bs3.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div>	</a>					
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>ROADSTER</h4>
								<span class="item_price">$160.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>													
							<div class="clearfix"> </div>
						</div>
					 </div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/bs5.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div>	</a>					
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>RED CHECKS</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/c5.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>NEWLOOK</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">
							</div>														
							<div class="clearfix"> </div>
						</div>
					 </div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/c4.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div>	</a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>MANGO</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>												
							<div class="clearfix"> </div>
						</div>
					 </div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/c3.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div>	</a>					
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>SISLEY</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>												
							<div class="clearfix"> </div>
						</div>
					 </div>
					
					 <a href="single.html"><div class="product-grid">
						<div class="more-product-info"></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/bs1.jpg" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns">ORDER NOW</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4>ROADSTER</h4>
								<span class="item_price">$187.95</span>
								<input type="text" class="item_quantity" value="1" />
								<input type="button" class="item_add" value="ADD">	
							</div>						 						
							<div class="clearfix"> </div>
						</div>
					</div>
				   <div class="clearfix"></div>					
			 </div>
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
