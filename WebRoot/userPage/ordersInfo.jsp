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
<title>订单确认</title>
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
				<li class="active">订单详情</li>
			</ol>
			<div class="cart-top">
				<!-- <a href="index.html"><< home</a> -->
			</div>
<!-- 			<form id="form" action="submitGoods.action" method="post"> -->
			<div class="col-md-9 cart-items">
				<h2>下面是待付款商品</h2>
				<s:if test="%{orderList==null}">
					<div class="cart-header">
						<div class="cart-sec">
							您还没有选择商品，请<a href="cartlist.action" >选择商品</a>之后再生成订单
						</div>
					</div>
				</s:if>
			<form id="form" action="Payprot.action" method="post">
				<s:else>
					<s:iterator  value="orderList" var="oo" status="status">
						<div class="cart-header">
							<div class="cart-sec">
								<s:if test="%{dog!=null}">
									<div class="cart-item cyc">
										<img
											src="<%=path%>/update/<s:property value="dog.picture" />" />
									</div>
									<input type="hidden" value="<s:property value="id" />" name="checkedName" />
									<div class="cart-item-info">
										<h3>
											<s:property value="dog.dogname" />
											<span id="alldogprice<s:property value="#status.index" />">总价: <s:property value="totalprice" /></span>
										</h3>
										<h4>
											<span>单价. ￥ </span><s:property value="dog.price" />
										</h4>
										<p class="qty">购买数量 :</p><s:property value="sellcount" />
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
									<div class="cart-item cyc">
										<img
											src="<%=path%>/update/<s:property value="products.picture" />" />
									</div>
									<input type="hidden" value="<s:property value="id" />" name="checkedName" />
									<div class="cart-item-info">
										<h3>
											<s:property value="products.name" />
											<span id="alldogprice<s:property value="#status.index" />">总价: <s:property value="totalprice"/></span>
										</h3>
										<h4>
											<span>单价. ￥ </span><s:property value="products.price" />
										</h4>
										<p class="qty">购买数量 :</p><s:property value="sellcount"/>
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
			</form>
			<!-- 个人信息 -->
				<div class="col-md-3 cart-total">
					 <div class="price-details">
						 <h3>订单信息</h3>
						 <span>商品数量</span>
						 <span id="ordercount" class="total"><s:property value="quantitynum" /></span>
						 <!-- <span>代填写</span>
						 <span class="total">100.00</span> -->
						 <div class="clearfix"></div>				 
					 </div>	
					 <h4 class="last-price">总金额：</h4>
					 <span id="ordersmoney" class="total final"><s:property value="ordersMoney" /></span>
					 <div class="clearfix"></div>
					 <div class="total-item">
						 <h2><a class="cpns" href="findUser.action" title="编辑">个人信息：</a></h2>
						 <p>姓名： <s:property value="#session.userinfo.name"/></p>
						 <p>地址：<s:property value="#session.userinfo.address"/></p>
						 <p>电话：<s:property value="#session.userinfo.phone"/></p>
						 <h4>选择支付方式</h4>
						 <a class="cpns" href="#">支付方式</a>
					 </div>
					 <a class="order" href="#" id="orderssubmit">提交订单</a>
					 <script type="text/javascript">
					 	$("#orderssubmit").click(function(){
					 		$("#form").submit() ;
					 	});
					 </script>
					</div>
		</div>
	</div>
	<!--fotter-->
	<jsp:include page="footer.jsp"></jsp:include>
	<!--fotter//-->

</body>
</html>

