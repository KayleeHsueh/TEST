<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>我要發問Question</title>
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
				<div id="content_L" style="font-family: '微軟正黑體', Calibri">
					<ul id="L-list">
						<li><a href="Q&A">常見問題集</a></li>
						<li><a href="Question">我要發問</a></li>
					</ul>

				</div>
				<!-- content_L fin -->
				<div id="content_R">
					<br/>
					<div style="padding-left:5px">
					<font style="font-family:'微軟正黑體', Calibri" color="#009933" size="+1">我要發問...</font>
						<div style="font-family:'微軟正黑體', Calibri">
							<div style="background-color:#B3FFCB">
						<br/>
							<form action="Question" method="post" style="padding-left:50px">
								<table style="text-align:left">
								<tr>
									<th>姓名：</th>
									<th><input type="text" id="QA"/></th>
								</tr>
								<tr>
									<th>Email：</th>
									<th><input type="email" id="email"></input></th></tr>
								<tr><th>問題類別：</th>
									<th>
									<input type="radio" name="QuestionCategory" value="註冊"/>註冊&nbsp;
									<input type="radio" name="QuestionCategory" value="課程"/>課程&nbsp;
									<input type="radio" name="QuestionCategory" value="畢業資格"/>畢業資格&nbsp;
									<input type="radio" name="QuestionCategory" value="學涯規劃"/>學涯規劃&nbsp;
									<input type="radio" name="QuestionCategory" value="其他"/>其他<br/>
									</th>
								</tr>
								<tr><th>問題內容：</th>
									<th><textarea cols="40" rows="5" name="QA">輸入您的問題...</textarea></th>
								</tr>
							<!-- 		<tr><th><input type="submit" name="submit" value="發問"/></th>   -->
									<th><input type="reset" value="發問"/></th></tr>
								</table>
						<br/><br/>
							</form>
						</div>
					</div>
				</div>
					<br/>
				</div> <!-- content_R fin -->
			</div> <!-- content fin -->
		</div> <!-- container fin -->
	<%@include file="../../templete/footer.jsp" %>
</body>
</html>
