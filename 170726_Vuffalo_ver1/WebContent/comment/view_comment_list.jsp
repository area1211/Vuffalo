<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 보기</title>
<link rel="styleSheet" href="comment/css/view_comment_list.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="comment/js/myScript.js"></script>
</head>
<body>
		
	<div class='managerBound'>
	<h5>댓글</h5>
	<hr>
				<c:set var="myMemberNum" value='${myMemberNum}' />
				<c:forEach var = "comment" items="${commentList}">
				<c:choose>
				<c:when test = "${comment.depth == '0' }">
				</c:when>
				<c:when test = "${comment.depth == '1' }">
					☞
				</c:when>
				<c:when test = "${comment.depth == '2' }">
					&nbsp;&nbsp;&nbsp;☞
				</c:when>
				<c:when test = "${comment.depth == '3' }">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;☞
				</c:when>
				<c:otherwise>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;☞
				</c:otherwise>
				</c:choose>
					${comment.writer}&nbsp;${comment.date}&nbsp;${comment.description}&nbsp;${myMemberNum}
				<img src = "comment/images/reply.png" onClick = "replyComment(${comment.boardNum}, ${comment.postNum}, ${comment.commentNum}, ${comment.depth})">
				
				<c:if test = "${comment.memberNum == myMemberNum}" >
				
					<img src = "comment/images/trash.png" onClick = "deleteComment(${comment.boardNum}, ${comment.postNum}, ${comment.commentNum}, '${comment.description}' )">
				
				</c:if>
				
				<c:if test = "${comment.memberNum == myMemberNum}" >
				
					<img src = "comment/images/fix.png" onClick = "editComment(${comment.boardNum}, ${comment.postNum}, ${comment.commentNum}, '${comment.description}' )">
				</c:if>
				<br>
				</c:forEach>
				<form name='formForEdit' id='formForEdit' method="get" action='editComment.do'>
					<input type="hidden" id="boardNumForEdit" name = "boardNumForEdit">
					<input type="hidden" id="postNumForEdit" name="postNumForEdit">
					<input type="hidden" id="commentNumForEdit" name="commentNumForEdit">
					<input type="hidden" id="descriptionForEdit" name="descriptionForEdit">
				</form>
				<form name='formForDelete' id='formForDelete' method="get" action='deleteComment.do'>
					<input type="hidden" id="boardNumForDelete" name = "boardNumForDelete">
					<input type="hidden" id="postNumForDelete" name="postNumForDelete">
					<input type="hidden" id="commentNumForDelete" name="commentNumForDelete">
					<input type="hidden" id="descriptionForDelete" name="descriptionForDelete">
				</form>
				<form name='formForReply' id='formForReply' method="get" action='addComment.do'>
					<input type="hidden" id="boardNumForReply" name = "boardNumForReply">
					<input type="hidden" id="postNumForReply" name="postNumForReply">
					<input type="hidden" id="commentNumForReply" name="commentNumForReply">
					<input type="hidden" id="depthForReply" name="depthForReply">
				</form>
				
	</div>
</body>
</html>
<%-- 			<c:choose>
				<c:when test="${favorOrNot == '0'}">
					<img src = "images/gray.png" onClick = "addFavorite()">
				</c:when>
				<c:otherwise>
					<img src = "images/yellow.png" onClick = "removeFavorite()">
				</c:otherwise>
			</c:choose> --%>