<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서수정 페이지</title>
    <link rel="stylesheet" href="/resources/css/edit-book.css">
</head>
<body>
<div>
    <span>도서정보수정을 하는 페이지입니다.</span>
</div>


<div class="ex1">
    <span>도서수정하기</span><br>
    <!-- 입력된 isbn 출력시키기 -->
    책제목 입력 :<input type="text" name = "title"><br>
    작가 입력 : <input type="text" name = "author"><br>
    출판사 입력 :<input type="text" name = "publisher"><br>
    <input type="button" onclick="editBook()" name="edit" value="도서수정">
</div>
</body>
</html>