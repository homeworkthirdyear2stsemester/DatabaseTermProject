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

    <table>
        <thead>
        <tr>
            <td class="ex1">ISBN</td>
            <td class="ex1">Title</td>
            <td class="ex1">Author</td>
            <td class="ex1">Publisher</td>
            <td class="ex1">Borrowed</td>
            <td class="ex1">CustomerID</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="borrow" items="${authorizedReturnList}">
            <c:url var="cancealLink" value="/book/comfirmReturnBorrow">
                <c:param name="bookIsbn" value="${borrow.isbn}"/>
                <c:param name="customerId" value="${borrow.customerId}"/>
            </c:url>
            <tr>
                <td class="ex2">${borrow.isbn}</td>
                <td class="ex2">${borrow.title}</td>
                <td class="ex2">${borrow.customerId}</td>
                <td class="ex2">${borrow.borrowDate}</td>
                <td class="ex2">${borrow.returnDate}</td>
                <td class="ex2"><a href="${cancealLink}" onclick="completeTask()">반납 승인</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="button" onclick="completeTask()" value="돌아가기">
</div>
</body>
<script type="text/javascript" src="/resources/js/authorizeReturn.js">
</script>
</html>