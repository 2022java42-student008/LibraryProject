<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

 <%@page import="bean.RentalBean" %>
 <%@page import="java.util.List" %>
 <% List<RentalBean> rentalBook = (List<RentalBean>)session.getAttribute("rentalInfo");
 	int size = rentalBook.size();
 %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lendbook</title>
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
	
 <table border="1" width="200px" align="center">
 	 <tr><td align="center"  bgcolor="#f0e68c"> 会員ID </td><th>${sessionScope.menberInfo.iID}</th></tr>
 	 <tr><td align="center"  bgcolor="#f0e68c" > 氏名 </td><th>${sessionScope.menberInfo.strName}</th></tr>
 </table>
 
 <font size="4" face="ＭＳ Ｐ明朝,ＭＳ 明朝"><br>
		<div id="text"> 貸し出す資料ID</div>
 </font>

<div id="text">
<form action ="/LibraryProject/LendBookServlet" method="post">

<%
    for (int i = 0; i < 5 - size ; i++) {
%>
    <div id="text"> <input type="text" name="lend" ></div>
<%
    }
%>

<br>

<div id="text">
	<input type="submit" formaction="/LibraryProject/lendingBook/LendingReturn.jsp" name="return" value="戻る"size="5">	
	<%if(size < 5 && size >= 0 ){ %>
	<input type="submit"  name="lending" value="確認" size="5">
	<%} %>
	<input type="hidden" name="action" value="seach">
</div>
 </form> 
 
 

</body>
</html>