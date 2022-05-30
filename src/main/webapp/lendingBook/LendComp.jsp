<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lead Comp</title>

<style>
	#text { text-align : center ; }
	.retu{background-color:#98fb98; border-radius: 10%;}
	p.small{line-height:190px; }
</style>

</head>
<body>

<p class="small"><br></p>

	<h1 style="text-align : center"> 貸出が完了しました。</h1>
	
	<div id="text">
	 <form action="/LibraryProject/lendingBook/LendingReturn.jsp"  method=post>
		 <input type="submit" class="retu" name="return" value="貸出・返却に戻る">
	 </form>
	</div>

</body>
</html>