<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
	page import="java.time.LocalDate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockAdd</title>
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


<div class="contact">

	<form action="/LibraryProject/StockAddServlet" method="post">
		<table class="contact-table"></table>

		<tr>
			<th class="contact-item"></th>
			<td class="contact-body"></td>
		</tr>

		<tr>
			<th class="contact-item">ISBN番号</th>
			<td class="contact-body"><input type="text"
				placeholder="ISBN番号を入力" name="ISBN" class="form-text" maxlength="13"
				required></td>	<td>
		
		<th class="contact-item">資料名</th>
		<td class="contact-body"><input type="text" placeholder="資料名を入力"
			name="title" class="form-text" required></td>
		</tr>
		<th class="contact-item">著者名</th>
		<td class="contact-body"><input type="text" placeholder="著者名を入力"
			name="author" class="form-text" required></td>
		</tr>
		<th class="contact-item">出版社</th>
		<td class="contact-body"><input type="text" placeholder="出版社名を入力"
			name="publisher" class="form-text" required></td>
		</tr>
		<th class="contact-item">出版年月日</th>
		<td class="contact-body"><input type="date" name="publish_date"
			class="form-text" required></td>
		</tr>
		<th class="contact-item">入荷年月日</th>
		<td class="contact-body"><input type="date" name="arrival_date"
			class="form-text" value=<%=LocalDate.now()%> required></td>
		</tr>
		<th class="contact-item">分類コード</th>
		<td class="contact-body"><select name="code">
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
		</select></td>
		<th class="contact-item">備考</th>
		<td class="contact-body"><input type="text" placeholder="備考を入力"
			name="publisher" class="form-text"></td>
		</tr>


		<input type="hidden" name=action value="conf">

	
	</form>

	<br>



	<div class="next">
		<input type=submit name="return" value="次へ">
	</div>

	<br>

	<div class="return">
		<input type="button" onclick="location.href='./StockMenu.html'"
			name="return" value="資料管理メニューへ戻る">
	</div>
	</div>
</body>
</html>