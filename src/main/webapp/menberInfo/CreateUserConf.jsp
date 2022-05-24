<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@
	page import="java.time.LocalDate"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規会員登録</title>
	</head>
	<body>
		<h1>新規会員登録</h1>
		<form action="../CreateUserServlet" method="post">
			<table border="1">
				<tr><td><input type="hidden" name="name" value=${param.name}>			氏名</td><td>${param.name}</td></tr>
				<tr><td><input type="hidden" name="post" value=${param.post}>			郵便番号</td><td>${param.post}</td></tr>
				<tr><td><input type="hidden" name="address" value=${param.address}>	住所</td><td>${param.address}</td></tr>
				<tr><td><input type="hidden" name="tel" value=${param.tel}>			電話番号</td><td>${param.tel}</td></tr>
				<tr><td><input type="hidden" name="mail" value=${param.mail}>			E-mail</td><td>${param.mail}</td></tr>
				<tr><td><input type="hidden" name="birthday" value=${param.birthday}>	生年月日</td><td>${param.birthday}</td></tr>
				<tr><td><input type="hidden" name="indate" value=${param.indate}>		入会年月日</td><td>${param.indate}</td></tr>
			</table>
			上記の内容で登録しますか？<br>
			<input type="submit" value="戻る" formaction="CreateUser.jsp"><input type="submit" value="追加" >
		</form>
	</body>