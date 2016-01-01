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
<%@include file="../../templete/header.jsp" %>
		
<!-- 網頁內容 -->			
		<div id="container">
			<div>
				<!-- content -->
				<br/>						
										<br/> <br/> <!-- 以下為審核部分 --> <font
													style="font-family: '微軟正黑體', Calibri" color="#FF3300">
														未審核的評論...</font>
													<table cellpadding="20px" border="1" bordercolor="#FF3300">
														<tr>
															<th>課程名稱</th>
															<th>班級姓名</th>
															<th>評論</th>
															<th>課堂重要與否星等</th>
															<th>老師</th>
															<th>審核</th>
														</tr>
														<tr>
															<c:forEach items="${commentList}" var="Comment">
																<c:if test="${Comment.comState==0}">
																	<tr>
																	<th>${Comment.course.courName}</th>
																	<th>${Comment.student.stuClass}${Comment.student.stuName}</th>
																	<th style="text-align: left">${Comment.comContent}</th>
																	<th>${Comment.courStars}<font style="font-weight:lighter" style="font-family:'微軟正黑體', Calibri" size="-1">
														顆星</font></th>
																	<th >${Comment.professor.profName}</th>
																	
																	<th>
																	
																	<form action="StateOK" method="post">
																		<input type="hidden" name="comId" value="${Comment.comId}"></input>
																		<input type="hidden" name="secreId" value="${account}"></input>
																		<input type="hidden" name="comState" value="${Comment.comState}"></input>
																		<button type="submit" value="yes" name="pass">通過</button>
																	</form>	
																		<br/>
																	
																	
																	</th>
																	</tr>
																</c:if>
															</c:forEach>
															
														</tr>
														
													</table> <br/><br/> <!-- 以下為既有的評論 --> <font
															style="font-family: '微軟正黑體', Calibri" color="#FF3300">
																已通過的評論...</font>
															<table cellpadding="20px" border="1" bordercolor="#FF3300">
														<tr>
															<th>課程名稱</th>
															<th>班級姓名</th>
															<th>評論</th>
															<th>課堂重要與否星等</th>
															<th>老師</th>
															<th>審核</th>
														</tr>
														
															<c:forEach items="${commentList2}" var="Comment">
															
															<tr>
																<c:if test="${Comment.comState==1}">
																	<th>${Comment.course.courName}</th>
																	<th>${Comment.student.stuClass}${Comment.student.stuName}</th>
																	<th style="text-align: left">${Comment.comContent}</th>
																	<th>${Comment.courStars}<font style="font-weight:lighter" style="font-family:'微軟正黑體', Calibri" size="-1">
														顆星</font></th>
																	<th >${Comment.professor.profName}</th>
																	<th>
																	
																	
																	<form action="delete" method="post">
																		<input type="hidden" name="courId" value="${Comment.course.courId}"></input>
																		<input type="hidden" name="comId" value="${Comment.comId}"></input>
																		<button type="submit" value="no" name="delete">刪除</button>
																	</form>
																	
																	</th>
																	
																</c:if>
																</tr>
																
															</c:forEach>
														
														
														
													</table> <br/><br/>
														
										</div> <br/><br/><br/>
			</div>
			<!-- content fin -->

			<div id="footer"></div>
			<!-- footer fin -->
				<div align="center">
					<font size="-1" color="#003366">Fu-Jen Catholic University Institute of Information Management. All Rights Reserved.</font>
				</div>
			</div> <!-- container fin -->
</body>
</html>
