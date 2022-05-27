<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

 <%@page import="bean.RentalBean" %>
 <%@page import="java.util.List" %>
 <% 
 	@SuppressWarnings("unchecked")
 	List<RentalBean> rentalBook = (List<RentalBean>)session.getAttribute("rentalInfo");
 	int size = rentalBook.size();
 %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lendbook</title>
<style>
	#text { text-align : center ; }
	.sub{background-color:#ffb6c1; border-radius: 10%;}
	.retu{background-color:#c0c0c0; border-radius: 10%;}
</style>
</head>
<body>

<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a>

	<div id="text"><h1>貸出</h1></div>

	
		<div id="text">会員情報</div>
	
	
 <table border="1"  align="center">
 	 <tr><td align="center"  bgcolor="#f0e68c"> 会員ID </td><th align="center">${sessionScope.menberInfo.iID}</th></tr>
 	 <tr><td align="center"  bgcolor="#f0e68c" > 氏名 </td><th align="center">${sessionScope.menberInfo.strName}</th></tr>
 </table>
 
 <br>
		<div id="text"> 貸し出す資料ID</div>


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
	<input type="button" onclick="location.href='/LibraryProject/lendingBook/LendingReturn.jsp'" name="return" value="戻る"size="5" class="retu">	
	<%if(size < 5 && size >= 0 ){ %>
	<input type="button" onclick="submit();"  name="lending" value="確認" size="5" class="sub">
	<%} %>
	<input type="hidden" name="action" value="seach">
</div>
 </form> 
 
 

</body>
</html>