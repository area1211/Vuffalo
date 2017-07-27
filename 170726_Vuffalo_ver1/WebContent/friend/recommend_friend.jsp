<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>친구추천</title>
<link rel="styleSheet" href="friend/css/recommend_friend.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" , src="friend/js/myScript.js"></script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div class="div_body">
		<div class="popupBound">
			<div class="backgroundBlue">친구추천</div>
			<br>
			<div class="centerBigFont">
				오늘은 어떤 친구를
				</h1>
				<div class="centerBigFont">
					만나게 될까요?
					</h1>
					<div>
						<img src="friends/images/recommendFriend.png">
					</div>
					<br> <input type="button" class="recommendButton"
						id="recommendButton" value="추천받기" onClick="recommend()" />
				</div>
			</div>
</body>
</html>