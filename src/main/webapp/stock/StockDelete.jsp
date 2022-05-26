<!-- 資料検索画面（004-002）-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockDelete</title>
<link href="StockSearch.css" rel="stylesheet">
</head>
<body>

<div class="leftmargin">
	 <a href="../TopMenu.html" >トップメニュー</a>
    </div>


<div class="centermargin">
    <h1 style="text-align:center">資料削除</h1>
    </div>

<br>

<!-- 削除する資料を検索フォーム -->
<form action="/LibraryProject/StockDeleteServlet?action=conf" method="post" align="center">
 資料ID
  <input type="search" name="BookID" placeholder="資料IDを入力">
  <input type="submit" name="action" value="検索">
</form>

<br>
<br>

<div class="return" align="center">
<input type="button" onclick="location.href='./StockMenu.html'" name="return" value="資料管理メニューへ戻る">	
</div>

</body>
</html>