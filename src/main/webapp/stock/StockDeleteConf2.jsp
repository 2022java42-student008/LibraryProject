<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockDeleteConf</title>
<link href="StockSearch.css" rel="stylesheet">
<style>
#text {
	text-align: center;
}
</style>
</head>
<body>

	<div class="leftmargin">
		<a href="/LibraryProject/TopMenu.html">トップメニュー</a>
	</div>


	<div class="centermargin">
		<h1 style="text-align: center">資料削除</h1>
	</div>

	<br>


	<table border="1" align="center">


			<tr>
				<td align="center" bgcolor="#CCCCFF">資料ID</td>
				<th>${searchResult.book_id}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">ISBN番号</td>
				<th>${searchResult.isbn}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">資料名</td>
				<th>${searchResult.title}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">著者名</td>
				<th>${searchResult.author}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">分類コード</td>
				<th>${searchResult.code}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">出版社</td>
				<th>${searchResult.publisher}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">出版日</td>
				<th>${searchResult.publishDate}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">備考</td>
				<th>${searchResult.remarks}</th>
			</tr>


	</table>

	<br>

	<!--削除理由の表示-->
	<table border="1" align="center">
		<tr>
			<td align="center" bgcolor="#E5E4E2">削除理由</td>
			<th>${reason}</th>
		</tr>
	</table>


	<div id="text">
		<p>削除する資料の最終確認です。</p>
		<p>上記の資料を削除してよろしいですか？</p>
	</div>






	<div class="return" align="center">
		<input type="button"
			onclick="location.href='/LibraryProject/stock/StockDeleteConf.jsp'"
			name="return" value="戻る">
		
		<br><br>
		
		<form action="/LibraryProject/StockDeleteServlet?action=DeleteComp"
			method="post">
			<input type="submit" value="削除確定">
		</form>
	</div>

	<br>

	<div class="return" align="center">
		<input type="button" onclick="location.href='/LibraryProject/stock/StockMenu.html'"
			name="return" value="資料管理メニューへ戻る">
	</div>

</body>
</html>