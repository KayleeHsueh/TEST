<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>系所簡介IMIntro</title>
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
				<div id="content_L">
					<ul id="L-list">
						<li><a href="IMIntro"><font
								style="font-family: '微軟正黑體', Calibri">系所簡介</font></a></li>
						<li><a href="GraduateSug"><font
								style="font-family: '微軟正黑體', Calibri">校友建議</font></a></li>
						<li><a href="Project"><font
								style="font-family: '微軟正黑體', Calibri">得獎專題</font></a></li>
					</ul>

				</div>
				<!-- content_L fin -->
				<div id="content_R">
					<div style="font-family:'微軟正黑體', Calibri">
					<div style="padding-left:150px">
					<c:forEach items="${picList}" var="pic">
					<table>
						<tr>
							<th>${pic.RIPicTitle}</th>
						</tr>
						<tr>
							<th><a href="${pic.RIPicPicture}"><img src="${pic.RIPicPicture}" width="400" height="300"></img></a></th>
						</tr>
						<tr>
							<th>${pic.RIPicContent}</th>
						</tr>
						<c:if test="${Login.identity!=null}">					
						<tr>					
							<th>
							<form action="deleteRIP" method="post">
							<button name="delete">刪除</button>
							</form>
							</th>					
						</tr>				
						</c:if>

					</table>
					</c:forEach>
						<br/><br/>
					</div>
					</div>
					<c:if test="${Login != null}">
					<font color="#990066" size="+2" style="font-family:'微軟正黑體', Calibri">新增圖片...</font><br/>
						<div style="font-family:'微軟正黑體', Calibri">
							<div style="background-color:#E8B7FF">
								<div style="text-align:left">
							<br/>
								<form action="" method="post">
								<table style="padding-left:30px">				
									<tr>
										<th>圖片標題：</th>
										<th><input type="text" name="RIPicTitle"/></th>
									</tr>
									<tr>
										<th>圖片網址：</th>
										<th><input type="text" name="RIPicPicture"/></th>
									</tr>
									<tr>
										<th>圖片介紹：</th>
										<th><textarea name="RIPicContent" cols="30" rows="5">請輸入圖片介紹...</textarea></th>
									</tr>
									<tr>
										<th><input type="submit" name="submit" value="送出"/></th>
										<th><input type="reset" name="reset" value="重新輸入"/></th>
									</tr>	
								</table>
								</form>
							<br/>
								</div>
							</div>
						</div>
					</c:if>
				</div> <!-- content_R fin -->
			</div> <!-- content fin -->
		</div> <!-- container fin -->
	<%@include file="../../templete/footer.jsp" %>
</body>
</html>
