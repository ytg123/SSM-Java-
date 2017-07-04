<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
	String path = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/style.css" />
	</head>
	<body>
		<!-- login S -->
		<div id="login">
			<div class="message">
				<spring:message code="sysmanager.loginJsp.title" />
			</div>
			<div id="darkbannerwrap"></div>
			<form action="<%=path%>/login.do" method="post">
				<input type="text" name="username" id="username"  placeholder="username..." required="required"/>
				<hr class="hr15"/>
				<input type="password" name="password" id="password" placeholder="password..." required="required"/>
				<hr class="hr15"/>
				<input type="submit" value="<spring:message code="sysmanager.loginJsp.loginBtn" />" class="submit" id="submit"/>
				<hr class="hr20"/>
			</form>
			<!-- 错误提示语 -->
			<c:if test="${logErr != null}">	
				<p class="error">
					<spring:message code="${logErr}" />
				</p>
			</c:if>
			<a href="<%=path%>/gotoLogin.do?locale=zh_CN" style="float:left;">Chinese</a>
			<a href="<%=path%>/gotoLogin.do?locale=en_US" style="float:right;">English</a>
		</div>
		<!-- E login -->
		
		<script>
			window.onload = function(){
				window.onkeyup = function(e){
					let ev = e || window.event;
					if(ev.keyCode == 13){
						let name = document.getElementById("username").value;
						let pwd = document.getElementById("password").value;
						if(name == ""){
							alert("用户名不能为空!");
						}else if(pwd == ""){
							alert("密码不能为空!");
						}else{
							document.getElementById("submit").onlcick;
						}
					}
				}
			}
		
		</script>
	</body>
</html>