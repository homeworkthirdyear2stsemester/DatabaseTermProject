<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <span>저장된 도서목록</span>
</div>

<div class="ex1">
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
        <c:forEach var="book" items="${books}" >
            <c:url var="deleteLink" value="/book/delete">
                <c:param name="bookIsbn" value="${book.isbn}"/>
            </c:url>
            <c:url var="updateLink" value="/book/editBookPage">
                <c:param name="bookIsbn" value="${book.isbn}"/>
            </c:url>
            <tr>
                <td class="ex2">${book.isbn}</td>
                <td class="ex2">${book.title}</td>
                <td class="ex2"> ${book.author} </td>
                <td class="ex2">${book.publisher}</td>
                <td class="ex2"> ${book.isBorrow}</td>
                <td>
                    <a href="${deleteLink}"
                       onclick="if (!(confirm('책을 목록에서 삭제 하시겠습니까?'))) return false">제거</a>
                    |
                    <a href="${updateLink}"
                       onclick="if (!(confirm('책 정보 수정 화면으로 넘어가시겠습니까?'))) return false">수정</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="button" onclick="gotoMainAdminPage()" value="goto main admin page"/>
</div>
<script type="text/javascript" src="/resources/js/book-management.js">
</script>
</body>
</html>