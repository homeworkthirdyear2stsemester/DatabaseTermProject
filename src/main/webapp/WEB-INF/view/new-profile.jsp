<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String temp_password = request.getParameter("temp_password");
	String email = request.getParameter("email");
	String name = request.getParameter("name");
	String phone_number = request.getParameter("phone_number");
	String action = request.getParameter("action");

	if (action.equals("아이디확인")) {
		if (id.equals("esf0511")) {
			out.println("<script>alert('이미 존재하는 아이디입니다.');</script>");
		} else {
			out.println("사용 가능한 아이디입니다.");
		}
	} else {
		if (!password.equals(temp_password)) {
			out.println("<script>alert('두 번 입력한 비밀번호가 일치하지 않습니다.');</script>");
			response.sendRedirect("register.jsp");
		}
		else{
			//DB에 해당 데이터 저장하기
		}
	}
%>