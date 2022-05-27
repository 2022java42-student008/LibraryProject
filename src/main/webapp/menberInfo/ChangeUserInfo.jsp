<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>会員情報変更</title>
		<link href="css/UserInfoStyle.css" rel="stylesheet">
		<script src="/LibraryProject/VariousFunctions.js"></script>
	</head>
	<body>
	<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a><br>
		<h1>会員情報変更</h1><br>
		
		<div class="tableCeter">
			<font color="red">${ChangeMessage}</font>
			<table border="1">
				<tr><td>会員ID</td><td>氏名</td><td>郵便番号</td><td>住所</td><td>携帯電話</td><td>メールアドレス</td><td>生年月日</td><td>入会年月日</td><td>退会年月日</td><td>最終情報更新日時</td></tr>
				<tr>
						<td>${sessionScope.menberInfo.iID}</td>
						<td>${sessionScope.menberInfo.strName}</td>
						<td>${sessionScope.menberInfo.post_no}</td>
						<td>${sessionScope.menberInfo.address}</td>
						<td>${sessionScope.menberInfo.tel}</td>
						<td>${sessionScope.menberInfo.mail}</td>
						<td>${sessionScope.menberInfo.birthday}</td>
						<td>${sessionScope.menberInfo.join_date}</td>
						<td>${sessionScope.menberInfo.secede_date}</td>
						<td>${sessionScope.menberInfo.update_date}</td>
				</tr>
			</table>
		</div>
		
		<br><h2>変更する内容を入力してください</h2><br>
		<form action="../ChangeUserInfoConf" method="post">
			<table border="1" >
				<tr><td>氏名</td><td><input type="text" name="inputName" value='${sessionScope.inputName}'></td></tr>
				<tr><td>郵便番号</td><td><input type="number" name="inputPost" value='${sessionScope.inputPost}' oninput="sliceMaxLength(this, 7)"></td></tr>
				<tr><td>住所</td><td><input type="text" name="inputAddress" value='${sessionScope.inputAddress}'></td></tr>
				<tr><td>電話番号</td><td><input type="text" name="inputTel" value='${sessionScope.inputTel}'></td></tr>
				<tr><td>E-mail</td><td><input type="text" name="inputMail" value='${sessionScope.inputMail}'></td></tr>
				<tr><td>生年月日</td><td><input type="date" name="inputBirthday" value='${sessionScope.inputBirthday}'></td></tr>
			</table>
			<input type="button" value="戻る" onclick="location.href='/LibraryProject/menberInfo/UserInfoSertch.jsp'"><input type="button" onclick="submit();" value="変更" >
		</form>
	</body>
</html>