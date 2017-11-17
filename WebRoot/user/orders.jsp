<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="<%=path %>/adminPage/lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="<%=path %>/adminPage/stylesheets/theme.css">
    <link rel="stylesheet" href="<%=path %>/adminPage/lib/font-awesome/css/font-awesome.css">

    <script src="<%=path %>/adminPage/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
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
            
            <h1 class="page-title">订单管理</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="<%=path %>/userPage/index.jsp">首页</a> <span class="divider">/</span></li>
            <li class="active">会员</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
</div>
<s:if test="orders.size==0">
	<div style="width: 1000px;height: 350px; text-align:center;line-height: 350px;font-size: 18px;">没有订单！</div>
</s:if>
<s:else>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>订单号</th>
          <th>商品</th>
          <th>购买数量</th>
          <th>购买金额</th>
          <th>地址</th>
          <th>联系方式</th>
          <th>是否发货</th>
          
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      <s:iterator value="orders" id="order">
      <s:if test="buyerconfirm==1">
      <tr>
          <td><s:property value="id"/></td>
          <td><s:if test="dog!=null"><s:property value="dog.dogtype.typename"/></s:if><s:else><s:property value="products.protype.protypename"/></s:else></td>
          <td><s:property value="sellcount"/></td>
          <td><s:property value="totalprice"/></td>
          <td><s:property value="userinfo.address"/></td>
          <td><s:property value="userinfo.phone"/></td>
          <td><s:if test="sellerconfirm==1">卖家发货</s:if><s:else>未发货</s:else></td>
          <td><a href="findOrder?orderid=<s:property value="id"/>">评价</a></td>
          <td>
              <a href="deleteOrders?id=<s:property value='id'/>" title="请谨慎删除" onclick="de"><i class="icon-remove"></i></a>
          </td>
        </tr>
	  </s:if>
      </s:iterator>
        
        
      </tbody>
    </table>
</div>
<div class="pagination">
	
    <a href="findOrders?currpageNo=1">首页</a>&nbsp;&nbsp;
  	<a href="findOrders?currpageNo=<s:property value='currpageNo>1?currpageNo-1:1'/>">上一页</a>&nbsp;&nbsp;
  	<a href="findOrders?currpageNo=<s:property value='currpageNo==totalPageCount?currpageNo:currpageNo+1'/>">下一页</a>&nbsp;&nbsp;
  	<a href="findOrders?currpageNo=<s:property value="totalPageCount"/>">末尾页</a>
  	<s:property value="currpageNo"/>/<s:property value="totalPageCount"/>&nbsp;&nbsp;&nbsp;
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>你想要删除这个用户吗?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-danger" data-dismiss="modal">删除</button>
    </div>
</div>

</s:else>
                    
                <jsp:include page="footer.jsp"></jsp:include>
                    
            </div>
        </div>
    </div>
    


    <script src="<%=path %>/adminPage/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        
        function de(){
        	alert("你想要删除这个用户吗？");
        }
    </script>
    
  </body>
</html>



