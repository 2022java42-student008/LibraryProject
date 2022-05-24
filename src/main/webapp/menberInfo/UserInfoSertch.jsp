<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>会員検索</title>
		<style>
			.centermargin 
			{
				position: relative;
				text-align: center;
			}
			.tableCeter{margin : auto;}
			
		</style>
	</head>
	<body>
	<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a>
		<h2 class="centermargin">会員情報</h2>
		<form action="../SerchInfoUser" method="post" class="centermargin">
			e-Mail : <input type="text" name="menberMail" placeholder=${sessionScope.sertch}">
			<input type="submit" value="検索">
		</form>
		
		<div class="tableCeter">
			<table border="1"class="tableCeter">
				<tr><td>会員ID</td><td>氏名</td><td>生年月日</td><td>入会年月日</td><td>退会年月日</td><td>最終情報更新日時</td></tr>
				<tr>
						<td>${sessionScope.menberInfo.iID}</td>
						<td>${sessionScope.menberInfo.strName}</td>
						<td>${sessionScope.menberInfo.birthday}</td>
						<td>${sessionScope.menberInfo.join_date}</td>
						<td>${sessionScope.menberInfo.secode_date}</td>
						<td>${sessionScope.menberInfo.update_date}</td>
				</tr>
			</table>
		</div>
		
		<c:if test="${not empty menberInfo}">
			<div class="centermargin">
				<form action="ChangeUserInfo" method="post">
					<input type="submit" value="変更" >
					<input type="submit" value="削除"formaction="DeleteUser">
				</form>
			</div>
		</c:if>
		
		<br>
		
		<div class="centermargin">貸出状況<br></div>
		<table border="1" class="tableCeter">
			<tr><td>在庫ID</td><td>ISBN番号</td><td>資料名</td><td>貸出年月日</td><td>返却期日</td></tr>
			<c:forEach items="${ sessionScope.rentalInfo }" var="rental">
				<tr><td>${rental.iBookID}</td><td>${rental.isbn}</td><td>${rental.title}</td><td>${rental.dRentalDate}</td><td>${rental.dReturnDate}</td></tr>
			</c:forEach>
		</table>
	</body>
</html>