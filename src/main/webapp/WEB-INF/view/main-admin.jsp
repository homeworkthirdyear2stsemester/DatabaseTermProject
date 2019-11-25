<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BookFLIX에 오신 것을 환영합니다.</title>
    <link rel="stylesheet" href="/resources/css/main-admin.css">
</head>
<body>
<td><span>BookFLIX 관리자님 환영합니다.</span></td>
<table border="1" align="center" width="260">
    <tr>
        <td>
            <input type="button" onclick="gotoBookRegister()" value="도서등록"/>
            <input type="button" onclick="gotoBookMangement()" value="도서관리"/>
            <input type="button" onclick="logout()" value="로그아웃"/>
            <input type="button" onclick="authorizeReturn()" value="반납승인대기 목록"/>
        </td>
    </tr>
</table>
<script type="text/javascript" src="/resources/js/main-admin.js">
</script>
</body>
</html>