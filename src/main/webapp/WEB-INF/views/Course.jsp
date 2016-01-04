<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>課程規劃Course</title>
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
			<a href="index.jsp" style="text-decoration: none"><font size="-1"
				style="font-family: '微軟正黑體', Calibri">回首頁</font></a>&nbsp;&nbsp;|&nbsp;
			<a href="http://www.fju.edu.tw/#&panel1-2"
				style="text-decoration: none"><font size="-1"
				style="font-family: '微軟正黑體', Calibri">輔仁大學</font></a>&nbsp;&nbsp;|&nbsp;
			<a href="http://english.im.fju.edu.tw/" style="text-decoration: none"><font
				size="-1" style="font-family: '微軟正黑體', Calibri">English</font></a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="Login" style="text-decoration: none"><font size="-1"
				style="font-family: '微軟正黑體', Calibri">登入</font></a>
		</div>
		<div>
			<a href="index.jsp"><img src="pics/Logo.PNG" onmouseover=""></a>
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
			<li><a href="Q&A"><font
					style="font-family: '微軟正黑體', Calibri">Q&A </font></a></li>
			<li><a href=""><font style="font-family: '微軟正黑體', Calibri">網站地圖</font></a></li>
		</ul>
		<div id="container">
			<div>
				<!-- content -->
				<br>
					<ul id="inside">
						<!--  分頁按鈕 -->
						<li><a href="Course" name="freshman"><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大一</font></a></li>
						<li><a href="Course" name="sophomore"><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大二</font></a></li>
						<li><a href="Course" name="junior"><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大三</font></a></li>
						<li><a href="Course" name="senior"><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大四</font></a></li>
					</ul> <br>
						<div align="right">
							<font color="#FF6600" style="font-family: '微軟正黑體', Calibri">*欲察看課程介紹與評論請點選該課程</font>
						</div> 
							<div id="contentR_in" style="width: 73%">+
											<table style="font-family: '微軟正黑體', Calibri" cellpadding="10">
												<tr>
													<font style="font-family: '微軟正黑體', Calibri" size="+1"
														color="#000099">上學期</font>
												</tr>
												<tr>
													<th style="padding-right: 20px"><font color="#000099"
														size="+1">必修:</font></th>
													<th><a href="Comment"><font color="#000033"
															style="text-decoration: underline">${Course.courName}</font></a></th>
												</tr>
												<br>
													<tr>
														<th style="padding-right: 20px"><font color="#000099"
															size="+1">選修:</font></th>
														<th><font color="#000033"
															style="text-decoration: underline">${Course.courName}</font></th>
													</tr> <br>
											</table> <br>
												<table style="font-family: '微軟正黑體', Calibri"
													cellpadding="10">
													<tr>
														<font style="font-family: '微軟正黑體', Calibri" size="+1"
															color="#000099">下學期</font>
													</tr>
													<tr>
														<th style="padding-right: 20px"><font color="#000099"
															size="+1">必修:</font></th>
														<th><font color="#000033"
															style="text-decoration: underline">${Course.courName}</font></th>
													</tr>
													<br>
														<tr>
															<th style="padding-right: 20px"><font
																color="#000099" size="+1">選修:</font></th>
															<th><font color="#000033"
																style="text-decoration: underline">${Course.courName}</font></th>
														</tr> <br> 

												</table>
												</c:forEach>
												<div align="right">
													<font color="#33CC00" style="text-decoration: underline">TOP</font>
												</div> <br><br>
														</table>
														<div align="right">
															<font color="#33CC00" style="text-decoration: underline">TOP</font>
														</div>
					
				<br><br>
				<c:if test="${Login!=null}">
						<div style="font-family: '微軟正黑體', Calibri" style="color:#603">
							<form action="Course.jsp" method="post">
								課程名稱：<input type="text" name="courName"><br><br>
								課程簡介：<input type="text" name="courBriefIntro"><br><br>
									<input type="submit" name="newCour" value="新增">
							</form>
						</div>
						<!-- 新增課程fin -->
				</c:if>
			</div>


			<div style="margin-left: 78%" style="font-family:'微軟正黑體', Calibri">
				<br><br><br><br><br>
														<table cellpadding="10px" bgcolor="#FFDDBB">
															<tr>
																<th><font color="#FF3300">擋修圖</font></th>
															</tr>
															<tr>
																<th><font style="text-decoration: underline"
																	color="#FF3300"> JAVA程式語言I</font></th>
															</tr>
															<tr>
																<th><font style="padding-left: 0%" color="#FF3300">↓</font></th>
																<tr>
																	<th><font style="text-decoration: underline"
																		color="#FF3300"> JAVA程式語言II</font></th>
																</tr>
														</table>
			</div>
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
	</div>
	<!-- footer fin -->
	<hr>
		<div align="center">
			<font size="-1" color="#003366" style="font-family: '微軟正黑體', Calibri">Copyright
				(c) 2015 Fu-Jen Catholic University Institute of Information
				Management. All Rights Reserved.</font>
		</div>
	</div>
	<!-- container fin -->
</body>
</html>
