<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>『BookFLIX』프로필 등록</title>
</head>
<body>
<form action='newProfile.jsp' method="post">
    <table border="1" align="center" width="500">
        <tr>
            <th colspan="2">프로필 생성하기</th>
        </tr>
        <tr>
            <td>이름 입력</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>사용할 아이디 입력</td>
            <td>
                <input type="text" name="id"><input type="submit" value="아이디확인">
            </td>
        </tr>
        <tr>
            <td>암호 입력</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>암호 재입력</td>
            <td><input type="password" name="temp_password"></td>
        </tr>
        <tr>
            <td>이메일 주소</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone_number"></td>
        </tr>
        <tr>
            <td>회원 분류</td>
            <td>
                <input type="radio" name="type" value="학부생" checked>학부생<br>
                <input type="radio" name="type" value="대학원생">대학원생<br>
                <input type="radio" name="type" value="교직원">교직원<br>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="프로필 등록">
                <input type="button" onclick="cancelRegister()" value="취소">
            </td>
        </tr>
    </table>
    <script type="text/javascript" src="/resources/js/register.js">
    </script>
</body>
</html>