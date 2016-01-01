<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>得獎專題Project</title>
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
					<ul id="L-list" style="font-family: '微軟正黑體', Calibri">
						<li><a href="IMIntro"><font
								style="font-family: '微軟正黑體', Calibri">系所簡介</font></a></li>
						<li><a href="GraduateSug"><font
								style="font-family: '微軟正黑體', Calibri">校友建議</font></a></li>
						<li><a href="Project">得獎專題</a></li>
					</ul>

				</div>
				<!-- content_L fin -->
				<div id="content_R">
				
				<br/> <font style="font-family: '微軟正黑體', Calibri"
						color="#330099" size="+2">得獎專題介紹</font> <br/> <font
							style="font-family: '微軟正黑體', Calibri" color="#3333CC">請選擇年份:</font>&nbsp;
							<select>
								<option>2015</option>
						</select> <!-- 這邊會有部分程式區塊跟Controller做連結 --> <br/><br/>
									<ul id="inside">
										<!--  分頁按鈕 -->
										<li><a href=""><font
												style="font-family: '微軟正黑體', Calibri">蛛絲碼機</font></a></li>
										<!-- 這三個要做同一個頁面的捷徑(? -->
										<li><a href=""><font
												style="font-family: '微軟正黑體', Calibri">ARtempt</font></a></li>
										<li><a href=""><font
												style="font-family: '微軟正黑體', Calibri">WeFund</font></a></li>
										<li><a href=""><font
												style="font-family: '微軟正黑體', Calibri">CPBL Dreamer</font></a></li>
										<li><a href=""><font
												style="font-family: '微軟正黑體', Calibri">We Care</font></a></li>
									</ul> <br/><br/><br/> <font
												style="font-family: '微軟正黑體', Calibri" color="#003366"
												size="+1">蛛絲碼機 產學合作第一名</font>
												<hr color="#009999" size="1"/>
													<br/>
														<table style="text-align: left">
															<tr>
																<th><iframe width="560" height="315"
																		src="https://www.youtube.com/embed/gUOOIbwpr9w"
																		frameborder="0" allowfullscreen></iframe></th>
															</tr>
															<tr>
																<th>專題介紹:.................................................<br/>...............................................</th>
															</tr>
															<tr>
																<th>指導老師:AAA<br/>學生:aaa bbb ccc ddd eee</th>
															</tr>
														</table> <br/> <font style="font-family: '微軟正黑體', Calibri"
															color="#003366" size="+1">ARtempt</font>
															<hr color="#009999" size="1"/>
																<br/>
																	<table style="text-align: left">
																		<tr>
																			<th><iframe width="560" height="315"
																					src="https://www.youtube.com/embed/GICZ-Uxz4XM"
																					frameborder="0" allowfullscreen></iframe></th>
																		</tr>
																		<tr>
																			<th>專題介紹:.................................................<br/>...............................................</th>
																		</tr>
																		<tr>
																			<th>指導老師:BBB<br/>學生:fff ggg hhh iii jjj</th>
																		</tr>
																	</table> <br/> <font style="font-family: '微軟正黑體', Calibri"
																		color="#003366" size="+1">WeFund</font>
																		<hr color="#009999" size="1"/>
																			<br/>
																				<table style="text-align: left">
																					<tr>
																						<th></th>
																					</tr>
																					<tr>
																						<th>專題介紹:.................................................<br/>...............................................</th>
																					</tr>
																					<tr>
																						<th>指導老師:AAA<br/>學生:aaa bbb ccc ddd eee</th>
																					</tr>
																				</table> <br/> <font
																					style="font-family: '微軟正黑體', Calibri"
																					color="#003366" size="+1">CPBL Dreamer</font>
																					<hr color="#009999" size="1"/>
																						<br/>
																							<table style="text-align: left">
																								<tr>
																									<th></th>
																								</tr>
																								<tr>
																									<th>專題介紹:.................................................<br/>...............................................</th>
																								</tr>
																								<tr>
																									<th>指導老師:AAA<br/>學生:aaa bbb ccc ddd
																											eee</th>
																								</tr>
																							</table> <br/> <font
																								style="font-family: '微軟正黑體', Calibri"
																								color="#003366" size="+1">We Care</font>
																								<hr color="#009999" size="1"/>
																									<br/>
																										<table style="text-align: left">
																											<tr>
																												<th></th>
																											</tr>
																											<tr>
																												<th>專題介紹:.................................................<br/>...............................................</th>
																											</tr>
																											<tr>
																												<th>指導老師:AAA<br/>學生:aaa bbb ccc ddd
																														eee</th>
																											</tr>
																										</table> <br/> <br/><br/>
				
			<!-- 		<br/> <font style="font-family: '微軟正黑體', Calibri"
						color="#330099" size="+2">得獎專題介紹</font> <br/> <font
							style="font-family: '微軟正黑體', Calibri" color="#3333CC">請選擇年份:</font>&nbsp;
							<select>
							<c:forEach items="${projectList}" var="year">
								<option>${year.proYear}</option>
							</c:forEach>
							</select>
						 <br/><br/>
					<c:forEach items="${projectList}" var="pro">
					<ul id="inside">
						<li><a href="">
						<font style="font-family: '微軟正黑體', Calibri">${pro.proTitle}</font></a></li>
					</ul>
					</c:forEach> <br/><br/><br/>
					<c:forEach items="${projectList}" var="prolist">
						<font style="font-family: '微軟正黑體', Calibri" color="#003366" size="+1">${prolist.proTitle}${prolist.proAward}</font>
						<hr color="#009999" size="1"/>
							<br/>
								<table style="text-align: left">
								<tr>
									<th>${prolist.proVideo}</th>
								</tr>
								<tr>
									<th>${prolist.proIntroduction}</th>
								</tr>
								<tr>
									<th>指導教授：${prolist.professor.profName}<br/>學生：${prolist.proMember}</th>
								</tr>
								</table> 
					</c:forEach>
					<br/><br/>    -->
				</div> <!-- content_R fin -->
			</div> <!-- content fin -->
		</div> <!-- container fin -->
	<%@include file="../../templete/footer.jsp" %>
</body>
</html>
