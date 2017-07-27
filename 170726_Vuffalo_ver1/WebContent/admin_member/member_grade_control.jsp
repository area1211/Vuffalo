<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등급관리</title>
<link rel="styleSheet" href="admin_member/css/member_grade_control.css">
<script type="text/javascript" src="admin_member/js/myScript.js"></script>
</head>
<body>
<div class="popupBound">
	<form name = "levelChangeMember" id="levelChangeMember" method="get" action = 'memberGrade.do'>
		<div class="backgroundBlue">등급관리</div>
		<br>
		<h3 class="textCenter">등급 관리 대상 멤버</h3>
		<div class="textCenter"><input type="text" class = "inputShortLine" id="name" name="name" value="${name}" readonly/></div><br>
		<br><br><br>
		<h3 class="textCenter">변경 대상 등급</h3>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id = "level" name="level" value="1" checked>일반회원<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id = "level" name="level" value="2">스태프<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id = "level" name="level" value="3">관리자<br>
		<br><br><br>
		<h3 class="textCenter">등급 변경을 적용하시겠습니까?</h3>
		<div class="textCenter">
		<input type="button" class = "bigConfirmButton" id="confirmButton" value="적용" onClick = "updateMem()"/>
		<input type="button" class = "bigCancelButton" id="cancelButton" value="취소" onClick = "cancel()"/>
		</div>
	</form>	
</div>
</body>
</html>