<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 추가/수정</title>
<link rel="styleSheet" href="admin_board/css/add_or_edit_board.css">
<script type="text/javascript" src="admin_board/js/admin_board.js"></script>
</head>
<body onload = "editBoardDefaultSetting('${addOrEdit}','${boardName}', '${boardDesc}','${writeRight}','${commentRight}','${openLevel}')">
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<jsp:include page="/admin_menu.jsp" /><!-- 관리자메뉴 -->
	
<div class='managerBound'>
	<c:choose>
		<c:when test="${addOrEdit == '0'}">
			<h3>게시판 추가하기</h3>
		</c:when>
		<c:otherwise>
			<h3>게시판 수정하기</h3>
		</c:otherwise>
	</c:choose>
	<hr>
<table>
	<tr>
		<td>
			게시판명
		</td>
		<td>
			<input type="text" class = "inputLine" id="boardName" name="boardName"  />
		</td>
	</tr>
	<tr>
		<td>
			게시판 설명
		</td>
		<td>
 			<input type="text" class = "inputLine" id="boardDesc" name="boardDesc"  />
		</td>
	</tr>
	<tr>
		<td>
			글 작성 권한
		</td>
		<td>
			<select class = "inputLine" name="writeRight" id = "writeRight" selectedIndex  = "2">
				<c:forEach var = "memberLevel" items="${memberLevelList}" varStatus="loopCount">
					<option value = "${loopCount.count}">${memberLevel}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			댓글 작성 권한
		</td>
		<td>
			<select class = "inputLine" name="commentRight" id = "commentRight" >
				<c:forEach var = "memberLevel" items="${memberLevelList}" varStatus="loopCount">
					<option value = "${loopCount.count}">${memberLevel}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			공개범위
		</td>
		<td>
			<select class = "inputLine" name="openLevel" id = "openLevel" >
				<c:forEach var = "openLevel" items="${openLevelList}" varStatus="loopCount">
					<option value = "${loopCount.count}">${openLevel}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	</table>
	<div class="textCenter">
	<br><br>
		<c:choose>
		<c:when test="${addOrEdit == '0'}">
			<input type="button" class = "bigConfirmButton" id="confirmButton" value="추가" onClick = "regBoard()"/>
		</c:when>
		<c:otherwise>
			<input type="button" class = "bigConfirmButton" id="confirmButton" value="수정" onClick = "editBoard()"/>
		</c:otherwise>
	</c:choose>
	
	<input type="button" class = "bigCancelButton" id="cancelButton" value="취소" onClick = "cancel()"/>	
	</div>
</div>
	
</body>
</html>