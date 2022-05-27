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
	<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a><br>
		<h1>新規会員登録</h1>
		<form action="CreateUserServlet" method="post">
			<table border="1">
				<tr><td><input type="hidden" name="name" value='${CreateUser.strName}'>			氏名</td><td>${param.name}</td></tr>
				<tr><td><input type="hidden" name="post" value='${CreateUser.post_no}'>			郵便番号</td><td>${param.post}</td></tr>
				<tr><td><input type="hidden" name="address" value='${CreateUser.address}'>	住所</td><td>${param.address}</td></tr>
				<tr><td><input type="hidden" name="tel" value='${CreateUser.tel}'>			電話番号</td><td>${param.tel}</td></tr>
				<tr><td><input type="hidden" name="mail" value='${CreateUser.mail}'>			E-mail</td><td>${param.mail}</td></tr>
				<tr><td><input type="hidden" name="birthday" value='${CreateUser.birthday}'>	生年月日</td><td>${param.birthday}</td></tr>
				<tr><td><input type="hidden" name="indate" value='${CreateUser.join_date}'>		入会年月日</td><td>${param.indate}</td></tr>
			</table>
			上記の内容で登録しますか？<br>
			<input type="submit" value="戻る" formaction="/LibraryProject/menberInfo/CreateUser.jsp"><input type="submit" value="追加" >
		</form>
	</body>