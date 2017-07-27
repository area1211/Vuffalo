<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글수정하기</title>
<link rel="styleSheet" href="comment/css/edit_comment.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="comment/myScript.js"></script>
</head>
<body>
<div class='outerBound'>
	<h2>댓글 수정</h2>
	<hr>
	<br><br>
<form name = "addComment" id="addComment" method="get" action="">
	<table>
		<tr>
			<td class="commentLeftLabel">
				댓글내용
			</td>
			<td class = "commentData">
				<textarea class = "commentData" id="description" name="description">${description}</textarea>
			</td>
		</tr>
	</table>
	<br><br>
	<div class = "textCenter">
		<input type="button" class = "bigConfirmButton" id="bigConfirmButton" value="확인" onClick = "editCommentReal()"/>
		<input type="button" class = "bigCancelButton" id="bigCancelButton" value="취소" onClick = "cancel()"/>
	</div>
	<input type="hidden" name="boardNum" id="boardNum" value="${boardNum}">
	<input type="hidden" name="postNum" id="postNum" value="${postNum}">
	<input type="hidden" name="upperCommentNum" id="upperCommentNum" value="${commentNum}">
	
</form>

</div>

</body>
</html>