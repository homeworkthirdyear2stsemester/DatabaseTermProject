<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BookFLIX 로그인</title>
    <link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>

<form:form action="loginCheck" modelAttribute="user" method="POST">
    <table border="1" align="center" width="500">
        <tr>
            <th colspan="2"><span>도서대여서비스 BookFLIX</span>
            </th>
        </tr>
        <tr>
            <td>사용자 아이디</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>사용자 암호</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <th colspan="2">
                <div><input type="submit" name="action" value="로그인">
                    <input type="button" onclick="goToRegisterPage()" value="회원가입">
                </div>
            </th>
        </tr>
    </table>
</form:form>
<script type="text/javascript" src="/resources/js/login.js">
</script>
</body>
</html>