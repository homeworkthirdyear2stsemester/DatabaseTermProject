<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서관리 페이지</title>
    <link rel="stylesheet" href="/resources/css/book-management.css">
</head>
<body>
<div>
    <span>도서관리를 담당하는 페이지입니다.</span>
</div>

<form:form action="registerBook" modelAttribute="book" method="POST">
    <div class="ex1">
        <span>도서등록하기</span><br>
        도서 isbn 입력 :<form:input path="isbn"/><br>
        책제목 입력 :<form:input path="title"/><br>
        작가 입력 : <form:input path="author"/><br>
        출판사 입력 :<form:input path="publisher"/><br>
        <input type="submit"
               onclick="if (!(confirm('등록 하시겠습니까?'))) return false"
               value="도서등록">
    </div>
</form:form>
<div class="ex1">
    <span>도서삭제하기</span>
    도서 isbn 입력 : <input type="text" name="isbn"><input type="button" onclick="deleteBook()" name="delete" value="도서삭제">
</div>
<div class="ex1">
    <span>도서수정하기</span>
    도서 isbn 입력 : <input type="text" name="isbn"><input type="button" onclick="editBook()" name="edit" value="도서수정">
</div>
<script type="text/javascript" src="/resources/js/book-management.js">
</script>
</body>
</html>