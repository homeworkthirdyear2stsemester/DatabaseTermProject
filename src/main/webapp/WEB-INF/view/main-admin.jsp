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
<form action='main.jsp' method="post">
    <td><span>BookFLIX 관리자님 환영합니다.</span></td>
    <table border="1" align="center" width="260">
        <tr>
            <td>
                <input type="submit" name="bookManagement" value="책관리">
                <input type="button" name="returnAuthorize" value="반납승인">
                <input type="button" name="topTen" value="상위텐">
            </td>
        </tr>
    </table>
</form>
</body>
</html>