<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>課程評論Comment</title>
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
						<li><a href="Course" name="freshman"><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大一</font></a></li>
						<!-- 這三個要做同一個頁面的捷徑(? -->
						<li><a href="Course" name="sophomore"><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大二</font></a></li>
						<li><a href="Course" name="junior"><font
								style="font-family: '微軟正黑體', Calibri" size="+1">大三</font></a></li>
						<li><a href="Course" name="senior"><font
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
					<font size="+1" style="font-family:'微軟正黑體', Calibri" color="#000066">課程評論</font>
					<br/>
												<table cellpadding="20px" border="1" bordercolor="#99CCFF">
													<tr>
														<th>班級姓名</th>
														<th>評論</th>
														<th>課堂重要與否星等</th>
													</tr>
													
													
													<!-- ***抓讚數前3名的評論出來*** -->
													
													<c:forEach items="${commentList}" var="Comment">
														<tr>
														<th>${Comment.student.stuClass}${Comment.student.stuName}</th>
														<th style="text-align: left">${Comment.comContent}</th>
														<th>${Comment.courStars}<font style="font-weight:lighter" style="font-family:'微軟正黑體', Calibri" size="-1">
														顆星</font></th>
														</tr>
													</c:forEach>
													
												</table>
												
									</div> <br/><br/><br/>
			
			<!-- content fin -->

			</div> <!-- container fin -->
	<%@include file="../../templete/footer.jsp" %>
</body>
</html>
