<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>信息管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="findUser">个人信息</a></li>
            <li ><a href="findOrders">订单管理</a></li>
        </ul>
    </div>
