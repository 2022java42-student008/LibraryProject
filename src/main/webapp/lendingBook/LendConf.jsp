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
<title>Lend Conf</title>

<style>
	#text { text-align : center ; }
	.sub{background-color:#ffb6c1; border-radius: 10%;}
	.retu{background-color:#c0c0c0; border-radius: 10%;}
</style>
</head>
<body>

<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a>

<br><br>

		<div id="text"><h1>貸出</h1></div>
	
	

		<div id="text">会員情報</div>
	
	
 <table border="1"  align="center">
 <div id="text">
 	 <tr><td  align="center" bgcolor="#f0e68c"> 会員ID</td><th align="center">${sessionScope.menberInfo.iID}</th></tr>
 	 <tr><td align="center" bgcolor="#f0e68c"> 氏名 </td><th align="center">${sessionScope.menberInfo.strName}</th></tr>
 </div>
 </table>
 
 <br>
 <br>
 
 
		<div id="text"> 貸し出す資料ID</div>


	<table border="1"  align="center">
 		<tr bgcolor="#ffe4c4"><th>資料ID</th><th>ISBN番号</th><th>資料名</th><th>貸出年月日</th><th>返却期日</th><th>備考</th></tr>
<c:forEach items="${books}" var="book">
 		<tr><td  align="center">${book.book_id}</td><td>${book.isbn}</td><td>${book.title}</td><td><%= LocalDate.now() %></td><td>${book.discar_date}</td><td>${book.remarks}</td></tr>
</c:forEach>
    </table>



	<div id="text"><h3>上記の資料を貸出します。</h3></div>

<form action="/LibraryProject/LendBookServlet" method="post">
	<div id="text">
	<input type="submit"  formaction="/LibraryProject/lendingBook/LendBook.jsp"  display="inline-block"  name="return" value="戻る"  size="5" class="retu">
	
	<c:if test="${not empty books}">
		<input type="hidden" name="action" value="rentaldate">
		<input type="submit"  display="inline-block" name="return" value="貸出"  size="5" class="sub"> 
	</c:if>

			
  	</div>
</form>
 

</body>
</html>