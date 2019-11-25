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
    <span>도서관리를 담당하는 페이지입니다.</span>
</div>

<div class="ex1">
    <table>
        <thead>
        <tr>
            <%-- <th></th>  작성하세요--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <c:url var="deleteLink" value="/book/delete">
                <c:param name="bookIsbn" value="${book.isbn}"/>
            </c:url>
            <c:url var="updateLink" value="/book/update">
                <c:param name="bookIsbn" value="${book.isbn}"/>
            </c:url>
            <tr>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td> ${book.author} </td>
                <td>${book.publisher}</td>
                <td> ${book.isBorrow}</td>
                <td>${book.customerId}</td>
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