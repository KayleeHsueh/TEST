<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>回答問題Question_ans</title>
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
						<li><a href=""><font style="font-family: '微軟正黑體', Calibri">未答的問題</font></a></li>
						<li><a href=""><font style="font-family: '微軟正黑體', Calibri">已回答的問題</font></a></li>
					</ul>
					<br/>
							<font style="font-family:'微軟正黑體', Calibri" color="#FF6600" size="+1">已發問而未答...</font>
							<div style="font-family:'微軟正黑體', Calibri">
							<div style="background-color:#FC9">
							<div style="padding-left:30px">
								<table cellpadding="10px">
						  		
					
						  		<tr><th>問題類別</th><th>問題內容</th><th>回答</th><th>是否為常見問題</th><th>送出</th></tr>
								<c:forEach items="${waitingList}" var="QA">
									<tr>								
									<form action="updateQA" method="post">	
										<td>${QA.questionCategory.qCate_Name}</td>
										<td style="text-align:left">${QA.question_Content}</td>
										<th>
                                        <input type="text" name="answer_Content" placeholder="輸入回答" id="${QA.answer_Content} value="${QA.answer_Content}" required style="padding:10px"/>
										</th>
										<th>
											<c:choose>			
											<c:when test="${QA.problemSet == 'true'}">
												<input type="checkbox" name="problemSet" value="true" checked />
											</c:when>	
											<c:when test="${QA.problemSet == 'false'}">
												<input type="checkbox" name="problemSet" value="true" />
											</c:when>	
										</c:choose>		
										</th>
										<th>
										<input type="hidden" name="Question_ID" id="${QA.question_ID}" value="${QA.question_ID}"></input>
										<button type ="submit">回覆</button>                                      
										</th>
									</form>  
									
									</tr>
								</c:forEach>
							 	
								</table>
							</div>
							</div>
							</div>
							    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    				<script src="js/bootstrap.min.js"></script> 
					<script src="js/jquery.validate.js"></script>
					<script src="js/additional-methods.js"></script>
					<script src="js/messages_zh_TW.js"></script>
					<script>
					$("#updateForm").validate({
					rules:{
					title:"required",
					content:"required"
						}
					});
					</script>
								<br/>
							<font style="font-family:'微軟正黑體', Calibri" color="#CC33FF" size="+1">已回答的問題...</font>
							<div style="font-family:'微軟正黑體', Calibri">
							<div style="background-color:#E6CCFF">
							<div style="padding-left:50px">
								
								<table cellpadding="10px">				
								<tr><th>問題類別</th><th>問題內容</th><th>回答</th><th>是否為常見問題</th><th>刪除</th></tr>
								<c:forEach items="${finList}" var="QA">									
									<tr>
										<td>${QA.questionCategory.qCate_Name}</td>
										<td style="text-align:left">${QA.question_Content}</td>
										<td><input type="text" name="desc" value="${QA.answer_Content}" required style="padding:10px"/></td>
									
										<th>
											<c:choose>			
											<c:when test="${QA.problemSet == 'true'}">
												<input type="checkbox" value="true" checked/>
											</c:when>	
											<c:when test="${QA.problemSet == 'false'}">
												<input type="checkbox" value="false"/>
											</c:when>	
											</c:choose>						
										</th>
                                  
										<td>
										<form action="deleteQA" method="post">
											<input type="hidden" name="Question_ID" id="${QA.question_ID}" value="${QA.question_ID}"></input>
											<button type = "submit">刪除</button>
											</form>
										</td>                                                                     
									</tr>
								</c:forEach>
								</table>
								
							</div>
							</div>
							</div>
							<br/>
				</div>
				
				<!-- content_R fin -->
			</div>
			<!-- content fin -->
			
   			<div id="footer">
			<hr/>
				<div align="center">
					<font size="-1" color="#003366"
						style="font-family: '微軟正黑體', Calibri">Copyright (c) 2015
						Fu-Jen Catholic University Institute of Information Management.
						All Rights Reserved.</font>
				</div>
			</div> <!-- footer fin -->
		</div> <!-- container fin -->
</body>
</html>

