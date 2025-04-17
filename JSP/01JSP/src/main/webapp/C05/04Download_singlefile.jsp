D<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.io.*"%>

<%
// INPUTSTREAM
String dirPath = pageContext.getServletContext().getRealPath("/") + "C05\\files\\";
System.out.println("dirPath : " + dirPath);

try {
	// INPUTSTREAM
	FileInputStream in = new FileInputStream(dirPath + "TEST.txt");

	// OUTPUTSTREAM!!    - 
	out.clear();					// response outStream을 닫고 버퍼를 비움
	out = pageContext.pushBody();	// 현재 페이지의 body에 연결
	
	ServletOutputStream bout = response.getOutputStream();
	
	// Response Header 지정!!
	response.setHeader("Content-Type","application/octet-stream;charset-utf-8");
	response.setHeader("Content-Disposition","attachment; filename=TEST.txt");	
	byte[] buff = new byte[4096];
	while(true){
		int data = in.read(buff);
		if(data==-1)
			break;
		bout.write(buff,0,data);			// 속도가 조금 더 빠르게 다운로드 될 수 있음
		bout.flush();
	}
	bout.close();
	in.close();

} catch (Exception e) {
	e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>