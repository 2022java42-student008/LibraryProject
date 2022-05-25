<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page 	import="java.time.LocalDate"
       		import="java.time.format.DateTimeFormatter"
       %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#text { text-align : center ; }
</style>
</head>
<body>

<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a>

		<div id="text"><h1>貸出履歴</h1></div>

<br>

<<<<<<< Updated upstream
<form action="/LibraryProject/HistoryBookServlet">
=======
<form action="/LibraryProject/LendBookServlet"></form>
>>>>>>> Stashed changes

<div id="text">
<input type="text" display="inline-block"  name="search">

  <select display="inline-block"  name="ID">
    <option value="1">会員ID</option>
    <option value="2">資料ID</option>
  </select>
   <input type="hidden" name="action" value="history">
   <input type="submit" name="return" value="検索" size="5">
<<<<<<< Updated upstream
   
=======
>>>>>>> Stashed changes
  
</div>
</form>


<br>
<br>

<table border="1"  align="center">
 		<tr bgcolor="#ffe4c4"><th>会員ID</th><th>資料ID</th><th>資料名</th><th>貸出年月日</th><th>返却期日</th>
 		<th>返却年月日</th><th>備考</th></tr>
<c:forEach items=${"historys".rental} var="rental">
		<tr><td>${rental.user_id}</td><td>${rental.book_id}</td><td>${rental.title}</td><td>${rental.rental_date}</td><td>${rental.fixed_date}</td><td>${rental.return_date}<td>${book.remarks}</td></tr>
</c:forEach>
</table>

</body>
</html>