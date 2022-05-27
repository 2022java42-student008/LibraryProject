<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.time.LocalDate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockAdd</title>
<style>
#text {
	text-align: center;
}
</style>
<link rel="stylesheet" type="text/css" href="./css/StockAdd.css">
</head>

<body>

	<div class="leftmargin">
		<a href="../TopMenu.html">トップメニュー</a>
	</div>

	<div class="centermargin">
		<h1 style="text-align: center">資料登録</h1>
	</div>

	<!--↓ここから入力フォーム-->
	<div class="box">
		<form action="/LibraryProject/StockAddServlet" method="post">
			<label for="isbn">ISBN番号</label> 
				<input type="text"placeholder="ISBN番号を入力" name="ISBN" size="15" maxlength="13"required align="center" value='${bookinfo2.isbn}'> <br> <br> 
			<label for="bookname">資料名</label> 
				<input type="text" placeholder="資料名を入力"name="title" size="80" required value='${bookinfo2.title}'> <br> <br> 
			<label for="author">著者名</label> 
				<input type="text" placeholder="著者名を入力" name="author" size="50" required value='${bookinfo2.author}'> <br> <br> 
			<label for="publisher">出版社</label> 
				<input type="text" placeholder="出版者名を入力" name="publisher" size="50" required value='${bookinfo2.publisher}'> <br> <br>
			<label for="publishdate">出版年月日</label> 
				<input type="date" placeholder="出版年月日を入力" name="publish_date" required value='${bookinfo2.publishDate}'> <br><br> 
			<label for="arrivaldate">入荷年月日</label> 
				<input type="date" placeholder="入荷年月日を入力" name="arrivalDate" value=<%=LocalDate.now()%> required> <br> <br> 
			<label for="code">分類コード</label> 
				<select name="code">
					<c:forEach var="i" begin="0" end="9" step="1">
						<c:if test="${bookinfo2.code == i}">
							<option value=${i} selected>${i}</option>
						</c:if>
						<c:if test="${bookinfo2.code != i}">
							<option value=${i}>${i}</option>
						</c:if>
						
					</c:forEach>
			</select> <br> <br> <label for="arrivaldate">備考</label> 
			<input type="text" placeholder="備考を入力" name="remarks" size="80">
			<input type="hidden" name="action" value="conf">
	


	<br>


	<div id="text">
		<input type=submit name="return" value="次へ"> <br> <br>
		</div>
		<div id="text">
			<div class="return">
				<input type="button" onclick="location.href='./StockMenu.html'"
					name="return" value="資料管理メニューへ戻る">
				</form>
			</div>
		</div>
</body>
</html>