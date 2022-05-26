<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lead Comp</title>

<style>
	#text { text-align : center ; }
</style>

</head>
<body>

	<h1 style="text-align : center">貸出が完了しました。</h1>
	
	<div id="text">
	<form action="/LibraryProject/lendingBook/LendingReturn.jsp"  method=post>
	 <input type="submit" name="return" value="貸出・返却に戻る">
	 </form>
	</div>
	
</body>
</html>