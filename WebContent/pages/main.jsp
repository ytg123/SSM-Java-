<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/static/css/main.css">
</head>
<body>
	<!-- oaHead S -->
	<%@ include file="sysmanger/header.jsp" %>
	<!-- E oaHead -->
	<!-- content S -->
	<div class="oacontent">
		<!-- side S -->
		<div id="side">
			<ul>
				<li><a href="###">首页</a></li>
				<li><a href="<%=path%>/sysmanager/user/gotoUser.do">用户管理</a></li>
				<li><a href="<%=path%>/users">用户管理restful</a></li>
				<li><a href="<%=path%>/sysmanager/upload/goUpload.do">文件上传</a></li>
			</ul>
		</div>
		<!-- E side -->
		
		<!-- sRgiht S -->
		<div id="sRgiht">
			
		</div>
		<!-- E sRgiht -->
	</div>
	<!-- E content -->
	<script>
		window.onload = function(){
			let timeDom = document.getElementById("timer");
			function draw(){
					var date = new Date();
					//年月日
					var fullYear = date.getFullYear();
					var month = date.getMonth() + 1;
					var day = date.getDate();
					if(day < 10){
						day = "0" + day;
					}
					//时分秒
					var h = date.getHours();
					var m = date.getMinutes();
					var s = date.getSeconds();
					//去0
					if(h<10){
						h="0"+h;
					}
					if(m<10){
						m="0"+m;
					}
					if(s<10){
						s="0"+s;
					}
					//星期数
					var week = date.getDay();
					var arr = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
					//获取毫秒数
					var time = date.getTime();
					timeDom.innerHTML = fullYear+"-"+month+"-"+day+"  "+h+":"+m+":"+s+"   "+arr[week];
			};
			setInterval(function(){
				draw();
			},1000);
			
		}
	
	</script>
</body>
</html>