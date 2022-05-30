<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="/LibraryProject/menberInfo/css/UserInfoStyle.css" rel="stylesheet">
	</head>
	<body>
		<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a><br>
		<h1 class="centermargin">退会処理</h1>
		
		<div class="tableCeter">
		<div class="centermargin">会員情報</div>
			<table border="1"class="tableCeter">
				<tr><td>会員ID</td><td>氏名</td><td>郵便番号</td><td>住所</td><td>携帯電話</td><td>メールアドレス</td><td>生年月日</td><td>入会年月日</td><td>退会年月日</td><td>最終情報更新日時</td></tr>
				<tr>
						<td align="center">${sessionScope.menberInfo.iID}</td>
						<td>${sessionScope.menberInfo.strName}</td>
						<td>${sessionScope.menberInfo.post_no}</td>
						<td>${sessionScope.menberInfo.address}</td>
						<td>${sessionScope.menberInfo.tel}</td>
						<td>${sessionScope.menberInfo.mail}</td>
						<td>${sessionScope.menberInfo.birthday}</td>
						<td>${sessionScope.menberInfo.join_date}</td>
						<td>${sessionScope.menberInfo.secede_date}</td>
						<td>${sessionScope.menberInfo.update_date}</td>
				</tr>
			</table>
		</div>
		
		<br>
		
		<div class="centermargin">貸出状況<br></div>
		<table border="1" class="tableCeter">
			<tr><td>在庫ID</td><td>ISBN番号</td><td>資料名</td><td>貸出年月日</td><td>返却期日</td></tr>
			<c:forEach items="${ sessionScope.rentalInfo }" var="rental" >
				<tr><td style="color:red" align="center">${rental.iBookID}</td><td style="color:red">${rental.isbn}</td><td style="color:red">${rental.title}</td><td style="color:red">${rental.dRentalDate}</td><td style="color:red">${rental.dReturnDate}</td></tr>
			</c:forEach>
		</table>
		
		<br>
		
		<div class="centermargin">
			<form action="/LibraryProject/UserDeleteServlet" method="post">
			<c:if test="${sessionScope.canDelete == true}">
				本当に退会してもよろしいですか？<br>
			</c:if>
			
			<br>
			
				<input type="submit" value="戻る" formaction="/LibraryProject/menberInfo/UserInfoSertch.jsp">
				<c:if test="${sessionScope.canDelete == true}">
					<input type="submit" value="退会" >
				</c:if>
			</form>
		</div>
	</body>
</html>