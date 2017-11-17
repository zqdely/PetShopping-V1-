<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<javascript type="text/javascript">


</javascript>
 <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>显示信息管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="<%=path %>/adminPage/index.jsp">首页</a></li>
            <li ><a href="page.action">会员管理</a></li>
            <li ><a href="findValuations">评价管理</a></li>
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>商品管理<span class="label label-info">+3</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse in">
            <li ><a href="propage.action">商品列表</a></li>
            <li ><a href="<%=path %>/adminPage/sign-in.jsp">添加商品</a></li>
            <li ><a href="<%=path %>/adminPage/addProtype.jsp">添加商品种类</a></li>
        </ul>

        <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>宠物管理<i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="pageDogs">宠物列表</a></li>
            <li ><a href="<%=path %>/adminPage/addDog.jsp">添加宠物</a></li>
            <li ><a href="<%=path %>/adminPage/addDogType.jsp">添加宠物种类</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>动物领养相关规则</a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="privacy-policy.html">添加链接</a></li>
            <li ><a href="terms-and-conditions.html">发布最新规定</a></li>
        </ul>

        <a href="<%=path %>/adminPage/help.jsp" class="nav-header" ><i class="icon-question-sign"></i>帮助</a>
        <a href="faq.html" class="nav-header" ><i class="icon-comment"></i>常见问题解答（FAQ）</a>
    </div>
