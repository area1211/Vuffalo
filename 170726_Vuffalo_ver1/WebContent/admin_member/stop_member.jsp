<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>친구추천</title>
<link rel="styleSheet" href="admin_member/css/stop_member.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="admin_member/js/myScript.js"></script>
</head>
<body>
<div class="popupBound">
<form name = "stopMember" id="stopMember" method="get" action = 'stopMember.do'>
	<div class="backgroundBlue">활동정지</div>
	<h3 class="textCenter">활동 정지 대상 멤버</h3>
	<div class="textCenter"><input type="text" class = "inputShortLine" id="name" name="name" value="${name}" readonly/></div><br>
	<h3 class="textCenter">활동 정지 사유</h3>
	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id = "reason" name="reason" value="1">성인/도박 등 불법광고 및 스팸 활동<br>
	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id = "reason" name="reason" value="2">바람직하지 않은 활동(광고,도배,욕설,비방 등)<br>
	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id = "reason" name="reason" value="3" checked>사이트 운영 원칙에 위배되는 활동<br>
	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id = "reason" name="reason" value="4">기타 - 한글 25자 or 영문 50자 이내로 작성<br><br>
	<div class="textCenter"><input type="text" class = "inputShortLine" id="reasonInText" name="reasonInText"/></div><br>
	<h3 class="textCenter">활동 정지 기간</h3>
	&nbsp;&nbsp;&nbsp;&nbsp;<select class = "inputShortLine" name="stopPeriod" id = "stopPeriod">
		<c:forEach var = "period" items="${stopPeriod}" varStatus="loopCount">
			<option value = "${loopCount.count}">${period}</option>
		</c:forEach>
	</select>
	<br><br>
	<h3 class="textCenter">대상 멤버를 활동정지시키시겠습니까?</h3>
	<div class="textCenter">
	<input type="button" class = "bigConfirmButton" id="confirmButton" value="활동정지" onClick = "stopMem()"/>
	<input type="button" class = "bigCancelButton" id="cancelButton" value="취소" onClick = "cancel()"/>
	</div>
	</form>
</div>

</body>
</html>