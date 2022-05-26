<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReturnScreen</title>
<link href="/LibraryProject/lendingBook/ReturnCompleted.css"
	rel="stylesheet">
<style>
	#text { text-align : center ; }
</style>
</head>
<body>

	<a href="TopMenu.html" class="btn">トップメニュー</a>





	<div id="text">
		<h1>返却</h1>
	</div>
	
	
		<table border="1" align="center">
			<tr>
				<th align="center" >会員ID</th>
				<th  align="center" width="300">${sessionScope.menberInfo.iID }</th>
			</tr>
			<tr>
				<th align="center">氏名</th>
				<th align="center" width="300">${sessionScope.menberInfo.strName}</th>
			</tr>
		</table>
		
		<br>
		
		<div id="text">
		<form action="/LibraryProject/ReturnScreenServlet" method="post">
			<input type="hidden" name="userID"
				value=${sessionScope.menberInfo.iID}> <input type="hidden"
				name="userName" value=${sessionScope.menberInfo.strName}>

            <div >


			<table border="1"align="center">
				<tr>
					<th width="50" height="50"></th>
					<th width="150">資料ID</th>
					<th width="150">ISBN番号</th>
					<th width="150">資料名</th>
					<th width="150">貸出年月日</th>
					<th width="150">返却期日</th>
				</tr>






				<c:forEach items="${sessionScope.rentalInfo}" var="book"
					varStatus="stat">

					<tr>
						<td><input type="checkbox" name="return" value=${stat.index }></td>
						<th>${book.iBookID}</th>
						<th>${book.isbn}</th>
						<th>${book.title}</th>
						<th>${book.dRentalDate}</th>
						<th>${book.dFixedDate}</th>

					</tr>

				</c:forEach>



			</table>

<br>

			<input type="submit" value="戻る"
				formaction="/LibraryProject/lendingBook/LendingReturn.jsp">	
			<input type="submit" value="確認">
	</div>
	</form>
</div>

</body>
</html>