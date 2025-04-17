<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		label{font-size : .8rem; background-color:darkbrown; color:white;}
		span{}
	</style>
</head>
<body>
	<h1>JOIN FORN</h1>
	<div style="min-height:20px; font-size:.5rem; color:red;">
	${param.message }
	</div>
	<form action="${pageContext.request.contextPath}/06/03/join.jsp" method="post">
		<div>
			<label>이름</label><br/>
			<input type = "text" name="name"/>
		</div>
		<div>
			<label>주소</label><br/>
			<input type = "text" name="addr"/>
		</div>
		<div>
			<label>이메일</label><br/>
			<input type = "text" name="email"/>
		</div>
		<div>
			<label>아이디</label><br/>
			<input type = "text" name="username"/>
		</div>
		<div>
			<label>비밀번호</label><br/>
			<input type = "text" name="password"/>
		</div>
		<div>
			<button>회원가입</button>
		</div>
	</form>
</body>
</html>