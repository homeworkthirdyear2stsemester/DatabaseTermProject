<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>대출 TOP 10 확인</title>
    <link rel="stylesheet" href="/resources/css/topTen.css">
</head>
<body>

<div class="ex1">
    <span>대출 TOP 10 리스트입니다</span><br>
    <table id="topten-list">
        <thead>
        <td class="ex1">id</td>
        <td class="ex1">name</td>
        <td class="ex1">type</td>
        <td class="ex1">borrowCount</td>
        </thead>
        <tbody>
        <c:forEach var="map" items="${topTenData}">
            <tr>
                <td class="ex2">${map.id}</td>
                <td class="ex2">${map.name}</td>
                <td class="ex2">${map.type}</td>
                <td class="ex2">${map.cnt_borrow}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="button" onclick="refresh()" value="새로고침">
    <input type="button" onclick="gotoAdminMainPage()" value="돌아가기">
</div>
</body>
<script type="text/javascript" src="/resources/js/topTen.js">
</script>
</html>