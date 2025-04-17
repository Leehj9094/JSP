<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	if(session.getAttribute("isAuth")==null){
		response.sendRedirect("./join_form.jsp?message=Session_Expired");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LOGIN PAGE</h1>
	ISAUTH : <%=session.getAttribute("isAuth") %> <br/>
	ISAUTH(EL) : ${isAuth }<br/>
	
	ROLE : <%=session.getAttribute("role") %><br/>
	ROLE(EL) : ${role }<br/>
</body>
</html>