<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>建議審核</title>
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
			<a href="" style="text-decoration: none"><font size="-1"
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
			<li><a href="WEB-INF/views/IMIntro.jsp"><font
					style="font-family: '微軟正黑體', Calibri">系所簡介</font></a></li>
			<li><a href="WEB-INF/views/Teacher.jsp"><font
					style="font-family: '微軟正黑體', Calibri">師資陣容</font></a></li>
			<li><a href="WEB-INF/views/Course.jsp"><font
					style="font-family: '微軟正黑體', Calibri">課程規劃</font></a></li>
			<li><a href="WEB-INF/views/Q&A.jsp"><font
					style="font-family: '微軟正黑體', Calibri">Q&A </font></a></li>
			<li><a href=""><font style="font-family: '微軟正黑體', Calibri">網站地圖</font></li>
		</ul>
		<div id="container">
			<div>
				<!-- content -->
				<div id="content_L">
					<ul id="L-list">
						<li><a href="IMIntro.jsp"><font
								style="font-family: '微軟正黑體', Calibri">特色簡介</font></a></li>
						<li><a href="GraduateSug.jsp"><font
								style="font-family: '微軟正黑體', Calibri">校友建議</font></a></li>
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri">行事曆(暫定)</font></a></li>
					</ul>

				</div>
				<!-- content_L fin -->
				<div id="content_R">
					<!-- content_R -->
					<ul id="inside">
						<!--  分頁按鈕 -->
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri">未審核的建議</font></a></li>
						<!-- 這三個要做同一個頁面的捷徑(? -->
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri">已通過的建議</font></a></li>
					</ul>
					<br>

						<div style="padding-left: 5px">
							<font color="#FF3300" style="font-family: '微軟正黑體', Calibri">未審核的建議...</font>
							<table cellpadding="9px" bgcolor="#FFDAB5">
								<tr>
									<th>身分類別</th>
									<th>學校/公司行號</th>
									<th>建議</th>
									<th>審核</th>
								</tr>
								<tr>
									<th>研究所</th>
									<th style="text-align: left">中央大學資管所</th>
									<th>愛你所選，加油...............................................</th>
									<th><input type="submit" value="通過"> <input
											type="button" value="刪除"></th>
								</tr>
								<tr>
									<th>各行各業</th>
									<th style="text-align: left">益群健康股份有限公司</th>
									<th>資管的出路很廣，可以多方涉獵，找尋自己喜愛的領域，加油!!</th>
									<th><input type="submit" value="通過"> <input
											type="button" value="刪除"></th>
								</tr>

							</table>
							<br> <font color="#9999FF"
								style="font-family: '微軟正黑體', Calibri">已通過的建議...</font>
								<table cellpadding="9px" bgcolor="#B9DCFF">
									<tr>
										<th>身分類別</th>
										<th>學校/公司行號</th>
										<th>建議</th>
									</tr>
									<tr>
										<th>研究所</th>
										<th style="text-align: left">中央大學資管所</th>
										<th>愛你所選，加油...............................................</th>
									</tr>
								</table> <br>
						</div>
				</div>
				<!-- content_R fin -->
			</div>
			<!-- content fin -->

			<div id="footer"></div>
			<!-- footer fin -->
			<hr>
				<div align="center">
					<font size="-1" color="#003366"
						style="font-family: '微軟正黑體', Calibri">Copyright (c) 2015
						Fu-Jen Catholic University Institute of Information Management.
						All Rights Reserved.</font>
				</div>
		</div> <!-- container fin -->
</body>
</html>
