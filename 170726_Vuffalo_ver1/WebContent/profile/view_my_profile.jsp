<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 보기</title>
<link rel="styleSheet" href="profile/css/view_my_profile.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" , src="profile/js/myScript.js"></script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
<div class='outerBound'>
	<h2>내 프로필 보기</h2>
	<div>다른 친구들이 보는 나의 프로필입니다! 당신의 개성을 마음껏 뽐내보세요:)</div>
	<hr>
	<!-- <form name = 'myProfile' id ='myProfile' method = 'get' action = 'editProfile.do'>-->
	<form name = 'myProfile' id ='myProfile' method = 'get' action = 'ProfileEditServlet'>
	<table>
		<tr>
			<td rowspan="6">
			<c:choose>
				<c:when test="${moveOrNot == '1'}">
					<video class = "photo" src = ${movie} autoplay="false" loop="false" controls="true"></video>
				</c:when>
				<c:otherwise>					
					<img class="photo" src = ${image}>
				</c:otherwise>
			</c:choose>
			
			</td>
			<td class = "profileLabel">닉네임&nbsp;&nbsp;</td>
			<td class = "profileData">${bean.nickname}</td>
			
		</tr>
		<tr>
			<td class = "profileLabel">나이&nbsp;&nbsp;</td>
			<c:choose>
			<c:when test="${bean.age==0}">
			<td class = "profileData">입력안함</td>
			</c:when>
			<c:otherwise>
			<td class = "profileData">${bean.age}</td>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			
			<td class = "profileLabel">사용언어&nbsp;&nbsp;</td>
			<c:choose>
			<c:when test="${bean.mTongue==null }">
			<td class = "profileData">입력안함</td>
			</c:when>
			<c:otherwise>
			<td class = "profileData">${bean.mTongue}</td>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			
			<td class = "profileLabel">실습희망언어&nbsp;&nbsp;</td>
			<c:choose>
			<c:when test="${bean.interest==null }">
			<td class = "profileData">입력안함</td>
			</c:when>
			<c:otherwise>
			<td class = "profileData">${bean.interest}</td>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			
			<td class = "profileLabel">이메일&nbsp;&nbsp;</td>
			<c:choose>
			<c:when test="${bean.email=='' }">
			<td class = "profileData">입력안함</td>
			</c:when>
			<c:otherwise>
			<td class = "profileData">${bean.email}</td>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			
			<td class = "profileLabel">성별&nbsp;&nbsp;</td>
			<c:choose>
				<c:when test="${bean.gender==0 }">
					<td class ="profileData">입력안함</td>
				</c:when>
				<c:when test="${bean.gender=='1' }">
					<td class = "profileData">남성</td>
				</c:when>
				<c:when test="${bean.gender=='2' }">
					<td class = "profileData">여성</td>
				</c:when>
			</c:choose>
		</tr>
		<tr>
			<c:choose>
			<c:when test="${bean.selfIntro==null }">
			<td rowspan='4' class="profileDesc">프로필 등록안함</td>
			</c:when>
			<c:otherwise>
			<td rowspan='4' class="profileDesc">자기소개 : ${bean.selfIntro }</td>
			</c:otherwise>
			</c:choose>
			
			<td class = "profileLabel">국가&nbsp;&nbsp;</td>>
			<c:choose>
			<c:when test="${bean.nationality==null}">
					<td class = "profileData">입력안함</td>
			</c:when>
			<c:otherwise>
					<td class = "profileData">${bean.nationality}</td>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			
			<td class = "profileLabel">프로필 공개&nbsp;&nbsp;</td>
			<c:choose>
			<c:when test="${bean.openRange==0}">
					<td class = "profileData">입력안함</td>
					</c:when>
			<c:when test="${bean.openRange=='1' }">
					<td class = "profileData">전체공개</td>
				</c:when>
				<c:when test="${bean.openRange=='2' }">
					<td class = "profileData">친구공개</td>
				</c:when>
				<c:when test="${bean.openRange=='3' }">
					<td class = "profileData">비공개</td>
				</c:when>
			</c:choose>
			<td class = "profileData">${pprofileOpenType}</td>
		</tr>
		<tr>
			
			<td class = "profileLabel">최종방문일&nbsp;&nbsp;</td>
			<c:choose>
			<c:when test="${bean.lastVisitDate==null}">
				<td class = "profileData">입력안함</td>
				</c:when>
			<c:otherwise>
			<td class = "profileData">${bean.lastVisitDate}</td>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			
			<td class = "profileLabel">프로필수정일&nbsp;&nbsp;</td>
			<c:choose>
			<c:when test="${bean.lastProfileUpdate==null }">
			<td class = "profileData">입력안함</td>
			</c:when>
			<c:otherwise>
			<td class = "profileData">${bean.lastProfileUpdate}</td>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td></td>
			
			<td></td>
			<input type="hidden" name="flag" value="0">
			<td><input type="button" class = "confirmButton" id="confirmButton" value="수정" onClick = "editProfile()"/></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>