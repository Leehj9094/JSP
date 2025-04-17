<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%							// 키보드로 입력 받기 전까지 안나옴
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.print("단 입력 : ");
	int row = sc.nextInt();
	int col = sc.nextInt();
	System.out.printf("단 : %d 열 : %d\n", row, col);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	단수를 입력받아 해당 구구단을 찍어보세요 (Table로 만드세요 - 스크립틀릿)
 -->

<table>
	<tbody>
		<%				
			for(int i=2;i<10;++i)
			{
			%>
				<tr>
				<%
					for(int j=1;j<10;j++)
					{
					%>
						<td><%=i+"*"+j%></td>
						<%
							}
						%>
					</tr>
					<% 
							
						
				}
			%>
		
			
	</tbody>
</table>

</body>
</html>