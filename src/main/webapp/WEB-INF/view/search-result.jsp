<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>대여, 예약</title>
    <link rel="stylesheet" href="/resources/css/search.css">

</head>
<body>

<div>
    <table>
        <tbody>
        <c:forEach var="book" items="${books}">
            <c:url var="borrowLink" value="/book/makeBorrow">
                <c:param name="bookIsbn" value="${book.isbn}"/>
            </c:url>
            <c:url var="reservateLink" value="/book/makeReservation">
                <c:param name="bookIsbn" value="${book.isbn}"/>
            </c:url>

            <tr>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.publisher}</td>
                <td>${book.isBorrow}</td>
                <td>
                    <a href="${borrowLink}"
                       onclick="if (!(confirm('대출을 하시겠습니까?'))) return false">대출</a>
                    |
                    <a href="${reservateLink}"
                       onclick="if (!(confirm('예약 하시겠습니까?'))) return false">예약</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="button" onclick="goToSearchPage()" value="검색 화면으로 이동"/>
</div>
<script type="text/javascript" src="/resources/js/search.js">
</script>
</body>
</html>