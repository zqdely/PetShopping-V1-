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
    <title>宠物列表</title>
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
            
            <h1 class="page-title">宠物列表</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.jsp">首页</a> <span class="divider">/</span></li>
             <li>宠物管理<span class="divider">/</span></li>
            <li class="active">宠物列表</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
    <div class="btn-toolbar">
		    <a href="addDog.jsp"><button class="btn"><i class="icon-plus"></i>添加宠物</button></a>
		    <a href="addDogType.jsp"><button class="btn btn-primary"><i class="icon-plus"></i>添加宠物种类</button></a>
		    <div class="btn-group"></div>
	</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>姓名</th>
          <th>种类</th>
          <th>价格</th>
          <th>生日</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      <s:iterator value="dogs">
      <tr>
          <td><s:property value="dogname"/></td>
          <td><s:property value="dogtype.typename"/></td>
          <td><s:property value="price"/></td>
          <td><s:property value="brithday"/></td>
          <td>
              <a href="updatedog?id=<s:property value='dogid'/>"><i class="icon-pencil"></i></a>
              <a href="#"><i class="icon-remove"  id="delete" onclick="javascript:onclickb()" ></i></a>
              <script type="text/javascript">
              	function onclickb(){
              		if(confirm("确定删除吗？")){
              			location.href="deleteDog?id=<s:property value='dogid'/>";
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
	
    <a href="pageDogs?currpageNo=1">首页</a>&nbsp;&nbsp;
  	<a href="pageDogs?currpageNo=<s:property value='currpageNo>1?currpageNo-1:1'/>">上一页</a>&nbsp;&nbsp;
  	<a href="pageDogs?currpageNo=<s:property value='currpageNo==totalPageCount?currpageNo:currpageNo+1'/>">下一页</a>&nbsp;&nbsp;
  	<a href="pageDogs?currpageNo=<s:property value="totalPageCount"/>">末尾页</a>
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



