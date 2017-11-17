<%@page import="cn.jbit.petshopping.entity.Userinfo"%>
<%@page import="cn.jbit.petshopping.entity.Orders"%>
<%@page import="cn.jbit.petshopping.biz.impl.OrderBizImpl"%>
<%@page import="cn.jbit.petshopping.biz.OrderBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>Cart</title>
<link href="<%=path%>/userPage/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="<%=path%>/userPage/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Raleway:400,200,600,800,700,500,300,100,900'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Arimo:400,700,700italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/userPage/css/component.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="New Fashions Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script src="<%=path%>/userPage/js/jquery.min.js"></script>
<script src="<%=path%>/userPage/js/simpleCart.min.js">
	
</script>
<!-- start menu -->
<link href="<%=path%>/userPage/css/megamenu.css" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="<%=path%>/userPage/js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!-- start menu -->
</head>
<body>
	<!--header-->
	<jsp:include page="top_menu_other.jsp"></jsp:include>
	<!--header//-->
	<div class="cart">
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="men.html">首页</a>
				</li>
				<li class="active">购物车</li>
			</ol>
			<div class="cart-top">
				<!-- <a href="index.html"><< home</a> -->
			</div>
			<div class="col-md-9 cart-items">
				<h2>已经购买的商品</h2>
				<s:if test="%{orderList.size==0}">
					<div class="cart-header">
						<div class="cart-sec">
							购物车空空，赶紧购物吧
						</div>
					</div>
				</s:if>
		 <form id="form" action="submitGoods.action" method="post">	
				<s:else>
					<s:iterator  value="orderList" var="oo" status="status">
						<!-- <script>
							$(document).ready(function(c) {
							$('.close1').on('click', function(c){
								/* $('.cart-header').fadeOut('slow', function(c){
									$('.cart-header').remove();
								}); */
									alert("确认删除吗？");
								});	  
							});
						</script> -->
						<div class="cart-header">
							<div class="cart-sec">
								<s:if test="%{dog!=null}">
								选中订单：<input type="checkbox" value="<s:property value="id" />" name="checkedName" id="checkedName<s:property value="#status.index" />" onchange="javascript:checkChang(<s:property value="#status.index" />)" />
								<!-- 删除信息 -->
								<a href="deleteGood.action?id=<s:property value="id" />" class="close1"></a>
									<div class="cart-item cyc">
										<img
											src="<%=path%>/update/<s:property value="dog.picture" />" />
									</div>
									<div class="cart-item-info">
										<h3>
											<s:property value="dog.dogname" />
											<span id="alldogprice<s:property value="#status.index" />">总价: <s:property value="totalprice" /></span>
										</h3>
										<h4>
											<span>单价. ￥ </span><s:property value="dog.price" />
										</h4>
										<p class="qty">购买数量 :</p>
										<input min="1" type="number" id="quantity<s:property value="#status.index" />" name="quantity" onchange="javascript:changnum(<s:property value="dog.price" />,<s:property value="#status.index" />)"
												onblur="javascript:changMoney(<s:property value="dog.price" />,<s:property value="id" />,<s:property value="#status.index" />)" value="<s:property value="sellcount" />" class="form-control input-small">
										<script type="text/javascript">
											function changnum(dogprice,index){
												var num = document.getElementById("quantity"+index).value;
												var allnum = num*dogprice;
												document.getElementById("alldogprice"+index).innerHTML ="总价："+allnum;
											}
											
											function changMoney(dogprice,id,index){
												var num = document.getElementById("quantity"+index).value;
												var allnum = num*dogprice;
												$.getJSON("${pageContext.request.contextPath}/changordersMoney.action?id="+id+"&allnum="+allnum+"&quantitynum="+num,null,function(result){
													document.getElementById("alldogprice"+index).innerHTML ="总价："+result.info;
												});
											}
											function checkChang(index){
												obj = document.getElementsByName("checkedName");
												check_val = [];
												for(k in obj){
													if(obj[k].checked)
														check_val.push(obj[k].value);
												}
												$.get("submitOrders?checkedName="+check_val,null,function(result){
													$("#ordersmoney").html(result.allTotl);
													$("#ordercount").html(result.numOrders);
													if(document.getElementById("checkedName"+index).checked){
														document.getElementById("checkedName"+index).checked=true;
													}else{
														document.getElementById("checkedName"+index).checked=false;
													}
													
												});
											}
										</script>
									</div>
									<div class="clearfix"></div>
									<div class="delivery">
										<p>
											<s:property value="dog.intro" />
										</p>
										<span>${creatime} </span>
										<div class="clearfix"></div>
									</div>
								</s:if>
								<s:else>
								选中订单：<input type="checkbox" value="<s:property value="id" />" name="checkedName" id="checkedName<s:property value="#status.index" />" onchange="javascript:checkChang(<s:property value="#status.index" />)" />
								<!-- 删除信息 -->
								<a href="deleteGood.action?id=<s:property value="id" />" class="close1"></a>
									<div class="cart-item cyc">
										<img
											src="<%=path%>/update/<s:property value="products.picture" />" />
									</div>
									<div class="cart-item-info">
										<h3>
											<s:property value="products.name" />
											<span id="alldogprice<s:property value="#status.index" />">总价: <s:property value="totalprice"/></span>
										</h3>
										<h4>
											<span>单价. ￥ </span><s:property value="products.price" />
										</h4>
										<p class="qty">购买数量 :</p>
										<input min="1" type="number" id="quantity<s:property value="#status.index" />" name="quantity" onchange="javascript:changnum(<s:property value="products.price" />,<s:property value="#status.index" />)"
												onblur="javascript:changMoney(<s:property value="products.price" />,<s:property value="id" />,<s:property value="#status.index" />)" value="<s:property value="sellcount"/>" class="form-control input-small">
									</div>
									<div class="clearfix"></div>
									<div class="delivery">
										<p>
											<s:property value="products.intro" />
										</p>
										<span>${creatime} </span>
										<div class="clearfix"></div>
									</div>
								</s:else>
							</div>
						</div>

					</s:iterator>
				</s:else>
		</form>
			</div>
			<!-- 提交订单 -->
				<div class="col-md-3 cart-total">
					 <a class="continue" href="#" id="orderssubmit" >提交订单</a>
					 <script type="text/javascript">
					 	$("#orderssubmit").click(function(){
					 		$("#form").submit() ;
					 	});
					 </script>
					 <div class="price-details">
						 <h3>订单信息</h3>
						 <span>商品数量</span>
						 <span id="ordercount" class="total">0</span>
						 <!-- <span>代填写</span>
						 <span class="total">100.00</span> -->
						 <div class="clearfix"></div>				 
					 </div>	
					 <h4 class="last-price">总金额：</h4>
					 <span id="ordersmoney" class="total final">0.00</span>
					 <div class="clearfix"></div>
					<!--  <a class="order" href="#">Place Order</a>
					 <div class="total-item">
						 <h3>OPTIONS</h3>
						 <h4>COUPONS</h4>
						 <a class="cpns" href="#">Apply Coupons</a>
						 <p><a href="#">Log In</a> to use accounts - linked coupons</p>
					 </div> -->
					</div>
		</div>
	</div>
	<!--fotter-->
	<jsp:include page="footer.jsp"></jsp:include>
	<!--fotter//-->

</body>
</html>

