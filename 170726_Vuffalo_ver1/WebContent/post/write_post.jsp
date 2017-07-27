<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글쓰기</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="post/js/write_post.js"></script>
<link rel="stylesheet" href="post/css/write_post.css"/>
</head>
<body>	
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div class="write_post">
	<form action="writePost.do" id="send_form">
		
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
						<td><input type="text" id="title" class="title" name="title" placeholder="제목을 입력하세요"/></td> 
					</tr>
					<tr>
						<td class="td_size">영상</td>
						<td><input type="file" name="attachment" id="attachment" value="첨부" style="width:400px;" onchange="fileInfo(this)"/></td>
					</tr>
					<tr>
						<td class="td_size">내용</td>
						<td><textarea id="content" name="content" class="content"></textarea></td>
					</tr>
				</table>
				<br>
				<div class="btnBox">
					<input type="button" class="write" id="send_btn" value="글쓰기"/>
					<input type="button" class="cancel" id="cancel" value="취소"/>
					<input type="hidden" name="imgFlag" id="imgFlag" value="0"/>
					<input type="hidden" name="fileUrl" id="fileUrl" value="url"/>
				</div>
			</div>
		
	</form>
	</div>
</body>
</html>