<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML >
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>首页</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="<%=path %>/adminPage/lib/bootstrap/css/bootstrap.css" /></link>

    <link rel="stylesheet" type="text/css" href="<%=path %>/adminPage/stylesheets/theme.css" /></link>
    <link rel="stylesheet" href="<%=path %>/adminPage/lib/font-awesome/css/font-awesome.css"></link>
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
    <link rel="shortcut icon" href="../assets/ico/favicon.ico"></link>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png"></link>
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png"></link>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png"></link>
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png"></link>
    <script type="text/javascript">
           
  setInterval(function(){
      var date=new Date();
      var h=date.getHours();
      var m=date.getMinutes();
      var s=date.getSeconds();
      if(h>=8&&h<22&&m%10==0&&s==0){
          window.location.href=window.location.href;
      }
      $("#h").html(h);
      $("#m").html(m);
      $("#s").html(s);
  },1000);
  
  </script>
</head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body> 
  <!--<![endif]-->
    <jsp:include page="top.jsp"></jsp:include>
    
    <jsp:include page="leftmenu.jsp"></jsp:include>
    

    
    <div class="content">
        
        <div class="header">
            <div class="stats" id="systemtime">
           
    <p class="stat"><span class="number" id="s"></span>秒</p>
    <p class="stat"><span class="number" id="m"></span>分</p>
    <p class="stat"><span class="number" id="h"></span>时</p>
</div>

            <h1 class="page-title">首页</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="<%=path %>/adminPage/index.jsp">首页</a> <span class="divider">/</span></li>
            <li class="active">统计信息</li>
        </ul>
        <s:if test="#session.userinfo!=null">
        	<div style="width: 1000px;height: 350px; text-align:center;line-height: 350px;">
        	<span style="color:#00A600; font-size:18px;">欢迎您！<s:property value="#session.userinfo.name"/></span><a href="findUser">修改个人信息<<</a>
        </div>
        </s:if>
        <s:else>
        	<div style="width: 1000px;height: 350px; text-align:center;line-height: 350px;">
        	<a href="<%=path%>/login.jsp"><span style="color:#00A600; font-size:18px;">请登录！<<</a>
        </s:else>
			<jsp:include page="footer.jsp"></jsp:include>
                    
            </div> 
  </body>
</html>
