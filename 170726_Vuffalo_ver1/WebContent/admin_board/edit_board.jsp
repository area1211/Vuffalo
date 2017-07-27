<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 수정하기</title>
<link rel="styleSheet" href="admin_board/css/edit_board.css">
<script type="text/javascript" src="admin_board/js/admin_board.js"></script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<jsp:include page="/admin_menu.jsp" /><!-- 관리자메뉴 -->
<div class='managerBound'>
	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시판 수정하기</h3>
	
	<form name="deleteProfileForm" id="deleteProfileForm" method="get" action="CheckStopMember">
	<table>
		<tr>
			<td>
				수정할 게시판
			</td>
			<td>
 				<select class = "inputLine" name="boardName">
					<c:forEach var = "boardName" items="${boardList}" varStatus="loopCount">
						<option value = "${loopCount.count}">${boardName}</option>
					</c:forEach>
				</select>				
			</td>
		</tr>
	</table>
	</form>
	<div class="textCenter">
	<br><br>
	<input type="button" class = "bigConfirmButton" id="confirmButton" value="선택" onClick = "selectBoard()"/>
	<input type="button" class = "bigCancelButton" id="cancelButton" value="취소" onClick = "cancel()"/>
	
	</div>
</div>	
</body>
</html>