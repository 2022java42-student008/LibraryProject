<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>returndiscriminant</title>
<link href="css/ReturnCompleted.css" rel="stylesheet">
</head>
<body>

	<a href="TopMenu.html" class="btn">トップメニュー</a>

<br><br>

	<form action="/LibraryProject/ReturnCompletedServlet" method="post">
		<div class="centermargin">
			<h1>返却</h1>
			
			会員情報
			<table border="1" align="center">
				<tr>
					<th align="center">会員ID</th>
					<th align="center">${sessionScope.menberInfo.iID }</th>
				</tr>
				<tr>
					<th align="center">氏名</th>
					<th align="center">${sessionScope.menberInfo.strName}</th>
				</tr>
			</table>


<br>
			

			貸出状況
			<table border="1" align="center">
				<tr>
					<th >資料ID</th>
					<th >ISBN番号</th>
					<th >資料名</th>
					<th >貸出年月日</th>
					<th >返却期日</th>
				</tr>



				<c:forEach items="${rental}" var="book" varStatus="stat">

					<tr>

						<th>${book.iBookID}</th>
						<th>${book.isbn}</th>
						<th>${book.title}</th>
						<th>${book.dRentalDate}</th>
						<th>${book.dFixedDate}</th>

					</tr>

				</c:forEach>



			</table>

			<h3>上記の資料を返却します。</h3>

			<input type="submit" value="戻る" formaction="ReturnScreen.jsp">
			<input type="hidden" name="action" value="comp">
			<input type="submit" value="返却">

		</div>
	</form>

</body>
</html>