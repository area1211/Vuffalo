<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="post/css/edit_post.css"/>
<style>

</style>
<script src="js/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(e) {
	$('#write_btn').click(function(){
		alert("수정합니다.");
		ttt = $('#content').val();
		$('#text').attr('value',ttt);
		$('#edit_form').submit();
	});
});
</script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div class="edit_post">
	<form method="post" action="editPost.do" id="edit_form">
		
			<div class="board_title">
				<h2>자유게시판</h2>
				<h4>다양한 주제로 자유롭게 이야기해보세요</h4>
				<hr>
			</div>
			<div class="board_section">
			<br><br>
				<table>
					<tr>
						<td class="td_size">제목</td>
						<td><input type="text" id="title" class="title" name="title" value="${title}"/></td> 
					</tr>
					<tr>
						<td class="td_size">영상</td>
						<td><input type="file" name="attachment" id="attachment" value="첨부" style="width:400px;" onchange="fileInfo(this)"/>
						<input type="hidden" name="fileUrl" value="${fileUrl}"/>
						</td>
					</tr>
					<tr>
						<td class="td_size">내용</td>
						<td><textarea id="content" name="content" class="content">${text}</textarea>
						<input type="hidden" id="text" name="text" value="${text}"/>
						</td>
					</tr>
				</table>
				<br>
				<div class="btnBox">
					<input type="button" class="cancel" id="cancel" value="취소"/>
					<input type="button" class="write" id="write_btn" value="수정"/>
				</div>
			</div>
		
		<input type="hidden" name="postNum" value="${postNum}"/>
	</form>
	</div>
</body>
</html>