<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReturnScreen</title>
<link href="css/ReturnCompleted.css" rel="stylesheet">
<style>
	#text { text-align : center ; }
</style>
</head>
<body>

	<a href="/LibraryProject/TopMenu.html" class="btn">トップメニュー</a>


<div id="text">
	<form action="../SerchInfoUser" method="post">
		<div>
			<h1>貸出・返却</h1>


			E-mail <input type="text" name="menberMail" > <input
				type="submit" value="検索">
		</div>
	</form>
</div>

<br>

		<table border="1" align="center">

			<tr>
				<td align="center">会員ID</td>
				<td align="center">${sessionScope.menberInfo.iID}</td>
			</tr>
			<tr>
				<td align="center">氏名</td>
				<td align="center">${sessionScope.menberInfo.strName}</td>
			</tr>

		</table>
	


	<form action="../ReturnScreen.jsp" method="post">
		<input type="hidden" name="userID" value=${menberInfo.iID}> <input
			type="hidden" name="userName" value=${menberInfo.strName}>

<br>

		<div>
			<table border="1" align="center">



				<tr>
					<th width="150">資料ID</th>
					<th width="150">ISBN番号</th>
					<th width="150">資料名</th>
					<th width="150">貸出年月日</th>
					<th width="150">返却期日</th>
				</tr>

				<c:forEach items="${sessionScope.rentalInfo}" var="book"
					varStatus="stat">

					<tr>

						<th>${book.iBookID}</th>
						<th>${book.isbn}</th>
						<th>${book.title}</th>
						<th>${book.dRentalDate}</th>
						<th>${book.dFixedDate}</th>

					</tr>

				</c:forEach>
			</table>
<br>
<div id="text">
			<c:if test="${not empty sessionScope.menberInfo }">
				<input type="submit" value="貸出" formaction="LendBook.jsp" > 
				<c:if test="${ not empty sessionScope.rentalInfo }">
					<input type="submit" value="返却" >
				</c:if>
			</c:if>
			</div>
		</div>
	</form>


</body>
</html>