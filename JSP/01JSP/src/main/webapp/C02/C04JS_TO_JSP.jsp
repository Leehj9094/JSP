<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
		boolean isInit=true;						// 2번째 true값인것을 확인하면 true 로 저장
	%>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String flag = request.getParameter("flag");
		System.out.println("FLAG : " + flag);
		System.out.println("isInit = " + isInit);
		if(flag!=null && flag.equals("true")){		// 들어오면 
			isInit=false;
		}
			
	
	%>
	USERNAME :
	<%=username%><br> PASSWORD :
	<%=password%><br> ROLE :
	<%=role%><br>

	<form action="C04JS_TO_JSP.jsp" name="myForm">
		<input name="username" type="hidden" /> 
		<input name="password" type="hidden" /> 
		<input name="role" type="hidden" /> 
		<input name="flag" value="true" type="hidden" />
	</form>

	<script>
		const form = document.myForm;
		const flag = '<%=isInit%>';			// 처음 자바에 요청하는 건지 두번째 요청하는 것인지 확인하는 
		console.log("flag",flag);
		if(flag == 'true'){					// 처음 요청했을 때 true 값이라면 
			form.username.value = "홍길동";
			form.password.value = "1234";
			form.role.value = "ROLE_USER";
			form.submit();
		}
	</script>
	
</body>
</html>