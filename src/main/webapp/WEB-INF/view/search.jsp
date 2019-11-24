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
            //여기에 검색결과와 일치하는 도서명 혹은 ISBN 출력
        </div>
    </div>
    <div class="ex2">
        <div>
            //여기에 정보 뜨게 하기
        </div>
        <input type="submit" name="action" value="대출">
        <input type="submit" name="action" value="예약">
    </div>


</form:form>

</body>
</html>