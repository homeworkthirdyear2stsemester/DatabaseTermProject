<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BookFLIX에 오신 것을 환영합니다.</title>
    <link rel="stylesheet" href="/resources/css/main-user.css">
</head>
<body>
<div>
    <span>BookFLIX에 오신 것을 환영합니다.</span>
</div>

<div>
    <input type="button" onclick="goToEditProfilePage()" name="profile" value="프로필 수정하기">
    <input type="button" onclick="goToSearchBookPage()" name="search" value="도서목록 검색하기">
</div>

<div>
    도서대출목록
    <table id="borrow-list">
        <thead>
        <tr>
            <th>

            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="borrow" items="${borrows}">
            <tr>
                <td>${borrow.isbn}</td>
                <td>${borrow.title}</td>
                <td>${borrow.borrowDate}</td>
                <td>${borrow.returnDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
    도서예약목록
    <table id="reservation-list">
        <thead>
        <tr>
            <th>

            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reservation" items="${reservations}">
            <tr>
                <td>${reservation.isbn}</td>
                <td>${reservation.reservDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="/resources/js/main-user.js">
</script>
</body>
</html>