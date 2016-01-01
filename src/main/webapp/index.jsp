<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>高中生系網頁Index</title>

<style>
body {
	background-color: #FFF;
}
</style>
<link href="css/CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="templete/header.jsp" %>
		<div id="container">
			<!-- <img src="pics/m8V9qo.gif"/>-->
				<div>
					<!-- content -->
					<div style="font-family:'微軟正黑體', Calibri">
					<div style="padding-left:300px">
					<br/>
					<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Fu_Jen_Catholic_University_Seal.svg/932px-Fu_Jen_Catholic_University_Seal.svg.png" width="400" height="400"/>
					
				<!-- 	<c:forEach items="${homepicList}" var="ind">
					<table>
						<tr>
							<th>${ind.RIPicTitle}</th>
						</tr>
						<tr>
							<th><a href="${ind.RIPicPicture}"><img src="${ind.RIPicPicture}" width="400" height="300"></img></a></th>
						</tr>
						<tr>
							<th>${ind.RIPicContent}</th>
						</tr>
					</table>
					</c:forEach>  -->
						<br/><br/>
					</div>
					</div>
					<!-- content_R fin -->
				</div> <!-- content fin -->
			</div> <!-- container fin -->
			<%@include file="templete/footer.jsp" %>

</body>
</html>
