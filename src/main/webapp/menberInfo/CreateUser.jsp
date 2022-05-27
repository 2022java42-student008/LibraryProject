<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@
	page import="java.time.LocalDate"
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規会員登録</title>
		<script src="/LibraryProject/VariousFunctions.js"></script>
	</head>
	<body>
	<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a>
		<h1>新規会員登録</h1>
		<form action="CreateUserConf.jsp">
			<table border="1">
				<tr><td>氏名</td><td><input type="text" name="name" required></td></tr>
				<tr><td>郵便番号</td><td><input type="number" name="post" oninput="sliceMaxLength(this, 7)" required></td></tr>
				<tr><td>住所</td><td><input type="text" name="address" required></td></tr>
				<tr><td>電話番号</td><td><input type="text" name="tel" required></td></tr>
				<tr><td>E-mail</td><td><input type="text" name="mail" required></td></tr>
				<tr><td>生年月日</td><td><input type="date" name="birthday" required></td></tr>
				<tr><td>入会年月日</td><td><input type="date" name="indate" value=<%= LocalDate.now() %>></td></tr>
			</table>
			<input type="button" onclick="submit();" value="戻る" formaction="../TopMenu.html"><input type="submit" value="追加" >
		</form>
	</body>