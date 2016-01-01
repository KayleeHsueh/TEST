<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>校友建議GraduateSug</title>
<style>
body {
	background-color: #FFF;
}
</style>
<link href="css/CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
<a name="top"></a>
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
						<li><a href="Project">得獎專題</a></li>
					</ul>

				</div> <!-- content_L fin -->
				<div id="content_R"> <!-- content_R -->
					<ul id="inside"> <!--  分頁按鈕 -->
						<li><a href=""><font style="font-family:'微軟正黑體', Calibri"><a href="#01">研究所</a></font></a></li> 
					    <li><a href=""><font style="font-family:'微軟正黑體', Calibri"><a href="#02">創業者</a></font></a></li>
				  		<li><a href=""><font style="font-family:'微軟正黑體', Calibri"><a href="#03">各行各業</a></font></a></li>
					</ul><br/><br/>
					<font style="font-family:'微軟正黑體', Calibri" color="#003366" size="+1"><a name="01">研究所</a></font>
					<hr align="left" width="70%" color="#003366" size="1"/><br/>
					<div style="text-align:left">
					<div style="font-family:'微軟正黑體', Calibri">
						<table>
						<c:forEach items="${sugList}" var="GraduateSug">
						<c:if test="${GraduateSug.graduate.gradWork==1}">
						<tr>
							<!-- <th><img src="pics/boy.png"/></th> -->
							<th>校友姓名：</th>
							<th>${GraduateSug.graduate.gradName}</th>
						</tr>
						<tr>
							<th>學系：</th>
							<th>${GraduateSug.graduate.gradPosition}</th>
						</tr>
						<tr>
							<th>大學：</th>
							<th>${GraduateSug.graduate.gradCompany}</th>
						</tr>
						<tr>
							<th>工作心得：</th>
							<th>${GraduateSug.sugWorkSharing}</th>
						</tr>
						<tr>
							<th>給新鮮人的建議：</th>
							<th>${GraduateSug.sugForFresh}</th>
						</tr>
						</c:if>
						</c:forEach>
						</table>
						<div align="right"><font style="font-family:'微軟正黑體', Calibri" color="#0C0"><a href="#top">TOP</a></font></div>
						<br></br>
					<font style="font-family:'微軟正黑體', Calibri" color="#003366" size="+1"><a name="02">創業者</a></font>
					<hr align="left" width="70%" color="#003366" size="1"/><br/>
					<div style="text-align:left">
					<div style="font-family:'微軟正黑體', Calibri">
						<table>
						<c:forEach items="${sugList}" var="GraduateSug">
						<c:if test="${GraduateSug.graduate.gradWork==2}">
						<tr>
							<!-- <th><img src="pics/boy.png"/></th> -->
							<th>校友姓名：</th>
							<th>${GraduateSug.graduate.gradName}</th>
						</tr>
						<tr>
							<th>職位：</th>
							<th>${GraduateSug.graduate.gradPosition}</th>
						</tr>
						<tr>
							<th>公司：</th>
							<th>${GraduateSug.graduate.gradCompany}</th>
						</tr>
						<tr>
							<th>工作心得：</th>
							<th>${GraduateSug.sugWorkSharing}</th>
						</tr>
						<tr>
							<th>給新鮮人的建議：</th>
							<th>${GraduateSug.sugForFresh}</th>
						</tr>
						</c:if>
						</c:forEach>
						</table>
						<div align="right"><font style="font-family:'微軟正黑體', Calibri" color="#0C0"><a href="#top">TOP</a></font></div>
						<br></br>
					<font style="font-family:'微軟正黑體', Calibri" color="#003366" size="+1"><a name="03">各行各業</a></font>
					<hr align="left" width="70%" color="#003366" size="1"/><br/>
					<div style="text-align:left">
					<div style="font-family:'微軟正黑體', Calibri">
						<table>
						<c:forEach items="${sugList}" var="GraduateSug">
						<c:if test="${GraduateSug.graduate.gradWork==3}">
						<tr>
							<!-- <th><img src="pics/boy.png"/></th> -->
							<th>校友姓名：</th>
							<th>${GraduateSug.graduate.gradName}</th>
						</tr>
						<tr>
							<th>職位：</th>
							<th>${GraduateSug.graduate.gradPosition}</th>
						</tr>
						<tr>
							<th>公司：</th>
							<th>${GraduateSug.graduate.gradCompany}</th>
						</tr>
						<tr>
							<th>工作心得：</th>
							<th>${GraduateSug.sugWorkSharing}</th>
						</tr>
						<tr>
							<th>給新鮮人的建議：</th>
							<th>${GraduateSug.sugForFresh}</th>
						</tr>
						</c:if>
						</c:forEach>
						</table>
						<div align="right"><font style="font-family:'微軟正黑體', Calibri" color="#0C0"><a href="#top">TOP</a></font></div>
					</div>
					</div>
					</div>
					</div><br/><br/>
					</div>
					</div>
				</div> <!-- content_R fin -->
			</div> <!-- content fin -->
		</div> <!-- container fin -->
	<%@include file="../../templete/footer.jsp" %>
</body>
</html>
