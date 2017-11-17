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
            
            <h1 class="page-title">商品管理</h1>
        </div>
     
        <ul class="breadcrumb">
            <li><a href="index.jsp">首页</a> <span class="divider">/</span></li>
            <li>商品管理<span class="divider">/</span></li>
            <li class="active">商品列表</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn">商品列表</button>
    <a href="sign-in.jsp"><button class="btn btn-primary"><i class="icon-plus"></i>添加商品</button></a>
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>商品名称</th>
          <th>商品价格</th>
          <th>商品种类</th>
          <th>库存数量</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      <s:iterator value="products">
	      <tr>
	           <td><s:property value="name"/></td>
	           <td><s:property value="price"/></td>
	           <td><s:property value="protype.protypename"/></td>
	           <td><s:property value="procount"/></td>
	           <td>
	              <a href="showProducts?pdid=<s:property value='productid'/>"><i class="icon-pencil"></i></a>
	              <a href="#"><i class="icon-remove"  id="delete" onclick="javascript:onclickb()" ></i></a>
	              <script type="text/javascript">
              	     function onclickb(){
              		    if(confirm("确定删除吗？")){
              			    location.href="deleteProducts?pdid=<s:property value='productid'/>";
              		    }
              	     }
                 </script>
	           </td>
	       </tr>
      </s:iterator>
        
        
      </tbody>
    </table>
</div>
<div class="pagination">
	
    <a href="propage?currpageNo=1">首页</a>&nbsp;&nbsp;
  	<a href="propage?currpageNo=<s:property value='currpageNo>1?currpageNo-1:1'/>">上一页</a>&nbsp;&nbsp;
  	<a href="propage?currpageNo=<s:property value='currpageNo==totalPageCount?currpageNo:currpageNo+1'/>">下一页</a>&nbsp;&nbsp;
  	<a href="propage?currpageNo=<s:property value="totalPageCount"/>">末尾页</a>
  	<s:property value="currpageNo"/>/<s:property value="totalPageCount"/>&nbsp;&nbsp;&nbsp;
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



