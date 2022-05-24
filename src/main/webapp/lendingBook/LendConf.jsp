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
<title>LendConf</title>

<style>
	div { text-align : center ; }
</style>
</head>
<body>

<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a>

		<div><h1>貸出</h1></div>
	
	
	<font size="4" face="ＭＳ Ｐ明朝,ＭＳ 明朝">	
		<div>会員情報</div>
	</font>
	
 <table border="1" width="7%" align="center">
 <div>
 	 <tr><td  align="center" bgcolor="#f0e68c"> 会員ID</td><th></th></tr>
 	 <tr><td align="center" bgcolor="#f0e68c"> 資料ID </td><th></th></tr>
 </div>
 </table>
 
 <br>
 <br>
 
   <font size="4" face="ＭＳ Ｐ明朝,ＭＳ 明朝">
		<div> 貸し出す資料ID</div>
 </font>

	<table border="1" width="50%" align="center">
 		<tr bgcolor="#ffe4c4"><th>資料ID</th><th>ISBN番号</th><th>資料名</th><th>貸出年月日</th><th>返却期日</th><th>備考</th></tr>
<c:forEach items="${books}" var="book">
 		<tr><td>${book.book_id}</td><td>${book.isbn}</td><td>${book.title}</td><td><%= LocalDate.now() %></td><td>${book.discar_date}</td><td>${book.remarks}</td></tr>
</c:forEach>
    </table>

<br>

 <form action="/LibraryProject/LendBookServlet" method="post">
 <div>
	<input type="button"  onclick="location.href='/lendingBook/LendBook.jsp'"  display="inline-block"  name="return" value="戻る"  size="5">
	<input type="submit"  display="inline-block" name="return" value="貸出"  size="5"> 	
			<input type="hidden" name="action" value="rentaldate">
  </div>
  </form>
 

</body>
</html>