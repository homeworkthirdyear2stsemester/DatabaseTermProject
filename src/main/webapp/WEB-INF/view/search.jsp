<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BookFLIX 로그인</title>
    <link rel="stylesheet" href="/resources/css/search.css">
</head>
<body>
<form action="bookSearch" method="GET">
    <div class="ex1">
        <div><span>검색 설정</span><br>
            <input type="radio" name="type" value="isbn" checked>ISBN
            <input type="radio" name="type" value="도서 제목">도서 제목
        </div>

        <div><span>도서명 혹은 ISBN 입력</span><br>
            <input type="text" name="data"/>
            <input type="submit" value="검색"/>
        </div>
    </div>
</form>
</body>
</html>