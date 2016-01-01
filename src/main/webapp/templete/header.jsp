<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Header</title>
</head>
<body>
	<div id="container">
		<div align="right">
			<a href="index.jsp" style="text-decoration: none"><font size="-1"
				style="font-family: '微軟正黑體', Calibri">回首頁</font></a>&nbsp;&nbsp;|&nbsp;
			<a href="http://www.fju.edu.tw/#&panel1-2"
				style="text-decoration: none"><font size="-1"
				style="font-family: '微軟正黑體', Calibri">輔仁大學</font></a>&nbsp;&nbsp;|&nbsp;
			<a href="http://english.im.fju.edu.tw/" style="text-decoration: none"><font
				size="-1" style="font-family: '微軟正黑體', Calibri">English</font></a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<c:choose>
				<c:when test="${Login==true}">
					<a href="Login" style="text-decoration: none"><font size="-1"
						style="font-family: '微軟正黑體', Calibri">登出</font></a>
				</c:when>
				<c:when test="${Login!=true}">
					<a href="Login" style="text-decoration: none"><font size="-1"
						style="font-family: '微軟正黑體', Calibri">登入</font></a>
				</c:when>
			</c:choose>
		</div>
		<div>
			<a href="index.jsp" title="天主教輔仁大學"><img src="https://imwebegroupservice.storage.googleapis.com/%E8%B3%87%E7%AE%A1%E7%B3%BB.png" /></a>
		</div>
	</div>
	<ul id="nav">
		<li><a href="IMIntro">
			<font style="font-family: '微軟正黑體', Calibri">系所簡介</font></a></li>
		<li><a href="Teacher">
			<font style="font-family: '微軟正黑體', Calibri">師資陣容</font></a></li>
		<li><a href="Course">
			<font style="font-family: '微軟正黑體', Calibri">課程規劃</font></a></li>
		<li><a href="Q&A">
			<font style="font-family: '微軟正黑體', Calibri">Q&A</font></a></li>
<!-- 	<li><a href="">
			<font style="font-family: '微軟正黑體', Calibri">網站地圖</font></a></li>  -->
	</ul>
</body>
</html>