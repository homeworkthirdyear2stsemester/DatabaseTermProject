<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BookFLIX 프로필 등록</title>
</head>
<body>
<form:form action='customerSave' modelAttribute="customer" method="POST">
    <table border="1" align="center" width="500">
        <tr>
            <th colspan="2">프로필 생성하기</th>
        </tr>
        <tr>
            <td>이름 입력</td>
            <td><form:input path="name" maxlength="10"/></td>
        </tr>
        <tr>
            <td>사용할 아이디 입력</td>
            <td>
                <form:input path="id" maxlength="20"/>
            </td>
        </tr>
        <tr>
            <td>암호 입력</td>
            <td><form:password path="password" maxlength="20"/></td>
        </tr>
        <tr>
            <td>이메일 주소</td>
            <td><form:input path="email" maxlength="30"/></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><form:input path="phoneNumber" maxlength="11"/></td>
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
                <input type="submit" value="프로필 등록">
                <input type="button" onclick="cancelRegister()" value="취소">
            </td>
        </tr>
    </table>
</form:form>
<script type="text/javascript" src="/resources/js/register.js">
</script>
</body>
</html>