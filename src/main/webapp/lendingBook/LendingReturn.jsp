<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReturnScreen</title>
<link href="css/ReturnCompleted.css" rel="stylesheet">
</head>
<body>

	<a href="/LibraryProject/TopMenu.html" class="btn">トップメニュー</a>



	<form action="../SerchInfoUser" method="post">
		<div class="centermargin">
			<h1>貸出・返却</h1>


			E-mail <input type="text" name="menberMail">
		</div>
		<input type="submit" value="検索">
	</form>



	<table border="1">
		<tr>
			<td>会員ID</td>
			<td>${sessionScope.menberInfo.iID}</td>
		</tr>
		<tr>
			<td>氏名</td>
			<td>${sessionScope.menberInfo.strName}</td>
		</tr>
	</table>


	<form action="../ReturnScreen.jsp" method="post">
		<input type="hidden" name="userID" value=${menberInfo.iID}> <input
			type="hidden" name="userName" value=${menberInfo.strName}>

		<div>
			<table border="1">



				<tr>
					<th width="150">資料ID</th>
					<th width="150">ISBN番号</th>
					<th width="150">資料名</th>
					<th width="150">貸出年月日</th>
					<th width="150">返却期日</th>
				</tr>

				<c:forEach items="${sessionScope.rentalInfo}" var="book" varStatus="stat">

					<tr>
					
						<th>${book.iBookID}</th>
						<th>${book.isbn}</th>
						<th>${book.title}</th>
						<th>${book.dRentalDate}</th>
						<th>${book.dFixedDate}</th>

					</tr>

				</c:forEach>
			</table>



			<input type="submit" value="貸出" formaction="LendBook.jsp">
			 <input type="submit" value="返却">
		</div>
	</form>

</body>
</html>