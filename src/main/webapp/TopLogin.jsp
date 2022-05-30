<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン画面</title>
		<link rel="stylesheet" type="text/css" href="css/TopLogin.css">
		
		<style>
			p.small{line-height:120px; }
		</style>
	</head>
	<body>
	
	<p class="small"><br></p>
	
	<h1 class="s_center">図書管理システム</h1>
	<form action="TopLoginServlt" method="post">
	
			<p class="s_center">職員ID：<input type="number" name="id" required></p>
			<p class="s_id">パスワード：<input type="password" name="pass" required><br></p>
			<c:if test="${not empty loginConf || loginConf == false}">
				<p class="s_err">職員IDかパスワードが違います</p>
			</c:if>
			<p class="s_center"><input type="submit" value="ログイン">
		</form>
		
	</body>
</html>