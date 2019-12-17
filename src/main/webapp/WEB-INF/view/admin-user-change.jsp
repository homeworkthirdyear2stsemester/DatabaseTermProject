<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자관리 페이지</title>
    <link rel="stylesheet" href="/resources/css/user-management.css">
</head>
<body>
<div>
    <span>저장된 도서목록</span>
</div>

<div class="ex1">
    <table>
        <thead>
        <tr>
            <td class="ex1">ID</td>
            <td class="ex1">PW</td>
            <td class="ex1">Email</td>
            <td class="ex1">name</td>
            <td class="ex1">phoneNumber</td>
            <td class="ex1">type</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}" >
            <c:url var="deleteLink" value="/user/adminUserDelete">
                <c:param name="userId" value="${customer.id}"/>
            </c:url>
            <c:url var="updateLink" value="/user/adminEditUserPage">
                <c:param name="userId" value="${customer.id}"/>
            </c:url>
            <tr>
                <td class="ex2">${customer.id}</td>
                <td class="ex2">${customer.password}</td>
                <td class="ex2"> ${customer.email} </td>
                <td class="ex2"> ${customer.name} </td>
                <td class="ex2">${customer.phoneNumber}</td>
                <td class="ex2"> ${customer.type}</td>
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
    <input type="button" onclick="gotoMainAdminPageForUserManagement()" value="goto main admin page"/>
</div>
<script type="text/javascript" src="/resources/js/user-management.js">
</script>
</body>
</html>