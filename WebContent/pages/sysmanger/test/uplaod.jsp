<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/static/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/static/sg/css/sg.css">
<style>
	#sRgiht h2{padding:10px;color:#f50;}
	.upload{width:96%;height:auto;background:#E1E6F6;margin:10px auto;}
	.upload h3{margin:20px;}
	#uploadform,#uploadFiles{display:none;} 
	#uploadbtn,#selectbtn,#uploadbtns,#selectbtns{display:inline-block;width:80px;height:30px;line-height:30px;text-align:center;border-radius:5px;background-color:#f50;color:#fff;margin:20px;}
	.upload .ul{width:100%;height:100px;}
	.upload .ul li{width:100px;height:100px;float:left;margin:0 5px;}
	.upload .ul li h4{text-align:center;}
	.upload .ul li h4 a{color:#f00;}
</style>
</head>
<body>
	<!-- oaHead S -->
	<%@ include file="../header.jsp" %>
	<!-- E oaHead -->
	<!-- oacontent S -->
	<div class="oacontent">
		<!-- side S -->
		<div id="side">
			<ul>
				<li><a href="/SSM">首页</a></li>
				<li><a href="<%=path%>/sysmanager/user/gotoUser.do">用户管理</a></li>
				<li><a href="<%=path%>/sysmanager/upload/goUpload.do">文件上传</a></li>
			</ul>
		</div>
		<!-- E side -->
		
		<!-- sRgiht S -->
		<div id="sRgiht">
			<h2>文件上传</h2>
			<div class="upload">
				<h3>单个文件上传</h3>
				<!-- 默认 enctype="application/x-www-form-urlencoded" -->
				<form action="<%=path%>/sysmanager/upload/uploadFile.do" method="post" enctype="multipart/form-data" id="form">
					<input type="file"  name="uploadFile" id="uploadform" required="required"/>
				</form>
				<a href="javascript:;" id="selectbtn">♧选择文件</a>
				<a href="javascript:;" id="uploadbtn">☝上传文件</a>
				
				<h3>图片展示</h3>
				<c:if test="${uploadPath != null }">
						<img alt="" src="<%=basePath%>${uploadPath}" width="100" height="100">
				</c:if>
			</div>
			<div class="upload">
				<h3>多文件上传</h3>
				<form action="<%=path%>/sysmanager/upload/uploadFiles.do" method="post" enctype="multipart/form-data" id="forms">
					<input type="file"  name="uploadFiles" required="required" id="uploadFiles" multiple="multiple"/>
				</form>
				<a href="javascript:;" id="selectbtns">♧选择多文件</a>
				<a href="javascript:;" id="uploadbtns">☝上传文件</a>
				<h3>图片展示</h3>
				<ul class="ul">
					<c:forEach items="${Maps}" var="item">
						<li>
							<h4>
								<a href="<%=path%>/sysmanager/upload/downLoad.do?fileName=${item.value }">${item.value }</a>
							</h4>
							<img alt="" src="<%=basePath%>upload/${item.value }" width="100%" height="100%">
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!-- E sRgiht -->
	</div>
	<!-- E oacontent -->

	<script src="<%=path %>/static/js/jquery-3.1.1.min.js"></script>
	<script src="<%=path %>/static/sg/sg.js"></script>
	<script src="<%=path %>/static/sg/tz_util.js"></script>
	<script src="<%=path %>/static/js/lock.js"></script>
	<script>
		//加载动画
		loading("数据正在加载中...",3);
		//上传
		$("#selectbtn").on("click",function(){
			$("#uploadform").click();
		})
		$("#uploadbtn").on("click",function(){
			$("#form").submit();
		})
		//多文件上传
		$("#selectbtns").on("click",function(){
			$("#uploadFiles").click();
		})
		$("#uploadbtns").on("click",function(){
			$("#forms").submit();
		})
	</script>
</body>
</html>