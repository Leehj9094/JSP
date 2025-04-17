<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LOGIN PAGE</h1>
	<form action=""${pageContext.request.contextPath}/login.do" method="post"">
		<input name="userid"><br/>
		<input name="password"><br/>
		<button>LOGIN</button>
	</form>
	<div>${userid_msg}</div>
	<div>${password_msg}</div>
</body>
</html>