<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BookFLIX에 오신 것을 환영합니다.</title>
    <link rel="stylesheet" href="/resources/css/main-user.css">
</head>
<body>
<form action='main.jsp' method="post">
    <td><span>BookFLIX에 오신 것을 환영합니다.</span></td>
    <table border="1" align="center" width="260">
        <tr>
            <td>
                <input type="submit" name="profile" value="프로필 수정하기">
                <input type="button" name="search" value="도서목록 검색하기">
            </td>
        </tr>
    </table>
    <div>
        도서대출목록
    </div>
    <div>
        도서예약목록
    </div>
</form>
</body>
</html>