<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockAddConf</title>
<style>
#text {
	text-align: center;
}
</style>
<link href="StockAdd.css" rel="stylesheet">
</head>
<body>

<div class="leftmargin">
	 <a href="/LibraryProject/TopMenu.html" >トップメニュー</a>
    </div>

<div class="centermargin">
    <h1 style="text-align:center">資料の登録(確認)</h1>
    </div>


<table border="1" align="center">
     
   
	 <tr><td align="center"  bgcolor="#CCCCFF"> 資料ID</td><th>${id}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> ISBN番号</td><th>${bookinfo1.isbn}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 資料名</td><th>${bookinfo1.title}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 著者名</td><th>${bookinfo2.author}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 分類コード</td><th>${bookinfo2.code}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 出版社</td><th>${bookinfo2.publisher}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 出版年月日</td><th>${bookinfo2.publishDate}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 入荷年月日</td><th>${bookinfo1.arrivalDate}</th></tr>
     <tr><td align="center"  bgcolor="#CCCCFF"> 備考</td><th>${bookinfo1.remarks}</th></tr>
</table>

<br>
<br>

<form action="/LibraryProject/StockAddServlet" method="post">
 <div class="enter">
 <div id="text">
 <input type="button" onclick="location.href='/LibraryProject/stock/StockAdd.jsp'" name="return" value="戻る" >	
<input type=submit name="enter" value="登録" >
<input type="hidden" name=action value="add">
	</form>
</div>
</div>

</body>
</html>