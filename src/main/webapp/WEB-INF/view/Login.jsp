<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>『BookFLIX』 로그인</title>
</head>
<body>

	<form action='main.jsp' method="post">
	<table border="1" align="center" width="500">
		<tr>
			<th colspan="2"><span style=" font: bold 2em/1em Georgia, serif ; color: maroon;">
            도서대여서비스 『BookFLIX』</span></th>
		</tr>
		<tr>
			<td>사용자 아이디</td>
			<td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<td>사용자 암호</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<th colspan="2">
            <p><input type="submit" name="action" value="로그인"></p>
            <p>아이디가 없습니까?<br>
            <input type="submit" name="action" value="회원가입">
            </p>
            </th>
		</tr>
	</table>
	</form>
</body>
</html>