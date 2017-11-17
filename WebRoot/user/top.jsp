<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">用户：<s:property value="#session.userinfo.name"/></a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> 设置
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">个人账户</a></li>        
                            <li><a tabindex="-1" href="<%=path %>/login.jsp">注销</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="<%=path %>/userPage/index.jsp"><span class="first">返回</span> <span class="second">首页</span></a>
        </div>
    </div>
