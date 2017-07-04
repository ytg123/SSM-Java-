<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<div id="side">
	<ul>
		<li><a href="###">首页</a></li>
		<li><a href="<%=path%>/gotoUser.do">用户管理</a></li>
	</ul>
</div>