<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>給予建議Suggest</title>
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
						<li><a href="Subject"><font
								style="font-family: '微軟正黑體', Calibri">得獎專題</font></a></li>
					</ul>

				</div>
				<!-- content_L fin -->
				<div id="content_R">
					<!-- content_R -->
					<ul id="inside">
						<!--  分頁按鈕 -->
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri">研究所</font></a></li>
						<!-- 這三個要做同一個頁面的捷徑(? -->
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri">創業者</font></a></li>
						<li><a href=""><font
								style="font-family: '微軟正黑體', Calibri">各行各業</font></a></li>
					</ul>
					<br/>
						<div style="padding-left: 5px">
							<font color="#009933" style="font-family: '微軟正黑體', Calibri">給予建議...</font>
							<table cellpadding="9px" bgcolor="#BFFFBF">
								
								<tr>
									<th>工作心得</th>
									<th><input type="text" style="padding: 10px" value="work"/></th>
								</tr>
								<tr>
									<th>給在校生建議</th>
									<th><input type="text" style="padding: 10px"
										value="suggest"/></th>
								</tr>
								<tr>
									<th>送出</th>
									<th><input type="submit" value="送出"/></th>
								</tr>

							</table>
							<br/> <font color="#9999FF"
								style="font-family: '微軟正黑體', Calibri">其他建議...</font>
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
								</table> <br/>
						</div>
				</div>
				<!-- content_R fin -->
			</div>
			<!-- content fin -->

			<div id="footer"></div>
			<!-- footer fin -->
			<hr/>
				<div align="center">
					<font size="-1" color="#003366"
						style="font-family: '微軟正黑體', Calibri">Copyright (c) 2015
						Fu-Jen Catholic University Institute of Information Management.
						All Rights Reserved.</font>
				</div>
		</div> <!-- container fin -->
</body>
</html>