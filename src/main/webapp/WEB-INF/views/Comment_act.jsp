<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>給予課程評論</title>
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
			<div>
				<!-- content -->
				<br/>
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
					</ul> <br/><br/> 
					<div align="left">
					 <font size="+3" style="font-family:'微軟正黑體', Calibri" color="#000066">${courName}</font>
					 <font size="+1" style="font-family:'微軟正黑體', Calibri" color="#000066">的課程介紹與評論</font>
					 </div>		
					<br/>
								
					
					<div align="left">
						<font size="+1" color="#000066" style="font-family: '微軟正黑體', Calibri"> 課程介紹:${courseBrief}</font>
					</div>
										<br/><br/> 
												
												<c:choose>
												<c:when test="${not empty myList.comContent}">
													<c:if test="${myList.secretary.secreId==0}">
													<font style="font-family: '微軟正黑體', Calibri" color="#FF0000">您的評論正在審核中...</font>
													
													</c:if>
												</c:when>
												<c:otherwise>
												<font style="font-family: '微軟正黑體', Calibri"
												color="#009933">我要給予評論...</font><br/>
												<form action="LeaveComment" method="post">
												<table cellpadding="10px" border="1" bordercolor="#009933" style="font-family:'微軟正黑體', Calibri">
													<tr>
														<th>班級姓名</th>
														<th>教授姓名</th>
														<th>評論</th>
														<th>課堂重要與否星等</th>
														<th>送出</th>
													</tr>
													<tr>
														<th>${account}</th>
														
														<th>
														<select name="profId">
														<c:forEach items="${teacherList}" var="teacherList">
															
															
																<option value="${teacherList.professor.profId}">${teacherList.professor.profName}</option>
									
															
														
														</c:forEach>
														</select>
														</th>
														
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
														
														<th><input type="hidden" name="courId" value="${courId}"></input>
															<button type="submit">送出評論</button><br/>
															
														</th>
													</tr>
												</table>
												</form>
												</c:otherwise>
												</c:choose>
												 <br/><br/> <!-- 以上為給予評論區塊 --> <!-- 以下為瀏覽其他評論並按讚的區塊 -->
														<font style="font-family: '微軟正黑體', Calibri"
														color="#0066CC"> 瀏覽其他評論並按讚...</font>
												<form action="like" method="post">		
														<table cellpadding="20px" border="1" bordercolor="#0066CC" style="font-family:'微軟正黑體', Calibri">
															<tr>
																<th>Like</th>
																<th>班級姓名</th>
																<th>評論</th>
																<th>課堂重要與否星等</th>
															</tr>
														<c:forEach items="${commentlist}" var="Comment">	
															<tr>
																<th>
																	<input type="hidden" name="courId" value="${Comment.course.courId}"></input>
																	<input type="hidden" name="comId" value="${Comment.comId}"></input>
																	<input type="hidden" name="comLikes" value="${Comment.comLikes}"></input>
																	<button type="submit">我要按讚</button>
																</th>
																<th>${Comment.student.stuClass}${Comment.student.stuName}</th>
																<th style="text-align: left">${Comment.comContent}</th>
																<th>${Comment.courStars}顆星</th>
															</tr>
														</c:forEach>
														</table>
												</form>	
									</div> <br/><br/><br/>
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
