<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>給予課程評論</title>
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
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大一</font></a></li>
						<!-- 這三個要做同一個頁面的捷徑(? -->
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大二</font></a></li>
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大三</font></a></li>
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大四</font></a></li>
					</ul> <br><br> 
					<c:forEach items="${courseList}" var="course">
					 <font size="+3" style="font-family:'微軟正黑體', Calibri" color="#000066">${Course.courName}</font>
					 <font size="+1" style="font-family:'微軟正黑體', Calibri" color="#000066">的課程介紹與評論</font>		
					<br><br>
									<div style="padding-left: 80px">
										<table>
											<th><font color="#000066" style="font-family: '微軟正黑體', Calibri"> 課程介紹:
												${Course.courBriefIntro}</font></th>
					</c:forEach>
										</table>
										<br><br> <font style="font-family: '微軟正黑體', Calibri"
												color="#009933">我要給予評論...</font>
												<table cellpadding="10px" border="1" bordercolor="#009933" style="font-family:'微軟正黑體', Calibri">
													<tr>
														<th>班級姓名</th>
														<th>評論</th>
														<th>課堂重要與否星等</th>
														<th>送出</th>
													</tr>
													<tr>
													<form action="LeaveComment" method="post">
													<c:forEach items="commentList" var="Comment"> 
													
													
													 <!-- ***這邊應該是要從session抓student name & class -->													 
													 
													 
														<th>${Comment.student.stuClass}${Comment.student.stuName}</th>
														
													</c:forEach>
														<th><input type="text" style="padding: 10px" name="comContent"></th>
														<th>
														<select name="courStars">
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														</select>
														<font style="font-weight:lighter" style="font-family:'微軟正黑體', Calibri" size="-1">
														顆星</font>
														</th>
														<th><input type="submit" value="送出評論" name="submit"><br></th>
													</form>
													</tr>
												</table> <br><br> <!-- 以上為給予評論區塊 --> <!-- 以下為瀏覽其他評論並按讚的區塊 -->
														<font style="font-family: '微軟正黑體', Calibri"
														color="#0066CC"> 瀏覽其他評論並按讚...</font>
														<table cellpadding="20px" border="1" bordercolor="#0066CC" style="font-family:'微軟正黑體', Calibri">
															<tr>
																<th>Like</th>
																<th>班級姓名</th>
																<th>評論</th>
																<th>課堂重要與否星等</th>
															</tr>
															<c:forEach items="commentList" var="Comment">
															<tr>
																<th>
																	<button type="button">我要按讚</button>
																</th>
																<th>${Comment.student.stuClass}${Comment.student.stuName}</th>
																<th style="text-align: left">${Comment.comContent}</th>
																<th>${Comment.courStars}</th>
															</tr>
															</c:forEach>
														</table>
									</div> <br><br><br>
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
