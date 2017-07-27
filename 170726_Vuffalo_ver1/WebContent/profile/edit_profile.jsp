<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 수정하기</title>
<link rel="styleSheet" href="profile/css/edit_profile.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" , src="profile/js/myScript.js"></script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
<div class='outerBound'>
	<h2>내 프로필 수정</h2>
	<div>다른 친구들이 보는 나의 프로필입니다! 당신의 개성을 마음껏 뽐내보세요:)</div>
	<hr>
	<form name = 'myProfileForm' id = 'myProfileForm' method='post' action = 'ProfileEditServlet'>
	<table>
	<tr>
		<td>
			이름
		</td>
		<td>
			<input type="text" class = "inputLine" id="name" name="name" value="${pname}"/>
		</td>
	</tr>
	<tr>
		<td>
			나이
		</td>
		<td>
		<input type="text" class = "inputLine" id="age" name="age" value="${page}"/>
 			<!-- <select class = "inputLine" name="age" id = "age">
				<c:forEach var = "age" items="${ageList}">
					<option value = "${age}">${age}</option>
				</c:forEach>
			</select>-->
		</td>
	</tr>
	<tr>
		<td>
			모국어
		</td>
		<td>
			<select class = "inputLine" name="motherTongue" id = "motherTongue" >
				<c:forEach var = "language" items="${languageList}" varStatus="loopCount">
					<option value = "${language}">${language}</option>
				</c:forEach>
			</select>

		</td>
	</tr>
	<tr>
		<td>
			실습희망언어
		</td>
		<td>
			<select class = "inputLine" name="hopeLanguage" id = "hopeLanguage">
				<c:forEach var = "language" items="${languageList}" varStatus="loopCount">
					<option value = "${language}">${language}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			이메일주소
		</td>
		<td>
			<input type="text" class = "inputLine" id="mail" name="mail"  value="${pmail}" />
		</td>
	</tr>
	<tr>
		<td>
			성별
		</td>
		<td>
			<!-- <input type="text" class = "inputLine" id="gender" name="gender" value=""   />-->
			<select class = "inputLine" name="gender" id = "gender">
				<c:forEach var = "gender" items="${genderList}" varStatus="loopCount">
					<option value = "${loopCount.count}">${gender}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			국가
		</td>
		<td>
			<select class = "inputLine" name="country" id = "country">
				<c:forEach var = "country" items="${countryList}" varStatus="loopCount">
					<option value = "${country}">${country}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			자기소개
		</td>
		<td>
			<textarea class = "inputLines" id="introduce" name="introduce" >${pselfIntro } </textarea>
		</td>
	</tr>
	<tr>
		<td>
			프로필 공개 여부
		</td>
		<td>
			<input type="radio" name="profileOpenType" value="1">전체공개
			<input type="radio" name="profileOpenType" value="2" checked>친구공개
			<input type="radio" name="profileOpenType" value="3">비공개
		</td>
	</tr>
	<tr>
		<td>
			소개영상
		</td>
		<td>
			<!-- <input type="text" class = "inputShortLine" id="image" name="image"   />
			<input type="button" class = "searchButton" id="writeButton" value="찾기"/>-->
			<input type="file" name = "addedFile" onClick="fileInfo(this)" value="1"/>
		</td>
	</tr>
	<tr>
		<td>
		</td>
		<td>
			<input type="button" class = "confirmButton" id="confirmButton" value="확인" onClick = "modifyProfile()"/>
			<input type="button" class = "cancelButton" id="searchButton" value="취소" onClick = "cancelModifyProfile()"/>
			<input type="hidden" name="flag" value="1"/>
		</td>
	</tr>
	</table>
	</form>
	</div>
</body>
</html>