<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@
	page import="java.time.LocalDate"
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規会員登録</title>
		<style>
#text {
	text-align: center;
}
</style>
<link rel="stylesheet" type="text/css" href="./css/StockAdd.css">
		<script src="/LibraryProject/VariousFunctions.js"></script>
	</head>
	<body>
	<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a>
		<div class="centermargin">
		<h1 style="text-align: center">新規会員登録</h1>
		</div>
		<font color="red">${CreateMessage}</font>
		<form action="/LibraryProject/CreateUserConf" method="post">
			<table border="1" align="center">
				<tr><td>氏名</td><td><input type="text" name="name" required value='${CreateUser.strName }'></td></tr>
				<tr><td>郵便番号</td><td><input type="number" name="post" value='${CreateUser.post_no }' oninput="sliceMaxLength(this, 7)" required></td></tr>
				<tr><td>住所</td><td><input type="text" name="address" required value='${CreateUser.address }'></td></tr>
				<tr><td>電話番号</td><td><input type="text" name="tel" required value='${CreateUser.tel }'></td></tr>
				<tr><td>E-mail</td><td><input type="text" name="mail" required value='${CreateUser.mail }'></td></tr>
				<tr><td>生年月日</td><td><input type="date" name="birthday" required value='${CreateUser.birthday }'></td></tr>
				<tr><td>入会年月日</td><td><input type="date" name="indate" value=<%= LocalDate.now() %>></td></tr>
			</table>
			<br>
			<div id="text">
			<div class="button">
			<input type="button" onclick="location.href='/LibraryProject/TopMenu.html'" value="戻る" formaction="../TopMenu.html">
			<input type="submit" value="追加" >
			</div>
			</div>
			
		</form>
	
	</body>