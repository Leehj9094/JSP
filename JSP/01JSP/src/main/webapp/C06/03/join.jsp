<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String email = request.getParameter("email");
	String username = request.getParameter("username");
	String password =request.getParameter("password");
	
	// 유효성 체크
	if(name.isEmpty()){
		request.setAttribute("name_msg","name을 입력하세요");
	}
	if(addr.isEmpty()){
		request.setAttribute("addr_msg","addr를 입력하세요");
	}
	if(email.isEmpty()){
		request.setAttribute("email_msg", "email을 입력하세요");
	}
	if(username.isEmpty()){
		request.setAttribute("username_msg", "username을 입력하세요");
	}
	if(password.isEmpty()){
		request.setAttribute("password_msg","password를 입력하세요");
	}
	if(username.isEmpty()||password.isEmpty()){
		request.getRequestDispatcher("./join_form.jsp").forward(request, response);
		return ;
	}
	
	// 01 이메일 확인 (DB 조회 - 생략)
	if(!email.equals("aaaa@gmail.com")){
		request.setAttribute("email_msg","해당 EMAIL은 존재하지 않습니다");
		request.getRequestDispatcher("./join_form.jsp").forward(request, response);
		return ;
	}
	
%>    
    