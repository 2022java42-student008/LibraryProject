<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="css/UserInfoStyle.css" rel="stylesheet">
	</head>
	<body>
		<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a><br>
		<h1 class="centermargin">退会処理</h1>
		<div class="tableCeter">
		会員情報<br>
			<table border="1"class="tableCeter">
				<tr><td>会員ID</td><td>氏名</td><td>郵便番号</td><td>住所</td><td>携帯電話</td><td>メールアドレス</td><td>生年月日</td><td>入会年月日</td><td>退会年月日</td><td>最終情報更新日時</td></tr>
				<tr>
						<td>${sessionScope.menberInfo.iID}</td>
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
		
	</body>
</html>