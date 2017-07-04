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
	#sRgiht h2{padding:20px;color:#f50;}
	#sRgiht .table{width:96%;border-collapse:collapse;margin:0 auto;}
	#sRgiht .table .yhtitle{font-size:16px;margin-bottom:15px;text-align: center;}
	#sRgiht #addUser{display:block;width:80px;height:30px;line-height:30px;text-align:center;border-radius:5px;background-color:#DE5145;color:#fff;margin-left:20px;}
	#sRgiht #addUser:hover{background:#fff;color:#333;}
	#sRgiht .table thead tr{background:#37BCF8;height:30px;color:#333;}
	#sRgiht .table thead tr th{border:1px solid #333;text-align: center;}
	#sRgiht .table tbody tr{width:100%;height:30px;}
	#sRgiht .table tbody tr.zwu{text-align:center;color:#f00;line-height:30px;}
	#sRgiht .table tbody tr:hover td{background:#60717E;color:#fff;}
	#sRgiht .table tbody tr td{text-align:center;border:1px solid #333;}
	/* 弹出层 */
	#ggLog{width:300px;height:300px;background:#fff;position:absolute;left:0;right:0;top:0;bottom:0;margin:auto;border-radius:5px;box-shadow:0 0 5px #555;display:none;}
	#ggLog strong{text-align:center;display:block;margin-bottom:-10px;margin-top:10px;}
	#ggLog strong #close{float:right;width:30px;height:30px;text-align:center;line-height:30px;margin-right: 5px;cursor:pointer;}
	#ggLog form label{display:block;widht:100%;height:30px;margin:20px 0;}
	#ggLog form label input{width:240px;height:30px;line-height:30px;text-indent:1em;outline:none;border:none;border:1px solid #e4e4e4;border-radius:5px;}
	#ggLog form label select{width:60px;height:30px;line-height:30px;text-indent:1em;outline:none;border:none;border:1px solid #e4e4e4;border-radius:5px;}
	#ggLog form label span{margin-left:8px;}
	#ggLog form input[type="submit"]{display:block;width:80px;height:30px;line-height:27px;cursor:pointer;text-align:center;border-radius:5px;background-color:#DE5145;color:#fff;margin:20px auto;}
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
				<li><a href="<%=path%>/users">用户管理restful</a></li>
				<li><a href="<%=path%>/sysmanager/upload/goUpload.do">文件上传</a></li>
			</ul>
		</div>
		<!-- E side -->
		
		<!-- sRgiht S -->
		<div id="sRgiht">
			<h2>用户管理</h2>
			<a href="javascript:;" id="addUser">＋新增用户</a>
			<table class="table">
				<caption class="yhtitle">
					用户列表<span style="color:#f00;">${addErr }</span>
				</caption>
				<thead>
					<tr>
						<th>选择</th>
						<th>ID</th>
						<th>用户名</th>
						<th>登录名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>生日</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${userList != null }">	
						<c:forEach items="${userList }" var="user">	
							<tr>
								<td>
									<input type="checkbox" />
								</td>
								<td>${user.id }</td>
								<td>${user.userName }</td>
								<td>${user.loginName }</td>
								<td>${user.sex ==1?'女':'男' }</td>
								<td>${user.age }</td>
								<td>${user.birthday == null ? '暂无生日': user.birthday}</td>
								<td>
									<%-- <a href="<%=path%>/sysmanager/user/delUserId.do?id=${user.id}" class="delete" data-id="${user.id }">删除</a> --%>
									<a href="javascript:;" class="delete" data-id="${user.id }">删除</a>
									<a href="javascript:;" class="update" data-id="${user.id }"
										data-username = "${user.userName }"
										data-loginname = "${user.loginName }"
										data-age = "${user.age }"
										data-sex = "${user.sex}"
									>修改</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${userList == null }">
						<tr class="zwu">
							<td colspan="8">暂无数据</td>
						</tr>
					</c:if>
				</tbody>
			</table>

		</div>
		<!-- E sRgiht -->
	</div>
	<!-- E oacontent -->
	<!-- 弹出层 -->
	<div id="ggLog">
		<strong>
			用户信息
			<sup id="close">✘</sup>
		</strong>
		
		<form>
			<input type="hidden" name="id" id="uid" />
			<label>
				<span>用户名:</span><input type="text" placeholder="用户名..." name="userName" id="userName" required="required"/>
			</label>
			<label>
				<span>登录名:</span><input type="text" placeholder="登录名..." name="loginName" id="loginName" required="required"/>
			</label>
			<label>
				<span>年&nbsp;&nbsp;&nbsp;龄:</span><input type="number" placeholder="年龄..." id="age" name="age" required="required"/>
			</label>
			<label>
				<span>性&nbsp;&nbsp;&nbsp;别:</span><select name="sex" id="sex">
					<option value="0">男</option>
					<option value="1">女</option>
				</select>
			</label>
			<input type="submit" value="保存" />
		</form>
	</div>
	<script src="<%=path %>/static/js/jquery-3.1.1.min.js"></script>
	<script src="<%=path %>/static/sg/sg.js"></script>
	<script src="<%=path %>/static/sg/tz_util.js"></script>
	<script src="<%=path %>/static/js/lock.js"></script>
	<script>
		//加载动画
		loading("数据正在加载中...",3);
		//新增
		$("#addUser").on('click',function(){
			$("#uid").val("");
			$("#userName").val("");
			$("#loginName").val("");
			$("#age").val("");
			$("#sex").val("");
			$("#ggLog").slideDown(500);
			//赋连接
			$("#ggLog").find("form").attr("action","<%=path%>/user/");
			$("#ggLog").find("form").attr("method","post");
		})
		$("#close").on("click",function(){
			$("#ggLog").slideUp(500);
		})
		//修改
		$(".update").on("click",function(){
			let uid = $(this).data("id"),
				username = $(this).data("username"),
				loginname = $(this).data("loginname"),
				age = $(this).data("age"),
				sex = $(this).data("sex");
			$("#uid").val(uid);
			$("#userName").val(username);
			$("#loginName").val(loginname);
			$("#age").val(age);
			$("#sex").val(sex);
			$("#ggLog").slideDown(500);
			//赋连接
			$("#ggLog").find("form").attr("action","<%=path%>/user/");
			$("#ggLog").find("form").attr("method","put");
		})
		//删除
		$(".delete").click(function(){
			let uid = $(this).data("id"),
				that = $(this);
			$.tzAlert({
				content:"您确定要删除吗？",
				callback:function(ok){
					 if(ok){
						 $.ajax({
							type:"delete",
							url:"<%=path%>/user/"+uid,
							async:true,
							dataType:"json",
							success:function(data){
								if(data.result == 1){
									that.parents("tr").fadeOut(1000,function(){
										$(this).remove();
									});
								}
							},
							error:function(data){
								alert(data.responseText);
							}
						});
					}
				}
			}); 
		}) 
		
	</script>
</body>
</html>