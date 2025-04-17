<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%							// 키보드로 입력 받기 전까지 안나옴
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.print("행 열 입력 : ");
	int row = sc.nextInt();
	int col = sc.nextInt();
	System.out.printf("행 : %d 열 : %d\n", row, col);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tbody>
			<%				// 마음대로 태그를 생성할 수 있는 태그
				// tr태그 생성 반복
				for(int i=0;i<row;i++)
				{
					%>
					<tr>
						<%
							for(int j=0;j<col;j++)
							{
						%>
						<td><%=i+":"+j%></td>
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