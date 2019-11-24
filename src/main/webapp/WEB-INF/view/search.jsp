<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BookFLIX 로그인</title>
    <link rel="stylesheet" href="/resources/css/search.css">

</head>
<body>

<form:form action="search" modelAttribute="customer" method="POST">
    <div class="ex1">
        <div><span>검색 설정</span><br>
            <input type="radio" name="type" value="isbn" checked>ISBN
            <input type="radio" name="type" value="도서 제목">도서 제목
        </div>

        <div><span>도서명 혹은 ISBN 입력</span><br>
            <input type="text" name="title">
            <input type="submit" name="action" value="검색">
        </div>
        <div>
            <!-- 여기에서 검색한 책의 내용이 추가되어야 함 -->
            <a href="main-user.jsp">대출</a>
            <a href="main-user.jsp">예약</a><br>
        </div>
    </div>
</form:form>

</body>
</html>