<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BookFLIX 회원정보수정</title>
</head>
<body>

<form:form action="changeCustomerData" modelAttribute="customer" method="POST">
    <table border="1" align="center" width="500">
        <tr>
            <th colspan="2">프로필 수정하기</th>
        </tr>
        <tr>
            <td>암호 재입력</td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td>이메일 주소 재설정</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>전화번호 재입력</td>
            <td><form:input path="phoneNumber"/></td>
        </tr>
        <tr>
            <td>회원 분류</td>
            <td>
                <form:radiobutton path="type" value="10"/>학부생<br>
                <form:radiobutton path="type" value="30"/>대학원생<br>
                <form:radiobutton path="type" value="60"/>교직원<br>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="프로필 수정">
                <input type="button" onclick="cancelEditing()" value="취소">
                <input type="button" onclick="deleteProfile()" value="삭제">
            </td>
        </tr>
    </table>
</form:form>
<script type="text/javascript" src="/resources/js/edit-profile.js">
</script>
</body>
</html>