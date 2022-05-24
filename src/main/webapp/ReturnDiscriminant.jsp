<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>returndiscriminant</title>
<link href="css/ReturnCompleted.css" rel="stylesheet">
</head>
<body>

	<a href="TopMenu.html" class="btn">トップメニュー</a>



	<form action="ReturnCompleted.html" method="post">
		<div class="centermargin">
			<h1>返却</h1>
			<table border="1">
				<tr>
					<th>会員ID</th>
					<th width="300"></th>
				</tr>
				<tr>
					<th>氏名</th>
					<th width="300"></th>
				</tr>
			</table>





			<table border="1">
				<tr>
					<th width="150">資料ID</th>
					<th width="150">ISBN番号</th>
					<th width="150">資料名</th>
					<th width="150">貸出年月日</th>
					<th width="150">返却期日</th>
				</tr>


			
					<c:forEach items="${stat.count }" var="book" varStatus="stat">

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

			<input type="submit" value="戻る" formaction="ReturnScreen.jsp"> <input
				type="submit" value="返却">

		</div>
	</form>

</body>
</html>