<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String id = (String) session.getAttribute("id");
    if (id == null) {
        response.sendRedirect("/user/login");
    }
%>

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

<div class="ex1">
    <span>도서대출목록</span>
    <table id="borrow-list">
        <thead>
        <td class="ex1">Isbn</td>
        <td class="ex1">Title</td>
        <td class="ex1">BorrowDate</td>
        <td class="ex1">ReturnDate</td>
        </thead>
        <tbody>
        <c:forEach var="borrow" items="${borrows}">
            <c:url var="returnRequest" value="/book/waitingForReturn">
                <c:param name="bookIsbn" value="${borrow.isbn}"/>
                <c:param name="borrowNumber" value="${borrow.borrowNumber}"/>
            </c:url>
            <tr>
                <td>${borrow.isbn}</td>
                <td>${borrow.title}</td>
                <td>${borrow.borrowDate}</td>
                <td>${borrow.returnDate}</td>
                <td><a href="${returnRequest}" onclick="requestReturn()">도서 반납</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="ex1">
    <span>도서예약목록</span>
    <table id="reservation-list">
        <thead>
        <td>isbn</td>
        <td>ReservationDate</td>
        </thead>
        <tbody>
        <c:forEach var="reservation" items="${reservations}">
            <c:url var="cancealLink" value="/book/cancealReservationPage">
                <c:param name="bookIsbn" value="${reservation.isbn}"/>
            </c:url>
            <tr>
                <td>${reservation.isbn}</td>
                <td>${reservation.reservDate}</td>
                <td><a href="${cancealLink}" onclick="cancealReservation()">예약 취소</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <input type="button" onclick="logout()" value="로그아웃"/>
</div>
<script type="text/javascript" src="/resources/js/main-user.js">
</script>
</body>
</html>