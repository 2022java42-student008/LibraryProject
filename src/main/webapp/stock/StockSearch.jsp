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
  <input type="search" name="BookID" placeholder="資料IDを入力">
  <input type="submit" name="submit" value="検索">
</form>



<table border="1" align="center">
     
     <c:forEach  items="${searchResult}" var = "item">;
    
     
     <tr><td align="center"  bgcolor="#CCCCFF"> 資料ID</td><th>${item.book_id}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> ISBN番号</td><th>${item.isbn}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 分類コード</td><th>${item.code}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 資料名</td><th>${item.title}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 著者名</td><th>${item.author}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 出版社</td><th>${item.publisher}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 出版日</td><th>${item.publishDate}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 入荷年月日</td><th>${item.arrivalDate}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 削除年月日</td><th>${item.discardDate}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 備考</td><th>${item.remarks}</th></tr>
     
     <td>
     
     <table border="1" align="center">
<tr><td align="center"  bgcolor="#D9E5FF">同じ資料(ISBN番号)の在庫</td><th></th>
</table>

 </c:forEach>
 
</table>

<br>
<br>

<div class="return" align="center">
<input type="button" onclick="location.href='./StockMenu.html'" name="return" value="資料管理メニューへ戻る">	
</div>

</body>
</html>