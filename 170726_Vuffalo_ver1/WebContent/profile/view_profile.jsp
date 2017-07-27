<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필보기팝업</title>
<link rel="styleSheet" href="profile/css/view_profile.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="profile/js/myScript.js"></script>

</head>
<body>
<input type="hidden" id="favorOrNot" name="favorOrNot" value = "${favorOrNot}">
<div class='popupBound'>
<table>
	<tr>
		<td colspan="4" class="backgroundBlue">
			프로필 상세보기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<img class="pointer" src="profile/images/gray.png"  onClick = "goServlet('${grade}', '${bean.num}', '${bean.nickname}', 12);" />
			<!--
			<c:choose>
			
				<c:when test="${favorOrNot == '0'}">
					<img src = "profile/images/gray.png" onClick = "addFavorite()">
				</c:when>
			
				<c:otherwise>
					<img src = "profile/images/yellow.png" onClick = "removeFavorite()">
				</c:otherwise>
			</c:choose>
			-->
		</td>
	</tr>
	<tr>
		<td colspan = "4">
				<img class="photo" src="profile/images/recommendFriend.png"/>
				<!-- 
				<c:choose>
					<c:when test="${moveOrNot == '1'}">
						<video class = "photo" src = "${movie}"" autoplay loop></video>
					</c:when>
					<c:otherwise>					
						<img class="photo" src = "${image}">
					</c:otherwise>
				</c:choose>
				 -->
		</td>
	</tr>
	
		
	<tr>
		<td class="popupLabelHeight">닉네임</td>
		<td class="textCenter">${bean.nickname}</td>
		
		<td class="popupLabelHeight">나이</td>
		<c:choose>
		<c:when test="${bean.age == 0 }">
		<td class="textCenter">입력안함</td>
		</c:when>
		<c:otherwise>
		<td class="textCenter">${bean.age}</td>
		</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td class="popupLabelHeight">성별</td>
		<c:choose>
			<c:when test="${bean.gender == '1' }">
				<td class="textCenter">남성</td>
		 	 </c:when>
		  <c:otherwise>
		  <td class="textCenter">여성</td>
		  </c:otherwise>
		 </c:choose>
		<td class="popupLabelHeight">국가</td>
		<c:choose>
			<c:when test="${bean.nationality==null }">
			<td class = "textCenter">입력안함</td>
			</c:when>
			<c:otherwise>
			<td class = "textCenter">${bean.nationality}</td>
			</c:otherwise>
			</c:choose>
	</tr>
	<tr>
	
		<td class="popupLabelHeight">사용언어</td>
		<c:choose>
			<c:when test="${bean.mTongue==null }">
			<td class = "textCenter">입력안함</td>
			</c:when>
			<c:otherwise>
			<td class = "textCenter">${bean.mTongue}</td>
			</c:otherwise>
			</c:choose>
		<td class="popupLabelHeight">관심언어</td>
		<c:choose>
			<c:when test="${bean.interest==null }">
			<td class = "textCenter">입력안함</td>
			</c:when>
			<c:otherwise>
			<td class = "textCenter">${bean.interest}</td>
			</c:otherwise>
			</c:choose>
	</tr>
	<tr>
		<td class="popupLabelHeight">프로필수정일</td>
		<c:choose>
			<c:when test="${bean.lastProfileUpdate==null }">
			<td class = "textCenter">입력안함</td>
			</c:when>
			<c:otherwise>
			<td class = "textCenter">${bean.lastProfileUpdate}</td>
			</c:otherwise>
			</c:choose>
		<td class="popupLabelHeight">최종방문일</td>
		<c:choose>
			<c:when test="${bean.lastVisitDate==null}">
				<td class = "textCenter">입력안함</td>
				</c:when>
			<c:otherwise>
			<td class = "textCenter">${bean.lastVisitDate}</td>
			</c:otherwise>
			</c:choose>
	</tr>
	<tr>
	</tr>
	<tr>
	</tr>
	<tr>
	<td colspan="4"></td>
	</tr>
	<tr>
		<td colspan = "4">
			<div class="textCenter">
			<img class="pointer" src = "profile/images/block.png" onClick = "goServlet('${grade}', '${bean.num}', '${bean.nickname}', 6);">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<img class="pointer" src = "profile/images/message.png" onClick = "goServlet('${grade}', '${bean.num}', '${bean.nickname}', 11);">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<img class="pointer" src = "profile/images/friend.png" onClick = "goServlet('${grade}', '${bean.num}', '${bean.nickname}', 3);">
			</div>	
		</td>
	</tr>
</table>
</div>
</body>
</html>