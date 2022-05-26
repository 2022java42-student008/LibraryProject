<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page 	import="java.time.LocalDate"
       		import="java.time.format.DateTimeFormatter"
       %>
         <%@page import="bean.StockBean" %>
          <%@page import="java.util.List" %>
       <%  List<StockBean> discarBook = (List<StockBean>)session.getAttribute("books"); %>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LendConf</title>

<style>
	#text { text-align : center ; }
</style>
</head>
<body>

<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a>

		<div id="text"><h1>貸出</h1></div>
	
	
	<font size="4" face="ＭＳ Ｐ明朝,ＭＳ 明朝">	
		<div id="text">会員情報</div>
	</font>
	
 <table border="1"  align="center">
 <div id="text">
 	 <tr><td  align="center" bgcolor="#f0e68c"> 会員ID</td><th>${sessionScope.menberInfo.iID}</th></tr>
 	 <tr><td align="center" bgcolor="#f0e68c"> 氏名 </td><th>${sessionScope.menberInfo.strName}</th></tr>
 </div>
 </table>
 
 <br>
 <br>
 
   <font size="4" face="ＭＳ Ｐ明朝,ＭＳ 明朝">
		<div id="text"> 貸し出す資料ID</div>
 </font>

	<table border="1"  align="center">
 		<tr bgcolor="#ffe4c4"><th>資料ID</th><th>ISBN番号</th><th>資料名</th><th>貸出年月日</th><th>返却期日</th><th>備考</th></tr>
<c:forEach items="${books}" var="book">
 		<tr><td>${book.book_id}</td><td>${book.isbn}</td><td>${book.title}</td><td><%= LocalDate.now() %></td><td>${book.discar_date}</td><td>${book.remarks}</td></tr>
</c:forEach>
    </table>

<br>

 <form action="/LibraryProject/LendBookServlet" method="post">
 <div id="text">
	<input type="submit"  formaction="/LibraryProject/lendingBook/LendBook.jsp"  display="inline-block"  name="return" value="戻る"  size="5">
	
<c:if test="${not empty discarBook.discar_date}" > 
	<input type="submit"  display="inline-block" name="return" value="貸出"  size="5"> 	
</c:if>

			<input type="hidden" name="action" value="rentaldate">
  </div>
  </form>
 

</body>
</html>