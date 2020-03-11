<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
</head>
<body>
<form action="./modifySave.do" method="POST">
	<input type="hidden" name="clno" value="${bdto.bno }"/>
	<table border="1">
			<tr>
			<td colspan="2" style="text-align: center;">글 수정</td>
			</tr>
			<tr>
				<td>글번호</td>
				<td>${bdto.bno }</td>
			</tr>
			<tr>
				<td>작성날짜</td>
				<td>${bdto.regdate }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${bdto.title }"/></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="author" value="${bdto.author } "/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="40" rows="5" name="content">${bdto.content }</textarea></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="email" value="${bdto.email } "/></td>
			</tr>
			<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="수정하기"/>
			</td>
			</tr>
	</table>
</form>
</body>
</html>