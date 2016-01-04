<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Q&A</title>
<style>
body {
	background-color: #FFF;
}
</style>
<link href="css/CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>

		<div id="container">
			<div>
				<!-- content -->
				<div id="content_L" style="font-family: '微軟正黑體', Calibri">
					<ul id="L-list">
						<li><a href="Q&A">常見問題集</a></li>
						<li><a href="Question">我要發問</a></li>
					</ul>

				</div>
				<!-- content_L fin -->
				<div id="content_R">
					<ul id="inside">
						<!--  分頁按鈕 -->
						<li><a href="Q&A"><font
								style="font-family: '微軟正黑體', Calibri">申請入學</font></a></li>
						<!-- 這三個要做同一個頁面的捷徑(? -->
						<li><a href="Q&A"><font
								style="font-family: '微軟正黑體', Calibri">繁星推薦</font></a></li>
						<li><a href="Q&A"><font
								style="font-family: '微軟正黑體', Calibri">指考分發</font></a></li>
						<li><a href="Q&A"><font
								style="font-family: '微軟正黑體', Calibri">大學課程</font></a></li>
						<li><a href="Q&A"><font
								style="font-family: '微軟正黑體', Calibri">未來工作發展</font></a></li>
					</ul>
					<br/> <font style="font-family: '微軟正黑體', Calibri"
						color="#003366" size="+1"></font>
						<hr align="left" width="70%" color="#003366" size="1"/>
							<table style="text-align: left">
							<c:forEach items="${usualList}" var="QA">
								
								<tr>
								<th>Q:${QA.question_Content}</th>
								

								<th>A:${QA.answer_Content}</th>
								</tr>
								
								
								
							</c:forEach>
							</table>
						<br/>
				</div> <!-- content_R fin -->
			</div> <!-- content fin -->
		</div> <!-- container fin -->

</body>
</html>
