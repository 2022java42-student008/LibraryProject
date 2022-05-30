<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>変更内容確認</title>
		<style>
#text {
	text-align: center;
}
</style>
		<link href="css/UserInfoStyle.css" rel="stylesheet">
	</head>
	<body>
	<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a><br>
	<h1 style="text-align: center">変更内容確認</h1>
		<div class="tableCeter">
		<br>
			<table border="1"align="center">
				<tr><td>会員ID</td><td>氏名</td><td>郵便番号</td><td>住所</td><td>電話番号</td><td>メールアドレス</td><td>生年月日</td><td>入会年月日</td><td>退会年月日</td><td>最終情報更新日時</td></tr>
				<tr>
						<td align ="center">${sessionScope.user.iID}</td>
						<td>${sessionScope.user.strName}</td>
						<td>${sessionScope.user.post_no}</td>
						<td>${sessionScope.user.address}</td>
						<td>${sessionScope.user.tel}</td>
						<td>${sessionScope.user.mail}</td>
						<td>${sessionScope.user.birthday}</td>
						<td>${sessionScope.user.join_date}</td>
						<td>${sessionScope.user.secede_date}</td>
						<td>${sessionScope.user.update_date}</td>
				</tr>
			</table>
		</div>
		
		<h2 style="text-align: center">上記の内容で変更して宜しいでしょうか?</h2>

		<div class="centermargin">
	
			<form action="/LibraryProject/BackUserInfo" method="post">
			
			<div id="text">
				<input type="submit" value="戻る" >
				<input type="submit" value="変更" formaction="ChangeUserInfoComp">
			
			</div>
			</form>
		</div>
		
	</body>
</html>