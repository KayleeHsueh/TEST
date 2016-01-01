<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>師資陣容Teacher</title>
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
		<div style="margin-left: 100px">
			<!-- content -->
			<ul id="inside">
				
				<!--  分頁按鈕 -->
				<li><a href="Teacher?ProfSpe_ID=401"><font
						style="font-family: '微軟正黑體', Calibri"><a href="#01">科技行銷</a></font></a></li>
				<!-- 專業ID401 -->
				<li><a href="Teacher?ProfSpe_ID=402"><font
						style="font-family: '微軟正黑體', Calibri"><a href="#02">程式設計</a></font></a></li>
				<!-- 專業ID402 -->
				<li><a href="Teacher?ProfSpe_ID=403"><font
						style="font-family: '微軟正黑體', Calibri"><a href="#03">商業智慧</a></font></a></li>
				<!-- 專業ID403 -->
				<li><a href="Teacher?ProfSpe_ID=404"><font
						style="font-family: '微軟正黑體', Calibri"><a href="#04">企業應用</a></font></a></li>
				<!-- 專業ID404 -->
				<li><a href="Teacher?ProfSpe_ID=405"><font
						style="font-family: '微軟正黑體', Calibri"><a href="#05">電子商務</a></font></a></li>
				<!-- 專業ID405 -->
			</ul><br/>
			<br /> 
			<div style="font-family: '微軟正黑體', Calibri">
			<div style="text-align:left">
			<font color="#003366" size="+1"><a name="01">科技行銷</a></font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<div style="padding-left:150px">
			<table>
				<c:forEach items="${SpecialtyList1}" var="teacher">
					<!-- c:if test="${true}" -->
						<tr>
							<th><img src="${teacher.profPicture}" width="150" height="200"/></th> 
							<th>${teacher.profName}<br />${teacher.profGraduateSchool}<br />${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
					<!-- /c:if -->
				</c:forEach>
			</table>
			</div>
			<div align="right"><font style="font-family:'微軟正黑體', Calibri" color="#0C0"><a href="#top">TOP</a></font></div>
			<br />
			<br /> <font color="#003366" size="+1"><a name="02">程式設計</a></font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<div style="padding-left:150px">
			
			<table>
				<c:forEach items="${SpecialtyList2}" var="teacher">
					<!-- c:if test="${true}" -->
						<tr>
							<th><img src="${teacher.profPicture}" width="150" height="200"/></th>  
							<th>${teacher.profName}<br />${teacher.profGraduateSchool}<br />${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
					<!-- /c:if -->
				</c:forEach>
			</table>
			
			</div>
			<div align="right"><font style="font-family:'微軟正黑體', Calibri" color="#0C0"><a href="#top">TOP</a></font></div>
			<br />
			<br /> <font color="#003366" size="+1"><a name="03">商業智慧</a></font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<div style="padding-left:150px">
			<table>
				<c:forEach items="${SpecialtyList3}" var="teacher">
					<!-- c:if test="${true}" -->
						<tr>
							<th><img src="${teacher.profPicture}" width="150" height="200"/></th> 
							<th>${teacher.profName}<br />${teacher.profGraduateSchool}<br />${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
					<!-- /c:if -->
				</c:forEach>
			</table>
			</div>
			<div align="right"><font style="font-family:'微軟正黑體', Calibri" color="#0C0"><a href="#top">TOP</a></font></div>
			<br />
			<br /><font color="#003366" size="+1"><a name="04">企業應用</a></font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<div style="padding-left:150px">
			<table>
				<c:forEach items="${SpecialtyList4}" var="teacher">
					<!-- c:if test="${true}" -->
						<tr>
							<th><img src="${teacher.profPicture}" width="150" height="200"/></th> 
							<th>${teacher.profName}<br/>${teacher.profGraduateSchool}<br/>${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
					<!-- /c:if -->
				</c:forEach>
			</table>
			</div>
			<div align="right"><font style="font-family:'微軟正黑體', Calibri" color="#0C0"><a href="#top">TOP</a></font></div>
			<br />
			<br /><font color="#003366" size="+1"><a name="05">電子商務</a></font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<div style="padding-left:150px">
			<table>
				<c:forEach items="${SpecialtyList5}" var="teacher">
					<!-- c:if test="${true}" -->
						<tr>
							<th><img src="${teacher.profPicture}" "width="150" height="100"/></th>  
							<th>${teacher.profName}<br />${teacher.profGradusteSchool}<br />${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
					<!-- /c:if -->
				</c:forEach>
			</table>
			</div>
			<div align="right"><font style="font-family:'微軟正黑體', Calibri" color="#0C0"><a href="#top">TOP</a></font></div>
			<br />
			<br />
			</div>
			</div>
			</div> <!-- content fin -->
		</div> <!-- container fin -->
	<%@include file="../../templete/footer.jsp" %>
</body>
</html>
