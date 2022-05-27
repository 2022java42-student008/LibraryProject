<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
	page import="java.time.LocalDate"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockAdd</title>
<link href="StockAdd.css" rel="stylesheet">
</head>

<body>

	<div class="leftmargin">
		<a href="../TopMenu.html">トップメニュー</a>
	</div>

	<div class="centermargin">
		<h1 style="text-align: center">資料登録</h1>
	</div>

	<!--↓ここから入力フォーム-->

	<form action="/LibraryProject/StockAddServlet" method="post">
		ISBN番号 <input type="text" placeholder="ISBN番号を入力" name="ISBN"size="15" maxlength="13" required> <br> 
		資料名 <input type="text" placeholder="資料名を入力" name="title" size="80" required> <br> 
		著者名 <input type="text" placeholder="著者名を入力" name="author" size="50" required> <br>
		出版社 <input type="text" placeholder="出版者名を入力" name="publisher"size="50" required> <br> 
		出版年月日 <input type="date"placeholder="出版年月日を入力" name="publish_date" required> <br>
		入荷年月日 <input type="date" placeholder="入荷年月日を入力" name="arrivalDate" value=<%= LocalDate.now() %> required> <br>


		分類コード <select name="code" >
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
		</select>
		
		 <br>
		 
		  備考 <input type="text" placeholder="備考を入力" name="remarks"
			size="80"> <input type="hidden" name=action value="conf">



		<br>


		<div class="next">
			<input type=submit name="return" value="次へ">
		</div>
	</form>
	<br>

	<div class="return">
		<input type="button" onclick="location.href='./StockMenu.html'"
			name="return" value="資料管理メニューへ戻る">
	</div>
</body>
</html>