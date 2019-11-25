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
        <td>id</td>
        <td>name</td>
        <td>type</td>
        <td>borrowCount</td>
        </thead>
        <tbody>
        <!--가장 많이 빌린 10명 출력-->
        </tbody>
    </table>
</div>
    <input type="button" onclick="refresh()" value="새로고침">
    <input type="button" onclick="completeTask()" value="돌아가기">
</body>
<script type="text/javascript" src="/resources/js/topTen.js">
</script>
</html>