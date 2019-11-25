<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>반납승인 페이지</title>
    <link rel="stylesheet" href="/resources/css/authorizeReturn.css">
</head>
<body>
<div class="ex1">
    <span>반납승인 대기 리스트</span><br>
</div>
<table>
    <thead>
    <tr>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="borrow" items="${authorizedReturnList}">
        <c:url var="cancealLink" value="/book/comfirmReturnBorrow">
            <c:param name="bookIsbn" value="${borrow.isbn}"/>
            <c:param name="customerId" value="${borrow.customerId}"/>
        </c:url>
        <tr>
            <td>${borrow.isbn}</td>
            <td>${borrow.title}</td>
            <td>${borrow.customerId}</td>
            <td>${borrow.borrowDate}</td>
            <td>${borrow.returnDate}</td>
            <td><a href="${cancealLink}" onclick="completeTask()">반납 승인</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<input type="button" onclick="completeTask()" value="돌아가기">

</body>
<script type="text/javascript" src="/resources/js/authorizeReturn.js">
</script>
</html>