<%@page import="cn.jbit.petshopping.entity.Dogtype"%>
<%@page import="cn.jbit.petshopping.biz.impl.DogTypeBizImpl"%>
<%@page import="cn.jbit.petshopping.biz.DogTypeBiz"%>
<%@page import="cn.jbit.petshopping.entity.Protype"%>
<%@page import="cn.jbit.petshopping.biz.impl.ProtypeBizImpl"%>
<%@page import="cn.jbit.petshopping.biz.ProtypeBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="header2 text-center">
	 <div class="container">
	     <div class="main-header">
			  <div class="carting">
				 <ul><li style="color: #fff;">
				 <%if(session.getAttribute("userinfo")!=null){
						%>
							<a href="<%=path%>/user/index.jsp">欢迎您：<s:property value="#session.userinfo.name"/></a>
						<%
				}else{
				%>
					<a href="<%=path %>/login.jsp">登录</a>
				<%
				} %>
				 </li></ul>
				 </div>
			 <div class="logo">
				 <h3><a href="index.jsp"> <img src="<%=path %>/userPage/images/logo.png"></img> </a></h3>
			  </div>			  
			 <div class="box_1">				 
				 <a href="cartlist.action"><h3>购物车: <span id="goodnum"></span> (<span id="money" ></span>)<img src="<%=path %>/userPage/images/cart.png" alt=""/></h3></a>
				 <script type="text/javascript">
				 	$.get("cartinfo.action",null,function(result){
				 		if(result!=0){
				 			$("#money").html(result.money+"元");
				 			$("#goodnum").html(result.goodNum);
				 		}else{
				 			$("#money").html("");
				 			$("#goodnum").html("");
				 		}
				 	});
				 
				 </script>
				 <p><a href="javascript:;" class="simpleCart_empty"><!-- 目前没有添加商品 --></a></p>
			 
			 </div>
			 
			 <div class="clearfix"></div>
		 </div>
				
				<!-- start header menu -->
		<ul class="megamenu skyblue">
			<li class="active grid"><a class="color1" href="<%=path %>/userPage/index.jsp">首页</a></li>
			<li class="grid"><a href="#">商品</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>狗狗</h4>
								<ul>
									<%
										DogTypeBiz dtb = new DogTypeBizImpl();
										List<Dogtype> dogtype = dtb.findAllType();
										for(Dogtype dogt:dogtype){
										%>
										
									<li><a href="dogOrproducts.action?dtypeid=<%=dogt.getTypeid() %>"><%=dogt.getTypename() %></a></li>
									<%
									}
									 %>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>狗粮</h4>
								<ul>
									<%
										ProtypeBiz ptb = new ProtypeBizImpl();
										List<Protype> protype = ptb.fingAll();
										for(Protype product:protype){
										%>
										<li><a href="dogOrproducts.action?ptypeid=<%=product.getProtypeid() %>"><%=product.getProtypename() %></a>
										</li>
										<%
										}
									 %>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>宠物之家</h4>
								<ul>
									<li><a href="products.html">trends</a></li>
									<li><a href="products.html">sale</a></li>
									<li><a href="products.html">style videos</a></li>
									<li><a href="products.html">accessories</a></li>
									<li><a href="products.html">kids</a></li>
									<li><a href="products.html">style videos</a></li>
								</ul>	
							</div>												
						</div>						
						<!-- <div class="col1">
							<div class="h_nav">
								<h4>my company</h4>
								<ul>
									<li><a href="products.html">tremds</a></li>
									<li><a href="products.html">sale</a></li>
									<li><a href="products.html">style videos</a></li>
									<li><a href="products.html">accessories</a></li>
									<li><a href="products.html">kids</a></li>
									<li><a href="products.html">style videos</a></li>
								</ul>	
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>popular</h4>
								<ul>
									<li><a href="products.html">new arrivals</a></li>
									<li><a href="products.html">men</a></li>
									<li><a href="products.html">women</a></li>
									<li><a href="products.html">accessories</a></li>
									<li><a href="products.html">kids</a></li>
									<li><a href="products.html">style videos</a></li>
								</ul>	
							</div>
						</div> -->
					</div>
					<div class="row">
						<div class="col2"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
					</div>
    				</div>
				</li>
				<li><a href="#">新品</a><div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>狗狗</h4>
								<ul>
									<%
										for(Dogtype dogt:dogtype){
										%>
										
									<li><a href="dogOrproducts.action?dtypeid=<%=dogt.getTypeid() %>"><%=dogt.getTypename() %></a></li>
									<%
									}
									 %>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>狗粮</h4>
								<ul>
									<%
										for(Protype product:protype){
										%>
										<li><a href="dogOrproducts.action?ptypeid=<%=product.getProtypeid() %>"><%=product.getProtypename() %></a>
										</li>
										<%
										}
									 %>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>宠物之家</h4>
								<ul>
									<li><a href="men.html">trends</a></li>
									<li><a href="men.html">sale</a></li>
									<li><a href="men.html">style videos</a></li>
									<li><a href="men.html">accessories</a></li>
									<li><a href="men.html">kids</a></li>
									<li><a href="men.html">style videos</a></li>
								</ul>	
							</div>												
						</div>						
						<!-- <div class="col1">
							<div class="h_nav">
								<h4>my company</h4>
								<ul>
									<li><a href="men.html">trends</a></li>
									<li><a href="men.html">sale</a></li>
									<li><a href="men.html">style videos</a></li>
									<li><a href="men.html">accessories</a></li>
									<li><a href="men.html">kids</a></li>
									<li><a href="men.html">style videos</a></li>
								</ul>	
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>popular</h4>
								<ul>
									<li><a href="men.html">new arrivals</a></li>
									<li><a href="men.html">men</a></li>
									<li><a href="men.html">women</a></li>
									<li><a href="men.html">accessories</a></li>
									<li><a href="men.html">kids</a></li>
									<li><a href="men.html">style videos</a></li>
								</ul>	
							</div>
						</div> -->
					</div>
					<div class="row">
						<div class="col2"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
					</div>
    				</div>
				</li>			
				<li><a href="#">热卖商品</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>狗狗</h4>
								<ul>
									<%
										for(Dogtype dogt:dogtype){
										%>
										
									<li><a href="dogOrproducts.action?dtypeid=<%=dogt.getTypeid() %>"><%=dogt.getTypename() %></a></li>
									<%
									}
									 %>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>狗粮</h4>
								<ul>
									<%
										for(Protype product:protype){
										%>
										<li><a href="dogOrproducts.action?ptypeid=<%=product.getProtypeid() %>"><%=product.getProtypename() %></a>
										</li>
										<%
										}
									 %>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>宠物之家</h4>
								<ul>
									<li><a href="shop.html">trends</a></li>
									<li><a href="shop.html">sale</a></li>
									<li><a href="shop.html">style videos</a></li>
									<li><a href="shop.html">accessories</a></li>
									<li><a href="shop.html">kids</a></li>
									<li><a href="shop.html">style videos</a></li>
								</ul>	
							</div>												
						</div>						
						<!-- <div class="col1">
							<div class="h_nav">
								<h4>my company</h4>
								<ul>
									<li><a href="shop.html">trends</a></li>
									<li><a href="shop.html">sale</a></li>
									<li><a href="shop.html">style videos</a></li>
									<li><a href="shop.html">accessories</a></li>
									<li><a href="shop.html">kids</a></li>
									<li><a href="shop.html">style videos</a></li>
								</ul>	
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>popular</h4>
								<ul>
									<li><a href="shop.html">new arrivals</a></li>
									<li><a href="shop.html">men</a></li>
									<li><a href="shop.html">women</a></li>
									<li><a href="shop.html">accessories</a></li>
									<li><a href="shop.html">kids</a></li>
									<li><a href="shop.html">style videos</a></li>
								</ul>	
							</div>
						</div> -->
					</div>
					<div class="row">
						<div class="col2"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
					</div>
    				</div>
				</li>			
				<li class="grid"><a href="about.html">联系客服</a></li>
			 	<li class="grid"><a href="blog.html">服务宗旨</a></li>	
				</ul> 			 
			  <div class="clearfix"></div>			   	
	 </div>

</div>