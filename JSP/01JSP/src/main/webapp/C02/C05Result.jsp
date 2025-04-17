<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String col1 = request.getParameter("col1");
	String col2 = request.getParameter("col2");
	String col3 = request.getParameter("col3");
	String col4 = request.getParameter("col4");
	String navStyle = request.getParameter("style");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	ul{
		list-style:none;
		padding:0;
		margin:0;
	}
	header{
		width:100%;
	}
</style>
</head>
<body>

	<div class="wrapper">
		<header>
			<div class="top-header"></div>
			<nav>
				<ul style="<%=navStyle%>">
					<li><%=col1 %></li>
					<li><%=col2 %></li>
					<li><%=col3 %></li>
					<li><%=col4 %></li>
				</ul>
			</nav>
		</header>
		<main>
			<section></section>
		</main>
		<footer></footer>
	</div>

	 

</body>
</html>