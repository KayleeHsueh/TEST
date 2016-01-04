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
<link href="CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="container">
		<div align="right">
			<a href="HomePage" style="text-decoration: none"><font size="-1"
				style="font-family: '微軟正黑體', Calibri">回首頁</font></a>&nbsp;&nbsp;|&nbsp;
			<a href="http://www.fju.edu.tw/#&panel1-2"
				style="text-decoration: none"><font size="-1"
				style="font-family: '微軟正黑體', Calibri">輔仁大學</font></a>&nbsp;&nbsp;|&nbsp;
			<a href="http://english.im.fju.edu.tw/" style="text-decoration: none"><font
				size="-1" style="font-family: '微軟正黑體', Calibri">English</font></a>&nbsp;&nbsp;|&nbsp;&nbsp;
			${Login}
			<c:choose>
				<c:when test="/${Login!=null}">
					<a href="Login" style="text-decoration: none"><font size="-1"
						style="font-family: '微軟正黑體', Calibri">登出</font></a>
				</c:when>
				<c:otherwise>
					<a href="Login" style="text-decoration: none"><font size="-1"
						style="font-family: '微軟正黑體', Calibri">登入</font></a>
				</c:otherwise>
			</c:choose>

		</div>
		<div>
			<a href="HomePage"><img src="pics/Logo.PNG" onMouseOver=""></a>
			<br>
		</div>
	</div>
	<!--<img src="Flower.PNG" height=20% width="40%" align="right"/>-->
	<br>
	<ul id="nav">
		<li><a href="IMIntro"><font
				style="font-family: '微軟正黑體', Calibri">系所簡介</font></a></li>
		<li><a href="Teacher"><font
				style="font-family: '微軟正黑體', Calibri">師資陣容</font></a></li>
		<li><a href="Course"><font
				style="font-family: '微軟正黑體', Calibri">課程規劃</font></a></li>
		<li><a href="Q&A"><font style="font-family: '微軟正黑體', Calibri">Q&A
			</font></a></li>
		<li><a href=""><font style="font-family: '微軟正黑體', Calibri">網站地圖</font></a></li>
	</ul>
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
						color="#000066">帳號：</font>&nbsp;<input type="text" name="username"><br>
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
			<hr>
			<img
				src="https://imwebegroupservice.storage.googleapis.com/footlogo.gif" />
			<table style="text-align: left">
				<tr>
					<th width="50%">
						<ul style="font-family: '微軟正黑體', Calibri">
							<li><font size="-1" color="#000066">新北市新莊區242中正路510號
									利瑪竇大樓LM306</font></li>
							<li><font size="-1" color="#000066">碩士班秘書室
									TEL:(02)29052940 FAX:(02)29052182</font></li>
							<li><font size="-1" color="#000066">大學部秘書室
									TEL:(02)29052666 FAX:(02)29052182</font></li>
						</ul>
					</th>
					<th><iframe width="470" height="200" frameborder="0"
							scrolling="no" marginheight="0" marginwidth="0"
							src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=zh-TW&amp;geocode=&amp;q=輔仁大學&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=46.677964,107.138672&amp;ie=UTF8&amp;hq=輔仁大學&amp;t=m&amp;ll=25.036227,121.432142&amp;spn=0.003888,0.010085&amp;z=15&amp;iwloc=A&amp;output=embed"></iframe><br />
						<small><a
							href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=zh-TW&amp;geocode=&amp;q=輔仁大學&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=46.677964,107.138672&amp;ie=UTF8&amp;hq=輔仁大學&amp;t=m&amp;ll=25.036227,121.432142&amp;spn=0.003888,0.010085&amp;z=15&amp;iwloc=A"
							style="color: #0000FF; text-align: left"></a></small> <a
						href="http://www.fju.edu.tw/aboutFju.jsp?labelID=7"><font
							style="font-family: '微軟正黑體', Calibri" size="-1"
							style="text-decoration:none">校園鳥瞰圖</font></a></th>
				</tr>
			</table>
		</div>
		<!-- footer fin -->
		<hr>
		<div align="center">
			<font size="-1" color="#003366" style="font-family: '微軟正黑體', Calibri">Copyright
				(c) 2015 Fu-Jen Catholic University Institute of Information
				Management. All Rights Reserved.</font> <br> <br>
		</div>
	</div>
	<!-- container fin -->


</body>
</html>
