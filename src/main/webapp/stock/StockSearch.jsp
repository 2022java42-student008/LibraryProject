<!-- 資料検索画面（004-002）-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockSearch</title>
<link href="StockSearch.css" rel="stylesheet">
</head>
<body>

<div class="leftmargin">
	 <a href="../TopMenu.html" >トップメニュー</a>
    </div>


<div class="centermargin">
    <h1 style="text-align:center">資料検索</h1>
    </div>

<br>


<form action="../StockSearchServlet" method="post" align="center">
 資料ID
  <input type="number" name="BookID" placeholder="資料IDを入力">
  <input type="submit" name="submit" value="検索">
</form>

<br>

<table border="1" align="center">
     <!--検索結果の表示 -->
    
     
     <tr><td align="center"  bgcolor="#CCCCFF"> 資料ID</td><th>${searchResult.book_id}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> ISBN番号</td><th>${searchResult.isbn}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 分類コード</td><th>${searchResult.code}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 資料名</td><th>${searchResult.title}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 著者名</td><th>${searchResult.author}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 出版社</td><th>${searchResult.publisher}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 出版年月日</td><th>${searchResult.publishDate}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 入荷年月日</td><th>${searchResult.arrivalDate}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 削除年月日</td><th>${searchResult.discardDate}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 備考</td><th>${searchResult.remarks}</th></tr>
     
     </table>
    <table border="1" align="center">
     
    <br>
     
<tr><td align="center"  bgcolor="#D9E5FF">同じ資料(ISBN番号)の在庫</td><th>
	<c:forEach items="${bookIDs}" var="bookID" varStatus="i">
		<a href="../StockSearchServlet?BookID=${bookID}">${bookID}</a> <c:if test="${i.last == false}"> ,</c:if> 
	</c:forEach>
</th>
</table>

<br>

<div class="return" align="center">
<input type="button" onclick="location.href='./StockMenu.html'" name="return" value="資料管理メニューへ戻る">	
</div>

</body>
</html>