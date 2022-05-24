<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>変更内容確認</title>
	</head>
	<body>
		<div class="tableCeter">
			<table border="1"class="tableCeter">
				<tr><td>会員ID</td><td>氏名</td><td>生年月日</td><td>入会年月日</td><td>退会年月日</td><td>最終情報更新日時</td></tr>
				<tr>
						<td>${user.iID}</td>
						<td>${user.strName}</td>
						<td>${user.birthday}</td>
						<td>${user.join_date}</td>
						<td>${user.secode_date}</td>
						<td>${user.update_date}</td>
				</tr>
			</table>
		</div>
	</body>
</html>