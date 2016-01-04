<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>高中生系網頁HomePage</title>

<style>
body {
	background-color: #FFF;
}
</style>
<link href="css/CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="container">
		<div align="right">
			<a href="index.jsp style="text-decoration: none"><font size="-1"
				style="font-family: '微軟正黑體', Calibri">回首頁</font></a>&nbsp;&nbsp;|&nbsp;
			<a href="http://www.fju.edu.tw/#&panel1-2"
				style="text-decoration: none"><font size="-1"
				style="font-family: '微軟正黑體', Calibri">輔仁大學</font></a>&nbsp;&nbsp;|&nbsp;
			<a href="http://english.im.fju.edu.tw/" style="text-decoration: none"><font
				size="-1" style="font-family: '微軟正黑體', Calibri">English</font></a>&nbsp;&nbsp;|&nbsp;&nbsp;
			${Login}
			<c:choose>
				<c:when test="${Login!=null}">
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
			<a href="index.jsp"><img src="pics/Logo.PNG" onmouseover=""></a>
			<br>
		</div>
	</div>
	<br>
		<ul id="nav">
			<li><a href="IMIntro"><font
					style="font-family: '微軟正黑體', Calibri">系所簡介</font></a></li>
			<li><a href="Teacher"><font
					style="font-family: '微軟正黑體', Calibri">師資陣容</font></a></li>
			<li><a href="Course"><font
					style="font-family: '微軟正黑體', Calibri">課程規劃</font></a></li>
			<li><a href="Q&A"><font
					style="font-family: '微軟正黑體', Calibri">Q&A </font></a></li>
			<li><a href=""><font style="font-family: '微軟正黑體', Calibri">網站地圖</font></li>
		</ul>
		<div id="container">
			<img src="pics/m8V9qo.gif">
				<div>
					<!-- content -->
					<div id="content_L">
						<ul id="L-list">
							<li><a href=""><font
									style="font-family: '微軟正黑體', Calibri">行事曆(暫定)</font></a></li>
						</ul>

					</div>
					<!-- content_L fin -->
					<div id="content_R">
						<br>
							<div align="center">
								<div align="center">
									<img src="pics/AACSB.jpg" height="50%" width="50%" />
								</div>
								<font style="font-family: '微軟正黑體', Calibri">輔仁大學為台灣第一所通過AACSDB認證之大學</font>
							</div> <br><br><br>
					</div>
					<!-- content_R fin -->
				</div> <!-- content fin -->

				<div id="footer">
					<hr>
						<img
							src="https://imwebegroupservice.storage.googleapis.com/footlogo.gif" />
						<table style="text-align: left">
							<tr>
								<th>
									<ul>
										<li><font style="font-family: '微軟正黑體', Calibri">新北市新莊區242中正路510號
												利瑪竇大樓LM306</font></li>
										<li><font style="font-family: '微軟正黑體', Calibri">碩士班秘書室
												TEL:(02)29052940 FAX:(02)29052182</font></li>
										<li><font style="font-family: '微軟正黑體', Calibri">大學部秘書室
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
										style="text-decoration:none">校園鳥瞰圖</a></th>
							</tr>
						</table>
				</div> <!-- footer fin -->
				<hr>
					<div align="center">
						<font size="-1" color="#003366"
							style="font-family: '微軟正黑體', Calibri">Copyright (c) 2015
							Fu-Jen Catholic University Institute of Information Management.
							All Rights Reserved.</font> <br><br><br>
			</div> <!-- container fin -->
</body>
</html>
