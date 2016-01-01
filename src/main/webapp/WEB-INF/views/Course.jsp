<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>課程規劃Course</title>
<style>
body {background-color: #FFF;}
</style>
<link href="css/CSS.css" rel="stylesheet" type="text/css" />
</head>
	<body>

<%@include file="../../templete/header.jsp" %>
		
<!-- 網頁內容 -->	
		<div id="container">
				<br/>
				
<!--  分頁按鈕 -->				
					<ul id="inside">
						<li>
							<a href="Course?courCateId=801" name="freshman">
								<font style="font-family: '微軟正黑體', Calibri" size="+1">大一</font>
							</a>
						</li>
						<li>
							<a href="Course?courCateId=802" name="sophomore">
								<font style="font-family: '微軟正黑體', Calibri" size="+1">大二</font>
							</a>
						</li>
						<li>
							<a href="Course?courCateId=803" name="junior">
								<font style="font-family: '微軟正黑體', Calibri" size="+1">大三</font>
							</a>
						</li>
						<li>
							<a href="Course?courCateId=804" name="senior">
								<font style="font-family: '微軟正黑體', Calibri" size="+1">大四</font>
							</a>
						</li>
					</ul> <br/>
					
						<div align="right">
							<font color="#FF6600" style="font-family: '微軟正黑體', Calibri">*欲察看課程介紹與評論請點選該課程</font>
						</div>
						<div align="left">
					
						<font style="font-family: '微軟正黑體', Calibri" color="#003366" size="+2">${grade}</font>
						</div>
<!-- 年級 -->
						<div id="contentR_in" style="width: 73%">
								<table style="font-family: '微軟正黑體', Calibri" cellpadding="10">
									<tr>
										<th>
											<font style="font-family: '微軟正黑體', Calibri" size="+1" color="#000099">上學期</font>
										</th>
									</tr>
									<th style="padding-right: 20px">
										<font color="#000099" size="+1">必修:</font>
									</th>
									
										<c:forEach items="${course11}" var="Course">
											<td>			
												<c:choose>
										<c:when test="${identity==null||identity eq 'graduate'}">
											<a href="Comment?courId=${Course.courId}"><font color="#000033" style="text-decoration: underline">${Course.courName}</font></a>
										</c:when>
										<c:otherwise>
											<a href="Comment_act?courId=${Course.courId}"><font color="#000033" style="text-decoration: underline">${Course.courName}</font></a>
										</c:otherwise>
									</c:choose>
											</td>
										</c:forEach>
								</table>
								
								<table style="font-family: '微軟正黑體', Calibri" cellpadding="10">
									<th style="padding-right: 20px">
										<font color="#000099" size="+1">選修:</font>
									</th>
									<c:forEach items="${course12}" var="Course">
										<td>			
											<c:choose>
										<c:when test="${identity==null||identity eq 'graduate'}">
											<a href="Comment?courId=${Course.courId}"><font color="#000033" style="text-decoration: underline">${Course.courName}</font></a>
										</c:when>
										<c:otherwise>
											<a href="Comment_act?courId=${Course.courId}"><font color="#000033" style="text-decoration: underline">${Course.courName}</font></a>
										</c:otherwise>
									</c:choose>
										</td>
									</c:forEach>
								</table>	
																
								<table style="font-family: '微軟正黑體', Calibri" cellpadding="10">
									<tr>
										<th><font style="font-family: '微軟正黑體', Calibri" size="+1" color="#000099">下學期</font></th>
									</tr>
									<th style="padding-right: 20px">
										<font color="#000099" size="+1">必修:</font>
									</th>
									<c:forEach items="${course21}" var="Course">
										<td>			
											<c:choose>
										<c:when test="${identity==null||identity eq 'graduate'}">
											<a href="Comment?courId=${Course.courId}"><font color="#000033" style="text-decoration: underline">${Course.courName}</font></a>
										</c:when>
										<c:otherwise>
											<a href="Comment_act?courId=${Course.courId}"><font color="#000033" style="text-decoration: underline">${Course.courName}</font></a>
										</c:otherwise>
									</c:choose>
										</td>
									</c:forEach>
								</table>
								<table style="font-family: '微軟正黑體', Calibri" cellpadding="10">
									<th style="padding-right: 20px">
										<font color="#000099" size="+1">選修:</font>
									</th>
									<c:forEach items="${course22}" var="Course">
									<td>
									<c:choose>
										<c:when test="${identity==null||identity eq 'graduate'}">
											<a href="Comment?courId=${Course.courId}"><font color="#000033" style="text-decoration: underline">${Course.courName}</font></a>
										</c:when>
										<c:otherwise>
											<a href="Comment_act?courId=${Course.courId}"><font color="#000033" style="text-decoration: underline">${Course.courName}</font></a>
										</c:otherwise>
									</c:choose>
									</td>
									</c:forEach>
								</table>			
								<br/><br/>
						</div>

			
			</div> <!-- container fin -->
	<%@include file="../../templete/CourFooter.jsp" %>
			
	</body>
</html>
