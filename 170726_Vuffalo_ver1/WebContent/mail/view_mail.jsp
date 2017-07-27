<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메일보기</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="mail/js/view_mail.js"></script>
<link rel="stylesheet" href="mail/css/view_mail.css"/>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div id="l_body" style="height:700px; width:1000px; margin:auto;" >
	<div>
		<h2>&nbsp;편지내용</h2>
	</div>
	<hr/>
	<div id="btns">
		<input type="button" value="답장" onclick = "replyLetter()"/>
		<input type="button" value="삭제"/>
		<input type="button" value="목록으로"/>
	</div>
	<br/>
	<form id="reply" method = "GET" action="linkSendMail.do">
		<input type="hidden" id="receiverNickName" name="receiverNickName" />
	</form>
	<div id="tb">
		<table>
			<tr>
				<td>From.</td>
				<td><input type="text" value="${profile.senderNickName}" readonly/></td>		
			</tr>
			<tr>
				<td>Title.</td>
				<td><input type="text" value="${profile.title}" readonly/></td>
			</tr>
			<tr>
				<td>Date.</td>
				<td><input type="text" value="${profile.sendDate}" readonly/></td>
			</tr>
			<tr>
				<td><button id="spreadBtn" class="btn01">펼치기</button></td>
			</tr>
			<tr>
			<td colspan="2">
			<c:choose>
				<c:when test="${profile.fileFlag == '2'}">
					<video class = "photo" src = ${profile.fileUrl} autoplay="true" loop="false" controls="true"></video>
					
				</c:when>
				<c:when test="${profile.fileFlag == '1'}">
					
					<img class="photo" src = ${profile.fileUrl}>
				</c:when>
			</c:choose>
			</td>
			</tr>
			<tr>                                   
				<td id="hiddenList" class="box" colspan="2" style="display: none;">
				<video poster="movie.jpg" width="400" height="300" controls="controls">
				 <source src="movie.ogg" type='video/ogg' />
				 <source src="mail/videos/악녀.mp4" type='video/mp4' /> 
				</video>
				</td>
			</tr>
			<tr>
				<td class="box" colspan="2">${profile.content}</td>
			</tr>
		</table>	
	</div>
</div>
</body>
</html>