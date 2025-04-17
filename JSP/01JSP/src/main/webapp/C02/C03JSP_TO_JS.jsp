<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- BankEnd 처리 코드 -->
<%
String msg1 = "HELLO1";
String msg2 = "HELLO2";
String msg3 = "HELLO3";
String msg4 = "HELLO4";
request.setAttribute("message", "TEST");			// 굳이 param을 안써도 가능한 setAttribute 
request.setAttribute("message2", "TEST_2");			// 굳이 param을 안써도 가능한 setAttribute 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
	/*
		const message1 = '<%=msg1%>';		// 표현식을 사용 가능 - ''(문자열인 것을 나타내기 위함)사용해야 됨
		const message2 = '<%=msg2%>';	
		const message3 = '<%=msg3%>';	
		const message4 = '<%=msg4%>';	
	*/
		const message1 = '${message}';		// EL
		const message2 = '${message2}';		// EL
		const message3 = `${message}`;		// 벡틱키는 보간법(JSP의 message값을 리터럴 형태로 변환)
		
		console.log(message1);
		console.log(message2);
		console.log(message3);
//		console.log(message4);
	</script>

</body>
</html>