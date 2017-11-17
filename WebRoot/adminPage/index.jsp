<%@page import="cn.jbit.petshopping.entity.Userinfo"%>
<%@page import="cn.jbit.petshopping.dao.impl.UserinfoDaoImpl"%>
<%@page import="cn.jbit.petshopping.dao.UserinfoDao"%>
<%@page import="cn.jbit.petshopping.biz.impl.OrderBizImpl"%>
<%@page import="cn.jbit.petshopping.biz.OrderBiz"%>
<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  <body class=""> 
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
<div class="copyrights">版权 <a href="http://www.cssmoban.com/">JXCW</a></div>
        <div class="container-fluid">
            <div class="row-fluid">
                    

<div class="row-fluid">

    <div class="alert alert-info" id="welcomeinfo">
        <button type="button" class="close" data-dismiss="alert" onclick="javascript:hiddwelcome()">×</button>
        <strong>欢迎使用宠物管理系统/</strong> welcome to use system!
    </div>
	<script type="text/javascript">
		function hiddwelcome(){
			$("#welcomeinfo").hide();
		}
	</script>
    <div class="block">
        <a href="#page-stats" class="block-heading" data-toggle="collapse">常用功能</a>
        <div id="page-stats" class="block-body collapse in">

            <div class="stat-widget-container">
                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title" style="color:red">2,500</p>
                        <p class="detail">未处理订单</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">3,299</p>
                        <p class="detail">热卖宠物</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">待添加</p>
                        <p class="detail">待添加</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">待添加</p>
                        <p class="detail">待添加</p>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="block span6">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse">最新注册用户<span class="label label-warning">+10</span></a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>用户名</th>
                  <th>邮箱</th>
                  <th>电话</th>
                </tr>
              </thead>
              <%
              	UserinfoDao uid = new UserinfoDaoImpl();
              	List<Userinfo> users = uid.sixperson();
               %>
              <tbody>
              <%
              	for(Userinfo us:users){
              		%>
              			<tr>
		                  <td><%=us.getName() %></td>
		                  <td><%=us.getEmail() %></td>
		                  <td><%=us.getPhone() %></td>
		                </tr>
              		<%
              	}
               %>
              </tbody>
            </table>
            <p><a href="page.action">查看更多用户...</a></p>
        </div>
    </div>
    <div class="block span6">
        <a href="#widget1container" class="block-heading" data-toggle="collapse">季度销售统计 </a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>季度</th>
                  <th>统计结果</th>
                </tr>
              </thead>
             
              <tbody>
                <tr>
                  <td>第一季度：</td>
                  <td>111</td>
                </tr>
                  <tr>
                  <td>第二季度：</td>
                  <td>the_mark7</td>
                </tr>
                  <tr>
                  <td>第三季度：</td>
                  <td>the_mark7</td>
                </tr>
                  <tr>
                  <td>第四季度：</td>
                  <td>the_mark7</td>
                </tr>
                
              </tbody>
            </table>
            <p><a href="#">查看详情（待开发）</a></p>
        </div>
    </div>
</div>
<!-- 后期添加功能 -->
<!-- <div class="row-fluid">
    <div class="block span6">
        <div class="block-heading">
            <span class="block-icon pull-right">
                <a href="#" class="demo-cancel-click" rel="tooltip" title="Click to refresh"><i class="icon-refresh"></i></a>
            </span>

            <a href="#widget2container" data-toggle="collapse">History</a>
        </div>
        <div id="widget2container" class="block-body collapse in">
            <table class="table list">
              <tbody>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> Mark Otto</p>
                      </td>
                      <td>
                          <p>Amount: $1,247</p>
                      </td>
                      <td>
                          <p>Date: 7/19/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> Audrey Ann</p>
                      </td>
                      <td>
                          <p>Amount: $2,793</p>
                      </td>
                      <td>
                          <p>Date: 7/12/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> Mark Tompson</p>
                      </td>
                      <td>
                          <p>Amount: $2,349</p>
                      </td>
                      <td>
                          <p>Date: 3/10/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> Ashley Jacobs</p>
                      </td>
                      <td>
                          <p>Amount: $1,192</p>
                      </td>
                      <td>
                          <p>Date: 1/19/2012</p>
                          <a href="#">View Transaction</a>
                      </td>
                  </tr>
                    
              </tbody>
            </table>
        </div>
    </div>
    <div class="block span6">
        <p class="block-heading">Not Collapsible</p>
        <div class="block-body">
            <h2>Built with Less</h2>
            <p>The CSS is built with Less. There is a compiled version included if you prefer plain CSS.</p>
            <p>Fava bean jícama seakale beetroot courgette shallot amaranth pea garbanzo carrot radicchio peanut leek pea sprouts arugula brussels sprout green bean. Spring onion broccoli chicory shallot winter purslane pumpkin gumbo cabbage squash beet greens lettuce celery. Gram zucchini swiss chard mustard burdock radish brussels sprout groundnut. Asparagus horseradish beet greens broccoli brussels.</p>
            <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
        </div>
    </div>
</div> -->

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
