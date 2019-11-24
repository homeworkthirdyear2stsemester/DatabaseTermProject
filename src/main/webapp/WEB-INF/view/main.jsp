<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String action = request.getParameter("action");

    if (action.equals("로그인")) {
		
		/*
		DB에서 정보 가져오기. 아이디를 통해 해당 사용자를 찾고 비번을 비교
		비밀번호가 일치하면 해당 아이디가 관리자인지 일반 사용자인지 확인.
		관리자일 경우 main_Admin으로 페이지 넘기기.
		일반 사용자일 경우 main_user로 페이지 넘기기.
		일치하지 않으면 경고 띄우고 로그인 페이지 복귀
		*/
        //if(비번 일치)
        //if(일반 사용자)
        response.sendRedirect("main-user.jsp");
        //else(관리자)
        response.sendRedirect("main_Admin");
        //else(일치하지 않거나 해당 아이디가 존재하지 않는 경우)
        out.println("<script>alert('존재하지 않는 아이디거나 비밀번호가 일치하지 않습니다.');</script>");
        response.sendRedirect("login.jsp");


    } else if (action.equals("회원가입")) {
        response.sendRedirect("register.jsp");
    }
%>