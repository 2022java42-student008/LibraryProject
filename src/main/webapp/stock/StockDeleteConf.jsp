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

		<c:forEach items="${searchResult}" var="item">;
    
     
     <tr>
				<td align="center" bgcolor="#CCCCFF">資料ID</td>
				<th>${item.book_id}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">ISBN番号</td>
				<th>${item.isbn}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">資料名</td>
				<th>${item.title}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">著者名</td>
				<th>${item.author}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">分類コード</td>
				<th>${item.code}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">出版社</td>
				<th>${item.publisher}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">出版日</td>
				<th>${item.publishDate}</th>
			</tr>
			<tr>
				<td align="center" bgcolor="#CCCCFF">備考</td>
				<th>${item.remarks}</th>
			</tr>


		</c:forEach>

	</table>
	<br>
	<c:if test ="${not empty item.discardDate}" >
	
	
	<div id="text">
		<p>上記の資料を削除します。</p>
		<p>（削除すると在庫台帳に廃棄年月日が記録されます）</p>
		<br>
		<p>よろしければ以下に削除理由を入力し、確認画面へ進んでください。</p>
	</div>

	<form action="/LibraryProject/StockDeleteServlet" method="post">
		<input type="text" placeholder="削除理由を入力" name="DeleteReason" size="80">
		<input type="hidden" name="action" value="conf"> <input
			type="submit" value="確認画面へ">
	</form>
	
	</c:if>
	
	<br>




	<div class="return" align="center">
	<form action=/LibraryProject/stock/StockDelete.html>
		<input type="submit"name="return" value="戻る">
    </form>


	</div>


	<br>

	<div class="return" align="center">
		<input type="button" onclick="location.href='./StockMenu.html'"
			name="return" value="資料管理メニューへ戻る">
	</div>

</body>
</html>