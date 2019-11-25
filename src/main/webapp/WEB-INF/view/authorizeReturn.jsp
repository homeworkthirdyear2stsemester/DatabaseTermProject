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
        <!--여기 반납승인을 대기하고 있는 리스트마다 승인 버튼-->
        <a> href="main-admin.jsp">승인</a>
    </div>
    <input type="button" onclick="completeTask()" value="돌아가기">

</body>
<script type="text/javascript" src="/resources/js/authorizeReturn.js">
</script>
</html>