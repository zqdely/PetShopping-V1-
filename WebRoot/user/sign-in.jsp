<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%
	Map<String, Object> sessio = ActionContext.getContext().getSession();
	sessio.remove("userinfo");
	response.sendRedirect(request.getContextPath()+"/userPage/index.jsp");
%>
