<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>登入</title>
<style>
body {
	background-color: #FFF;
}
</style>
<link href="css/CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="../../templete/header.jsp" %>
	<div id="container">
		<div style="padding-top: 50px" align="center">
			<!-- content -->

			<form style="background-color: #D9FFD9" method="post" action="Login">
				<div style="font-family: '微軟正黑體', Calibri">
					<br /> <br /> <input type="radio" name="identity" value="student"><font
						color="#000066">學生</font> <input type="radio" name="identity"
						value="graduate"><font color="#000066">校友</font> <input
						type="radio" name="identity" value="secretary"><font
						color="#000066">系秘</font> <br> <br> <font
						color="#000066">帳號：</font>&nbsp;<input type="text" name="id"><br>
					<br> <font color="#000066">密碼：</font>&nbsp;<input
						type="password" name="password"><br> <br>
					<button type="submit">登入</button>
					<br> <br />
				</div>
			</form>

			<br> <br> <br>
		</div>
		<!-- content fin -->

		<div id="footer">
			
		<hr/>
		<div align="center">
			<font size="-1" color="#003366" style="font-family: '微軟正黑體', Calibri">Copyright
				(c) 2015 Fu-Jen Catholic University Institute of Information
				Management. All Rights Reserved.</font> <br> <br>
		</div>
	</div>
	</div>
	<!-- container fin -->


</body>
</html>
