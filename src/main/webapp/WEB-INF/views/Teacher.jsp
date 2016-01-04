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

	<div id="container">
		
		<div style="margin-left: 100px">
			<!-- content -->
			<br />
			<ul id="inside">
				
				<!--  分頁按鈕 -->
				<li><a href="Teacher?ProfSpe_ID=401"><font
						style="font-family: '微軟正黑體', Calibri">科技行銷</font></a></li>
				<!-- 專業ID401 -->
				<li><a href="Teacher?ProfSpe_ID=402"><font
						style="font-family: '微軟正黑體', Calibri">程式設計</font></a></li>
				<!-- 專業ID402 -->
				<li><a href="Teacher?ProfSpe_ID=403"><font
						style="font-family: '微軟正黑體', Calibri">商業智慧</font></a></li>
				<!-- 專業ID403 -->
				<li><a href="Teacher?ProfSpe_ID=404"><font
						style="font-family: '微軟正黑體', Calibri">企業應用</font></a></li>
				<!-- 專業ID404 -->
				<li><a href="Teacher?ProfSpe_ID=405"><font
						style="font-family: '微軟正黑體', Calibri">電子商務</font></a></li>
				<!-- 專業ID405 -->
			</ul>
			
	<c:choose>
	<c:when test="${sessionScope['scopedTarget.account'].identity=='secretary'}">											
	<form method="post" action="insertTeacher">
		<table cellpadding="10px" border="1" bordercolor="#009933" style="font-family:'微軟正黑體', Calibri">
			<CAPTION>新增</CAPTION>
			<tr>			
				<th>教授名稱</th>
				<th>圖片網址</th>
				<th>學校</th>
				<th>科系</th>
				<th>學位</th>
				<th>專長</th>			
				
			</tr>
			<tr>			
				<th><input type="text" name="profName"/></th>
				<th><input type="text" name="profPicture"/></th>
				<th><input type="text" name="profGraduateSchool"/></th>
				<th><input type="text" name="profGraduateDepartment"/></th>
				<th><input type="text" name="profDegree"/></th>
				<th>
				<select class="form-control" id="profSpeName" name="profSpeName" multiple>
					 <option name="profSpeName" value="企業應用">
					  	企業應用
				  	 </option>
				  	  <option name="profSpeName" value="商業智慧">
					  	商業智慧
				  	 </option>
				  	  <option name="profSpeName" value="科技行銷">
					  	科技行銷
				  	 </option>
				  	  <option name="profSpeName" value="程式設計">
					  	程式設計
				  	 </option>
				  	  <option name="profSpeName" value="電子商務">
					  	電子商務
				  	 </option>
				</select>			
				</th>
	   			<th><button type="submit">送出</button></th><br/>				
			</tr>
		</table>
	</form>	
	</c:when>
	</c:choose>			
			
			
			
			<br /> <font style="font-family: '微軟正黑體', Calibri" color="#003366"
				size="+1">科技行銷</font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<table>
				<c:forEach items="${SpecialtyList1}" var="teacher">
					<!-- c:if test="${true}" -->
						<tr>
							<th><img src="${teacher.profPicture}" width="100" height="100"/></th> 
							<th>${teacher.profName}<br />${teacher.profGraduateSchool}<br />${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
						<tr>
						<c:if test="${sessionScope['scopedTarget.account'].identity=='secretary'}">
							<td>
								<form action="deleteTeacher" method="post">
									<input type="hidden" name="profID" id="${teacher.profID}" value="${teacher.profID}"></input>
									<button type = "submit">刪除</button>
								</form>
							</td>                                                                     
						</c:if> 
						</tr> 
				</c:forEach>
			</table>
			<br />
			<br /> <font style="font-family: '微軟正黑體', Calibri" color="#003366"
				size="+1">程式設計</font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<table>
				<c:forEach items="${SpecialtyList2}" var="teacher">
					
						<tr>
							<th><img src="${teacher.profPicture}" width="100" height="100"/></th>  
							<th>${teacher.profName}<br />${teacher.profGraduateSchool}<br />${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
						<tr>
						<c:if test="${sessionScope['scopedTarget.account'].identity=='secretary'}">
							<td>
								<form action="deleteTeacher" method="post">
									<input type="hidden" name="profID" id="${teacher.profID}" value="${teacher.profID}"></input>
									<button type = "submit">刪除</button>
								</form>
							</td>                                                                     
						</c:if>
						</tr>   
						<tr></tr>					
				</c:forEach>
			</table>
			<br />
			<br /> <font style="font-family: '微軟正黑體', Calibri" color="#003366"
				size="+1">商業智慧</font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<table>
				<c:forEach items="${SpecialtyList3}" var="teacher">
					<!-- c:if test="${true}" -->
						<tr>
							<th><img src="${teacher.profPicture}" width="100" height="100"/></th> 
							<th>${teacher.profName}<br />${teacher.profGraduateSchool}<br />${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
						<tr>
						<c:if test="${sessionScope['scopedTarget.account'].identity=='secretary'}">
							<td>
								<form action="deleteTeacher" method="post">
									<input type="hidden" name="profID" id="${teacher.profID}" value="${teacher.profID}"></input>
									<button type = "submit">刪除</button>
								</form>
							</td>                                                                     
						</c:if> 
						</tr>
				</c:forEach>
			</table>
			<br />
			<br /><font style="font-family: '微軟正黑體', Calibri" color="#003366"
				size="+1">企業應用</font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<table>
				<c:forEach items="${SpecialtyList4}" var="teacher">
					<!-- c:if test="${true}" -->
						<tr>
							<th><img src="${teacher.profPicture}" "width="100" height="100"/></th> 
							<th>${teacher.profName}<br/>${teacher.profGraduateSchool}<br/>${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
						<tr>
					    <c:if test="${sessionScope['scopedTarget.account'].identity=='secretary'}">
							<td>
								<form action="deleteTeacher" method="post">
									<input type="hidden" name="profID" id="${teacher.profID}" value="${teacher.profID}"></input>
									<button type = "submit">刪除</button>
								</form>
							</td>                                                                     
						</c:if>
						</tr>   
				</c:forEach>
			</table>
			<br />
			<br /><font style="font-family: '微軟正黑體', Calibri" color="#003366"
				size="+1">電子商務</font>
			<hr align="left" width="80%" color="#003366" size="1" />
			<br />
			<table>
				<c:forEach items="${SpecialtyList5}" var="teacher">
					<!-- c:if test="${true}" -->
						<tr>
							<th><img src="${teacher.profPicture}" "width="100" height="100"/></th>  
							<th>${teacher.profName}<br />${teacher.profGradusteSchool}<br />${teacher.profGraduateDepartment}<br />${teacher.profDegree}</th>
						</tr>
						<tr>
						<c:if test="${sessionScope['scopedTarget.account'].identity=='secretary'}">
							<td>
								<form action="deleteTeacher" method="post">
									<input type="hidden" name="profID" id="${teacher.profID}" value="${teacher.profID}"></input>
									<button type = "submit">刪除</button>
								</form>
							</td>                                                                     
						</c:if>
						</tr>	   
				</c:forEach>
			</table>
			<br />
			<br />

			</div> <!-- content fin -->
		</div> <!-- container fin -->

</body>
</html>
