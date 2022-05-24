<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div { text-align : center ; }
</style>
</head>
<body>

<a href="/LibraryProject/TopMenu.html?Top">トップメニュー</a>

		<div><h1>貸出履歴</h1></div>

<br>

<div>
<input type="text" display="inline-block"  name="search">

  <select display="inline-block"  name="ID">
    <option value="1">会員ID</option>
    <option value="2">資料ID</option>
  </select>
  
   <input type="submit" name="return" value="検索" size="5">
</div>


<br>
<br>

<table border="1" width="50%" align="center">
 		<tr bgcolor="#ffe4c4"><th>会員ID</th><th>資料ID</th><th>貸出年月日</th><th>返却期日</th>
 		<th>返却年月日</th><th>備考</th></tr>
 		<c:forEach >
 		
 		</c:forEach>
</table>

</body>
</html>