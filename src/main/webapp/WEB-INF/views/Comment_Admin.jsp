<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>課程評論審核</title>
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
								style="font-family: '微軟正黑體', Calibri" size="+1">未審核的評論</font></a></li>
						<!-- 這三個要做同一個頁面的捷徑(? -->
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri" size="+1">既有的評論</font></a></li>
					</ul> <br><br>
							<form action="" method="post">
								<input type="text" name="courName" value="${Course.courName}"/>
								<font size="+1" color="#000066">的課程介紹與評論</font> <br><br>
										<div style="padding-left: 80px">
											<table>
												<th><font color="#000066"
													style="font-family: '微軟正黑體', Calibri"> 課程介紹: </font> <input
													type="text" name="courBriefIntro"
													value="${Course.courBriefIntro}"/>&nbsp;&nbsp;
															<button type="button" name="updateCour" value="修改課程"/>
																修改課程</form></th>
											</table>
											<br> <br> <!-- 以下為審核部分 --> <font
													style="font-family: '微軟正黑體', Calibri" color="#FF3300">
														未審核的評論...</font>
													<table cellpadding="20px" border="1" bordercolor="#FF3300">
														<tr>
															<th>班級姓名</th>
															<th>評論</th>
															<th>課堂重要與否星等</th>
															<th>審核</th>
														</tr>
														<tr>
															<c:forEach items="${commentList}" var="Comment">
																<c:if test="${Comment.comState==false}">
																	<th>${Comment.student.stuClass}${Comment.student.stuName}</th>
																	<th style="text-align: left">${Comment.comContent}</th>
																	<th>${Comment.courStars}<font style="font-weight:lighter" style="font-family:'微軟正黑體', Calibri" size="-1">
														顆星</font></th>
																	<th>
																	<form action="" method="post">
																		<button type="button" value="yes" name="通過">通過</button>
																	</form>	
																		<br>
																	<form action="" method="post">
																		<button type="button" value="no" name="刪除">刪除</button>
																	</form>
																	</th>
																</c:if>
															</c:forEach>
														</tr>
													</table> <br><br> <!-- 以下為既有的評論 --> <font
															style="font-family: '微軟正黑體', Calibri" color="#99CCFF">
																已通過的評論...</font>
															<table cellpadding="20px" border="1"
																bordercolor="#99CCFF">
																<tr>
																	<th>班級姓名</th>
																	<th>評論</th>
																	<th>課堂重要與否星等</th>
																</tr>
																<tr>
																	<c:forEach items="${commentList}" var="Comment">
																		<c:if test="${Comment.comState==true}">
																			<th>${Comment.student.stuClass}${Comment.student.stuName}</th>
																			<th style="text-align: left">${Comment.comContent}</th>
																			<th>${Comment.courStars}<font style="font-weight:lighter" style="font-family:'微軟正黑體', Calibri" size="-1">
														顆星</font></th>
																		</c:if>
																	</c:forEach>
																</tr>
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
