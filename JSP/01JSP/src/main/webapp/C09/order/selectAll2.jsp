<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="C09.*,C09.DBUtils,java.util.*" %>
    <%
    List<OrderDto3> list3 = DBUtils.getInstance().selectAllOrder3();
    %>
    <!-- 
    	INNER JOIN
     -->

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
		select order_date, round(avg(price*quantity),2)
		from tbl_order
		group by order_date
	  --> 
	       <%
     
     List<OrderDto2> list2 = DBUtils.getInstance().selectAllOrder2();
     
     %>

	<h1>지역 + 날짜별 구매총액</h1>
	<table>
		<tr>
			<th>지역</th>
			<th>날짜</th>
			<th>총액</th>
		</tr>
		
		<tr>
			<td>대구</td>
			<td>2025-01-01</td>
			<td>10000</td>
		</tr>
	</table>
</body>
</html>