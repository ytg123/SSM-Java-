<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>异常处理页面 exHandle</h2>
	<%
		Exception ex = (Exception)request.getAttribute("ex");
		out.println(ex.getMessage());
		out.println(ex.getClass());
	%>
</body>
</html>