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
    <form:form modelAttribute="book" method="GET">
        <form:hidden path="isbn"/>
        <span>도서수정하기</span><br>
        <!-- 입력된 isbn 출력시키기 -->
        책제목 입력 :<form:input path="title"/><br>
        작가 입력 : <form:input path="author"/><br>
        출판사 입력 :<form:input path="publisher"/><br>
        <input type="submit" onclick="editBook()" name="edit" value="도서수정">
    </form:form>
</div>
<script type="text/javascript" src="/resources/js/edit-book.js">
</script>
</body>
</html>